class Person{
	private String name;
	private int age;
	public Person(){
		System.out.println("-------------I'm no parameter---------");
	}
	public Person(String name){
		System.out.println("-------------I'm name parameter---------");
		this.name = name;
	}
	public Person (String name,int age){
		System.out.println("-------------I'm name and age parameter---------");
		this.name = name;
		this.age = age;
	}
	public String getPersonInfo(){
		return "name: "+name+" age: "+age;
	}
}
class Persons{
	private String name;
	private int age;
	public Persons(){
		System.out.println("-------------I'm object---------");
	}
	public Persons(String name){
		this();
		this.name = name;
	}
	public Persons (String name,int age){
		this(name);
		this.age = age;
	}
	public String getPersonInfo(){
		return "name: "+name+" age: "+age;
	}
}
public class Test3{
		public static void main(String[] args) {
				Person per1 = new Person();        
				Person per2 = new Person("nibaba");        
				Person per3 = new Person("nigege",20);        
				System.out.println(per1.getPersonInfo());        
				System.out.println(per2.getPersonInfo());        
				System.out.println(per3.getPersonInfo()); 
				System.out.println("############### I am division line ######################");
				Persons ps = new Persons("nilaolao",90);
				System.out.println(ps.getPersonInfo());        
		}

	}