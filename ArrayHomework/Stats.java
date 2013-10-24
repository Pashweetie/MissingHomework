import java.util.Random;
// import java.util.Math;
public class Stats {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,6,7,7,8,8};
		Random switcher = new Random();
		for (int i= 0; i < a.length; i++) {
			a[switcher.nextInt(a.length)] = a[i];
		}
		System.out.println("Random Array");
		print(a,0,a.length);
		System.out.println("Mean");
		System.out.println(mean(a));
		System.out.println("Mode");
		print(mode(a), 1, 2);
		System.out.println("Maximum");
		System.out.println(max(a));
		System.out.println("Minimum");
		System.out.println(min(a));
		System.out.println("Standard Deviation");
		System.out.println(standardDeviation(a));
	}
	//quartiles1 and three
	//median

	public static void print(int[] x, int z, int y) {
		for (int i = z;i <y; i++) {
			System.out.println(x[i]);
		}
	}
	public static double mean(int[] x) {
		double total = 0;
		for (int i = 0; i < x.length; i++) {
			total = total + x[i]; 
		}
		total = total / x.length;
		return total;
	}
	public static int max(int[] x) {
		int max = 0;
		for (int i = 0; i < x.length ; i++ ) {
			for (int b = 0; b < x.length;b++) {
				if(x[i]>x[b]) {
					if(x[i]>max){
						max = x[i];					} 			
				}
			}
			for(int b = x.length-1; b>0; b=b-1) {
				if(x[i]>x[b]) {
					if (x[i]>max) {
						max = x[i];
					}
				}
			}
		}
		return max;
	}
	public static int min(int[] x) {
		int min = x[0];
		for (int i = 0; i < x.length ; i++ ) {
			for (int b = 0; b < x.length;b++) {
				if(x[i]<x[b]) {
					if(x[i]<min){
						min = x[i];					} 			
				}
			}
			for(int b = x.length-1; b>0; b=b-1) {
				if(x[i]<x[b]) {
					if (x[i]<min) {
						min = x[i];
					}
				}
			}
		}
		return min;
	}
	// public static double median(int[] x) {
	// 	if (x.length % > 0) {
	// 		double pos = (x.length / 2) + 0.5; 
	// 		double neg = (x.length / 2) - 0.5;
	// 		(x[pos]-x[neg])/2)+x[pos];
	// 	}
	// 	for (int i = 0;	i < x.length; i++) {
	// 		if (x[i] > ) {
				
	// 		}x[i]
	// 	}
	// }
	public static int[] mode(int[] x) {
		int[] count = new int[20];
		int[] total = new int[2];
		for (int i = 0; i<x.length; i++) {
			for (int b = 0; b<	x.length-1; b++) {
				if(x[i]==x[b+1]) {
					count[i]=count[i]+1;
				}
				if (count[i]>total[1]) {
					total[0] = count[i];
					total[1] = x[i];
				}
				
			}
		}
		return total;
	}
	public static double standardDeviation(int[] x) {
		double thisMean = mean(x);
		int i = 0;
		double total=0;	
		for (i = 0; i<x.length; i++) {
			double thisSubtractor = x[i] - thisMean;
			System.out.println(thisSubtractor);
			double thisSquared = thisSubtractor * thisSubtractor;
			System.out.println(thisSquared);
			total = total + thisSquared;
		}
		System.out.println(total);
		double standard = Math.sqrt(total/(i));
		return standard;
	}
	public static double median(int[] x) {
		double lala = (x.length-1)/2;
		int[] keeper = new int[x.length-1];
		int least = max(x) + 1;
		int countLand = 0;
		double answer = 0;
		int lalaPos = (lala + 0.5).intValue();
		int lalaNeg = (lala - 0.5).intValue();

		for ( int i = 0; i>x.length-1 ; i++) {
			if (x[i]< x[i+1]){
				least = x[i];
			}
		}
		least = keeper[countLand];
		for ( int i = 0; i>x.length-2 ; i++) {
			if (x[i]>least && x[i]<x[i+1]) {
				least = x[i];
				if (i == x.length -1) {					
					least = keeper[countLand];
					countLand++;
				}
			}
		}
		boolean isEven = false;
		double modulo= (x.length/2)%2;
		if (modulo == 0) {
			isEven = true;
		}
		if (modulo != 0) {
			isEven = false;
		}
		if (isEven) {
			answer = keeper[lala];
		}
		if (!isEven) {
			answer = ((keeper[lalaPos] - keeper[lalaNeg])/2)+keeper[lalaNeg];
		}
		return answer;
	}
}