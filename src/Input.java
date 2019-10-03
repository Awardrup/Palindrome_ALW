import java.util.Scanner;

import java.io.*;
public class Input {
	
	
	boolean subsequence = true;
	int A = -1; int B = -1; int C = -1; int D = -1; int a = -1; int b = -1; int c = -1; int d = -1;
	int n = 0; int q = 0;
	String s1; String s2; String s3; String s4;
	String one; String two; String three; String four;
	

	Scanner Char = new Scanner(System.in); 
	
	
	
	public  String mainInput() throws IOException{
		// TODO Auto-generated method stub
		System.out.print("WOULD YOU LIKE TO ENTER A SEQUENCES MANUALLY OR FROM A FILE? (M/F): ");
		String temp = Char.nextLine();
		if(temp.charAt(0) == 'M') {
			System.out.println();
			System.out.print("Enter the first sequence: ");
			s1 = Char.nextLine();
			s1.toLowerCase();
			System.out.print("Enter the second sequence: ");
			s2 = Char.nextLine();
			s2.toLowerCase();
			
			ArrayStack<Character> ArrayA = new ArrayStack<Character>(s1.length());
			ArrayStack<Character> ArrayB = new ArrayStack<Character>(s2.length());
			ArrayA.clear();
			ArrayB.clear();
			
			while(n < s1.length() || subsequence != false) {
				char po = s1.charAt(n);
				ArrayA.push(po);
				
				for(int m = 0; m < s2.length(); m++) {
				char oo = s2.charAt(m);
				ArrayB.push(oo);
				
					
				if(ArrayB.peek() == ArrayA.peek()) {
					A = ArrayA.getTopIndex();
					B = ArrayB.getTopIndex();
					subsequence = true;
					}
				else
					subsequence = false;
				
				}
				
				ArrayB.clear();
				if(n < s1.length())
					n++;
				
				
				if(n < s1.length()) {
					ArrayA.push(po);
				
				for(int o = 0; o < s2.length(); o++) {
				ArrayB.push(s2.charAt(o));
				if(ArrayB.peek() == ArrayA.peek() && ArrayB.getTopIndex() != B) {
					C = ArrayA.getTopIndex();
					D = ArrayB.getTopIndex();
						}
					}
				}
				ArrayB.clear();
				if(B < D && A < C)
					subsequence = false;
				else 
					subsequence = true;
				
				one = s1 + " IS NOT A SUBSEQUENCE OF " + s2;
				two = s1 + " IS A SUBSEQUENCE OF " + s2;
				
				A = -1; B = -1; C = -1; D = -1;
				
				if(subsequence == false) 
					return one;
				else
					return two;
				
				
			}
			
			System.out.print("Would you like to enter a new sequence? (Y/N)");
			temp = Char.nextLine();
			if(temp.charAt(0) == 'Y') {
				mainInput();
			}
			else if(temp.charAt(0) == 'N'){
					System.out.print("<END RUN>");
			}
			
			
		
		
		} else if(temp.charAt(0) == 'F'){
			System.out.println();
			System.out.print("Please enter the file name: ");
			File file = new File(Char.nextLine());
			Scanner files = new Scanner(file);
			try {
			
			
			while (files.hasNextLine()) {
				String s3 = files.next();
				s3.toLowerCase();
				String s4 = files.next();
				s4.toLowerCase();
				
				ArrayStack<Character> ArrayC = new ArrayStack<Character>(s1.length());
				ArrayStack<Character> ArrayD = new ArrayStack<Character>(s2.length());
				
				while(q < s3.length() || subsequence != false) {
					char bo = s3.charAt(q);
					ArrayC.push(bo);
					
					for(int p = 0; p < s4.length(); p++) {
					ArrayD.push(s4.charAt(p));
					
						
					if(ArrayD.peek() == ArrayC.peek() && b == -1) {
						a = ArrayC.getTopIndex();
						b = ArrayD.getTopIndex();
						}
					else
						subsequence = false;
					
					ArrayD.pop();
					}
					
					
					if(q < s3.length())
						q++;
					
					
					if(q < s3.length()) {
						ArrayC.push(bo);
					
					for(int w = 0; w < s2.length(); w++) {
					ArrayD.push(s4.charAt(w));
					if(ArrayD.peek() == ArrayC.peek() && ArrayD.getTopIndex() != d) {
						c = ArrayC.getTopIndex();
						d = ArrayD.getTopIndex();
						}
					ArrayD.pop();
						}
					}
					if(b > d)
						subsequence = false;
					
					three = s3 + " IS NOT A SUBSEQUENCE OF " + s4;
					four = s3 + " IS A SUBSEQUENCE OF " + s4;
					
					if(subsequence == false)
							return three;
					else
						return four;
					
				}
			}
		} finally {
				files.close();
			}
		}
		
		if(temp.charAt(0) == 'F') {
			if(subsequence == false)
				return three;
			else
				return four;
		} else {
			if(subsequence == false)
				return one;
			else
				return two;
		
		}
		
	}
}

