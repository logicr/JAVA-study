// class Person{
// 	private String name;
// 	private int age;
// 	public Person (){
// 		System.out.println("biubiu");// no parameter structure
// 	}
// 	public Person (String n,int i){//parameter structure
// 		name = n;
// 		setAge(i);
// 		System.out.println("i am here");
// 	}
// 	public void setName(String n){//setter name
// 		name = n;
// 	}

// 	public String getName (){//getter name
// 		return name;
// 	}
// 	public void setAge(int i){// setter age
// 		if ( i> 0 && i < 100){
// 			age = i;
// 		}
// 		else{
// 			age = 0;
// 		}
// 	}
// 	public int getAge(){//getter age
// 		return age;
// 	}
// 	public void getPersonInfo(){//check privati and print it
// 		System.out.println(name +" "+age);
// 	}
// }
// public class Test{
// 	public static void main(String[] args){
// 		// Person per = new Person ();//类名称 对象名称 = new 类名称();
// 		// per.name = "你爹";
// 		// per.age = 23;
// 		// Person per = new Person ("你爹",23);
// 		// Person p = new Person();
// 		// p.setName("你爷爷");
// 		// p.setAge(200);
		
// 		// System.out.println(p.setName("你爷爷"));//已经加了private，外部都不能调用
// 		// p.getPersonInfo();
// 		// Person pp = new Person("nidie",22);
// 		Person pp = new Person("nidaye",35);
// 		// System.out.println(new Person ("niyyeye",99).getPersonInfo);
// 		// new Person ("niyyeye",99).getPersonInfo;
// 		pp.getPersonInfo();
		
// 	}
// }
class Person {
	private String name;
	private int age;
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getPersonInfo(){
		return "name :" + name +",age :"+age;
	}
}
public class Test{
	public static void main(String[] args) {
		Person pp = new Person("nidie",23);
		System.out.println(pp.getPersonInfo());
	}
}