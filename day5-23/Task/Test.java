package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
//class PrintUtil{
//	private OutputStream out;
//
//	public PrintUtil(OutputStream out) {
//		super();
//		this.out = out;
//	}
//	public void print(String str) {
//		try {
//			this.out.write(str.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void print(int data) {
//		this.print(String.valueOf(data));
//	}
//	public void println(String str) {
//		this.print(str+"\r\n");
//	}
//	public void println() {
//		this.print("\r\n");
//	}
//}
//public class Test {
//	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("C:/Users/wrinkle/Desktop/test.txt");
//		PrintUtil printUtil = new PrintUtil(new FileOutputStream(file));
//		printUtil.print("Hello");
//		printUtil.print(123);
//		printUtil.println();
//		printUtil.print("hello bit");
//		Scanner scanner = new Scanner(file);
////		scanner.close();
//		while (scanner.hasNext()) {
//			System.out.println(scanner.nextLine());
//		}
//		
//		scanner.close();
//	}
//}
class Person implements Serializable{
	private transient String name;
	private int age;
	private String school ;
	public Person(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
}
public class Test {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("C:/Users/wrinkle/Desktop/testser.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(new Person("Jan", 23, "SUST"));
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		System.out.println(oin.readObject());
		oin.close();
		out.close();
	}
}