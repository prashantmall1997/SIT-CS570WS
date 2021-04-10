//Prashant Pramodkumar Mall
//CWID: 10459371
//little-endian
public class BinaryNumber {
	
	private int data[];
	private	boolean overflow;

	public BinaryNumber(int length) {
		data = new int[length];
		
		for(int fill = 0; fill<length;fill++) {
			data[fill] = 0;			
		}		
	}
	
	public BinaryNumber(String str) {
		int length = str.length();
		
		data = new int[length];
		
		for (int fill=0;fill<length;fill++) {
			if ((((str.charAt(fill)) - '0') < 2) && ((str.charAt(fill)) - '0') > -1) {
				data[fill] = (str.charAt(fill)) - '0';
			} else {
				System.out.println("Invalid Binary Number!");
			}
			
		}		
	}
	
	public int getLength() {
		return data.length;
	}
	
	public int getDigit(int index) {
		if (index>=data.length) {
			System.out.println("Array size is smaller than the index provided.");
		} else {
			return data[index];
		}
		return 0;
	}
	
	public int toDecimal(int binary) {
		int decimalValue = 0;
		int base = 1;
		
		int tempBinary = binary;
		while (tempBinary > 0) {
			int lastDigit = tempBinary % 10;
			tempBinary = tempBinary / 10;
			decimalValue += lastDigit * base;
			base = base * 2;
		}
	return decimalValue;
	}
	
	public void shiftR(int amount) {
		int curLength = data.length;
		int newLength = curLength + amount;
		int tempData[];
		tempData = new int[newLength];
		for (int fill = 0; fill<amount;fill++) {
			tempData[fill]=0;
		}
		for (int fill = amount;fill<newLength;fill++) {
			tempData[fill] = data[fill-amount];
		}
		data = tempData;
//		for (int loop=0; loop<data.length;loop++) {
//			System.out.print(data[loop]);
//		}
	}
	
	public void add(BinaryNumber aBinaryNumber) {
		if (data.length != aBinaryNumber.getLength()) {
			System.out.println("Length of the two binary numbers do not match.");
		} else {
			int carry = 0;
			int add = 0;
			int sum[] = new int[data.length+1];
			for (int loop = 0; loop<data.length; loop++) {
				add = carry + data[loop] + aBinaryNumber.getDigit(loop);
				if (add == 0) {
					carry = 0;
					sum[loop] = 0;
				} 
				else if (add == 1) {
					carry = 0;
					sum[loop] = 1;
				} 
				else if (add == 2) {
					carry = 1;
					sum[loop] = 0;
				}
				else if (add == 3) {
					carry = 1;
					sum[loop] = 1;
				}
				
				if (loop == data.length-1) {
					if (carry == 1) {
						sum[loop+1] = 1;
						overflow = true;
					} 
					else if (carry == 0) {
						overflow = false;
					} 
				}
			}
			if (overflow == true) {
				for (int loop=0; loop<data.length+1;loop++) {
					this.data = sum;
				}				
			} else {
				for (int loop=0; loop<data.length;loop++) {
					int size = sum.length-1;
					this.data = new int[size];
					for(int i=0; i<this.data.length; i++){
						this.data[i] = sum[i];
				    }
				}
			}
//			for (int loop=0; loop<aBinaryNumber.data.length;loop++) {
//				System.out.print(aBinaryNumber.data[loop]);
//			}
		}		
	}
	
	public void clearOverflow(){
		overflow = false;	
	}
	
	public String toString() {
		if (overflow == true) {
			System.out.println("Overflow");
		} else {
			String result = "";
			for (int loop = 0; loop < data.length; loop++) {
				result = result + data[loop];;
			}
			return result;
		}
		return "";
	}
	
	
	
	public static void main(String[] args) {
		
		BinaryNumber first = new BinaryNumber("10110");
//		BinaryNumber second = new BinaryNumber("00011101");
		
//		int len = first.getLength();
//		int dig = first.getDigit(0);
		int todec = first.toDecimal(10);
		System.out.println(todec);

//		first.shiftR(3);
//		first.add(second);
//		first.clearOverflow();
//		String strFirst = first.toString();
//		System.out.println(strFirst);
	}
}
