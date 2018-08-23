package Read_Write_file;

import java.io.*;
import java.util.stream.*;
import java.util.*; 

public class file_RW {
	static void copy(String source_path, String destination_folder) throws IOException {
		try {
			int line_number = 0;
			InputStream inputStream = new FileInputStream(source_path);
			InputStreamReader isr = new InputStreamReader(inputStream,"GBK");
			BufferedReader bReader = new BufferedReader(isr);
			FileWriter fWriter = new FileWriter(destination_folder);
			BufferedWriter bWriter =new BufferedWriter(fWriter);
			String line;
			while ((line = bReader.readLine()) != null) {
//				System.out.println(line.length());
			//System.out.println(line_number);
				line_number++;
				//System.out.println(line);
					bWriter.write(line + "\r\n");
			}
			bReader.close();
			inputStream.close();
			isr.close();
			bWriter.close();
			fWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException e");
			e.printStackTrace();
		}
	}

	static void print_to_screen(String file_path) throws IOException {
		try {
			int line_number = 0;
			FileReader fReader = new FileReader(file_path);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			System.out.println("encode="+fReader.getEncoding());
			while ((line = bReader.readLine()) != null) {
				line_number++;
				System.out.println(line_number);
				System.out.println(line);
			}
			bReader.close();
			fReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
//look specified file 
	static void Show_file_info(String file_path) {
		File file = new File(file_path);
		System.out.println("canExecute=" + file.canExecute());
		System.out.println("canRead=" + file.canRead());
		System.out.println("canwrite=" + file.canWrite());
		System.out.println("exit=" + file.exists());
	}
	
	
	//make an fake data
	static void fake_data(String file)throws IOException{
		try{
			String line;
			String output;
			int line_number=0 ;
			int index=1;
			int ascii_num;
			char ch;
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(int i=48; i<=57;i++){
				ascii_num = i;
				String ascii_num_string = String.valueOf(ascii_num);
				ch = (char)ascii_num;
				bWriter.write(ch);
			}
			bWriter.close();
			fWriter.close();
		}
			//catch block
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	static void remove_string(String source_path,String destination_folder) throws IOException {
		try {
			int line_number = 0;
			int ascii_num;
			char ch;
			//read
			InputStream inputStream = new FileInputStream(source_path);
			InputStreamReader isr = new InputStreamReader(inputStream,"gbk");
			BufferedReader bReader = new BufferedReader(isr);
			//write
			OutputStream outputStream = new FileOutputStream(destination_folder);
			OutputStreamWriter osr = new OutputStreamWriter(outputStream,"gbk");
			BufferedWriter bWriter = new BufferedWriter(osr);
			String line;
			
			int[] err_code = {37810,65533,32,22,00,2,16,28,37804,12,5,1,25,24,20,18,17,7,8,3,4,19,6,23,21,9};
			String unknow_word="凢圠怭俙棐揁憖丗儗慞榯嘝杚厱厡檉慺侾憒攓厜枑晫攖慤杸厊抃";

			//per line
			while((line=bReader.readLine())!=null){
					ArrayList arraylist = new ArrayList();
				//per char
				for(int i=0;i<line.length();i++){
					ch = line.charAt(i);
					ascii_num = (int)ch;
					
					
					for(int temp=0;temp<err_code.length;temp++){
						arraylist.add(err_code[temp]);
					}
					boolean is_err_code = arraylist.contains(ascii_num);
					
					String cstring = Character.toString(ch);
					boolean is_unknow_word = unknow_word.contains(cstring);
						
					
					if(is_err_code||is_unknow_word){
						//System.out.print("1");
						//System.out.print(is_unknow_word);
						//bWriter.write(" ");
					}else{
						//System.out.println("2");
						bWriter.write(ch);
					}
				}
				bWriter.newLine();
			}
			bReader.close();
			inputStream.close();
			isr.close();
			bWriter.close();
			osr.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
