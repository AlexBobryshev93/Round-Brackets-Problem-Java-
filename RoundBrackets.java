/*
It's convenient to use binary mask. 1 means an opening bracket, 0 means a closing.
A sequence of N opening and N closing brackets gives (2 * N) brackets in sum.
It gives (2 ^ N) possible combinatons. We should check which of them are valid.

There are two requirements for these combinations to be valid:
1) the numbers of opening and closing brackets in a sequence should be equal;
2) the number of closing brackets in a row can not be more than the number
of opening brackets before them.  
*/

import java.util.Scanner;

class RoundBrackets {
	private static int N;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		
		System.out.println("How many bracket pairs do we use?");
		N = scanner.nextInt(); // N supposed to be integer and not negative
		
		if (N == 0) { // 
			System.out.println("Number of valid combinations: " + 1); // an empty bracket sequence is also valid
			return;			
		}
		
		for (int i = 0; i < Math.pow(2, 2 * N); i++) {
			if (checkCombination(Integer.toBinaryString(i))) counter++; //here we check every combination using the binary mask
		}
		
		System.out.println("Number of valid combinations: " + counter); 
	}
	
	private static boolean checkCombination(String str) { // str is a sequence of 0's and 1's
		int numberOfOpening = 0;
		int numberOfClosing = 0;
		while (str.length() < (2 * N)) str = "0" + str; // so we make e.g. 0010 instead of 10, which is not the same in our case: ))() is not () 
		
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') numberOfOpening++;
			else numberOfClosing++; // if this char is '0'
			
			if (numberOfClosing > numberOfOpening) { // 2nd requirement
				//System.out.println(str + " is invalid");
				return false; 
			}
		}
		
		if (numberOfClosing != numberOfOpening) { // 1st requirement
			//System.out.println(str + " is invalid");
			return false; 
		}
		
		//System.out.println(str + " is valid");
		return true;
	}
}