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

//��IO��һ��������ϵ�˵���
//��һ����ϵ����
class Content{
	//��ʽ
//	BEGIN:VCARD
//	VERSION:3.0
//	N;CHARSET=UTF-8:����
//	FN;CHARSET=UTF-8:����
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
		
		
//		Content con = new Content("���ǲ�������", "13314433445");
//		OutputStream out = new FileOutputStream(file,true);
//		out.write(con.toString().getBytes());
		//����ʹ����ķ�ʽ
		
		//�������
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
		//��ʽ
//		BEGIN:VCARD
//		VERSION:3.0
//		N;CHARSET=UTF-8:����
//		FN;CHARSET=UTF-8:����
//		TEL;TYPE=CELL:12345678910
//		END:VCARD
		String N = "N;CHARSET=UTF-8:";//�����
//		String N = "N;";
		N = N + n;
		String FN = "FN;CHARSET=UTF-8:";//�������
//		String FN = "FN;";
		FN = FN +n;
		String TEL = "TEL;TYPE=CELL:";
		TEL = TEL + num;
		
//		PrintStream prin = new PrintStream(new FileOutputStream(file,true));
//		new PrintStream(file, "UTF-8");
//		PrintStream prin = new PrintStream(file, "UTF-8");//�����ַ���������Ҫ������Ȼ���룬����5���ӣ�������Сʱ��
		OutputStream out = new FileOutputStream(file,true);//ʵ��׷������
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
