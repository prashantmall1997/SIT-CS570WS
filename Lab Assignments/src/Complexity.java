import java.lang.Math;
public class Complexity {
	
	public static void method0(int n) {
		//complexity O(n)
		int counter=0; 
		for (int i=0; i<n; i++) { 
			System.out.println("Operation "+counter); 
			counter++; 
			} 
		}

	public static void method1(int n) {
		//complexity O(n2)
		int ran = 0;
		for (int counter1=0; counter1<n;counter1++) {
			for (int counter2=0; counter2<n;counter2++) {
				if (counter1==counter2 ) {
					System.out.println("Operation "+ (counter1+1)); 
				}
				ran++;
			}
		}
		System.out.println("Number of times ran " + ran);
	}
	
	public static void method2(int n) {
		//O(n3)
		int ran = 0;
		for (int counter1=0; counter1<n;counter1++) {
			for (int counter2=0; counter2<n;counter2++) {
				for (int counter3=0; counter3<n;counter3++) {
					if (counter1==counter2 ) {
						if (counter2==counter3 ) {
						System.out.println("Operation "+ (counter1+1)); 
						}
					}
					ran++;
				}
			}
		}
		System.out.println("Number of times ran " + ran);
	}
	
	public static void method3(int n) {
		//O(logn)
		int ran = 0;
		for (int counter=n; counter>0;counter=counter/2) {
			System.out.println("Operation "+ (n-counter + 1)); 
			ran++;
		}
		System.out.println("Number of times ran " + ran);		
	}
	
	public static void method4(int n) {
		//O(nlogn)
		int ran = 0;
		for (int counter1=n; counter1>0;counter1--) {
			for (int counter2=n; counter2>0;counter2=counter2/2) {
				ran++;
				if (counter1 == counter2) {
					System.out.println("Operation "+ (n - counter1 + 1)); 
				}
			}
		}
		System.out.println("Number of times ran " + ran);
	}
	
	public static void method5(int n) {
		//O(loglogn)
		int ran = 0;
		for (int counter=0; counter<n;counter=counter*counter) {
			System.out.println("Operation "+ (counter + 1)); 
			ran++;
			if (counter == 1 || counter == 0) {
				counter++;
			}		
		}
		System.out.println("Number of times ran " + ran);	
	}
	
	public static void method5sqrt(int n) {
		//O(loglogn)
		int ran = 0;
		for (int counter=n; counter>0;counter=(int) Math.sqrt(counter)) {
			System.out.println("Operation "+ (n - counter + 1)); 
			ran++;
			if (counter == 1) {
				break;
			}
		}
		System.out.println("Number of times ran " + ran);	
	}
	
	
	
	private static int ranSix = 1;
	public static int method6(int n) { 
		System.out.println("Operation " + ranSix);
		if (n < 1) {
			return ranSix;
		}
		ranSix++;
			method6(n-1);
			method6(n-1);
		return ranSix; 
		}		  
			
	public static void main(String[] args) {
//		TODO Auto-generated method stub
//		method0(10);
		method1(10);
		method2(10);
		method3(1000);
		method4(1000);
		method5(1000);
//		method5sqrt(1000);
		System.out.println("Number of times ran " + method6(3));
	}
}