package net.massie.zooauth;

import net.massie.zooauth.roles.IRole;

public class Main {
	
	public static final void main(final String[] args) {
		if (args.length < 2) {
			System.out.println("Requires 2 params:");
			System.out.println("  arg[0]: password file");
			System.out.println("  arg[1]: path to the role file(s)");
			return;
		}
		
		Authenticator auth = new Authenticator(args[1]);
		auth.loadPasswordFile(args[0]);
		IRole role = auth.login();
		if (role != null) {
			System.out.println(role.getData());
		}
		System.out.println("Exiting...");
	}
}
