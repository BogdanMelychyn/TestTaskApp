package ua.lviv;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerObject {
	
	// deserializing object from file
	public Object deserData(String fileName) {
		FileInputStream fileIn;
		Object object = null;
		try {
			File file = new File(fileName + ".ser");
			
			if (file.createNewFile()) 
			fileIn = new FileInputStream(file);
			
			fileIn = new FileInputStream(fileName + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			object = in.readObject();
			fileIn.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			
		} catch (EOFException e) {
			System.out.println("");
			
		} catch (IOException e) {
			System.out.println("Warning! Input/Output ERROR!");
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found!");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return object;
	}
	
	// serializing object into file
	public void serData(String fileName, Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			fileOut.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Warning! Input/Output ERROR!");
			e.printStackTrace();
		}catch (Exception e) {
				System.out.println("Warning! ERROR!");
				e.printStackTrace();
				System.exit(1);
		}
	}
	
}
