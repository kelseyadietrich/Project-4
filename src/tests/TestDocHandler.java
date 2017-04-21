package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import resume.DocHandler;

public class TestDocHandler {

	DocHandler document;
 	
 	@Before
 	public void setup() {
 		DocHandler document = new DocHandler();
 		this.document = document;
 	}
 	
 	@Test
 	public void test1() {
 		document.write("This is just a test motherfucker");
 		try {
			String text = document.read();
			assertEquals("This is just a test motherfucker", text);
		} catch (IOException e) {
			System.out.println("Failed test");
			e.printStackTrace();
		}
 	}


}
