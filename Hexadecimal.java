import java.io.*;
import java.util.*;
/**
*@author Marcus Gonzalez
*@version 20170217
*
*/
public class Hexadecimal {

	private PrintWriter pw;
	private String hexStr;
	/**
	*Constructor for objects of class hexadecimal
	*@param PrintWriter pw
	*
	*/
	public Hexadecimal(PrintWriter pw){
		this.pw = pw;
		hexStr = null;
	}
	/**
	*Calls methods to convert from hexadecimal to decimal
	*
	*
	*/
	public void hexToDec(){
		this.inputHex();
		if(checkInput()== true){
			this.toDec();
			this.outDec();
		}
	}
	/**
	*Calls methods to convert from hexadecimal to binary
	*
	*
	*/
	public void hexToBin(){
		this.inputHex();
		if(checkInput()==true){
			this.toBin();
			this.outBin();
		}
	}
	
	/**
	*Converts user input to decimal
	*
	*
	*/
	private void toDec(){
		ResizeIntStack s = new ResizeIntStack();
		int j = 0;
		int hex = 0;
		for (int i = 0;i<hexStr.length();i++){//gets num value of hex at i and pushes on stack
			s.push(Character.getNumericValue(hexStr.charAt(i)));
		}	
		while (!s.isEmpty()) {//adds all values from stack for dec value
			hex+=(Math.pow(16,j++) * s.pop());
		}	
		hexStr = Integer.toString(hex);
	}
	/**
	*Prints decimal value of user input
	*
	*
	*/
	private void outDec(){
		System.out.println(hexStr);
		pw.println(hexStr);
	}
	
	/**
	*Prompts user to input a hex value
	*
	*
	*/
	private void inputHex(){
		System.out.println("Enter a Hexadecimal number:");
		pw.println("Enter a Hexadecimal number:");
		Scanner sc = new Scanner(System.in);
		hexStr = sc.nextLine();
		hexStr = hexStr.toUpperCase();
		pw.println(hexStr);
	}
	/**
	*Converts user input to a binary value
	*
	*
	*/
	private void toBin(){
		StringBuilder temp = new StringBuilder();
		StringBuilder hex = new StringBuilder(hexStr);
		StringBuilder nibble = new StringBuilder();
		for (int i = 0;i<hexStr.length();i++){//maps each hex character to its binary value
			if (hex.charAt(i)=='0')
				temp.append("0000");
			else if(hex.charAt(i) == '1')
				temp.append("0001");
			else if(hex.charAt(i) == '2')
				temp.append("0010");
			else if(hex.charAt(i) == '3')
				temp.append("0011");
			else if(hex.charAt(i) == '4')
				temp.append("0100");
			else if(hex.charAt(i) == '5')
				temp.append("0101");
			else if(hex.charAt(i) == '6')
				temp.append("0110");
			else if(hex.charAt(i) == '7')
				temp.append("0111");
			else if(hex.charAt(i) == '8')
				temp.append("1000");
			else if(hex.charAt(i) == '9')
				temp.append("1001");
			else if(hex.charAt(i) == 'A')
				temp.append("1010");
			else if(hex.charAt(i) == 'B')
				temp.append("1011");
			else if(hex.charAt(i) == 'C')
				temp.append("1100");
			else if(hex.charAt(i) == 'D')
				temp.append("1101");
			else if(hex.charAt(i) == 'E')
				temp.append("1110");
			else if(hex.charAt(i) == 'F')
				temp.append("1111");
		}
		for (int i = 0;i<=40;i+=5){//adds nibbles to string until 8 nibbles are achieved
			if (temp.length()<32){
				while (temp.length()<32) {
					temp.insert(i,"0000");
				}
			}
			if(i < temp.length())//inserts a space after each nibble
			temp.insert(i+4," ");
		}
		hexStr = temp.toString();
	}
	/**
	*Prints binary value of user input
	*
	*
	*/
	private void outBin(){
		System.out.println(hexStr);
		pw.println(hexStr);
		
	}
	/**
	*Checks user input for hexadecimal compliance
	*
	*
	*/
	private boolean checkInput(){//checks if hex input is with limits for a hex value
		for(int i = 0;i < hexStr.length();i++){
			if((hexStr.charAt(i)<'0'||hexStr.charAt(i)>'9')&& (hexStr.charAt(i)<'A'||																		hexStr.charAt(i)>'F')){
			System.out.println("Invalid Input");
			pw.println("Invalid Input");
			
			return false;
			}
		}
		return true;
	}
		
}