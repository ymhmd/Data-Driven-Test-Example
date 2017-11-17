package Test.GitHubCodes;

import static com.jayway.restassured.RestAssured.given;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;

public class DataDrivenTCs{
	
	/*
	 * 1) TestNG dataProvider annotation is to apply Data-Driven approach on test cases.
	 * 2) All test data in external Excel file > TestData.xls > SC (Excel Sheet).
	 * 3) Test data schema consists of 3 columns:
	 *   - URL
	 *   - Request type (GET, POST, ....)
	 *   - Expected returned status code to validate
	 * 4) ProvideData method returns 2D array with Object data type which contains the data in the Excel sheet.
	 * 5) Here I used Jxl API to parse the excel files.
	 */
	@DataProvider
	public Object[][] ProvideData() throws Exception{
		//open excel file
		Workbook workbook = Workbook.getWorkbook(new File("TestData.xls"));
		//the required sheet
		Sheet sheet = workbook.getSheet("SC");
		//return number of rows(records)
		int records = sheet.getRows()-1;
		int currentPosition = 1;
		Object[][] values = new Object[records][3];
		for(int i = 0 ; i < records ; i++, currentPosition++){
			//loop over the rows
			for(int j = 0 ; j < 3 ; j++) values[i][j] = sheet.getCell(j, currentPosition).getContents();
		}
		workbook.close();
		return values;
	}
	
	/*
	 * 1) test_steps methods is annotated with Test annotation. DataProvider is added to pass the test data in
	 *    the Excel sheet to test_steps methods.
	 * 2) Arguments URL, reguestMethod and StatusCode should be added as method arguments to represent the 3
	 *    columns in the excel sheet. URL represents the first column value, reguestMethod represents the second
	 *    column value and so on.
	 * 3) Here I write test case steps only one time and TestNG "@Test(dataProvider="ProvideData")" annotation makes the 
	 *    method test_steps to loop over all the rows in the Excel sheet.
	 */
	@Test(dataProvider="ProvideData")
	public void test_steps(String URL, String reguestMethod, String StatusCode){
		Response res = null;
		res = given().when().get(URL);
		Assert.assertEquals(Integer.toString(res.statusCode()), StatusCode);
		
	}
	
}
