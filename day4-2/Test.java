// 5.编程题： 
// 定义一个抽象的"Role"类，有姓名，年龄，性别等成员变量 
// 1）要求尽可能隐藏所有变量(能够私有就私有,能够保护就不要公有)，
// //private,abstract 
// 再通过GetXXX()和SetXXX()方法对各变量进行读写。具有一个抽象的play()方法， 
// 该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。
// //this ,构造方法，
// 2）从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构造方法除外），
// //? 内部类？
// 并扩展salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。 //static
// 同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法， 
// //super ，//重写？
// 并提供一个final sing()方法。 
// //final
// 3）"Manager"类继承"Employee"类，有一个final成员变量"vehicle" 
// //继承
// 在main()方法中制造Manager和Employee对象,并测试这些对象的方法。
abstract class Role {//抽象方法
	private String name;
	private int age;
	private String sex;
	public void setName (String name){//setter方法
		this.name = name;
	}
	public String getName (){//getter 方法
		return name;
	}
	public void setAge (int age){//settter
		this.age = age;
	}
	public int  getAge (){//getter
		return age;
	}
	public void setSex (String sex){//setter
		this.sex = sex;
	}
	public String getSex(){//getter
		return sex;
	}
	public abstract void play();//抽象方法，只能由子类实现
	public Role (){//无参构造器
		System.out.println ("i'm here");
	}
	public Role (String name){//有参构造
		this();//this调用本类方法
		this.name = name;
	}
	public Role (String name,int age,String sex){//有参构造
		this(name);//调用本类方法
		this.age = age;
		this.sex = sex;
	}
	
}
class Employee extends Role{//继承Role
		private int salary;
		static int ID;
		public Employee(){}//一个午餐构造
		public void play (){//实现父类的抽象方法
			System.out.println (this.getAge());//注意这里的this
			System.out.println (this.ID);

			System.out.println ("Hello Employee");
			// this.sing();//ok
		}
		public Employee(int salary,String name,int age,String sex,int ID){//Employee 的有参构造
			super(name,age,sex);
			this.ID = ID;
			this.salary = salary;
		}
		final void sing (){//final 方法
			System.out.println("sing");
		}
		}	
class Manager extends Employee{//manager继承Employee 
	public static final int vehicle = 0127;
	public Manager(int salary,String name,int age,String sex,int ID){//构建一个有参构造用来传递参数
		super(salary, name, age, sex, ID);
	}

}
public class Test {
	public static void main(String[] args) {
		// Manager man = new Manager();
		Role emp = new Employee(12,"Jan",23,"man",12);
		emp.play();
		this.sing();
		System.out.println("+++++++++++++++++++++++++++++++++");
		Role man = new Manager(555,"logicr",202,"man",88);
		man.play();
	}
}



// abstract class Person{
// private String name ; // 属性
// public String getName(){ // 普通方法
// 	return this.name;
// }
// public void setName(String name){
// 	this.name = name ;
// }
// // {}为方法体，所有抽象方法上不包含方法体
// public abstract void getPersonInfo() ; //抽象方法
// }
// class Student extends Person{
// 	public void getPersonInfo(){
// 		System.out.println("I am a student");
// 	}
// }
// public class Test{
// 	public static void main(String[] args) {
// Person per = new Student() ; //实例化子类，向上转型
// per.getPersonInfo() ; //被子类所覆写的方法
// //per.setName("Jan");
// System.out.println(per.getName());
// }
// }


// class Person{
// 	public String info = "爸爸！";
// }
// class Student extends Person{
// 	public String info = "儿子！" ;
// 	public void print(){
// //不找本类中的属性
// 		System.out.println(super.info);
// 		System.out.println(this.info);
// 	}
// }
// public class Test{
// 	public static void main(String[] args) {
// 		new Student().print();
// 	}
// }
// class Person{
// 	private String name;
// 	public String getName() {
// 		return name;
// 	}
// 	public void setName(String name) {
// 		this.name = name;
// 	}
// }
// class Student extends Person{
// 	public void fun(){
// 		System.out.println(getName());
// 	}
// }
// public class Test {
// 	public static void main(String[] args) {
// 		Student student = new Student();
// 		student.setName("Steven");
// 		System.out.println(student.getName());
// 		student.fun();
// 	}
// }




// class Person{
// 	public void print(){
// 		System.out.println("[PRINT]方法："+this);
// 	}
// }
// public class Test{
// 	public static void main(String[] args) {
// 		Person p1 = new Person();
// 		System.out.println("[MAIN]方法："+p1);
// 		p1.print();
// 		System.out.println("=================");
// 		Person p2 = new Person();
// 		System.out.println("[MAIN]方法："+p2);
// 		p2.print();
// 	}
// }

// class Person{
// 	private String name;
// 	private int age;
// 	public Person(String name,int age){
// 		this.name = name ;
// 		this.age = age ;
// 		this.print();//调用普通方法
// }
// public String getPersonInfo(){
// 	return "姓名：" + name + ",年龄："+age;
// }
// public void print(){
// 	System.out.println("*****************");
// }
// }
// public class Test{
// 	public static void main(String[] args) {
// 		Person per = new Person("张三",20);
// 		System.out.println(per.getPersonInfo());
// 	}
// }





// public class Test {
// 	public static void main(String[] args) {
// 		printDaffodilsNum();
// 	}
// 	public static void printDaffodilsNum(){
// 		int i = 0;
// 		for (i = 1; i < 1000 ; i ++){
// 			int tmp = i;
// 			int sum = 0;
// 			//while (tmp){//错误写法，java中有布尔型的数值专门用做判断
// 			while (0 != tmp){
// 				sum += (tmp%10)*(tmp%10)*(tmp%10);
// 				tmp /= 10;
// 					//System.out.println(tmp);
// 					//System.out.println(sum);
// 			}
// 			if (sum == i){
// 					System.out.println(i);
// 				}

// 		}
// 	}
// }





// class A {
// 	public A (){
// 		System.out.println ("A");
// 	}
// }

// class B extends A {
// 	public B (){
// 		System.out.println("B");//父类先执行A，再执行B
// 	}
// 	public static void main(String[] args) {
// 		B b = new B();
// 	}
// }






// class A {
// 	int y = 6;
// 	class Inner {
// 		static int y = 3;
// 		/*static 修饰 int y = 3，int y = 3 将被共享，
// 		但是int y的作用域是内部类 Inner ，
// 		static 修饰之后并不能改变其作用域，所以产生矛盾。*/
// 		void show (){
// 			System.out.println(y);
// 		}
// 	}
// }
// class Test {
// 	public static void main(String[] args) {
// 		A.Inner inner = new A().new Inner();
// 		inner.show();
// 	}
// }























// class Father {
// 	private String name = "Jan";
// 	class Child {
// 		public void introFather( ){
// 			System.out.println(name);
// 		}
// 	}
// }
// public class Test {
// 	public static void main(String[] args) {
// 		Father.Child child = new Father().new Child();
// 		child.introFather();

// 	}
// }