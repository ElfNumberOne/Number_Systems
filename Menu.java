import java.util.*;
import java.io.*;
/**
*@author Marcus Duree
*@version 20170217
*
*/
public class Menu {
	PrintWriter pw;
	/**
	*Constructor for objects of class menu
	*@param PrintWriter pw
	*
	*/
	public Menu(PrintWriter pw){
		this.pw = pw;
	}
	/**
	*Displays a menu of options for user
	*
	*
	*/
	public void display(){
		System.out.println("1-Decimal To Binary||2-Decimal To Hex||3-Binary To Decimal||\n4-Binary To Hex||5-Hex To Decimal||6-Hex To Binary");
		pw.println("1-Decimal To Binary||2-Decimal To Hex||3-Binary To Decimal||\n4-Binary To Hex||5-Hex To Decimal||6-Hex To Binary");
		System.out.print("Enter a selection:");
		pw.println("Enter a selection:");
		
	}
	
	/**
	*Gets the users input in string format and checks for compliance to menu options
	*
	*
	*/
	public int getSelection(){
		Scanner sc = new Scanner(System.in);
		int selection = 0;
		String sel = null;
		sel = sc.next();
		pw.println(sel);
		if(sel.charAt(0) > '6' ||sel.charAt(0)< '1' ){
			System.out.println("Invalid Selection:System Exit");
			pw.println("Invalid Selection:System Exit");
			return 7;
		}
		else if(sel.length()>1){
			System.out.println("Invalid Selection:System Exit");
			pw.println("Invalid Selection:System Exit");
			return 7;
		}
		else {
			return selection= Integer.valueOf(sel);
		}
	}
}