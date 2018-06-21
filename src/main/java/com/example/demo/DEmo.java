package com.example.demo;

public class DEmo {

	// Can be done directly
	// channelSftp.put("C:/Users/shgujarathi/Desktop/SFTPSample.txt",
	// "SFTPSample.txt");

	// GETTING FILES FROM REMOTE SERVER
	/*
	 * channelSftp.get("testfile.txt", fileFromServerPath);
	 * System.out.println("Getting files from Remote Server to local- SUCCESS");
	 * 
	 * // PUSHING FILES TO REMOTE SERVER
	 * 
	 * // Can be done using I/O channelSftp.cd(SFTPWORKINGDIR); File f = new
	 * File(fileToServerpath); channelSftp.put(new FileInputStream(f), f.getName());
	 * System.out.println("Pushing files from local to Remote Server- SUCCESS");
	 */

	/*
	 * // PUSHING MULTIPLE .TXT FILES TO REMOTE SERVER File folder = new
	 * File("C:/Users/shgujarathi/Desktop/AllFiles"); File[] listOfFiles =
	 * folder.listFiles(); for (int i = 0; i < listOfFiles.length; i++) { File file
	 * = listOfFiles[i]; if (file.isFile() && file.getName().endsWith(".txt")) {
	 * channelSftp.cd(SFTPWORKINGDIR); channelSftp.put(new FileInputStream(file),
	 * file.getName()); } }
	 */

	// GETTING FILES FROM REMOTE SERVER

	// channelSftp.get("testfile.txt", fileFromServerPath);
	// System.out.println("Getting files from Remote Server to local- SUCCESS");

	// PUSHING FILES TO REMOTE SERVER

	// Can be done using I/O
	// channelSftp.cd(SFTPWORKINGDIR);
	// File f = new File(fileToServerpath);
	// channelSftp.put(new FileInputStream(f), f.getName());

	// Can be done directly
	// channelSftp.put("C:/Users/shgujarathi/Desktop/SFTPSample.txt",
	// "SFTPSample.txt");
	// System.out.println("Pushing files from local to Remote Server- SUCCESS");
	
	
	//String fileToServerpath = "C:/Users/shgujarathi/Desktop/SFTPSample.txt";
	//String fileFromServerPath = "C:/Users/shgujarathi/Desktop/Spring-POC";

}
