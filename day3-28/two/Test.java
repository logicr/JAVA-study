class Animal {
	private static String property = "Animal" ;
	private  String name = "dog";
	private int num = 2;
	private int weight = 30;
	public Animal (String name ,int num, int weight){
		this.name = name;
		this.num = num;
		this.weight = weight;

	}
	public void getPrintInfo(){
		System.out.println("is "+property+" name:"+name+" number:"+num+" weight:"+weight);
	}
}
public class Test {
	public static void main(String[] args) {
		Animal dog = new Animal("dog",1,20);
		dog.getPrintInfo();
		Animal cat = new Animal("cat",3,10);
		cat.getPrintInfo();
	}
}
