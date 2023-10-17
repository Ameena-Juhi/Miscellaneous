package Noticeboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;


public class notice{
	
	private static int Contact ;
	private static String Name ;
	
//	public class notice{
		public static void main(String[] args) throws IOException{
		
		//String content = "Hello welcome to the marvel group!";
		Path path = Path.of("data.txt");
		
		//Files.writeString(path, content);
		System.out.println(Files.readString(path));
		
		}
}