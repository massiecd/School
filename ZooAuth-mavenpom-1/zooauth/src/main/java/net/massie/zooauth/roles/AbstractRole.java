package net.massie.zooauth.roles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractRole implements IRole {

	private String basePath = "/tmp";

	@Override
	public void setFilePath(final String path) {
		basePath = path;
		if (!basePath.endsWith(File.separator)) {
			basePath += File.separator;
		}
	}

	@Override
	public String getData() {
		StringBuffer sb = new StringBuffer();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(basePath + getDataFilename()));
			char[] buffer = new char[1024];
			int bytesRead;
			while ((bytesRead = reader.read(buffer, 0, buffer.length)) != -1) {
				sb.append(buffer, 0, bytesRead);
			}
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
		return sb.toString();
	}

	public abstract String getDataFilename();
}
