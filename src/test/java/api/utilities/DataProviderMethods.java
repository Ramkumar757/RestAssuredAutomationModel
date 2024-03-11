package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
	
	ExcelUtilities ut;
	
	@DataProvider(name="UserApiData")
	public String[][] userApiAllData() throws IOException {
		
		String path =".\\ExcelFiles\\testdataFile.xlsx";
		 ut = new ExcelUtilities(path);
		 
		 int rowCount = ut.getRowCount("Sheet1");
		 int colCount = ut.getCellCount("Sheet1", 1);
		 
		 
		 String[][] userdata = new String[rowCount][colCount];
		 
		 
		 for(int i =1 ;i<=rowCount ; i++) {
			 for(int j =0 ;j<colCount ; j++) {
				 
				 userdata[i-1][j]  = ut.getCellData("Sheet1", i, j);
				 
			 }
			 
		 }
		 
		 return userdata;
		
	}
	
	@DataProvider(name="userName")
	public String[] getSingleUserName() throws IOException {
		
		String path =".\\ExcelFiles\\testdataFile.xlsx";
		 ut = new ExcelUtilities(path);
		 
		 int rowCount = ut.getRowCount("Sheet1");
		 
		 String[] userName = new String[rowCount];
		 
		 for (int i=1;i<=rowCount; i++) {
			 
			 userName[i-1]= ut.getCellData("Sheet1", i,1);
		 }
		 
		 
		 return  userName;
		
	}

}
