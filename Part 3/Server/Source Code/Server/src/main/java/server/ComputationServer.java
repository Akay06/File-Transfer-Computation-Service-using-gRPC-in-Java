package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import proto.ComputationServiceGrpc.ComputationServiceImplBase;
import proto.Fileserver.AckResponse;
import proto.Fileserver.AddRequest;
import proto.Fileserver.AddResponse;
import proto.Fileserver.ResultRequest;
import proto.Fileserver.SortRequest;
import proto.Fileserver.SortResponse;

public class ComputationServer {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private static final Map<String, Integer> addResults = new ConcurrentHashMap<>();
	private static final Map<String, List<Integer>> sortResults = new ConcurrentHashMap<>();

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8010).addService(new ComputationServiceImpl())
				.executor(Executors.newFixedThreadPool(10)).build();

		System.out.println("Server started...");
		server.start();
		server.awaitTermination();
	}

	static class ComputationServiceImpl extends ComputationServiceImplBase {

		@Override
		public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
			int result = request.getNum1() + request.getNum2();
			AddResponse response = AddResponse.newBuilder().setResult(result).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}

		@Override
		public void sort(SortRequest request, StreamObserver<SortResponse> responseObserver) {
			List<Integer> sortedList = new ArrayList<>(request.getArrayList());
			Collections.sort(sortedList);
			SortResponse response = SortResponse.newBuilder().addAllSortedArray(sortedList).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}

		@Override
		public void addAsync(AddRequest request, StreamObserver<AckResponse> responseObserver) {
			String operationId = UUID.randomUUID().toString();
			CompletableFuture.runAsync(() -> {
				int result = request.getNum1() + request.getNum2();
				addResults.put(operationId, result);
			});
			AckResponse response = AckResponse.newBuilder()
					.setMessage("Addition request acknowledged with ID: " + operationId).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}

		@Override
		public void sortAsync(SortRequest request, StreamObserver<AckResponse> responseObserver) {
			String operationId = UUID.randomUUID().toString();
			CompletableFuture.runAsync(() -> {
				List<Integer> sortedList = new ArrayList<>(request.getArrayList());
				Collections.sort(sortedList);
				sortResults.put(operationId, sortedList);
			});
			AckResponse response = AckResponse.newBuilder()
					.setMessage("Sort request acknowledged with ID: " + operationId).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}

		@Override
		public void getAddResult(ResultRequest request, StreamObserver<AddResponse> responseObserver) {
			String operationId = request.getOperationId();
			if (addResults.containsKey(operationId)) {
				AddResponse response = AddResponse.newBuilder().setResult(addResults.get(operationId)).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} else {
				responseObserver.onError(Status.NOT_FOUND
						.withDescription("No result found for acknowledgement ID " + operationId).asRuntimeException());
			}
		}

		@Override
		public void getSortResult(ResultRequest request, StreamObserver<SortResponse> responseObserver) {
			String operationId = request.getOperationId();
			if (sortResults.containsKey(operationId)) {
				SortResponse response = SortResponse.newBuilder().addAllSortedArray(sortResults.get(operationId))
						.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} else {
				responseObserver.onError(Status.NOT_FOUND
						.withDescription("No result found for acknowledgement ID " + operationId).asRuntimeException());
			}
		}

	}

	public synchronized void startSyncFromServer() {
		scheduler.scheduleAtFixedRate(() -> {
			try {
				addResults.clear();
				sortResults.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 1, 1, TimeUnit.HOURS);
	}

}
