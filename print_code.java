import java.io.*;
import java.nio.charset.Charset;


public class print_code {
	public static void main(String[] args) throws IOException {
		String test_file ="C:\\Users\\tiger\\Desktop\\test2.txt";
		InputStream inputStream = new FileInputStream(test_file);
		InputStreamReader isr = new InputStreamReader(inputStream,"GBK");
		BufferedReader bReader = new BufferedReader(isr);
		try{
			String line ;
			char ch;
			int ascii_num;

			//per line
			while((line = bReader.readLine())!=null){
				//per char
				for(int i =0;i<line.length();i++){
					ch = line.charAt(i);
					ascii_num = (int)ch;
					System.out.println("字元"+"+"+"ascii_num");
					//System.out.print(i);
					System.out.print(ch);
					System.out.println(ascii_num);
				}
			} 
		}catch(FileNotFoundException e){
				e.printStackTrace();
		}
		bReader.close();
		isr.close();
		inputStream.close();
	}
}