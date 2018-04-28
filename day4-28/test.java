package monkey;

public class Test {
//	设最后一只猴子分到的桃子为x
//	第4只猴子分走后的桃子为：（x*5）+1；没分走时，桃子为： ((x*5+1)/4*5+1)
//	...
//	(((x*5+1)/4*5+1)/4*5+1)/4*5 +1 = a

	public static void main(String[] args) {
		float a = 0;
		int b = 0;
		float i = 0;
		int result = 0;
		while (1>0) {
			++i;
			a = ((((i*5+1)/4*5+1)/4*5+1)/4*5 +1)/4*5+1;
			//       5猴      4猴       3猴        2猴    	  1猴
			result = (int) a;
			if(a - result ==0) {
				System.out.println("桃子总数为："+a+"  第5只猴子分到桃子为："+i);
//				continue;
				++b;
				if(b ==100) {//打印前一百次结果
					break;
				}
			}
		}
		
	}

}
