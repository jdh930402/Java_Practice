package java_20190801;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
	public static boolean FileCopy(String originalFile, String copyFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int countByte = 0;
		boolean isSuccess = false;

		try {
			fis = new FileInputStream(originalFile);
			fos = new FileOutputStream(copyFile);
			byte[] b = new byte[1024 * 20];
			while ((countByte = fis.read(b)) != -1) {
				isSuccess = true;
				fos.write(b, 0, countByte);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static void main(String[] args) {
		System.out.println(FileCopy("C:\\dev\\test\\jdk.exe", "C:\\dev\\test\\jdk.exe"));
	}
}
