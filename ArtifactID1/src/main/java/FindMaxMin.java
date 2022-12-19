import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class FindMaxMin {
	
	public static int aniket_Max_Min_array(int a[],char H_OR_L) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				switch(H_OR_L) {
				case 'H' : if(a[i]>a[j]) {int swap = a[i];a[i]=a[j];a[j]=swap;};break;
				case 'L' : if(a[i]<a[j]) {int swap = a[i];a[i]=a[j];a[j]=swap;};break;
				default : System.out.println("Add proper Method Siganture");break;
				}				
			}
		}
		System.out.print("Sorted Array : ");
		for (int i = 0; i < a.length-1; i++) {
			System.out.print(" "+a[i]);
		}System.out.println();
		
		switch(H_OR_L) {
		case 'H' : System.out.println("Highest value = "+a[0]);break;
		case 'L' : System.out.println("Lowest value = "+a[0]);break;
		default : System.out.println("Add proper Method Siganture");break;
		}
		return a[0];
		
	}
	
	public static Integer aniket_Max_Min_ArrayList(List<Integer> A,char H_OR_L) {
		switch(H_OR_L) {
		case 'L':Collections.sort(A);break;
		case 'H':Collections.sort(A,Collections.reverseOrder());break;
		default : System.out.println("Add proper Method Siganture");break;
		}
		return  A.get(0);
	}
	@Test
	public static void main(String[] args) {
		int a[]= {5,8,6,8,0,7,5,8,8,8,5,4,588,5,5545,65,7646467,554545,66668464,5,66,454565,6544564,64948,65513354,698448949,684484,65464,65464,65464,6554654,6546,65465,65456,786546,32153,646,84,6565,68464,65464,6465,54564,31235,68464,68496,4646};
		System.out.println(aniket_Max_Min_array(a,'L'));
		
		List<Integer> A = Arrays.asList(5,8,6,8,0,7,5,8,8,8,5,4,588,5,5545,65,7646467,554545,66668464,5,66,454565,6544564,64948,65513354,698448949,684484,65464,65464,65464,6554654,6546,65465,65456,786546,32153,646,84,6565,68464,65464,6465,54564,31235,68464,68496,4646);		
		System.out.println(aniket_Max_Min_ArrayList(A,'H'));	
	}
	
}
