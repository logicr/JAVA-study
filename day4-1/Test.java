class Outer{
	private String msg = "Hello World" ;
// ********************************
class Inner{ //定义一个内部类
public void print(){ //定义一个普通方法
System.out.println(msg); //调用msg属性
}
}
// ********************************
//在外部类中定义一个方法，该方法负责产生内部类对象并且调用print()方法
public void fun(){
Inner in = new Inner(); //内部类对象
in.print(); // 内部类提供的print()方法
}
}
public class Test{
	public static void main(String[] args) {
Outer out = new Outer(); //外部类对象
out.fun(); //外部类方法
}
}
// public class Test {
	
// 	public Test(){
// 		System.out.println ("2 构造方法");
// 		}
   
//     {
// 			System.out.println ("1 构造块");//构造块优先于构造方法执行
// 	}
// 	static {

// 		System.out.println ("3 静态块");//只执行一次

// 	}


// 	public static void main(String[] args) {
// 		System.out.println("--start--");
// 		new Test();
// 		new Test();
// 		System.out.println("--end---");
// 	}
// }

// // class Person {
	
// // 	public Person(){
// // 		System.out.println ("2 构造方法");
// // 		}
   
// //     {
// // 			System.out.println ("1 构造块");//构造块优先于构造方法执行
// // 	}
// // 	static {

// // 		System.out.println ("3 静态块");//只执行一次

// // 	}

// // }
// // public class Test {
// // 	public static void main(String[] args) {
// // 		System.out.println("--start--");
// // 		new Person();
// // 		new Person();
// // 		System.out.println("--end---");
// // 	}
// // }