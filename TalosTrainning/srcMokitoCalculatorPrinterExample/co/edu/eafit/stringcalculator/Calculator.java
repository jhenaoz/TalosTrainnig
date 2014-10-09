package co.edu.eafit.stringcalculator;

public class Calculator {
	
	private Printer printer;
	
	public int add(int a, int b){
		if (!printer.isPrinterConnected()){
			throw new RuntimeException("no printer is connected");
		}
		int result = a+b;
		printer.print(String.valueOf(result));
		return result;
	}
	
	public int substract(int a, int b){
		if (!printer.isPrinterConnected()){
			throw new RuntimeException("no printer is connected");
		}
		int result = a-b;
		printer.print(String.valueOf(result));
		return result;
	}
	
	public int multiply(int a, int b){
		if (!printer.isPrinterConnected()){
			throw new RuntimeException("no printer is connected");
		}
		int result = a*b;
		printer.print(String.valueOf(result));
		return result;
	}

	public int divide(int a, int b){
		if (!printer.isPrinterConnected()){
			throw new RuntimeException("no printer is connected");
		}
		int result = a/b;
		printer.print(String.valueOf(result));
		return result;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}
