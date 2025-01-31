# File Transfer & Computation Service using gRPC in Java

This project consists of a simple file upload/download service and a computation service, using **Remote Procedure Call (RPC)** for communication. The implementation is done in **Java** using **gRPC** for client-server interactions.

## Requirements
- **Java 17+**

## How to Execute

### 📂 Part 1: Multi-threaded File Server

A **multi-threaded file server** that supports **UPLOAD, DELETE, and RENAME** file operations.

#### 🖥️ Start the Server:
   - Open a new CMD/PowerShell/Terminal window.
   - Navigate to the `Part 1/Server` folder.
   - Run the following command to start the server:

     ```bash
     java -jar Server-0.0.1-SNAPSHOT.jar
     ```

#### 💻 Run the Client:
   - Open another CMD/PowerShell/Terminal window.
   - Navigate to the `Part 1/Client` folder.
   - Run the following command to start the client:

     ```bash
     java -jar Client-0.0.1-SNAPSHOT.jar
     ```

### ☁️ Part 2: Dropbox-like Synchronized Storage Service

A real-time file synchronization system, where changes made to the synchronized folder on the client side (e.g., creating, updating, or deleting files) are automatically reflected on the server.

#### 🖥️ Start the Server:
   - Open a new CMD/PowerShell/Terminal window.
   - Navigate to the `Part 2/Server` folder.
   - Run the following command to start the server:

     ```bash
     java -jar Server-0.0.1-SNAPSHOT.jar
     ```

#### 💻 Run the Client:
   - Open another CMD/PowerShell/Terminal window.
   - Navigate to the `Part 2/Client` folder.
   - Run the following command to start the client:

     ```bash
     java -jar Client-0.0.1-SNAPSHOT.jar
     ```

### 🔢 Part 3: Computation Server with Synchronous & Asynchronous RPCs

A computation server that supports:

- Addition: add(i, j)
- Sorting: sort(array A)

This implementation uses both synchronous and asynchronous RPCs:

- Synchronous RPC: The client waits for a response before continuing.
- Asynchronous RPC: The client sends the request, receives an acknowledgment, and continues execution while waiting for the result.

#### 🖥️ Start the Server:
   - Open a new CMD/PowerShell/Terminal window.
   - Navigate to the `Part 3/Server` folder.
   - Run the following command to start the server:

     ```bash
     java -jar Server-0.0.1-SNAPSHOT.jar
     ```

#### 💻 Run the Client:
   - Open another CMD/PowerShell/Terminal window.
   - Navigate to the `Part 3/Client` folder.
   - Run the following command to start the client:

     ```bash
     java -jar Client-0.0.1-SNAPSHOT.jar
     ```
