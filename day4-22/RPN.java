package stack;

interface Stack {
	void stackPush(Object obj);
	void stackPop();
	int stackSize();
	Object stackTop();
	void printLink();
}

class Factory {// 工厂模式实例化StackImpl类
	private Factory() {
	}

	public static Stack getLinkInstance() {
		return new StackImpl();
	}
}

class StackImpl implements Stack {// 继承了Stack接口的方法，通过向上转型，产生实例化对象
	private int size = 0;// Stack入栈元素的数量
	private Node first;// 栈底，
	private Node last;// 栈顶

	private class Node {// 产生节点的内部类
		private Object item;// 存放入栈元素
		private Node next;// 放下一次要入栈的节点

		private Node(Object item, Node next) {// 构造方法
			this.item = item;
			this.next = next;
		}
	}

	@Override
	public void stackPush(Object obj) {// 入栈方法
		Node tmp = this.first;
		Node newnode = new Node(obj, null);
		this.last = newnode;
		if (this.first == null) {// 第一次入栈，设栈底
			this.first = newnode;
		} else {
			while (null != tmp.next) {// 非第一次入栈，遍历找栈顶，入栈
				tmp = tmp.next;
			}
			tmp.next = newnode;
		}
		this.size++;// 记得扩充元素数量
	}

	@Override
	public void stackPop() {// 出栈
		Node tmp = this.first;
		if(null ==tmp.next) {//当栈中只有一个元素时，直接清空栈
			this.first = null;
			this.last = null;
			this.size = 0;
			return;
		}
		while (null != tmp.next.next) {// 遍历栈，找离栈顶一个节点的节点
			tmp = tmp.next;
		}
		this.last = tmp;// 重设栈顶
		tmp.next = null;
		this.size--;
	}

	@Override
	public int stackSize() {// 获取当前栈中节点数（元素数量）
		return this.size;
	}

	@Override
	public Object stackTop() {// 获取栈顶元素
		return this.last.item;
	}

	@Override
	public void printLink() {// 辅助方法，查看当前栈中的所有元素
		Node tmp = this.first;
		while (null != tmp) {
			System.out.println(tmp.item);
			tmp = tmp.next;
		}
	}
}


public class Test {
	public static void main(String[] args) {
		Stack stack = Factory.getLinkInstance();//调用工厂类get方法，产生一个StackImpl类实例，向上转型实现Stack接口
		String str = "12 3 4 + * 6 - 8 2 / +";
		bracket(str, stack);
		//+++++++++++++++++++++++
		//测试入栈
//		stack.stackPush(1);
//		stack.stackPush("2");
//		stack.stackPush("3");
//		stack.stackPush("4");
//		stack.stackPush("5");
//		stack.stackPush("6");
//		stack.printLink();
//		System.out.println("++++++++++++++++++++++++++");
//		//+++++++++++++++++++++++++++++++++
//		//测试出栈
//		// link.stackPop();
//		stack.printLink();
//		System.out.println("++++++++++++++++++++++++++");
//		//+++++++++++++++++++++++++++++++++
//		//测试获取栈顶元素和元素数量
//		System.out.println(stack.stackTop());
//		System.out.println(stack.stackSize());
	}
//	enum SYS{
//		ADD ('+'),SUB('-'),MUL('*'),DIV('/');
//		private char ch;
//		private SYS (char ch) {
//			this.setCh(ch);
//		}
//		public char getCh() {
//			return ch;
//		}
//		public void setCh(char ch) {
//			this.ch = ch;
//		}
//			
//	}
	public static void bracket(String str,Stack stack) {
		int left = 0;
		int right = 0;
		char [] strarr = new char [str.length()];
		strarr = str.toCharArray();
//		for (int k = 0; k <)
		int num = 0;
		for (int i = 0; i <strarr.length; i ++ ) {
			while (' ' != strarr[i] && i < strarr.length && '0' <= strarr[i] && strarr[i] <= '9') {// "12 3 4 + * 6 - 8 2 / +";
				num = num * 10 + strarr[i]-'0';
				i++;
			}
			if (' ' == strarr[i] && '0' <= strarr[i-1] && strarr[i-1] <= '9') {
				stack.stackPush(num);
			}
			num = 0;
			// String s = String.valueOf('c'); //效率最高的方法
			switch (strarr[i]) {
			case '+':{
				right = Integer.parseInt(stack.stackTop().toString() ) ;//对象转int，先转为字符串，再转为数字Object o ;Integer.praseInt(o==null?"":o.toString())
				stack.stackPop();
				left = Integer.parseInt(stack.stackTop().toString() ) ;
				stack.stackPop();
				stack.stackPush(left+right);
			}
				break;
			case '-':{
				right = Integer.parseInt(stack.stackTop().toString() ) ;
				stack.stackPop();
				left = Integer.parseInt(stack.stackTop().toString() ) ;
				stack.stackPop();
				stack.stackPush(left-right);
			}
				break;
			case '*':{
				right = Integer.parseInt(stack.stackTop().toString() ) ;//对象转int，先转为字符串，再转为数字Object o ;Integer.praseInt(o==null?"":o.toString())
				stack.stackPop();
				left = Integer.parseInt(stack.stackTop().toString() ) ;
				stack.stackPop();
				stack.stackPush(left*right);
			}
				break;
			case '/':{
				right = Integer.parseInt(stack.stackTop().toString() ) ;//对象转int，先转为字符串，再转为数字Object o ;Integer.praseInt(o==null?"":o.toString())
				stack.stackPop();
				left = Integer.parseInt(stack.stackTop().toString() ) ;
				stack.stackPop();
				try {
					left = left/right;
					stack.stackPush(left);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();//啥都不写
				}
				
			}
				break;

			default:
				break;
			}
			
//			System.out.println(Integer.parseInt(stack.stackTop().toString() ));//检测每次入栈情况
		}
		System.out.println(Integer.parseInt(stack.stackTop().toString() ));
	}
}

