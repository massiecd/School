package net.massie.zooauth.roles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This abstract class basically provides a template method implemented by derived
 * classes to supply the exact name of the role data file. The class implements the
 * common role file processing logic.
 */
public abstract class AbstractRole implements IRole {

	private String basePath = "";

	@Override
	public final void setFilePath(final String path) {
		basePath = path;
		if (!basePath.endsWith(File.separator)) {
			basePath += File.separator;
		}
	}

	@Override
	public final String getData() {
		StringBuffer sb = new StringBuffer();

		BufferedReader reader= null;
		try {
			reader = new BufferedReader(new FileReader(basePath + getDataFilename()));
			char[] buffer = new char[1024];
			int bytesRead;
			while ((bytesRead = reader.read(buffer, 0, buffer.length)) != -1) {
				sb.append(buffer, 0, bytesRead);
			}
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (final Exception e) { /* ignore */ }
			}
		}
		return sb.toString();
	}

	/**
	 * Derived classes implement this method in order to provide the
	 * exact name for the role data file to load.
	 * 
	 * @return Exact name of the role data file
	 */
	public abstract String getDataFilename();
}
