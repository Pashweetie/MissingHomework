import java.lang.Math;
import java.util.Scanner;
public class Homework1 {
	private Scanner readIn = new Scanner(System.in);
	public static void main(String[] args) {
    System.out.println("hailstone");
    hailstone(12);
    System.out.println("e^x");
    etoThePower(2);
	}
	public static void etoThePower(int x){    
    int n = 0;
    double individuals = 1;
    double totals = 0+individuals;
    System.out.println("n:"+n+"  term:"+1+" sum:"+1);
    n++;
    String endOutput = "";
    for (; individuals> 0.000000000000001; n++) {
      individuals = Math.pow(x, n)/factorial(n);
      totals += individuals;
      endOutput = "n:"+n+"  term:"+individuals+" sum:"+totals;
      System.out.println(endOutput);
    }
    System.out.println("final");
    System.out.println(endOutput);

	}
    public static int factorial(int n) {
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
  public static void hailstone(int n) {
    boolean isEven = false;
    String endStringy = "";
      
    while (n>1 ) {
      if (n%2 == 0) {
        isEven = true;
      }else{
        isEven = false;
      }
      if (isEven) {          
        endStringy = n+", Is it even?:"+isEven+", "+n+"/2";
        n= n/2;
      }else{          
        endStringy = n+", Is it even?:"+isEven+", "+n+"*3+1";
        n = n*3 +1;
      }

      System.out.println(endStringy);
    }
    System.out.println("1, Is it even?: false, end");

   }

}