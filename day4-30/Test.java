package maze;

//建栈
interface Stack<T> {
	void stackPush(T posi);// 入

	void stackPop();// 出

	T stackTop();// 取

	int stackSize();// 数量

	boolean stackEmpty();// 为空否
}

class StackImp<T> implements Stack<T> {
	// 栈要放啥？头，尾，数量
	private int size;
	private Node first;
	private Node last;

	private class Node {
		private T position;
		private Node next;

		public Node(T position, StackImp<T>.Node next) {
			this.position = position;
			this.next = next;
		}

	}

	@Override
	public void stackPush(T posi) {
		Node tmp = this.first;
		Node newNode = new Node(posi, null);
		this.last = newNode;
		if (null == this.first) {
			this.first = newNode;
		} else {
			while (null != tmp.next) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		++this.size;
	}

	@Override
	public void stackPop() {
		// 只剩一个时
		// 剩多个时
		Node tmp = this.first;
		if (null == tmp.next || null == tmp) {
//		if (null == tmp.next) {
			this.first = null;
			this.last = null;
			this.size = 0;
			return;
		}
		while (null != tmp.next.next) {
			tmp = tmp.next;
		}
		tmp.next = null;
		this.last = tmp;
		--this.size;
	}

	@Override
	public T stackTop() {
		if (this.first == null) {
			return null;
		} else {
			return (T)this.last.position;
		}
	}

	@Override
	public int stackSize() {
		return this.size;
	}

	@Override
	public boolean stackEmpty() {
		if (0 == this.size) {
			return true;
		} else {
			return false;
		}

	}
}

class Position {
	private int x;
	private int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
public class Test {

	public static void main(String[] args) {
		Stack <Position> stack = new StackImp<Position>();
//		int [][] arr = new int[6][6];
		int [][] arr = {
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0 },
				{ 0, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 0, 0 } };
		Position entry = new Position(5, 2);
		maze(stack,arr,entry);
	}
	public static void maze(Stack<Position> stack,int arr[][],Position entry) {
		int r = 6;//arr.length/arr[0].length;
		int l = 6;//arr[0].length;
		int [][] maze= new int [r][l];
		for (int i = 0 ; i < r ; i ++) {//初始化走迷宫数组
			for (int j = 0; j < l; j ++) {
				maze[i][j] = arr[i][j];
			}
		}
		//需要几个判断方法
		//1.传入的坐标是否为真入口；
		//2.当前坐标是否为出口；
		//3.下一步要走的坐标是否可走；
		if (!isEntry(entry, maze, r, l)) {
			return;
		}
		Position cur = new Position(entry.getX(), entry.getY());
		Position tmp1 = new Position(entry.getX(), entry.getY());
		stack.stackPush(tmp1);
		maze[entry.getX()][entry.getY()] = 2;
		while (!isExit(maze, cur, entry, r, l)) {
			
			
			//up
			Position tmp = new Position(entry.getX(), entry.getY());
			tmp.setX(cur.getX()-1);
			tmp.setY(cur.getY());
			if (isPath(maze, tmp, r, l)) {
				maze[tmp.getX()][tmp.getY()] = 2;
				cur.setX(tmp.getX());
				stack.stackPush(tmp);
				System.out.println(stack.stackTop().getX() + " "+stack.stackTop().getY());
				printMaze(maze);
				continue;
			}
			//left
			tmp.setX(cur.getX());
			tmp.setY(cur.getY()-1);
			if (isPath(maze, tmp, r, l)) {
				maze[tmp.getX()][tmp.getY()] = 2;
				cur.setY(tmp.getY());
				stack.stackPush(tmp);
				System.out.println(stack.stackTop().getX() + " "+stack.stackTop().getY());
				printMaze(maze);
				continue;
			}
			//right
			tmp.setX(cur.getX());
			tmp.setY(cur.getY()+1);
			if (isPath(maze, tmp, r, l)) {
				maze[tmp.getX()][tmp.getY()] = 2;
				cur.setY(tmp.getY());
				stack.stackPush(tmp);
				System.out.println(stack.stackTop().getX() + " "+stack.stackTop().getY());
				printMaze(maze);
				continue;
			}
			//down
			tmp.setX(cur.getX()+1);
			tmp.setY(cur.getY());
			if (isPath(maze, tmp, r, l)) {
				maze[tmp.getX()][tmp.getY()] = 2;
				cur.setX(tmp.getX());
				stack.stackPush(cur);
				System.out.println(stack.stackTop().getX() + " "+stack.stackTop().getY());
				printMaze(maze);
				continue;
			}
			//走了，或者下一步走不了
			cur = stack.stackTop();
			printMaze(maze);
			maze[cur.getX()][cur.getY()] = 3;
			stack.stackPop();
		}
		System.out.println("I'm out!");
	}
	public static void printMaze(int [][] maze) {
		for (int i = 0 ; i < 6 ; i ++) {
			for (int j = 0; j < 6; j ++) {
				System.out.print(maze[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean isExit(int [][] maze,Position cur,Position entry,int r,int l) {//是否为出口
		if ((cur.getX() !=entry.getX() && cur.getY() !=entry.getY())  && (cur.getX() ==0 ||cur.getX() == r-1) || (cur.getY() ==0 ||cur.getY() == r-1))
			return true;
		return false;
		
	}
	public static boolean isEntry(Position entry,int [][] maze,int r,int l) {//入口是否合法
		if (maze[entry.getX()][entry.getY()] == 1 && (entry.getX() ==0 ||entry.getX() == r-1) || (entry.getY() ==0 ||entry.getY() == r-1)) {
			return true;
		}
		return false;
//		if (maze[entry.getX()][entry.getY()] == 1) {
//			System.out.println("1");
//		}
//		if ((entry.getX() ==0 ||entry.getX() == r-1)) {
//			System.out.println("2");
//		}
//		if(entry.getY() ==0 ||entry.getY() == r-1) {
//			System.out.println("3");
//		}
//		return true;
	}
	public static boolean isPath(int [][] maze,Position cur,int r,int l) {
		if (maze[cur.getX()][cur.getY()] == 1 && (cur.getX() >=0 ||cur.getX() <= r-1) && (cur.getY() >=0 ||cur.getY() <= r-1))
			return true;
		return false;
		
	}
}

