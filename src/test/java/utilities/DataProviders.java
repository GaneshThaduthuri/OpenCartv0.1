package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
//data provider1    --> copying a data table from excel sheet and use that table to our project...
	@DataProvider(name="LoginData") 
	
	public String[][] getData() throws IOException {
		String path = "C:\\Practices on Eclipse\\OpenCartV0.1\\testData\\OpenCartTestData.xlsx";  //created a path for excel
		
		ExcelUtility xlUtil=new ExcelUtility(path); //obtain the excelsheet class to our utils package
		int rowCount=xlUtil.getRowCount("Sheet1");
		int cellCount=xlUtil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[rowCount][cellCount]; //created a 2 dimentional array
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				loginData[i-1][j]=xlUtil.getCellData("Sheet1",i,j);  //1,0
				
			}
		}
		return loginData;
		    
	}
	
	//dataProvider 2
	
	//data provider 3
	
	//data provider 4
	
	
}