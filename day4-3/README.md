	1.

	interface InterfaceA { //接口
		String S = "good "; 
		void f(); 
	} 

	abstract class ClassA { //抽象类,不能直接产生实例化对象，必须有子类，子类覆写所有抽象方法
		abstract void g(); //抽象方法
	} 

	class ClassB extends ClassA implements InterfaceA { //继承抽象方法和接口
		void g() { //实现抽象方法，使用了接口的String S;
			System.out.print(S); 
		} 

		public void f() { //调用接口
			System.out.print(" "+ S); 
		} 
	} 
	public class Test { 
		public static void main(String[] args) { 
			ClassA a = new ClassB(); //classB向上转型
			InterfaceA b = new ClassB(); //classB向上转型
			a.g(); //good
			b.f(); //good
		} 
	}

	2.编程题: 
	利用接口做参数，写个计算器，能完成加减乘除运算。 
	（1）定义一个接口Compute含有一个方法int computer(int n, int m)。 
	（2）设计四个类分别实现此接口，完成加减乘除运算。 
	（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, 
	int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，
	并输出运算的结果。 
	（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。 



	interface IComputer{//接口
		public int computer (int n,int m);

	}

	class UseComputer{
		public static void useCom(IComputer com, int one,int two){//难点，不太懂,这个IComputer com


			com.computer(one,two);//这儿在类 UseComputer 里为什么可以调用 下面的类？
			// if ("add".equals(com) ){
			// 	Add add=new Add ();
			// 	add.Computer(one,two);
			// }
			// if ("sub".equals(com) ){
			// 	new Sub (one,two);
			// }
			// if ("mul".equals(com) ){
			// 	new Mul (one,two);
			// }
			// if ("div".equals(com) ){
			// 	new Div (one,two);
			}


		}

		class Add implements IComputer {
			public int computer (int n, int m){
			//return n + m;
				System.out.println(n + m);
				return 0;

			}
		}
		class Sub implements IComputer {
			public int computer (int n,int m){
			//return n - m;
				System.out.println(n - m);
				return 0;
			}
		}
		class Mul implements IComputer {
			public int computer (int n,int m){
			//return n * m;
				System.out.println(n * m);
				return 0;
			}
		}
		class Div implements IComputer {
			public int computer (int n,int m){
			//return n / m;
				System.out.println(n / m);
				return 0;
			}
		}


	public class Test {
		public static void main(String[] args) {
			//args[0],args[1],args[2] Integer.parseInt(args[0])
			// if (args.length <= 3){
			// 	System.out.println("format error! add a b");
			// 	System.exit(1);
			// }
			UseComputer computer = new UseComputer();//(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
			computer.useCom(new Add(),Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		}
	}




	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	3.按如下要求编写Java程序： 
	（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。 
	（2）定义接口B，里面包含抽象方法void setColor(String c)。 
	（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。 
	（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、 
	圆柱体的高height、颜色color。 
	（5）创建主类来测试类Cylinder。 

	interface IA {//接口A
		double PI = 3.14;
		// public static final double PI = 3.14;
		double area();
		// public abstract double area();
	}
	interface IB {//接口B
		// private String c;
		void setColor(String c);
	}
	interface IC extends IA,IB{//接口C 继承了A，B
		void volum ();
	}
	class Cylinder implements IC{//子类继承C 接口 调用接口 implements
		private int radius;
		private int height;
		private String color;
		public Cylinder(int radius,int height,String color)//有参构造,传入参数
		{
			this.radius = radius;
			this.height = height;
			this.color = color; 
		}
		public double area()//实现接口 A的抽象方法
		{
			return PI * radius*radius;
		}
		public void setColor (String color){ //实现B接口的方法
			this.color= color;
			System.out.println (color);
		}
		public void volum (){ //实现C接口的方法
			//return PI * radius*radius*height;
			System.out.println (PI * radius*radius*height);
			System.out.println (this.color);
		} 
	}

	public class Test {
		public static void main(String[] args) {
			Cylinder area = new Cylinder (2,2,"red");
			area.volum();
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println(area.area());
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			// area.setColor("yellow");
		}
	}

	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	4.(附加题-算法) 
	一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
	例如6=1＋2＋3.编程 找出1000以内的所有完数。
	public class Test {
		public static void main(String[] args) {
			find();
		}
		public static void find (){
			int i = 0;
			int sum = 0;
			for (i = 1; i < 1000; i ++){//拿每一个数出来进行循环
				int j = 0;
				sum = 0;
				for ( j = 1; j <= i/2; j ++){// 因子如果大于自身的一半就无法整除，节省时间t/2
					if ( 0 == i % j){//余数不为零，那么j是i的因子
						sum += j ;
					}
				}
					if (sum == i){//判断结果，满足输出。
						System.out.println (i);
					}
			}
		}
	}


