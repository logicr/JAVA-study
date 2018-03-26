class Person {
	private String name;
	private int age;
	public Person(){
		System.out.println("wa,you are beautifull");
	}
	public Person(String name,int age)
	{
		this();
		this.name = name;//invoke this class propety;
		this.age = age;
		this.print();// this is "invoke ordinary methord",watch out this piont " . ",
		//it's diffrience with "invoke this class metord" 
		// this();//if this() write here will wrong,it must set on the first on line;
	}
	public String getPersonInfo(){//this metord is to return for printing it
		return "name :" + name +",age :"+age;
	}
	public void print(){
		System.out.println("haha,i am Jan,java is interestin,it is a joke");
	}
}
public class Test2{
	public static void main(String[] args) {
		Person pp = new Person("nidie",23);
		System.out.println(pp.getPersonInfo());
	}
}
