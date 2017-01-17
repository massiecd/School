package net.massie.zooauth.roles;

/**
 * Interface allowing polymorphic operations over all user roles.
 */
public interface IRole {
	
	/**
	 * Sets the base path where the role data file is located.
	 * 
	 * @param path
	 * 			Path to the role data file(s)
	 */
	public void setFilePath(final String path);
	
	/**
	 * Returns role information.
	 * 
	 * @return Role information
	 */
	public String getData();
}
