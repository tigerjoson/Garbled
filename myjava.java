package test_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class myjava{
	public static void split_paragraph(String file,String file2) throws IOException{
		try{
			FileReader fReader =new FileReader(file);
			BufferedReader bReader =new BufferedReader(fReader);
			FileWriter fWriter =new FileWriter(file2);
			BufferedWriter bWriter =new BufferedWriter(fWriter);
			String line;
			String paragraph;
			int i=0;
			while((line=bReader.readLine())!=null){
				System.out.println(line);
				int length=line.length();
				i++;
				System.out.println("i="+i);
					System.out.println("line="+line);
				while(length>50){
					paragraph=line.substring(0,51)+ "\r\n";
					line=line.substring(51);
					System.out.println("paragraph"+paragraph);
					System.out.println("===============================");
					System.out.println("line"+line);
					break;
				}
			}
			bReader.close();
			fReader.close();
			bWriter.close();
			fWriter.close();
		}
		catch(FileNotFoundException e){
				e.printStackTrace();
		}
	}

}