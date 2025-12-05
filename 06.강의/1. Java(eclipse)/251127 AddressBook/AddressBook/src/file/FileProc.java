package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dto.AddressDto;

public class FileProc {

	private File file;
	
	public FileProc(String filename) {
		file = new File("c:/tmp/" + filename + ".txt");
		createNewFile();
	}
	
	public void createNewFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일이 성공적으로 생성되었습니다");
			}else {
				System.out.println("같은 이름의 파일이 존재합니다");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// data save/load
	public void fileSave(List<AddressDto> list) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
			for (AddressDto dto : list) {
				pw.println(dto.getData());
			}
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("저장완료했습니다");
	}
	
	public List<AddressDto> fileLoad() {		
		List<AddressDto> list = new ArrayList<AddressDto>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String str = "";			
			while((str = br.readLine()) != null) {
				// 문자열을 자르고 list에 삽입
				String data[] = str.split("-");
				AddressDto dto = new AddressDto(data[0], 
												Integer.parseInt(data[1]), 
												data[2], 
												data[3], 
												data[4]);
				list.add(dto);
			}
			br.close();			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}

		return list;
	}	
}




