package SupportingComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling {

	/**
	 * @author Tejesh Gangari
	 * Desc: This Class will take care of File handling functionalities
	 */
	
	static public FileInputStream fi;
	static public XSSFWorkbook wb;
	
	public static boolean isFileAvailable(String filePath) {
		
		boolean isFileAvailable = false;
		
		File file = new File(filePath);
		if(file.canRead()) {
			isFileAvailable = true;
		}
		
		return isFileAvailable;
	}
	
	
	public static XSSFWorkbook getWorkBook(String filePath) {
		
		File file = new File(filePath);
		
		try {
			fi = new FileInputStream(file);
			wb = new XSSFWorkbook(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wb;
	}
}
