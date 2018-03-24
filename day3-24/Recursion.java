public class Recursion{
	public static void main (String[] args){
		System.out.println(recursion(60));
	}
	public static double recursion(double x){
		if (1 < x){
			return recursion(x-1)*x;
		}
		else{
			return x;
		}
	}
}

