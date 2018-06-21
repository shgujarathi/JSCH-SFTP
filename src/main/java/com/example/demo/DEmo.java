package com.example.demo;

import java.io.File;
import java.io.FileFilter;

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

	// String fileToServerpath = "C:/Users/shgujarathi/Desktop/SFTPSample.txt";
	// String fileFromServerPath = "C:/Users/shgujarathi/Desktop/Spring-POC";

	public static File lastFileModified(String dir) {
		File fl = new File(dir);
		File[] files = fl.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		long lastMod = Long.MIN_VALUE;
		File choice = null;
		for (File file : files) {
			System.out.println(file.getName());
			if (file.lastModified() > lastMod && file.getName().endsWith(".txt")) {
				choice = file;
				lastMod = file.lastModified();
			}
		}
		return choice;
	}

}
