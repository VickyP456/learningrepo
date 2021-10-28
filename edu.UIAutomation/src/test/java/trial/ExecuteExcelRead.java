package trial;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExecuteExcelRead {
	String excelFileName ="InputTestData";
	
	@DataProvider
	public String[][] sendData() throws IOException {
				 		
		return ExcelRead.excelDataRead(excelFileName);
	}
	
	@Parameters({"cityName","cityState","Country"})
	@Test
	public void testRun(String city, String state,String countryName) {
		
		System.out.println(city);
		System.out.println(state);
		System.out.println(countryName);
		
		
	}
	
	
	/*
	 * public String[] abc() { String[] ab = {"12345"}; return ab; }
	 */
	
	
	
	
	
	/*
	 * Practise
	 * Create 5 set of Account with different test data login with each UN& pwd and
	 * verfiy the UN is correct
	 */


}

