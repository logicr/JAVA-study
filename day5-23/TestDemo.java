package IO;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

import javax.xml.transform.Source;

import org.omg.CORBA.DATA_CONVERSION;

@SuppressWarnings("serial")
//public class TestDemo {
//	public static void main(String[] args) {
////		File file = new File(File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"TestIO.java");
////		File file = new File("//Users//wrinkle//Desktop//hello.txt");
////		File file = new File("/Users/wrinkle/Desktop/hello.txt");
//		File file = new File("\\Users\\wrinkle\\Desktop\\hello.txt");
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//		System.out.println(file.exists());
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
////		File file = new File(File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test.txt");
//		if(!file.getParentFile().exists()) {
//			file.getParentFile().mkdirs();
//		}
//		if(file.exists()) {
//			file.delete();
//		}else {
//			file.createNewFile();
//		}
//	}
//}
//public class TestDemo {
//	public static void main(String[] args) throws IOException {
//		File file = new File(File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test.txt");
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//		System.out.println(file.exists());
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
////		File file = new File("G:"+File.separator);//+"Tset");
//		File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test.txt");
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//		System.out.println(file.exists());//���ڷ񣿴���ture
//		//file.delete();//ɾ��
//		System.out.println(file.exists());
//		System.out.println(file);//��ӡ�ļ�
////		File [] result = file.listFiles();//��ӡ�ļ�·�����ļ�
////		for (File file2 : result) {
////			System.out.println(file2);
////		}
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//		File file2 = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"HashMap��HashTable����.png");
//		if (!file.getParentFile().exists()) {
//			//file.mkdirs();//ȫ�������ļ���
//			file.getParentFile().mkdirs();
//		}
//		if(!file.exists()) {//�����ڣ�����
//			file.createNewFile();
//		}
//		if(file.exists()) {
//			file.delete();//��ɾ���ļ�
//			file.getParentFile().delete();//��ɾ��·��
//		}
//		System.out.println(file2.exists());//���ڷ�
//		System.out.println(file2.length());//��С
//		System.out.println(new Date(file2.lastModified()));//���һ��ʱ�䣬��ʱ�����ת��һ��
//	}
//}

//public class TestDemo{
//public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop");//+File.separator+"Test.txt");
//	listFiles(file);
//	//	File [] result = file.listFiles();//��ӡ�ļ�·�����ļ�
////	for (File file2 : result) {
////		System.out.println(file2);
////	}
//	}
//	public static void listFiles(File file) {
//		if (file.isDirectory()) {
//			File[] result = file.listFiles();
//			if(null != result) {
//			for (File file2 : result) {
//				listFiles(file2);
//				}
//			}
//		}
//		else {
//			System.out.println(file);
//		}
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//	if(!file.getParentFile().exists()) {
//		file.getParentFile().mkdirs();
//	}
//	//OutputStream outputStream = new FileOutputStream(file);	//�ظ�д
//	OutputStream outputStream = new FileOutputStream(file,true);	//׷��
//	String string = "Hello Jan\r\n";
//	outputStream.write(string.getBytes());//�������
//	outputStream.write(string.getBytes(),0,5);//�������
////	file.delete();
////	file.getParentFile().delete();//���ڲ��������Բ���ɾ��
//	outputStream.close();
////	file.delete();//ɾ�ļ�
////	file.getParentFile().delete();//ɾ·��
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//	if(!file.getParentFile().exists()) {
//		file.getParentFile().mkdirs();
//	}
//	if (file.exists()) {
//		InputStream input = new FileInputStream(file);
//		byte [] data = new byte [1024];//ÿ�ζ�ȡ�������
//		int len = input.read(data);//���ݷŵ�data��
//		String str = new String(data, 0, len);//תΪString
//		System.out.println(str);
//		input.close();
//		}
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//	if(!file.getParentFile().exists()) {
//		file.getParentFile().mkdirs();
//	}
//		String str = "Hello Jan \r\n";
//		Writer writer = new FileWriter(file);//
//		writer.write(str);
//		writer.close();
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//		if (file.exists()) {
//			Reader reader = new FileReader(file);
//			char [] data = new char[1024];
//			//int len = reader.read(data);
//			//String str = new String(data, 0, len);
//			//System.out.println(str);
//			reader.read(data);
//			for (char c : data) {
//				System.out.print(c);
//			}
//			reader.close();
//		}
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//	File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test"+File.separator+"Test.txt");
//		if (!file.getParentFile().exists()) {
//			file.getParentFile().mkdirs();
//		}
//		OutputStream out = new FileOutputStream(file,true);
//		
//		String  mse = "Hello Jan \r\n";//�������
//		Writer  out2 =new OutputStreamWriter(out);//��������
//		out2.write(mse);//���
//		out2.flush();//ˢ�£���close()
//		out2.close();
//	}
//}
//class CopyFileUtil{//������
//	private CopyFileUtil() {};//���췽��˽�л�
//	//·�����
//	public static boolean	fileIsExists(String path) {
//		return new File(path).exists();
//	}
//	//·������
//	public static void createParentDir(String path) {
//		File file = new File(path);
//		if(!file.getParentFile().exists()) {
//			file.getParentFile().mkdirs();
//		}
//	}
//	//�����ļ�
//	public static boolean copyFile(String srcPath,String desPath) {
//		File inputFile = new File(srcPath);//�ļ�ȡ��
//		File outputFile = new File(desPath);
//		FileInputStream fileInputStream= null;//������
//		FileOutputStream fileOutputStream= null;//�����
//		try {
//			fileInputStream = new FileInputStream(inputFile);
//			fileOutputStream = new FileOutputStream(outputFile);
//			copyFileHandle(fileInputStream,fileOutputStream);//�� ��������
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}finally {
//			try {
//				fileInputStream.close();
//				fileOutputStream.close();
//			} catch (IOException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return true;
//	}
//	//�������Ĳ���
//	private static void copyFileHandle(InputStream inputStream,OutputStream outputStream) throws IOException {
////		byte[] data = new byte[1024];//������
//		byte[] data = new byte[10240000];//������
//		int len = 0;
//		//read()���귵��-1
//		long start = System.currentTimeMillis();
//		while ((len = inputStream.read(data)) != -1) {
//			outputStream.write(data, 0, len);//0~len����Ϊ��һ����ʱ��
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("Time: "+(end-start));
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
////	String srcPath = "G:"+File.separator+"����ѧϰ����"+File.separator+"JAVA"+File.separator+"1-Java����Լ�����������װ.pdf";
//	String srcPath = "G:"+File.separator+"BaiduYunDownload"+File.separator+"�������.Survival.Family.2017.BD720P.��������.mp4";
//	String desPath = "G:"+File.separator+"�������.Survival.Family.2017.BD720P.��������.mp4";
//	System.out.println(new File(srcPath).exists());
//	if(CopyFileUtil.fileIsExists(srcPath)) {
//		CopyFileUtil.createParentDir(desPath);
//		System.out.println(CopyFileUtil.copyFile(srcPath, desPath));
//	}else {
//		System.out.println("Դ�ļ�������");
//	}
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		File file = new File("C:"+File.separator+"Users"+File.separator+"wrinkle"+File.separator+"Desktop"+File.separator+"Test.txt");
//		OutputStream out = new FileOutputStream(file);
//		out.write("����û����".getBytes("ISO8859-1"));
//		out.close();
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		String str = "Hello Jan";
//		//ʵ���������ݱ������ڴ��У�������FileInputStream
//		InputStream input = new ByteArrayInputStream(str.getBytes());
//		OutputStream output = new ByteArrayOutputStream();
//		int tmp = 0;
//		while ((tmp = input.read())!= -1) {
//			output.write(Character.toUpperCase(tmp));
//		}
//		System.out.println(str);
//		System.out.println(output);
//		input.close();
//		output.close();
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
////		File file =  new File("C:/Users/wrinkle/Desktop/Text.txt");
////		File file =  new File("C:/Users/wrinkle/Desktop/two.txt");
////		if(!file.exists()) {
////			OutputStream out = new FileOutputStream(file);
////			out.write("Dog".getBytes());
////		}
//		File [] files = new File [] {new File("C:/Users/wrinkle/Desktop/one.txt"),new File("C:/Users/wrinkle/Desktop/two.txt")};
//		String [] data = new String [2];//
//		StringBuffer buffer = new StringBuffer();
//		for (int i = 0; i < files.length; i++) {
//			data [i]  = readFile(files[i]);
//			//�ٴ��Ż���ȥ����ʽ������
//			buffer.append(data[i]);
//			buffer.append(" ");
//		}
//		
//		//�ⲿ���Ǹ�ʽ������
////		String contentA[] = data[0].split(" ");//��data�е����ݷŵ�contenA�У������ո񣬻���Ϊ��һ������
////		String contentB[] = data[1].split(" ");
////		System.out.println(data[0]);
////		System.out.println(data[1]);
////		for (int i = 0; i < contentA.length; i++) {
////			String string = contentA[i];
////			buffer.append(string);
////			buffer.append(" ");
////			}
////		//buffer.append("\r\n");
////		for (int j = 0; j < contentB.length; j++) {
////			String string2 = contentB[j];
////			buffer.append(string2);
////		}	
//		//�Ż�
////		for (int i = 0; i < data.length; i++) {
////			buffer.append(data[i]);
////			buffer.append(" ");
////		}
//		System.out.println(buffer);
//	}
//	public static String readFile(File file) throws IOException{
//		if (file.exists()) {
//			InputStream input = new FileInputStream(file);
//			ByteArrayOutputStream byt = new ByteArrayOutputStream();
//			int tmp = 0;
//			byte [] data = new byte [10];
//			while ((tmp =input.read(data)) != -1) {
//				byt.write(data,0,tmp);
//			}
//			byt.close();
//			input.close();
//			return new String(byt.toByteArray());
//		}
//		return null;
//	}
//}
//class PrintUtil{
//	private OutputStream out;
//	public PrintUtil(OutputStream out) {
//		this.out = out;
//	}
//	public void print(String string) {
//		try {
//			this.out.write(string.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void println(String string) {
//		this.print(string+"\r\n");
//	}
//	public void print(int data) {
//		this.print(String.valueOf(data));
//	}
//	public void println(int data) {
//		this.println(String.valueOf(data));
//	}
//	public void print(double data) {
//		print(String.valueOf(data));
//	}
//	public void println(double data) {
//		this.print(String.valueOf(data));
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
////		PrintUtil printUtil = new PrintUtil(new FileOutputStream(new File("C:/Users/wrinkle/Desktop/Print.txt")));
//		PrintUtil printUtil = new PrintUtil(System.out);
//			printUtil.print(1);
//			printUtil.println(2);
//			printUtil.print("Hello");
//			printUtil.println("Jan");
//			printUtil.print(6.0);
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) {
//		String name = "Jan";
//		int age = 20;
//		double money = 0.005892525;
//		String str = String.format("name: %s age: %d money: %1.5f",name,age,money);
//		System.out.println(str);
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
//		byte[] data = new byte[4];
//		System.out.println("input:>");
//		int tmp = in.read(data);
//		in.close();
//		System.out.println(new String(data,0,tmp));
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
//		ByteArrayOutputStream bb = new ByteArrayOutputStream();
//		byte[] data = new byte[4];
//		System.out.println("input:>");
//		int tmp = 0;
//		while ((tmp = in.read(data)) != -1) {
//			bb.write(data,0,tmp);
//			if (tmp < data.length) {
//				break;
//			}
//		}
//		in.close();
//		bb.close();
//		System.out.println(new String(bb.toByteArray()));
//	}
//}
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("input:>");
//		String str = buf.readLine();
//		System.out.println(str);
//	}
//}
//
//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Input:>");
//		if(scn.hasNext()) {
//			System.out.println(scn.next());
//		}
//		scn.close();
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Input:>");
//		if(scn.hasNext()) {
//			int age = scn.nextInt();
//			System.out.println(age);
//		}else {
//			System.out.println("input error");
//		}
//		scn.close();
//	}
//}

//public class TestDemo{
//	public static void main(String[] args) throws IOException {
//		Scanner scn = new Scanner(new FileInputStream(new File("C:/Users/wrinkle/Desktop/Localhost��������.txt")));
////		scn.useDelimiter("\n");//�Զ��嵱ǰ�ļ�
//		while (scn.hasNext()) {
//			System.out.println(scn.next());
//		}
//		scn.close();
//	}
//}

class Person implements Serializable{
	private transient String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
public class TestDemo{
	public static final File FILE = new File("C:/Users/wrinkle/Desktop/test.txt");
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ser(new Person("Jan", 23));
	}
	public static void ser(Object obj)throws FileNotFoundException,IOException, ClassNotFoundException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
//		ObjectOutputStream out = new ObjectOutputStream(System.out);
		out.writeObject(obj);
		out.close();
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(FILE));
		System.out.println(oin.readObject());
		oin.close();
	}
}
