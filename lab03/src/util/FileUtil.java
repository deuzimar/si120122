package util;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

	public static void fillAllFilesList(List<File> files, File dir) {
		if (!dir.isDirectory()) {
			return;
		}
		File[] fList = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isFile()
						&& pathname.getAbsolutePath().endsWith(".java");
			}
		});
		if (fList != null) {
			files.addAll(Arrays.asList(fList));
		}
		File dList[] = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		if (dList != null) {
			for (File dirFile : dList) {
				fillAllFilesList(files, dirFile);
			}
		}
	}
}
