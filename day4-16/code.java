// 作业
// 2.编程题: 
// 要求: 
// 1).Person类有name,age,salary属性，要求实现至少两个构造方法，并且属性私有，提供对应的getter、setter。 
// 2).覆写toString方法，要求在System.out.println()函数中传递Person对象能打印出三个属性值而不是对象地址。 
// 3).覆写equals方法，要求两个Person类对象的值相同时返回true。 

// 3.说出下列程序的执行结果，并说明原因: 
// Integer a = 55; 
// Integer b = 55; 
// System.out.println(a==b); 
// System.out.println(a==new Integer(55)); 
// System.out.println(a.equals(new Integer(55))); 
// Integer c = 129; 
// Integer d = 129; 
// System.out.println(c==d); 

// 4.写出懒汉式单例模式 

// 5.编程: 
// 1).定义一个MulException类继承Exception类，要求两数相乘等于100报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。 
// 2).定义一个DivException类继承RuntimeException类，要求两数相除等于2报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。 

// 6.(算法) 
// 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
// package task4_13;

//import javax.jws.Oneway;
//import javax.print.attribute.standard.MediaName;

////1).Person类有name,age,salary属性，要求实现至少两个构造方法，并且属性私有，提供对应的getter、setter。 
////2).覆写toString方法，要求在System.out.println()函数中传递Person对象能打印出三个属性值而不是对象地址。 
////3).覆写equals方法，要求两个Person类对象的值相同时返回true。 
//class Person {
//	private String name;
//	private int age;
//	private int salary;
//	public Person() {//无参构造
//		System.out.println("i'm here");
//	}
//	public Person(String name) {//有参构造
////		this();
//		this.name = name;
//	}
//	public String toString () {//覆写toString（）
//		return "name:"+this.name+" age:"+this.age+" salary:"+salary;
//	}
//	public boolean equals(Object obj) {//覆写equals
//		if (null == obj) {
//			return false;
//		}
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Person)) {
//			return false;
//		}
//		Person per = (Person)obj;//这里要向下转型是因为无法用obj.name调用name，在父类Object中没有name
//		return this.name.equals(per.name);
//	}
//	public String getName() {//getter,setter
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public int getSalary() {
//		return salary;
//	}
//	public void setSalary(int slaary) {
//		this.salary = slaary;
//	}
//}
//public class Test {
//
//	public static void main(String[] args) {
////	Person person = new Person();
////	person.setAge(20);
////	person.setName("Jan");
////	person.setSalary(9000);
////	System.out.println(person.toString());	
//	Person p1 = new Person("Jan");
//	Person p2 = new Person("Jan");
//	System.out.println(p1.equals(p2));
//	{
//		Integer a = 55; 
//		Integer b = 55; 
//		System.out.println(a==b); //ture,自动装箱在-128~127之间时共用
//		System.out.println(a==new Integer(55));//false 
//		System.out.println(a.equals(new Integer(55)));//ture 
//		Integer c = 129; 
//		Integer d = 129; 
//		System.out.println(c==d); //false
//	}
//	}
//
//}


//++++++++++++++++++++++++++++++++++++++++++++++++++++
//懒汉单例，上来就new的是饿汉

//class Idler{
//	private static Idler idler;//注意，static修饰的，这里始终都只有这一个对象
//	private Idler() {}//私有化构造方法，使外部无法使用它产生对象
//	public static Idler getIdler() {//用一个静态方法来产生对象
//		if(null == idler) {
//			idler = new Idler();
//		}
//		return idler;//让外部接收这个产生的对象
//	}
//	public void print() {//检测方法，如果能用对象调用，那么对象产生成功。
//		System.out.println("Hello Jan");
//	}
//}
//public class Test {
//	public static void main(String[] args) {
//		Idler idler =Idler.getIdler();
//		idler.print();
//	}
//}

//5.编程: 
//1).定义一个MulException类继承Exception类，要求两数相乘等于100报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。 
//2).定义一个DivException类继承RuntimeException类，要求两数相除等于2报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。 
//+++++++++++++++++++++++++++++++++++++++++++++
//1.0
//class MulException extends Exception{
//	 public MulException(String info) {
//		 super(info);
//	}
//}
//public class Test{
//	public static void main(String[] args) {
//		try {
//			mul(2,50);
//		} catch (MulException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
//	public static void mul(int x,int y) throws MulException {
//		if(100 != x*y) {
//			System.out.println(x*y);
//		}else {
//			throw new MulException("wrong!");
//		}
//	}
//}

//2.
//class DivException extends RuntimeException{
//	public DivException(String info) {
//		super(info);
//	}
//}
//public class Test{
//	public static void main(String[] args) {
//		div(4,2);
//	}
//
//	private static void div(int x, int y) {
//		if(2 != x/y) {
//			System.out.println(x/y);
//		}else {
//			throw new DivException("the result can't be 2!");
//		}
//	}
//}


//++++++++++++++++++++++++++++++++++++++++++++++

public class Test{
	public static void main(String[] args) {
		monkey();
//1 4 10 22 46 94 190 382 766 1534
		System.out.println(monkeys(10));
	}
	//迭代猴子
	public static void monkey() {
		int i = 10;
		int num =1;
		while(1 !=i--) {
			num = 2*(num +1);
		}
		System.out.println(num);
	}
	//递归猴子
	public static int monkeys(int i) {
		if (1 == i) {
			return 1;
		}else {
			System.out.println("monkey");
			return 2*(monkeys(i-1)+1);
		}
	}
}

