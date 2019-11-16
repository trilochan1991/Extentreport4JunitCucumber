package iocucumber.base.filereadermanager;

import iocucumber.base.filereader.PropertieReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager;
	private PropertieReader propertieReader;

	public static FileReaderManager getinstance() {
		return (fileReaderManager == null) ? fileReaderManager = new FileReaderManager()
				: fileReaderManager;
	}

	public PropertieReader getPropertieReaderInstance() {
		return (propertieReader == null) ? propertieReader = new PropertieReader()
				: propertieReader;
	}

}
