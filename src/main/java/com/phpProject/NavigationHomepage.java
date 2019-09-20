package com.phpProject;


import org.testng.annotations.Test;

public class NavigationHomepage {
	@Test
	public void test() {

		String table[][]=new String[1][2];
		table[0][0]="username";
		table[0][1]="password";
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[0].length;j++)

			System.out.println(table[i][j]);	
		}
	}

	@Test
	public void openBrowser()  {
			//	login1();
				
		String s = "uma";
		String rev="";
			for(int i=s.length()-1;i>=0;i--) {
				rev=rev+s.charAt(i);
			}
			System.out.println(rev);
	}


}
