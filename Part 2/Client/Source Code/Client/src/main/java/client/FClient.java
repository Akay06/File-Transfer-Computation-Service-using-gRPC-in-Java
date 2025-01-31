package client;

public class FClient {

	public static void main(String[] args) throws Exception {
		String syncFolderPath = "Client Files/";

		FolderWatcher folderWatcher = new FolderWatcher(syncFolderPath);
		Thread watcherThread = new Thread(folderWatcher);
		watcherThread.start();
	}
}
