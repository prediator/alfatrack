package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class FileReaderWriterTest {

	@Test
	public void shouldReadFromFileThatIsWasWrited() {

		String hello = "evil dragon belt";
		String filePath = "testFile.txt";

		FileReaderWriter.writeFile(hello, filePath);

		assertEquals(hello, FileReaderWriter.readFile(filePath));
		new File(filePath).delete();

	}
}
