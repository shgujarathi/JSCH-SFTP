package com.example.demo;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.regex.Pattern;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JSCHAPP {

	public void send() {
		String SFTPHOST = "10.142.159.48";
		int SFTPPORT = 22;
		String SFTPUSER = "tester";
		String SFTPPASS = "password";

		String SFTPWORKINGDIR = "/";

		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;

		Pattern pattern = Pattern.compile(".*\\.txt");

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;

			// System.out.println("Getting Multiple files from Server to local");
			// GETTING MULTIPLE .TXT FILES FROM REMOTE SERVER
			for (Object entry : channelSftp.ls(SFTPWORKINGDIR)) {
				ChannelSftp.LsEntry e = (ChannelSftp.LsEntry) entry;
				if (pattern.matcher(e.getFilename()).matches()) {
					channelSftp.get(e.getFilename(), "C:/Users/shgujarathi/Desktop/AllFiles");
					// System.out.println(e.getFilename() + " -> " +
					// Calendar.getInstance().getTime());
				}
			}

			// System.out.println("Pushing multiple files from local to remote server");
			// PUSHING FROM LOCAL TO REMOTE

			File file = new File("C:/Users/shgujarathi/Desktop/AllFiles");
			for (File f : file.listFiles()) {
				if (f.isFile() && f.getName().endsWith(".txt")) {
					channelSftp.cd("/imported");
					channelSftp.put(new FileInputStream(f), f.getName());
				}
			}

		} catch (Exception ex) {
			System.out.println("Exception found while tranfer the response.");
			ex.printStackTrace();
		} finally {

			channelSftp.exit();
			channel.disconnect();
			session.disconnect();
		}
	}

	/*
	 * public static void main(String[] args) { new JSCHAPP().send(); }
	 */


}
