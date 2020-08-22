package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ChangeMakerProject {

	public static void main(String[] args) {
		// Write a program to calculate change given to someone.
		System.out.print("Please enter the total of your purchase: ");
		Scanner totalsc = new Scanner(System.in);
		double total = totalsc.nextDouble();
		
		int[] result = changeMaker(total);
		System.out.println("The change breakdown is: ");
		System.out.print("Dollars: " + result[0] + ", ");
		System.out.print("Quarters: " + result[1] + ", ");
		System.out.print("Dimes: " + result[2] + ", ");
		System.out.print("Nickels: " + result[3] + ", ");
		System.out.println("Pennies: " + result[4] + ".");
		System.out.println("Thank you, please have a great day!");

	}
	/* We were given the task of writing a method to calculate the change given,
	 * and the breakdown of coins returned. I will be using a value given for the
	 * "total" charged from the main. Once this method is called, it will prompt 
	 * the user for the amount tendered and do some calculations to find the amount
	 * of change. Then I will process the remaining value with a series of 
	 */
	public static int[] changeMaker(double total) {
		DecimalFormat df = new DecimalFormat("0.00");
		int quarters, quarterval, dimes, dimeval, nickels, nickelval, pennies, pennyval;
		quarters = 0;
		dimes = 0;
		nickels = 0;
		pennies = 0;
		quarterval = 0;
		dimeval = 0;
		nickelval = 0;
		pennyval = 0;
		int cointotal = 0;
		System.out.println("Your total is: $" + total + ".");
		System.out.print("Please enter the amount tendered: ");
		Scanner paymentsc = new Scanner(System.in);
		double payment = paymentsc.nextDouble();
		double change = payment - total;
		System.out.println("The change due is: $" + df.format(change) +".");
		//This operation will remove any "dollar" values from the float
		int changeDol = (int) change;
		//This operation will then provide the remaining coins value
		double changeCoin = (change - (changeDol)) * 100;
		//This operation will change our coins from a double to int value for
		// ease of writing
		double coinrem = roundDecimal2(changeCoin);
		while(coinrem > cointotal && (coinrem - cointotal) >= 25) {
			quarters++;
			quarterval = quarters * 25;
			cointotal = quarterval + dimeval + nickelval + pennyval;
			}
			while(coinrem > cointotal && (coinrem - cointotal) >= 10) {
				dimes++;
				dimeval = dimes * 10;
				cointotal = quarterval + dimeval + nickelval + pennyval;
			}
			while(coinrem > cointotal && (coinrem - cointotal) >= 5) {
				nickels++;
				nickelval = nickels * 5;
				cointotal = quarterval + dimeval + nickelval + pennyval;
			}
			while(coinrem > cointotal && (coinrem - cointotal) != 0) {
				pennies++;
				pennyval = pennies * 1;	
				cointotal = quarterval + dimeval + nickelval + pennyval;
			}
		int[] result = new int[5];
		result[0] = changeDol; //Dollars in change
		result[1] = quarters; //Quarters in change
		result[2] = dimes; //Dimes in change
		result[3] = nickels; //Nickels in change
		result[4] = pennies; //Pennies in change
		return result; //Returns result array
	}
	
	//Unused method below "roundNum" was an attempt to round decimals to 0.00
	public static int roundNum(float y) {
		DecimalFormat df = new DecimalFormat("0.00");
		String s = String.valueOf(df.format(y));
		int a = s.charAt(0);
		System.out.print("string s: " + s + "Char at 5: " + a);
		int x = (int) y;
		float z = (float) y - x * 100;
		int z1 = (int) z;
		if(a >= 5) {
			z1++;		
		}
		if(a > 0 && a < 5) {
			z1--;
		}
		else {
			return z1;
		}
		return z1;
	}
	
	/*This method rounds the decimal places to 0.00. This helps to prevent
	 * having issues with calculating exact change value. 
	 */
	public static double roundDecimal2(double y) {
		DecimalFormat df = new DecimalFormat("0.00");
		String sValue = (String) df.format(y);
		double newValue = Double.parseDouble(sValue);
		return newValue;
	}

}
