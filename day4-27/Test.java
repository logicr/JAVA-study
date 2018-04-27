package stack;


interface Stack <T>{
	void stackPush(T obj);//入栈
	void stackPop();//出栈
	int size();//栈元素数量
	T stackTop();//取栈顶
	void printStak();//辅助函数，打印栈中元素
}

class StackImp <T> implements Stack <T>{
	//栈中要有啥？1.元素数量（头节点），里面放栈头和尾巴
	//栈的每个节点放元素和下一个节点的位置
	private int size;
	private Node first;
	private Node last;
	//建一个内部类，实例化节点
	private class Node {//只能此内部访问，private修饰,增强安全性
		private T item;
		private Node next;
		private  Node(T item ,Node next) {//
			this.item = item;
			this.next = next;
		}
	}
	@Override
	public void stackPush(T obj) {
		Node tmp = this.first;
		Node newNode = new Node(obj, null);
		this.last = newNode;
		if (null == this.first) {//首次时
			this.first = newNode;
		}else {
			while (null != tmp.next) {
				tmp = tmp.next;				
			}
			tmp.next = newNode;
		}
		++ this.size;
	}

	@Override
	public void stackPop() {
		Node tmp = this.first;
		if (null == tmp.next) {
			this.first =null;
			this.last = null;
			this.size = 0;
			return ;
		}
		while (null !=tmp.next.next) {
			tmp = tmp.next;
		}
		this.last = tmp;
		tmp.next = null;
		--this.size;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T stackTop() {
		return  (T) this.last.item;//不是返回return this.last啊
	}
	@Override
	public void printStak() {
		Node tmp = this.first;
		if (null == this.first) {
			return;
		}
		while (null != tmp.next) {
			System.out.print(tmp.item + "->");
			tmp = tmp.next;
		}
		System.out.println(tmp.item);
	}

//	@Override
//	public void stackPush(T obj) {
//		// TODO Auto-generated method stub
//		
//	}
}
class Factory{
	public static Stack<Character> getStack() {
		return new StackImp<Character>();
	}
}

public class Test {
	public static void main(String[] args) {
//			Stack<Character> stack = Factory.getStack();//工厂产生栈对象
			Stack<Character> stack = new StackImp<Character>();//自己产生栈对象
		
			String str = "(())hello Jan{{}}";
			bracket(stack, str);
			//括号匹配：左边括号入栈，右边括号，取栈，是一对，pop，不是，return wrong
			//肯能会用到 字符串 转字符数组 char [] strarr = str.toCharArray();

			//++++++++++栈检测++++++++++
//			System.out.println(stack.size());
//			stack.stackPush1("1");
//			stack.stackPush1("2");
//			stack.stackPush1("3");
//			stack.stackPush1("4");
//			stack.stackPush1("5");
//			stack.stackPop();
//			System.out.println(stack.size());
//			stack.printStak();
			
	}
	public static void bracket (Stack<Character> stack,String str) {
		if (null == str) {
			return ;
		}
		char [] strarr = new char [str.length()];//这里的length()区别于数组中的length，前是方法，后是数组变量
		strarr = str.toCharArray();//直接就放进去了
		int i = 0;//大小写转换 CTRL+ shift x/y
		while (i < strarr.length) {
			//先判断是不是括号，是左括号，入栈
			if ('(' == strarr[i] || '[' == strarr[i] || '{' == strarr [i]) {
				stack.stackPush(strarr[i]);
				++ i;//前置效率高，不产生临时变量
				continue;//入栈后面就不用再走了
			}
			if (')' == strarr[i] || ']' == strarr[i] || '}' == strarr [i]) {//是右边括号
				 if(stack.size() == 0) {//栈空了，还来右边括号，那右边括号多
					System.out.println("右括号多");
					++ i;
					return;
				}
				char c = stack.stackTop();//.toString().charAt(0) ;//曲线救国，对象转字符串再转字符
				if ((c == '(' && ')'==  strarr[i]) || ( c == '[' && ']' == strarr[i]) || ( c == '{' && '}' == strarr[i])){
					stack.stackPop();//栈中的括号与当前匹配
					++ i;
					continue;
				}else {//此时栈中与当前括号不匹配//[}
					System.out.println("括号不匹配");
					++ i;
					return;
				}
			}
			++ i;
		}
		if(stack.size() != 0) {//循环结束，要么完全匹配（栈空），要么左边括号多（栈不空），
			System.out.println("左括号多");
			return;
		}
		System.out.println("匹配 =.=");
	}
}
