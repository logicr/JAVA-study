package reflect;

 class HelloA {
	//���췽��
	public HelloA(){
	System.out.println("Hello A!���๹�췽��");
	}
	//�Ǿ�̬�����
	{
	System.out.println("i'm A class.����Ǿ�̬�����");
	}
	//��̬�����
	static{
	System.out.println("static A ���ྲ̬�����");
	}
	}
	public class HelloB extends HelloA {
	//���췽��
	public HelloB(){
	System.out.println("Hello B! ���췽��");
	}
	//�Ǿ�̬�����
	{
	System.out.println("i'm B class.�Ǿ�̬�����");
	}
	//��̬�����
	static{
	System.out.println("static B ��̬�����");
	}
	public static void main(String[] args) {
	System.out.println("---start---");
	new HelloB();
	new HelloB();
	System.out.println("---end---");
	}
	}