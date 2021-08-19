package my_tool;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;


public class file_RW {
		

		
	static void copy(String source_path, String destination_folder) throws IOException {
		try {
			int line_number;
			InputStream inputStream = new FileInputStream(source_path);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader bReader = new BufferedReader(isr);
			FileWriter fWriter = new FileWriter(destination_folder);
			BufferedWriter bWriter =new BufferedWriter(fWriter);
			String line;
			line_number =0;
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

	public void write_folder_info() {
		System.out.println("default write_folder_info() constructor");
	}

	public static int get_line_number(String file_path) throws IOException {
		FileReader fReader = new FileReader(file_path);
		BufferedReader bReader = new BufferedReader(fReader);
		int line_number=0;
		while ((bReader.readLine())!=null) {
			line_number ++;
		}
		bReader.close();
		fReader.close();
		return line_number;
	}
	
	public static void write_folder_info(String path) throws IOException {
		
		File file = new File(path);
		String[] file_liSt = file.list();
		// write file location
		String temp_file = "C:\\Users\\tiger\\Desktop\\temp\\";
//		filename
		String file_name = file.getName().concat("_before_soting");
		String document_extension = file_name.concat(".txt");
		String full_destination = temp_file.concat(document_extension);
		// write file's txt file
		FileWriter fileWriter = new FileWriter(full_destination);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		boolean filecanread = file.canRead();
		boolean isdir = file.isDirectory();
		if (filecanread && isdir) {
			for (int index = 0; index < file.listFiles().length; index++) {
				// for cast
				
				File f = new File(file_liSt[index]);
				String string = file_name.toString();
//				System.out.println(f.isDirectory());
				System.out.println(index);

				bufferedWriter.write(string);
				bufferedWriter.write("NO");
				bufferedWriter.write(Integer.toString(index + 1));
				bufferedWriter.write(",");
				bufferedWriter.write(file_liSt[index]);

				String file_full_name = path.concat(file_liSt[index]);
				Path path_one_file = Paths.get(file_full_name);
				Long file_size = Files.size(path_one_file);

				bufferedWriter.write("," + file_size + " bits");
				bufferedWriter.newLine();

			}
			System.out.println("write file place:");
			System.out.println(full_destination);
			bufferedWriter.close();
			fileWriter.close();
		} else {
			System.out.println("file canread :"+filecanread);
			System.out.println("is directory :"+isdir);
		}

	}
	
	static void print_to_screen() {
		System.out.println("print_to_screen default constructor");
	}
	public static void print_to_screen(String file_path,int columns,String charset_name ) throws IOException {	
		try {
			int line_number = 0;
			InputStream inputStream = new FileInputStream(file_path);
			InputStreamReader isr = new InputStreamReader(inputStream,charset_name);
			BufferedReader bReader = new BufferedReader(isr);
			String line;
		//	System.out.println("encode="+fReader.getEncoding());
			while ((line = bReader.readLine()) != null) {
				line_number++;
				if(line_number<=columns) {
					System.out.println("line_number : "+line_number);
					System.out.println(line);
				}
			}
			bReader.close();
			isr.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	static void print_to_screen(String file_path,int columns) throws IOException {
		try {
			int line_number = 0;
			FileReader fReader = new FileReader(file_path);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
		//	System.out.println("encode="+fReader.getEncoding());
			while ((line = bReader.readLine()) != null) {
				line_number++;
				if(line_number<=columns) {
					System.out.println(line_number);
					System.out.println(line);
				}
			}
			bReader.close();
			fReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void print_to_screen(String file_path) throws IOException {
		try {
			int line_number = 0;
			FileReader fReader = new FileReader(file_path);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			//System.out.println("encode="+fReader.getEncoding());
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
	static String[] get_file_list(String file_path) {
		File file = new File(file_path);
		String[] file_member = file.list();
		int numer_of_files = file.listFiles().length;
		String [] full_path = new String[numer_of_files];

			for (int i=0 ;i<file.list().length;i++) {
				full_path[i] = file_path+file_member[i];
			}
					
		return full_path;
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
	
		
	
	
	static ArrayList<Integer> indexofstring(String line_string ,char want_find_ch){
		int line_length =line_string.length();
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int index=0;index<line_length;index++) {
			if(line_string.charAt(index)==want_find_ch) {
				arrayList.add(index);
//				System.out.println(line_string.charAt(i));
			}
		}
		return arrayList;
	}
	
	public static ArrayList<String> noduplicatestring(ArrayList<String> datastringArrayList ){
		Collections.sort(datastringArrayList);
		ArrayList<String> noduplicateArrayList=new ArrayList<>();
		for(int i=0;i<datastringArrayList.size();i++) {
			if(i+1<datastringArrayList.size()) { 
			  String currentString = datastringArrayList.get(i);
			  String nexString = datastringArrayList.get(i+1);
			   if( nexString.equals(currentString)) {
//				   System.out.println(i+","+"currentString:"+currentString+",");
//				   System.out.println(i+1+","+"nexString:"+nexString);
			   } else {
				   noduplicateArrayList.add(currentString);
			   }
			 }else {
				noduplicateArrayList.add(datastringArrayList.get(i));
			}
		}
		return noduplicateArrayList;
	}
	
}
