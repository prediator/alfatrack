package com.pogodin.wp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileReaderWriter {

	public static  String readFile(String filePath) {

		try {
			FileReader reader = new FileReader(filePath);
			try {
				return IOUtils.toString(reader);
			} finally {
				IOUtils.closeQuietly(reader);
			}
		} catch (FileNotFoundException e) {
			System.err.println("file " + filePath + " Not find");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void writeFile(String fileContent, String filePath){

		try {
			File file = new File(filePath);

			if (file.exists()){
				file.delete();
			}
				file.createNewFile();

			FileWriter out = new FileWriter(file, true);
			try {
				out.write(fileContent);
			} finally {
				IOUtils.closeQuietly(out);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
