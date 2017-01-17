package net.massie.zooauth;

import java.io.File;
import java.util.Scanner;

import net.massie.zooauth.roles.IRole;

/**
 * This is the main class where processing starts.
 */
public class Main {
	
	private static String getExecutablePath() {
		String exePath = "." + File.separator;
		try {
			File cwd = new File(".");
			exePath = cwd.getCanonicalPath().toString() + File.separator;
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return exePath;
	}
	
	public static final void main(final String[] args) {
		String credentialsFile = getExecutablePath() + "cred.txt";
		String roleDataPath = getExecutablePath();
		
		// Process command line arguments to override file locations
		if (args.length == 1) {
			credentialsFile = args[0];
		} 
		if (args.length == 2) {
			credentialsFile = args[0];
			roleDataPath = args[1];
		}
		
		System.out.println("Credentials file: " + credentialsFile);
		System.out.println("Role data files:  " + roleDataPath);
		
		// Create an authenticator and solicit user credentials
		Authenticator auth = new Authenticator(roleDataPath);
		auth.loadPasswordFile(credentialsFile);
		
		Scanner scanner = new Scanner(System.in);
		IRole role = auth.login(scanner);
		if (role != null) {
			// Successful authentication (print role data)
			System.out.println(role.getData());
			
			// Wait for user to logout
			System.out.println();
			String line;
			boolean done = false;
			while (!done) {
				System.out.println("Press 'q' to logout and quit program: ");
				line = scanner.nextLine();
				if (line.equalsIgnoreCase("q")) {
					done = true;
				} else {
					System.out.println("Invalid entry!");
				}
			}
		}
		
		// Cleanup scanner to avoid resource leak.
		try {
			scanner.close();
		} catch (final Exception e) { /* ignore */ }
		
		System.out.println("Exiting...");
	}
}
