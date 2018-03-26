class Person{
	String name;
	public Person(String name){
		this.name = name;
	}
	public void print (){
		System.out.println("print methord-->" + this);
	}
}
public class Test4{
	public static void main(String[] args) {
		Person pp = new Person ("nidie");
		System.out.println("don't understand what is this-->:"+pp);
		pp.print();
		Person pt = new Person ("nidie");
		System.out.println("don't understand what is this-->:"+pt);
		pt.print();
	}
}
