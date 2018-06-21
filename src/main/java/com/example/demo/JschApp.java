package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Configuration

public class JschApp {

	private String sftphost = "10.142.159.48";
	private int sftpport = 22;
	private String sftpuser = "tester";
	private String sftppass = "password";
	private String sftpworkingdir = "/";
	private String localpath = "C:/Users/shgujarathi/Desktop/AllFiles";
	private String sftpdestdir = "/imported";

	Session session = null;
	Channel channel = null;
	ChannelSftp channelSftp = null;

	Pattern pattern = Pattern.compile(".*\\.txt");

	public void send() {

		/*
		 * System.out.println(sftpuser + " - " + sftphost + " - " + sftpport + " - " +
		 * sftppass + " - " + sftpworkingdir + " - " + localpath + " - " + sftpdestdir);
		 */

		try {

			// Making connection with REMOTE SERVER (REBEX downloaded for Testing )

			JSch jsch = new JSch();
			session = jsch.getSession(sftpuser, sftphost, sftpport);
			session.setPassword(sftppass);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;

			// GETTING FILES FROM REMOTE SERVER
			for (Object entry : channelSftp.ls(sftpworkingdir)) {
				ChannelSftp.LsEntry e = (ChannelSftp.LsEntry) entry;
				if (pattern.matcher(e.getFilename()).matches()) {
					channelSftp.get(e.getFilename(), localpath);
				}
			}
			System.out.println("GETTING FILES FROM REMOTE SERVER - Successful");

			// PUSHING FROM LOCAL TO REMOTE
			File file = new File(localpath);
			for (File f : file.listFiles()) {
				if (f.isFile() && f.getName().endsWith(".txt")) {
					channelSftp.cd(sftpdestdir);
					channelSftp.put(new FileInputStream(f), f.getName());
				}
			}
			System.out.println("PUSHING FROM LOCAL TO REMOTE - Successful");

		} catch (Exception ex) {
			System.out.println("Exception found while tranfer the response.");
			ex.printStackTrace();
		} finally {
			channelSftp.exit();
			channel.disconnect();
			session.disconnect();
		}
	}

}
