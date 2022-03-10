package ceasercipher;

import java.util.Scanner;

public class railfence {


public static void main(String[] args)
{
	String msg="";
	int a;
	Scanner SC = new Scanner(System.in);
	System.out.println("Enter the Message");
	msg=SC.nextLine();
	System.out.println("Enter the Depth");
	a=SC.nextInt();
	
//	System.out.println(col);
	getmat(msg,a);
	
	
	
}
public static void getmat(String s1,int depth)
{
	int col=s1.length()/depth;
	if(col%2==1)
	{
		col=col+1;
	}
	else {
		col=col;
	}
	char ar[][] = new char[depth][col];
//	char ar2[] = new char[col];
	
	String encrypted="";
	String decrypted="";
	int temp=0;
	System.out.println(depth);
	System.out.println(col);
//	int temp1=0,temp2=0;
//	for(int i=0;i<s1.length();i++)
//		{
//		
//		if(i%2==0)
//		{
//			ar1[temp1]=s1.charAt(i);
//			temp1++;
//		}
//		else {
//			ar2[temp2]=s1.charAt(i);
//			temp2++;
//		}
//			
//		}
//	for(int i=0;i<temp1;i++)
//		{
//		
//		
//				System.out.println(ar1[i]);
//				
//		}
//	for(int i=0;i<temp2;i++)
//	{
//			System.out.println(ar2[i]);
//			
//		}
//		}
	
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<depth;j++)
			{
				if(temp<s1.length())
				{
					ar[j][i]=s1.charAt(temp);
			
					temp=temp+1;
				}
			}
		}
	
	
	System.out.println("Encryped message" );
	for(int i=0;i<depth;i++)
	{
		for(int j=0;j<col;j++)
		{
			encrypted+=ar[i][j];
		}
	}
	System.out.println(encrypted );
	System.out.println("Decrypted message" );
	for(int i=0;i<col;i++)
	{
		for(int j=0;j<depth;j++)
		{
			decrypted+=ar[j][i];
		}
	}
	
	System.out.println(decrypted );
}
}







