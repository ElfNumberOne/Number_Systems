import java.io.*;
import java.util.*;
/**
*@author Marcus Gonzalez
*@version 20170217
*
*/
public class Binary {
	private PrintWriter pw;
	private String binary;
	/**
	*Constructor for objects of class Binary
	*@param PrintWriter pw
	*
	*/
	public Binary(PrintWriter pw){
		this.pw = pw;
		binary = null;
	}
	/**
	*Takes user input in string format for conversion
	*
	*
	*/
	private void inputBin(){
		System.out.println("Enter a binary number (32 bit or less/multiple of 4):");
		pw.println("Enter a binary number (32 bit or less/multiple of 4):");
		Scanner sc = new Scanner(System.in);
		binary = sc.next();
		pw.println(binary);
		
	}
	/**
	*Calls methods to convert from binary to decimal
	*
	*
	*/
	public void binToDec(){
		this.inputBin();
		if(checkValue()==true){
			this.toDec();
			this.outDec();
		}
	}
	/**
	*Calls methods to convert from binary to hexadecimal
	*
	*
	*/
	public void binToHex(){
		this.inputBin();
		if(checkValue()==true){
			this.toHex();
			this.outHex();
		}
	}
	/**
	*Converts from binary to decimal
	*
	*
	*/
	private void toDec(){
		long temp = Long.parseLong(binary.substring(binary.length()/2, binary.length()));
		long tempbin = 0;
		int j = 0;//splits the string in half with 2 for loops 
		for (int i = 0; i < binary.length()/2;i++){//second half of string
			tempbin+=((long)(Math.pow(2,j))*(temp%10));//convert binary to dec adding as it runs
			temp/=10;
			j++;
		}
		temp = Long.parseLong(binary.substring(0, binary.length()/2));//first half of string
		for (int i = 0; i <= binary.length()/2;i++){
			tempbin+=((long)(Math.pow(2,j))*(temp%10));
			temp/=10;
			j++;
		}
		binary = Long.toString(tempbin);
	}
	/**
	*Prints the decimal value of user input
	*
	*
	*/
	private void outDec(){
		System.out.println(binary);
		pw.println(binary);
		
	}
	/**
	*Converts from binary to hex
	*
	*
	*/
	private void toHex(){
		StringBuilder sb = new StringBuilder();
		StringBuilder tempsb = new StringBuilder(binary);
		
			for (int i = 0;i<binary.length();i+=4){//maps each nibble to its binary value
				if (tempsb.substring(i,i+4).equals("0000")) 
					sb.append('0');
				else if (tempsb.substring(i,i+4).equals("0001"))
					sb.append('1');
				else if (tempsb.substring(i,i+4).equals("0010"))
					sb.append('2');
				else if (tempsb.substring(i,i+4).equals("0011"))
					sb.append('3');
				else if (tempsb.substring(i,i+4).equals("0100"))
					sb.append('4');
				else if (tempsb.substring(i,i+4).equals("0101"))
					sb.append('5');
				else if (tempsb.substring(i,i+4).equals("0110"))
					sb.append('6');
				else if (tempsb.substring(i,i+4).equals("0111"))
					sb.append('7');
				else if (tempsb.substring(i,i+4).equals("1000"))
					sb.append('8');
				else if (tempsb.substring(i,i+4).equals("1001"))
					sb.append('9');
				else if (tempsb.substring(i,i+4).equals("1010"))
					sb.append('A');
				else if (tempsb.substring(i,i+4).equals("1011"))
					sb.append('B');
				else if (tempsb.substring(i,i+4).equals("1100"))
					sb.append('C');
				else if (tempsb.substring(i,i+4).equals("1101"))
					sb.append('D');
				else if (tempsb.substring(i,i+4).equals("1110"))
					sb.append('E');
				else if (tempsb.substring(i,i+4).equals("1111"))
					sb.append('F');
			}
			sb.insert(0,"0x");
			binary = sb.toString();
	}
	/**
	*Prints hexadecimal value of user input
	*
	*
	*/
	private void outHex(){
		System.out.println(binary);
		pw.println(binary);
		
	}
	/**
	*Checks user input for compliance to binary format
	*
	*
	*/
	private boolean checkValue(){
		for (int i = 0; i <binary.length();i++){
			if(Character.getNumericValue(binary.charAt(i))>'1' || binary.length()>32 || binary.length()																		%4 != 0){
				System.out.println("Invalid Input");
				pw.println("Invalid Input");
				
				return false;
			}
		}
		return true;		
	}
}