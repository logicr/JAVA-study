public class MultiTable {
	public static void main (String[]args){
		table();
	}
	public static void table (){
		int i = 0;
		for (i = 1; i < 10; i++){
			int j = 1;
			for (j = 1; j <= i; j++){
				//System.out.print(i);
				//System.out.print("+");
				//System.out.print(j);
				//System.out.print("=");
				//System.out.print(i*j );
				System.out.print((i)+"*"+(j)+"="+(i*j)+"; ");
			}
			System.out.println("\n");
		}
	
	}
}
