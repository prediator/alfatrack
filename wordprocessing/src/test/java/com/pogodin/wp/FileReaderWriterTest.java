package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;


public class FileReaderWriterTest {

	@Test
	public void shoulrReadFromFileThatIsWasWrited(){
		
		String hello = "evil dragon belt";
		String filePath = "testFile.txt";
		FileReaderWriter frw = FileReaderWriter.getInstance();
		File file = new File(filePath);
		
		frw.writeFile(hello, filePath);
		
		assertEquals(hello, frw.readFile(filePath));
		file.delete();
		
	}
}
