public class Recursion{
	public static void main (String[] args){
		System.out.println(recursion(60));
	}
	public static double recursion(double x){//递归,注意这儿的double，int是装不下 60!的
		if (1 < x){//递归出口
			return recursion(x-1)*x;
		}
		else{
			return x;
		}
	}
}

