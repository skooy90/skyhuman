package sec01.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class inputExam {

	public static void main(String[] args) {
		String fullPath = "c:\\tmp\\stream.txt";
		
		try(
			InputStream is = new FileInputStream(fullPath);
		){
			//퍼 담을 바가지 크기 설정
			
			
			
			int BUFFER_SIZE = 1024 * 8;
//			int BUFFER_SIZE = 11;
			byte[] datas = new byte[BUFFER_SIZE];
			
			String data = "";
			int result = 0;
			
			// do while 일반적인 버젼			
//				result = is.read(datas);
//				if(result != -1) {					
//				data += new String(datas, 0, result);
//				}
//			while(result != -1) {
//				result = is.read(datas);
//				if(result != -1) {					
//				data += new String(datas, 0, result);
//				}
//				
//			}
			// 깔끔해진 표현
			while ((result = is.read(datas)) != -1) {
				data += new String(datas, 0, result);
				System.out.println("==============================");
				System.out.println(data);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
