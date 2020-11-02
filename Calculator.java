package application;

public class Calculator {

	String result;
	String newNum;
	boolean addToResult;
	String operation;
	
	public Calculator () {
		result = newNum = operation = "";
		addToResult = true;
	}
	public void addDigit( String d) {
		if ( addToResult ) {
			result+=d;
		}
		else {
			newNum+=d;
		}
	}
	public void addDeci ( ) {
		if ( addToResult ) {
			result+=".";
		}
		else {
			newNum+=".";
		}
	}
	public void addNeg() {
		if ( addToResult ) {
			if (result.indexOf("-") == -1) {
				result = "-" + result;
			}
			else {
				result = result.substring(1);
			}
		}
		else {
			if (newNum.indexOf("-") == -1) {
				newNum = "-" + newNum;
			}
			else {
				newNum = newNum.substring(1);
			}
		}
		
	}
	public void doOperation() {
		if ( operation.equals("x")) {
			result = Double.toString(Double.parseDouble(result) * Double.parseDouble(newNum));
		}
		else if ( operation.equals("/") && Double.parseDouble(newNum) != 0) {
			result = Double.toString(Double.parseDouble(result) / Double.parseDouble(newNum));
		}
		else if ( operation.equals("+")) {
			result = Double.toString(Double.parseDouble(result) + Double.parseDouble(newNum));
		}
		else if ( operation.equals("-")) {
			result = Double.toString(Double.parseDouble(result) - Double.parseDouble(newNum));
		}
		else if ( operation.equals("%")) {
			result = Double.toString(.01 * Double.parseDouble(result) * Double.parseDouble(newNum));
		}
		newNum = "";
		operation = "";
	}
	public void clearAll() {
		addToResult = true;
		newNum = result = "";
		operation = "";
		
	}
	
}
