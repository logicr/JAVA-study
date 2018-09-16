package content;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

//用IO将一个个的联系人导出
//建一个联系人类
class Content{
	//格式
//	BEGIN:VCARD
//	VERSION:3.0
//	N;CHARSET=UTF-8:张三
//	FN;CHARSET=UTF-8:张三
//	TEL;TYPE=CELL:12345678910
//	END:VCARD
	private String begin = "BEGIN:VCARD";
	private String version = "VERSION:3.0";
	private StringBuilder N = new StringBuilder("");
	private StringBuilder FN = N;
	private StringBuilder tel = new StringBuilder("TEL;TYPE=CELL:");
	private String end = "END:VCARD";
		
	
	public Content(String n,String tel) {
		super();
		N = N.append(n);
		FN = N;
		this.tel = this.tel.append(tel);
	}


	@Override
	public String toString() {
		return "Content [begin=" + begin + ", version=" + version + ", N=" + N + ", FN=" + FN + ", tel=" + tel
				+ ", end=" + end + "]";
	}
	
}
public class Test {
	public static void main(String[] args) throws IOException {
//		File file = new File("C:/Users/wrinkle/Desktop/content.vcf");
		File file = new File("C:/Users/wrinkle/Desktop/content.vcf");
		if( ! file.exists()) {
			file.createNewFile();
		}
		if(! file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		
//		
//		OutputStream out = new FileOutputStream(file,true);
//		out.write(con.toString().getBytes());
		//放弃使用类的方式
		
		//用输出流
		Scanner scanner = new Scanner(System.in);
		String n = new String();
		String num = new String();
		System.out.println("Please input name:>");
		n = scanner.next();
		System.out.println("Please input num:>");
		num =scanner.next();
		content(file, n, num);
		scanner.close();
	}
	public static void content(File file,String n,String num) throws IOException {
		//格式
//		BEGIN:VCARD
//		VERSION:3.0
//		N;CHARSET=UTF-8:张三
//		FN;CHARSET=UTF-8:张三
//		TEL;TYPE=CELL:12345678910
//		END:VCARD
		String N = "N;CHARSET=UTF-8:";//必须加
//		String N = "N;";
		N = N + n;
		String FN = "FN;CHARSET=UTF-8:";//必须加上
//		String FN = "FN;";
		FN = FN +n;
		String TEL = "TEL;TYPE=CELL:";
		TEL = TEL + num;
		
//		PrintStream prin = new PrintStream(new FileOutputStream(file,true));
//		new PrintStream(file, "UTF-8");
//		PrintStream prin = new PrintStream(file, "UTF-8");//设置字符集，很重要啊，不然乱码，程序5分钟，调码两小时啊
		OutputStream out = new FileOutputStream(file,true);//实现追加输入
		PrintStream prin = new PrintStream(out, true,"UTF-8");
//		PrintWriter prin = new PrintWriter(new FileOutputStream(file,true));
		prin.println("BEGIN:VCARD");
		prin.println("VERSION:3.0");
		prin.println(N);
		prin.println(FN);
		prin.println(TEL);
		prin.println("END:VCARD");
		out.close();
		prin.close();
	}
}
