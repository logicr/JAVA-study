package day05;

public class Test {
//二维有序数组查找，
	public static void main(String[] args) {
		int target = 7;
//		int [][] array = {{1,2,3},{4,6,7},{}};
		int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(array.length);
		System.out.println(Find(target, array));
	}
	 public static boolean Find(int target, int [][] array) {
		
		 for (int i = 0; i < array.length; i++) {
			if(array[i].length == 0) {
				break;
			}
			 if (target >= array[i][0] && target <= array[i][array[i].length-1]) {
				for (int j = 0; j < array[i].length; j++) {
					if (target == array[i][j]) {
						return true;
					}
				}
				//return false;//如果加上的话跳过区间相似的情况 7       2~12 4~13
			}
		}
		 return false;
		 
	 }
}
