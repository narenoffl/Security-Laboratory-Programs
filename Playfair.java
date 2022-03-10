package ceasercipher;
import java.util.*;

public class Playfair {

public static String ALPHABETS="ABCDEFGHIKLMNOPQRSTUVWXYZ";


public static String nonrepeat( String s1,String s2)
{
	
	for(int i=0;i<s2.length();i++)
	{
		if(i==0 && s2.length()!=25 )
		{
			s1+=s2.charAt(i);
		}
		else {
			for(int j=0;j<s1.length();j++)
			{

			if(s2.charAt(i)!=s1.charAt(j))
			{
				if(j==s1.length()-1)
				{
				s1+=s2.charAt(i);
				
				}
			
				
			}
			else {
				break;
			}
			
				
			}
			
			
		}
			
		
	}
	return(s1);
}
public static void main(String[] args) {

	Scanner SC = new Scanner(System.in);
	System.out.println("Enter the text");
	String msg =SC.nextLine();
	System.out.println("Enter the Key");
	String key = SC.nextLine();
	String no_repeat="";
	char arr[][]=new char[5][5];
	String w=nonrepeat(no_repeat,key);
	
	String h=nonrepeat(w,ALPHABETS);
	
	
//	nonrepeat(no_repeat,key);
	keyMatrix(h,arr);
	String u=encryption(msg,arr);
	String v=decrypt(u,arr);
	System.out.println("Encrypted Message"+u);
	System.out.println("Encrypted Message"+v);
	
	
}

public static void keyMatrix(String key,char ar[][] )
{
	
	
	
	int temp=0;
	
	key=key.toUpperCase();
	for(int i=0;i<ar.length;i++)
	{
		for(int j=0;j<ar.length;j++) {
			
			
			if(temp<key.length())
			{
			ar[i][j]=key.charAt(temp);
			temp=temp+1;
			}
			
			
		}
	}
	
	
//	for(int i=0;i<ar.length;i++)
//	{
//		for(int j=0;j<ar.length;j++) {
//			System.out.println(ar[i][j]);
//		}
//		}
//	
}
	
public static String encryption(String message , char key[][])
{

	String cipherText="";
	for(int i=0;i<message.length();i++)  // PLAYFAIR
	{
		int p =0 , q=0 , r= 0 , s=0;
		for(int j=0;j<key.length;j++)
		{
			for(int k=0;k<key.length;k++)
			{
				if(message.charAt(i) == key[j][k])
				{
					p = j;
					q= k;
				}
				if(message.charAt(i+1) == key[j][k])
				{
					r=j;
					s=k;
				}
				
			}
		}
		
		if(p!=r && q!=s)
		{
			if(p > r)
			{
				char a = key[p][s];
				char b =key[r][q];
				cipherText += a;
				cipherText += b;
			}
			else
			{
				char a = key[r][q];
				char b =key[p][s];
				cipherText += a;
				cipherText += b;
			}
			
		}
		else if(p==r)
		{
			char a = key[p][q+1];
			char b =key[r][s+1];
			cipherText += a;
			cipherText += b;
		}
		else if(q==s)
		{
			char a = key[p+1][q];
			char b =key[r+1][s];
			cipherText += a;
			cipherText += b;
		}
		i++;
	}
	return cipherText;

}

public static String decrypt(String cipherText , char key[][])
{
	String plainText = "";
	for(int i=0;i<cipherText.length();i++)  // PLAYFAIR
	{
		int p =0 , q=0 , r= 0 , s=0;
		for(int j=0;j<key.length;j++)
		{
			for(int k=0;k<key.length;k++)
			{
				if(cipherText.charAt(i) == key[j][k])
				{
					p = j;
					q= k;
				}
				if(cipherText.charAt(i+1) == key[j][k])
				{
					r=j;
					s=k;
				}
				
			}
		}
		
		if(p!=r && q!=s)
		{
			if(p > r)
			{
				char a = key[p][s];
				char b =key[r][q];
				plainText += a;
				plainText += b;
			}
			else
			{
				char a = key[r][q];
				char b =key[p][s];
				plainText += a;
				plainText += b;
			}
			
		}
		else if(p==r)
		{
			char a = key[p][q-1];
			char b =key[r][s-1];
			plainText += a;
			plainText += b;
		}
		else if(q==s)
		{
			char a = key[p-1][q];
			char b =key[r-1][s];
			plainText += a;
			plainText += b;
		}
		i++;
	}
	return plainText;
}













	}
