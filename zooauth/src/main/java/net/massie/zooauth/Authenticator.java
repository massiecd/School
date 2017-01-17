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

/**
 * Responsible for authenticating a user. User supplied password is compared
 * against an MD5 hashed password in a credentials file.
 */
public class Authenticator {

	// Mapping of username to user attributes: password, role
	private Map<String, UserData> users = new TreeMap<String, UserData>();
	
	// Mapping of a role name with a role object
	private Map<String, IRole> roles = new TreeMap<String, IRole>();
	
	/**
	 * Simple class to store a user's password and role. These attributes
	 * are associated to a given username via map.
	 */
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
	
	/**
	 * Constructor
	 * 
	 * @param rolesFilePath
	 * 			Path to the role message data files
	 */
	public Authenticator(
		final String rolesFilePath) {
		roles.put("admin", new SysAdmin());
		roles.put("veterinarian", new Veterinarian());
		roles.put("zookeeper", new Zookeeper());
		
		for (IRole role : roles.values()) {
			role.setFilePath(rolesFilePath);
		}
	}
	
	/**
	 * Loads the password file into memory (internal map) for quick lookup
	 * during login.
	 * 
	 * @param passwordFilespec
	 * 			Complete path and filename of the password file
	 */
	public void loadPasswordFile(
		final String passwordFilespec) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(passwordFilespec));
			String[] tokenizedLine;
			
			while (scanner.hasNextLine()) {
				tokenizedLine = scanner.nextLine().split("[\\s]+");
				users.put(tokenizedLine[0], new UserData(tokenizedLine[1], 
						roles.get(tokenizedLine[(tokenizedLine.length - 1)])));
			}	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// Cleanup resources (scanner may leak resources if not closed
			// properly). These stupid close() methods may throw exceptions
			// (which is bad design in my opinion), thus the ignored try/
			// catch block.
			if (scanner != null) {
				try {
					scanner.close();
				} catch (final Exception e) { /* ignore */ }
			}
		}
	}
	
	/**
	 * Queries for user credentials, and if authenticated successfully, the user's role is
	 * returned. Three attempts are allowed.
	 * 
	 * @param scanner
	 * 			Scanner used for input processing
	 * @return Non-null role on success; null on failure.
	 */
	public IRole login(
		final Scanner scanner) {
		IRole role = null;
		String username;
		String password;
		for (int attempts = 0; attempts < 3; attempts++) {
			System.out.println();
			System.out.println("Username (or 'q' to exit): ");
			username = scanner.nextLine();
			if (username.toLowerCase().equals("q")) {
				break;
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
		return role;
	}
	
	/**
	 * Validates that the username/password combination is within the credentials file
	 * (cached in memory).
	 * 
	 * @param username
	 * 			Name of user attempting to authenticate
	 * @param password
	 * 			Password of the user attempting to authenticate
	 * @return 'true' if user is valid and provided correct password; 'false' otherwise.
	 */
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
