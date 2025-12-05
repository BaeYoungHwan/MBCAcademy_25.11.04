package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {
	
	File file;
	
	public FileProc(String filename) {
		file = new File("c:\\tmp\\" + filename + ".txt");
	}
	
	public void fileSave(String arr[]) {		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for(String s : arr) {
				pw.println(s);
			}
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	public String[] fileLoad() {
		
		String arr[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 데이터의 갯수
			int count = 0;
			String str = "";
			while((str = br.readLine()) != null) {
				count++;				
			}			
			br.close();
			
			// 배열할당
			arr = new String[count];			
			
			// 데이터저장
			int len = 0;
			br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
				arr[len] = str;
				len++;
			}
			br.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return arr;
	}

}





