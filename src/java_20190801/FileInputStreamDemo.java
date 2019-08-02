package java_20190801;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:\\dev\\test\\navercafe.html");
			fos = new FileOutputStream("C:\\dev\\test\\2019\\08\\01\\navercafe.html");
			byte[] readByte = new byte[1024*8];
			int readByteCount = 0;
			while( (readByteCount = fis.read(readByte)) != -1) {
				fos.write(readByte);				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
