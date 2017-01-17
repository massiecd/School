package net.massie.zooauth;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import net.massie.zooauth.roles.IRole;
import net.massie.zooauth.roles.SysAdmin;
import net.massie.zooauth.roles.Veterinarian;
import net.massie.zooauth.roles.Zookeeper;

public class Authenticator {

	private Map<String, UserData> users = new TreeMap<String, UserData>();
	private Map<String, IRole> roles = new TreeMap<String, IRole>();
	
	private class UserData {
		private String password;
		private IRole role;
		
		public UserData(
			final String password,
			final IRole role) {
			this.password = password;
			this.role = role;
		}
		
		public String getPassword() {
			return password;
		}
		
		public IRole getRole() {
			return role;
		}
	}
	
	public Authenticator(
		final String rolesFilePath) {
		roles.put("admin", new SysAdmin());
		roles.put("veterinarian", new Veterinarian());
		roles.put("zookeeper", new Zookeeper());
		
		for (IRole role : roles.values()) {
			role.setFilePath(rolesFilePath);
		}
	}
	
	public void loadPasswordFile(
		final String passwordFilespec) {
		try {
			Scanner scanner = new Scanner(new FileInputStream(passwordFilespec));
			String[] tokenizedLine;
			
			while (scanner.hasNextLine()) {
				tokenizedLine = scanner.nextLine().split("[\\s]+");
				users.put(tokenizedLine[0], new UserData(tokenizedLine[1], 
						roles.get(tokenizedLine[(tokenizedLine.length - 1)])));
			}	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public IRole login() {
		IRole role = null;
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		for (int attempts = 0; attempts < 3; attempts++) {
			System.out.println("Username (or 'q' to exit): ");
			username = scanner.nextLine();
			if (username.toLowerCase().equals("q")) {
				return null;
			}
			System.out.println("Password: ");
			password = scanner.nextLine();
			
			if (isPasswordValid(username, password)) {
				UserData record = users.get(username);
				if (record != null) {
					role = record.getRole();
					break;
				}
			} else {
				System.out.println("Unknown user and/or incorrect password");
			}
		}
		scanner.close();
		return role;
	}
	
	private boolean isPasswordValid(
		final String username,
		final String password) {
		boolean isValid = false;
		UserData record = users.get(username);
		if (record == null) {
			return isValid;
		}
		
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x",  b & 0xff));
			}
			isValid = sb.toString().equals(record.getPassword());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
