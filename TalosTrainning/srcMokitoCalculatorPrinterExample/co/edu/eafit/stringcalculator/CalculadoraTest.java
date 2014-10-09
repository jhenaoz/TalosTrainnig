package co.edu.eafit.stringcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculadoraTest {

	private Calculator calculator;
	
	@Mock
	private Printer printer; 
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		calculator = new Calculator();
		calculator.setPrinter(printer);
	}
	
	@Test
	public void testAddWithPrinterConnected(){
		Mockito.when(printer.isPrinterConnected()).thenReturn(true);
		int result = calculator.add(2,3);
		Assert.assertEquals("expecting 5",5, result);
		Mockito.verify(printer).print("5");
	}
	
	@Test(expected = RuntimeException.class)
	public void testAddWithPrinterNotConnected(){
		Mockito.when(printer.isPrinterConnected()).thenReturn(false);
		calculator.add(2,3);
	}
}
