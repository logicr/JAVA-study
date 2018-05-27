package task;

import java.util.*;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

//已通过
//以空格你转字符串
//
//public class Test {
//	public static void main(String[] args) {
//		reverse();
//	}
//	public static void reverse() {
//		Scanner scanner = new Scanner(System.in);
////		scanner.useDelimiter("\r\n");
//		String string = scanner.nextLine();
////		System.out.println(string);
//		scanner.close();
//		StringBuilder tmp = new StringBuilder();
//		String [] data = string.split(" ");
//		for (int i = 0; i < data.length; i++) {
//			//System.out.println(data[i]);
//			tmp = tmp.append(data[data.length-1-i]);
//			if(data.length-1 != i) {
//				tmp = tmp.append(" ");
//			}
//			
//		}
//		string = tmp.toString();
//		System.out.println(string);
//	}
//}

//下面一道题的未通过解法
//public class Test{
//	public static void main(String[] args) {
//		int [] array = {1,2,3,4,5,6,7,0};
//		InversePairs(array);
////		i = i % 1000000007;
////		System.out.println(i%1000000007);
//	}
//	public static int InversePairs(int [] array) {
//		Stack<Integer> stack = new Stack<>();
//		int count = 0;
//		int i = 0;
//		for (; i <array.length; ++i) {
//			if(i == array.length-1) {
//				break;
//			}
//			if (array[i] <= array[i+1]) {
//				System.out.println("i push "+array[i]);
//				stack.push(array[i]);
//			}
//			else {
//				stack.push(array[i]);
//				while (stack.peek() > array[i+1]) {
//					++count;
//					stack.pop();
//					if(stack.empty()) {
//						break;
//					}
//				}
//			}
//		}
//		
//		
//		
//		System.out.println(count);
//		return count%1000000007;
//		
//	}
//}

//已通过，递归解法
//有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，计算给定数组中的逆序对个数。
//
//给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
public class Test{
	public static int count = 0;
	public static void main(String[] args) {
		String string = "a+b=20\n";
		System.out.println(string.length());
//		int [] array = {1,2,3,4,5,6,7,0};
//		int [] array = {7,6,5,4,3,2,1,0};
//		int [] array = {1778759,2129338};
		int [] array = {2506437,1678253,1686990,1226120,1978369,2925527,1093247,539765,1397554,2811480,1030911,1404313,2225582,1354821,254286,2804514,1861463,1304284,1581472,631536,417180,3010645,374547,2673046,832031,2202421,1284116,2131019,2061562,1202654,171930,2074816,172710,2745521,2688800,2974317,158593,2221878,433945,1471582,595462,1483741,2682995,435376,149834,1226682,312371,1818,1665703,2555559,615778,553080,1659281,1665757,1150515,2181583,727165,1482528,803965,2994553,648494,3012361,2473016,1809867,248290,1584500,2319329,988986,2377674,39169,1148818,871969,1887091,592413,1042653,309195,544202,1839097,2526283,2734787,2319678,2495851,30276,2267521,2807656,174680,2446620,1111136,559142,2831620,421954,1770895,468975,1956368,232580,651244,1876893,2033837,935375,567545,1192622,2151567,1853828,821267,2416642,1490928,764034,431273,2377932,1610264,1624428,1432002,962009,1731188,1141353,360570,1643618,811997,2170885,303739,1226254,771985,2545439,2296343,2550579,1568320,2262686,1968659,1115422,1895806,2577977,473336,659568,511068,2453827,1702191,468043,1153023,1822902,1736965,2532046,1153152,1858443,837248,1603078,2815708,1863554,906468,936080,3017813,987759,2916518,1724507,1873990,247488,2632763,2017809,720625,2564340,106099,138401,246532,2408923,1428164,1447125,2832056,688031,1564278,395701,2670226,2186320,313229,2448269,1253905,2217581,2550975,125630,1141490,343270,1353613,1583248,1215477,340759,1371148,1061456,1718599,797269,477574,2532489,242458,1424991,2166376,278551,2373606,2923611,2925027,1154092,1436229,1572252,97251,2603402,1767927,576656,1623568};
		count = 0;//这是一个全局的静态常量，每次置零，不然无法通过
		System.out.println(InversePairs(array, array.length-1));//传值得时候减一，防止越界
	}
	public static int InversePairs(int [] array,int length) {
		if(length == 1) {
			for (int i = 0; i < length; i++) {
				if (array[i] > array[length]) {
//					System.out.println(array[i]);
					count++;
//					System.out.println("i am length :"+length);
				}
			}
//			System.out.println("i am count :"+ count);
			return count;
		}
		InversePairs(array, length-1);
		for (int i = 0; i < length; i++) {
			if (array[i] > array[length]) {
//				System.out.println(array[i]);
				count++;
//				System.out.println("i am length :"+length);
			}
		}
//		System.out.println("i am count :"+ count);
		return count;
	}
}