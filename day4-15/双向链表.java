interface Link {
	boolean add(Object obj);//加节点
	int length();//长度
	Object[] toArray();//节点转数组
	boolean contains(Object obj);//啥意思
	int indexOf(Object obj);//
	boolean set(int index,Object newElement);//
	Object get(int index);//
	void clear();//
}
class LinkFactory {//建立工厂类
	private LinkFactory() {}//私有化工厂类
	public static Link getInstance() {//get接口方法，get链表link
		return new LinkImpl();
	}
}
class LinkImpl implements Link {//继承接口
	/*
	link {
	size;
	first;
	last;
	}
	*/
	private int size = 0;//创建接口的成员变量，链表节点数
	private Node first;//头结点
	private Node last;//尾节点
	private class Node {//私有Node类产生节点对象
		private Object item;//这个是用来干嘛的?
		private Node next;
		private Node prev;
		private Node(Node prev,Object item, Node next) {//Node的有参构造
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	@Override
	public boolean add(Object obj) {//添加节点的方法
		Node l = this.last;//创建临时的节点，保存后一个节点
		Node newNode = new Node(l, obj, null);//调用Node类产生视实例化对象newNode
		last = newNode;//先放进去
		if (l == null) {//判断链表是否为空？这儿很难理解，当是空链表的时，last，first都为NUll
			this.first = newNode;//第一次判断之后，以后就不为空了
			System.out.println("i am here");
		}else {
			l.next = newNode;
			System.out.println("#######");
		}
		this.size++;
		return true;
	}
		@Override
		public int length() {//节点长度
			return this.size;
		}
		@Override
		public Object[] toArray() {//链表转对象数组
			Object[] result = new Object[size];//创建
			int i = 0;
			for(Node xNode = first; xNode != null ; xNode=xNode.next) {//循环装入
				result[i++] = xNode.item;
			}
			return result;
		}
		@Override
		public boolean contains(Object obj) {//不知道用来干嘛
			return indexOf(obj) != -1;
		}
		@Override
		public int indexOf(Object obj) {//找节点下标
			int index = 0;
			if (obj == null) {
				for (Node temp = first ; temp != null ; temp = temp.next) {
					if (temp.item == null) {
						return index;
					}
					index ++;
				}
			} else {
				for (Node temp = first ; temp != null ; temp = temp.next) {
					if (obj.equals(temp.item)) {
						return index;
					}
					index ++;
				}
			}
			return -1;
		}
		@Override
		public boolean set(int index, Object newElement) {//插入元素
			if (!isElementIndex(index)) {//节点下标不存在返回空
				return false;
			}
			Node node = node(index);//？
			node.item = newElement;
			return true;
		}
		@Override
		public Object get(int index) {//获取item
			if (!isElementIndex(index)) {
				throw new IndexOutOfBoundsException();
			}
			return node(index).item;
		}
		@Override
		public void clear() {//清空
			for(Node temp = first ; temp != null ; ) {
				Node next = temp.next;
				temp.item = null;
				temp.prev = null;
				temp.next = null;
				temp = next;
			}
			this.last = this.first = null;
			this.size = 0;
		}
		private boolean isElementIndex(int index) {//判断index是否正常
			return index >= 0 && index <= size;
		}
		private Node node(int index) {//这是干嘛？
			if (index < (size>>1)) {
				Node x = first;
				for(int i = 0 ; i < index ; i++) {
					x = x.next;
				}
				return x;
			}else{
				Node x = last;
				for(int i = size-1 ; i > index ; i--) {
					x = x.prev;
				}
				return x;
			}
		}
	}
	public class Test {
		public static void main(String[] args) {
			Link link = LinkFactory.getInstance();
			link.add("火车头");
			link.add("车厢1");
			link.add("车厢2");
			link.add("火车尾");
			System.out.println(link.contains("车厢3"));
			System.out.println(link.indexOf("车厢2"));
			System.out.println(link.get(3));
			System.out.println(link.length());
			System.out.println(link.set(3, "车厢3"));
			System.out.println(link.get(3));
			link.clear();
			System.out.println(link.length());
		}
	}