package practicePackage;

import java.util.Random;

public class GetRandomNum {
	
	public static void main(String[] args) {
		
		Random ran=new Random();
		int rand=ran.nextInt(250);
		
		int n=10;
		for(int i=0; i<=n; i++)
		{
			i=rand;
			System.out.println(i);
		}
	}

}
