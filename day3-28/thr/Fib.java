public class Fib {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);//String 强转为 int,以及在命令行带参数运行 将args[]作为参数
		fib(num);
	}
	public static void fib (int x){

		int a = 1;
		int b = 1;
		int c = 1;
		int i = 1;
		for(i = 1; i <= x; i ++ ){
			
			if (2 >= i){
			System.out.print(1+",");
		}
		else{
			c = b + a;
			a = b;
			b = c;
			System.out.print(c+",");
		}
		}
	}
}
