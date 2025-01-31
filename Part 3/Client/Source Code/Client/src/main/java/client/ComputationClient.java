package client;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import proto.ComputationServiceGrpc;
import proto.ComputationServiceGrpc.ComputationServiceBlockingStub;
import proto.Fileserver.AckResponse;
import proto.Fileserver.AddRequest;
import proto.Fileserver.AddResponse;
import proto.Fileserver.ResultRequest;
import proto.Fileserver.SortRequest;
import proto.Fileserver.SortResponse;

public class ComputationClient {

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8010).usePlaintext().build();

		ComputationServiceBlockingStub stub = ComputationServiceGrpc.newBlockingStub(channel);

		boolean exit = false;

		Scanner sc = new Scanner(System.in);

		while (!exit) {
			try {
				System.out.println("Choose an option:");
				System.out.println();
				System.out.println("(1) Synchronus Add");
				System.out.println("(2) Synchronus Sort");
				System.out.println("       ------");
				System.out.println("(3) Asynchronus Add");
				System.out.println("(4) Asynchronus Sort");
				System.out.println("(5) Get asynchronus add result");
				System.out.println("(6) Get asynchronus sort result");
				System.out.println("       ------");
				System.out.println("(7) Exit");

				int choice = sc.nextInt();
				int i, j;
				List<Integer> numberList;

				switch (choice) {
				case 1:
					System.out.println("Enter two numbers");
					try {
						System.out.println("i: ");
						i = sc.nextInt();
						System.out.println("j: ");
						j = sc.nextInt();
						synchronousAdd(i, j, stub);
					} catch (InputMismatchException e) {
						System.out.println("Invalid entry. Please enter a number!");
						sc.next();
					}
					break;

				case 2:
					System.out.println("Enter numbers separated by spaces:");
					sc.nextLine();
					numberList = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
							.collect(Collectors.toList());
					synchronousSort(numberList, stub);
					numberList.clear();
					break;

				case 3:
					System.out.println("Enter two numbers");
					try {
						System.out.println("i: ");
						i = sc.nextInt();
						System.out.println("j: ");
						j = sc.nextInt();
						asynchronousAdd(i, j, stub);
					} catch (InputMismatchException e) {
						System.out.println("Invalid entry. Please enter a number!");
						sc.next();
					}
					break;

				case 4:
					System.out.println("Enter numbers separated by spaces:");
					sc.nextLine();
					numberList = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
							.collect(Collectors.toList());
					asynchronousSort(numberList, stub);
					numberList.clear();
					break;

				case 5:
					System.out.println("Enter the acknowledgement ID for add operation to fetch the result:");
					sc.nextLine();
					fetchAddResult(sc.nextLine(), stub);
					break;

				case 6:
					System.out.println("Enter the acknowledgement ID for sort operation to fetch the result:");
					sc.nextLine();
					fetchSortResult(sc.nextLine(), stub);
					break;

				case 7:
					exit = !exit;
					break;

				default:
					System.out.println("Invalid choice. Please choose from above!");
				}
			} catch (StatusRuntimeException e) {
				if (e.getStatus().getCode() == Status.Code.NOT_FOUND) {
					System.out.println("Error: " + e.getStatus().getDescription());
				} else if (e.getStatus().getCode() == Status.Code.UNAVAILABLE) {
					System.out.println("Server unavailable");
				} else {
					System.out.println("An error occurred: " + e.getStatus());
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice. Please enter a number!");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry. Please enter a number!");
			}

		}

		sc.close();
		channel.shutdown();

	}

	public static void synchronousAdd(int a, int b, ComputationServiceBlockingStub stub) {
		AddRequest request = AddRequest.newBuilder().setNum1(a).setNum2(b).build();
		AddResponse response = stub.add(request);
		System.out.println("Synchronous Add Result: " + response.getResult());
	}

	public static void synchronousSort(List<Integer> array, ComputationServiceBlockingStub stub) {
		SortRequest request = SortRequest.newBuilder().addAllArray(array).build();
		SortResponse response = stub.sort(request);
		System.out.println("Synchronous Sort Result: " + response.getSortedArrayList());
	}

	public static void asynchronousAdd(int a, int b, ComputationServiceBlockingStub stub) {
		AddRequest request = AddRequest.newBuilder().setNum1(a).setNum2(b).build();
		AckResponse response = stub.addAsync(request);
		System.out.println(response.getMessage());
	}

	public static void asynchronousSort(List<Integer> array, ComputationServiceBlockingStub stub) {
		SortRequest request = SortRequest.newBuilder().addAllArray(array).build();
		AckResponse response = stub.sortAsync(request);
		System.out.println(response.getMessage());
	}

	public static void fetchAddResult(String operationId, ComputationServiceBlockingStub stub) {
		ResultRequest request = ResultRequest.newBuilder().setOperationId(operationId).build();
		AddResponse response = stub.getAddResult(request);
		System.out.println("Asynchronous Add Result: " + response.getResult());
	}

	public static void fetchSortResult(String operationId, ComputationServiceBlockingStub stub) {
		ResultRequest request = ResultRequest.newBuilder().setOperationId(operationId).build();
		SortResponse response = stub.getSortResult(request);
		System.out.println("Asynchronous Sort Result: " + response.getSortedArrayList());
	}
}
