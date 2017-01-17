package net.massie.zooauth.roles;

public final class SysAdmin extends AbstractRole {

	@Override
	public String getDataFilename() {
		return "sysadmin.txt";
	}
}
