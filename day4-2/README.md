
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
			// emp.sing();//怎么实现在这儿调用this方法
			System.out.println("+++++++++++++++++++++++++++++++++");
			Role man = new Manager(555,"logicr",202,"man",88);
			man.play();
		}
	}
