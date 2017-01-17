package net.massie.zooauth.roles;

public class SysAdmin extends AbstractRole {

	@Override
	public String getDataFilename() {
		return "sysadmin.txt";
	}
}
