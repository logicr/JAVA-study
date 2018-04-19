package Test;
//查找字符串中第一次出现N次的字符
public class Test {
	public static void main(String[] args) {
		String str = "woshinidie";
		System.out.println(findString(str));
	}
	public static char findString(String str) {
		int [] toChar = new int [200];//见一个数组，不是用来存字符的！！！存次数，下标放字符
		int i =0;
		for (i =0; i < str.length(); i ++) {
			char c = str.charAt(i);
			if ('A'< c && c< 'z')
			{
				toChar[c] ++;//下标为c的，计数
				if (3 ==toChar[c]) {//等于N返回
					return c;
				}
			}
		}
		return 0;		
	}
}

