package com.jv.matrix;

public class IsValidSudoku {
	
	
	public static void isValid() {
		
		boolean done = false;
		
		int i=0,j=0,ist=0,jst=0;
		while(!done) {
		
			if(i==9 && j==9)
				done=true;
			else if(j>=9) {
				ist+=3;
				jst=0;
			}
			
			for(i=ist;i<ist+3;i++) {
				for(j=jst;j<jst+3;j++) {
					System.out.print(i + "," + j+"  ");
				}
			}
			
			System.out.println();
			jst+=3;
		}
		
	}
	
	public static void main(String[] args) {
		isValid();
	}

}
