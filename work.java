package Read_Write_file;

import java.io.IOException;

public class work {
	public static void main(String[] args) throws IOException {
		String data = "C:\\Users\\tiger\\Desktop\\work\\LNLNSJRN.del";
		String output_copy = "C:\\Users\\tiger\\Desktop\\work\\output\\copy.txt";
		String clean_data ="C:\\Users\\tiger\\Desktop\\work\\output\\clean_data.txt";
		String test_file2 ="C:\\Users\\tiger\\Desktop\\test2.txt";
		file_RW.copy(data,output_copy);
		//file_RW.Show_file_info(output_copy);
		//file_RW.print_to_screen(data);
		
		file_RW.remove_string(output_copy,test_file2);
		
	}
}