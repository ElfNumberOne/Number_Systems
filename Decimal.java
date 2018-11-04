import java.io.*;
import java.util.*;
/**
*@author Marcus Gonzalez
*@version 20170217
*
*/
public class Decimal
 {
    private  PrintWriter pw;
    private String dec;
    /**
    *Constructor for objects of class Decimal
    *@param PrintWriter pw
    *
    */
    public Decimal(PrintWriter pw)
    {
	   this.pw = pw;
      dec = null;
    }
	/**
    *Calls methods to convert from decimal to binary
    */
    public void decToBin()
    {
	  this.inputDec();
     if (checkInput()==true) {
       this.toBin();
       this.outBin();
    }
    }
	/**
    *Calls methods to convert from decimal to hex
    *
    *
    */
    public void decToHex()
    {
	   this.inputDec();
      if (checkInput()==true) {
        this.toHex();
        this.outHex();
      }
    }
	
	/**
    *Converts user input from decimal to hex
    *  
    *
    */
    private void toBin()
    {
      int remainder = 0;
      int decvalue = Integer.valueOf(dec);
      StringBuilder sb = new StringBuilder();
      StringBuilder nibble = new StringBuilder();
      ResizeIntStack s = new ResizeIntStack();
      for (int i = 0;i<32;i++){
          s.push(decvalue % 2);//pushes remainder of decvalue/2 onto stack
          decvalue/=2;
           }
     while(!s.isEmpty())
          sb.append(s.pop());//pops the stack, getting the binary value
     for (int i = 0;i<sb.length();i++){
          if (i%4 == 0)
            nibble.append(" ");//forms the nibbles
          nibble.append(sb.charAt(i));
    }
     dec = nibble.toString();
    }
	/**
    *Prints user input in binary format
    *
    *
    */
    private void outBin()
    {
	    System.out.println(dec);
       pw.println(dec);
    }
	
	/**
    *Prompts user for decimal input
    *
    *
    */
    private void inputDec()
    {
	    System.out.println("Enter a Decimal value:");
      pw.println("Enter a Decimal value:");
       Scanner sc = new Scanner(System.in);
       dec = sc.next();
       pw.println(dec);
    }
    /**
    *Converts user input to hexadecimal format
    *
    *
    */
    private void toHex()
    {
      int remainder = 0;
      int decvalue = Integer.valueOf(dec);
      StringBuilder sb = new StringBuilder();
      while (decvalue != 0) {
        remainder = (decvalue % 16);//gets the remainder of decvalue/16
        decvalue /=16;
        if(remainder > 9)
          sb.append((char)(remainder + 55));//converts remainder to its hex format
        else 
          sb.append(remainder);
        
      }
      sb.reverse();
      sb.insert(0,"0x");
      dec = sb.toString();
    }
    /**
    *Prints user input in hexadecimal format
    *
    *
    */
    private void outHex()
    {
	    System.out.println(dec);
      pw.println(dec);
      
    }
    /**
    *Checks user input for decimal compliance
    *
    *
    */
    private boolean checkInput(){
      for (int i = 0;i < dec.length();i++) {
        if (dec.charAt(i) > '9'|| dec.charAt(i)<'0') {
          System.out.println("Invalid Input");
          pw.println("Invalid Input");
          
          return false;
        }
      }
      return true;
    }
		
	
}