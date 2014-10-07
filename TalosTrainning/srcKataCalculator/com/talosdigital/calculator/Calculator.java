package com.talosdigital.calculator;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.talosdigital.util.LoggerUtil.*;

import com.talosdigital.exceptions.NegativeNumberException;
import com.talosdigital.util.LoggerUtil;

/**
 * This class have the main logic for the kata Calculator
 * @author jhenaoz
 * @version 02/10/2014
 */
public class Calculator{
	
	ArrayList<String> separators;
	String input;
	
	
	public static void main(String[] args) {

	}
	public Calculator(){
		separators = new ArrayList<String>();
		input = "";
		LoggerUtil.startLogger("CalculatorFile.log");
	}
	
	/**
	 * this method get and string with input and return their sum, if the input
	 * is empty, the method return 0
	 * @param input
	 * @return result, the sum of the input
	 * @throws NegativeNumberException, if the input have a negative number
	 */
	public int add (String input) throws NegativeNumberException{
		this.input = input;
		int result = 0 ;
		String nums[];
		String separator = ",";
		StringBuilder negatives = new StringBuilder();
		//first check the failure, if the input don't have content
		if (input.length() == 0) {
			return result;
		}
		nums =input.split("\n|"+separator);
		//this conditional check for all the separators
		if (input.contains("//")) {
			String specialSeparators = getSpecialSeparators();
			input = this.input;
			nums =input.split("\n"+ specialSeparators);
		}
		for (String string : nums) {
			int num = Integer.parseInt(string);
		 //check is there is a negative number, and add it to a string
			if (num < 0) {
				if (negatives.length() == 0) {
					negatives.append(num);
				}else{
					negatives.append("," + num);
				}
			}else if(num>1000){
				continue;
			}
			//sum the number is pass the 2 conditions
			result += num;
		}
		if (negatives.length() > 0) {
			String message = "Negatives not allowed : " + negatives.toString();
			log.error(message);
			throw new NegativeNumberException(message);
		}
		return result;
	}
	
	/**
	 * This method take the especial separators, and return a regular expression
	 * with each separator in this format (separator|separator|separator....)
	 * @return
	 */
	public String getSpecialSeparators(){
		
		log.info("seraching for special separators");
		String nums[];
		StringBuilder output = new StringBuilder();
		String openBracket =Pattern.quote("[");
		String closeBracket = Pattern.quote("]");
		nums = input.split("//|\n");
		String separatorsForInput[] =nums[1].split(openBracket);
		for (String separator : separatorsForInput) {
			if (!separator.isEmpty()) {
				separator = separator.replaceAll(closeBracket, "");
				separators.add(separator);
			}
		}
		input =input.replaceFirst("//", "");
		input =input.replaceFirst("\n", "");
		input = input.replaceAll(openBracket, "");
		input = input.replaceAll(closeBracket, "");
		for (String separator : separators) {
			separator = Pattern.quote(separator);
			input = input.replaceFirst(separator, "");
			output.append("|" + separator);
		}
		return output.toString();
	}
}