package tests;

import java.io.File;

public class FilePathDemo {
	public static void main(String[] args) {
		show(".");
		show("..");
		
	}
	
	public static void show(String where) {
		System.out.println("Showing " + where);
		File f = new File(where);
		System.out.println(f.getAbsolutePath());
		for (String name: f.list()) {
			System.out.println(name);
		}
	}
}
