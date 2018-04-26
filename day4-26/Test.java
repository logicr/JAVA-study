package bracket;

interface Stack{
	void stackPush(Object obj);//��ջ
	void stackPop();//��ջ
	int size();//ջԪ������
	Object stackTop();//ȡջ��
	void printStak();//������������ӡջ��Ԫ��
}

class StackImp implements Stack {
	//ջ��Ҫ��ɶ��1.Ԫ��������ͷ�ڵ㣩�������ջͷ��β��
	//ջ��ÿ���ڵ��Ԫ�غ���һ���ڵ��λ��
	private int size;
	private Node first;
	private Node last;
	//��һ���ڲ��࣬ʵ�����ڵ�
	private class Node {//ֻ�ܴ��ڲ����ʣ�private����,��ǿ��ȫ��
		private Object item;
		private Node next;
		private  Node(Object item ,Node next) {//
			this.item = item;
			this.next = next;
		}
	}
	@Override
	public void stackPush(Object obj) {
		Node tmp = this.first;
		Node newNode = new Node(obj, null);
		this.last = newNode;
		if (null == this.first) {//�״�ʱ
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
	public Object stackTop() {
		return this.last.item;//���Ƿ���return this.last��
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
}
class Factory{
	public static Stack getStack() {
		return new StackImp();
	}
}
public class Test {
	public static void main(String[] args) {
			Stack stack = Factory.getStack();
			String str = "(())hello Jan{{}}";
			//����ƥ�䣺���������ջ���ұ����ţ�ȡջ����һ�ԣ�pop�����ǣ�return wrong
			//���ܻ��õ� �ַ��� ת�ַ����� char [] strarr = str.toCharArray();
			bracket( stack, str);
			//++++++++++ջ���++++++++++
//			System.out.println(stack.size());
//			stack.stackPush(1);
//			stack.stackPush(2);
//			stack.stackPush(3);
//			stack.stackPush(4);
//			stack.stackPush(5);
////			stack.stackPop();
//			System.out.println(stack.size());
//			stack.printStak();
			
	}
	public static void bracket (Stack stack,String str) {
		if (null == str) {
			return ;
		}
		char [] strarr = new char [str.length()];//�����length()�����������е�length��ǰ�Ƿ����������������
		strarr = str.toCharArray();//ֱ�ӾͷŽ�ȥ��
		int i = 0;//��Сдת�� CTRL+ shift x/y
		while (i < strarr.length) {
			//���ж��ǲ������ţ��������ţ���ջ
			if ('(' == strarr[i] || '[' == strarr[i] || '{' == strarr [i]) {
				stack.stackPush(strarr[i]);
				++ i;//ǰ��Ч�ʸߣ���������ʱ����
				continue;//��ջ����Ͳ���������
			}
			if (')' == strarr[i] || ']' == strarr[i] || '}' == strarr [i]) {//���ұ�����
				 if(stack.size() == 0) {//ջ���ˣ������ұ����ţ����ұ����Ŷ�
					System.out.println("�����Ŷ�");
					++ i;
					return;
				}
				char c = stack.stackTop().toString().charAt(0) ;//���߾ȹ�������ת�ַ�����ת�ַ�
				if ((c == '(' && ')'==  strarr[i]) || ( c == '[' && ']' == strarr[i]) || ( c == '{' && '}' == strarr[i])){
					stack.stackPop();//ջ�е������뵱ǰƥ��
					++ i;
					continue;
				}else {//��ʱջ���뵱ǰ���Ų�ƥ��//[}
					System.out.println("���Ų�ƥ��");
					++ i;
					return;
				}
			}
			++ i;
		}
		if(stack.size() != 0) {//ѭ��������Ҫô��ȫƥ�䣨ջ�գ���Ҫô������Ŷࣨջ���գ���
			System.out.println("�����Ŷ�");
			return;
		}
		System.out.println("ƥ�� =.=");
	}
}
