package task4_14;

//import java.awt.event.ItemEvent;

//import javax.print.attribute.Size2DSyntax;
//import javax.xml.soap.Node;

interface Link {
	void add (Object obj);
	boolean remove (int index);
	int indexOf(Object obj);
	boolean set(int index,Object obj);
	Object get(int index);
	int length();
	void clear();
	Object[] toArray();
	void printLink();
}
class Factory {
	private  Factory() {}
	public static Link getLinkInstance() {
		return new LinkImpl();
	}		
}
class LinkImpl implements Link {
	private int size = 0;
	private Node  first;
	private Node last;
	private class Node {
		private Object item;
		private Node next;
		private Node prev;
		private Node(Node prev,Object item,Node next) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	@Override
	public void add(Object obj) {
		Node tmp = this.last;
		Node newNode = new Node(tmp, obj, null);
		this.last = newNode;
		if (null == tmp) {
			this.first = newNode;
		}else {
			tmp.next = newNode;
		}
		this.size++;
	}

	@Override
	public boolean remove(int index) {
		Node tmp = this.first;
		if(index <0 || index >this.size) {
			return false;
		}
		while(0 !=index--){
			tmp = tmp.next;
		}
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		return true;
	}

	@Override
	public int indexOf(Object obj) {
		int i = 0;
		Node tmp = this.first;
		if (obj == null) {
			while (null != tmp) {
				if (tmp.item == null) {
					return i;
				}
				tmp = tmp.next;
				i++;
			}
		}
		else {
			while (null != tmp) {
				if (obj.equals(tmp.item)) {//注意这用里，equals的这么用的
				return i;
				}
			tmp = tmp.next;
			i++;
			}
		}
		return -1;
	
	}
	@Override
	public boolean set(int index, Object obj) {//插入
		Node tmp =this.first;
		Node newNode = new Node(null, obj, null);
//		Node newNode = null//错误的写法
//		newNode.item = obj;
		if(index <0 || index >this.size) {
			return false;
		}
		while(0 !=index--){
			tmp = tmp.next;
		}
		newNode.next =tmp.next;
		tmp.next = newNode;
		newNode.prev =tmp;
		return true;
	}

	@Override
	public Object get(int index) {//根据下标获取对象
		Node tmp = this.first;
		while (0 !=index--) {
			tmp = tmp.next;
		}
		return tmp.item;
	}

	@Override
	public int length() {
		return this.size;
	}

	@Override
	public void clear() {//
		Node tmp = this.first;
		while (null !=tmp) {
			Node fina =tmp.next;
			tmp.prev =null;
			tmp.item =null;
			tmp.next =null;
			tmp = fina;
		}
		this.size =0;
		this.last = null;
		this.first = null;
	}

	@Override
	public Object[] toArray() {
		int i = 0;
		Node tmp = this.first;
		Object[] num= new Object[this.size];//看，数组这么用的
		while(null !=tmp) {
			num [i] = tmp.item;
			tmp = tmp.next;
			i ++;
		}
		while (0 != i--) {
			System.out.println(num[i]);
		}
		return num;
	}

	@Override
	public void printLink() {
		Node tmp = this.first;
		while (null != tmp) {
			System.out.println(tmp.item);
			tmp =tmp.next;
		}
	}
	
}

public class Test {
	public static void main(String[] args) {
		Link link = Factory.getLinkInstance();
		link.add("0");
		link.add("1");
		link.add(null);
		link.add("2");
		link.add("3");
		link.add("4");
		/*测试length(),indexOf(),indexOf(null);
		System.out.println(link.length());
		System.out.println(link.indexOf("2"));
		System.out.println(link.indexOf("1"));
		System.out.println(link.indexOf(null));
		*/
//		link.printLink();//打印链表
//		System.out.println("++++++++++++");
//		link.remove(1);
//		link.printLink();//打印链表
//		System.out.println(link.indexOf("4"));
//		System.out.println(link.get(2));//获取下标元素
		//测set
//		link.printLink();//打印链表
//		System.out.println("++++++++++++");
//		link.set(1, "2");
//		link.printLink();//打印链表
		//测clear
//		link.printLink();
//		link.clear();
//		System.out.println("+++++++++++++++++");
//		link.printLink();
		
		
		link.printLink();
		System.out.println("+++++++++++++++++");
		link.toArray();
	}
}

//+++++++++++++++++++++++++++++++++++++++==




