package day05;

public class Test2 {
	public static void main(String[] args) {
//		char [] str = {'a','a','a'};
		char [] str = {};
//		char [] pattern = {'a','.','b','*','a'};
//		char [] pattern = {'a','b','*','a','c','*','a'};
//		char [] pattern = {'a','*','a','*','a','*'};
		char [] pattern = {'.','*'};
		System.out.println(match(str, pattern));
	}
	 public static boolean match(char[] str, char[] pattern) {
		 	int s = str.length;
			int p = pattern.length;
	        if (s>p){
	            return false;
	        }
			if(s == 0 && p == 0) {
				return true;
			}
			if (s == p && p>0) {
				if (pattern.toString().contains("*")) {
					return false;
				}
			}
			if (p>s) {
				if (!pattern.toString().contains("*")) {
					return false;
				}
			}
			if (s == 0 && p!=0) {
	            int i =0;
				for ( i = 0; i < pattern.length; i+=2) {
					if (i+1<pattern.length &&pattern[i+1] != '*') {
						return false;
					}
				}
				if (p%2!=0) {
					return false;
				}
					 return true;
				
			}
			int i = 0;
			int j = 0;
			 while (0 != s-- && 0 != p--) {
				 System.out.println(str[i]+" and "+pattern[i]);
				 if (str[i] != pattern[j]) {
					if (pattern[j] == '.') {
						i++;
						j++;
						continue;
					}
					else if (j+1<pattern.length && pattern[j+1] == '*') {
						i++;
						j+=2;
						continue;
					}
					else {
						return false;
					}
				}
				i++;
				j++;
			}
			return true;		 
	 }
}
