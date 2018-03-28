class Print{
	private String str;
	public Print(){
		System.out.println("Hello constructor");
	}
	public Print(String str){
		this();
		this.str = str;
		getString(str);
	}
	public static void getString(String str)
	{
		System.out.println(str);
	}
}
public class Test {
	public static void main(String[] args) {
		Print pr = new Print("Hello Jan");
	}
}
