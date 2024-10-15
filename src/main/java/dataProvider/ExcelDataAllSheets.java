package dataProvider;

import java.util.HashMap;
import java.util.List;

public class ExcelDataAllSheets {
    static ExcelDataAllSheets excelData;
	private String TestDataSheetName;
	private String TestDataColumnName;
	private ExcelReader reader;
	static HashMap<String, HashMap<String, String>> dataset;
	HashMap<String, String> testdata;
	static HashMap<String,HashMap<String, HashMap<String, String>>> testDataMap;
	
	public ExcelDataAllSheets(String FileName,String TestDataSheetName,String TestDataColumnName) {
		this.TestDataSheetName=TestDataSheetName;
		this.TestDataColumnName=TestDataColumnName;
		reader = new ExcelReader(FileName);
	}
	public HashMap<String, String> getTestdata(String DataSetID) {
		//Map<String,String> testdata = new LinkedHashMap<String,String>();
		testdata = new HashMap<String, String>();
		//int rowCount = reader.getRowCount(TestDataSheetName);
		int columnCount = reader.getColumnCount(TestDataSheetName);
		//System.out.println(rowCount+"    "+columnCount);
		int cellRowNum = reader.getCellRowNum(TestDataSheetName,TestDataColumnName,DataSetID);
		//System.out.println(cellRowNum);
		
			for (int j = 1; j <=columnCount; j++) {
				String key = reader.getCellData(TestDataSheetName,j,1);
				String value = reader.getCellData(TestDataSheetName,j, cellRowNum);
				if (value.contains(".0")) {
					String[] split = value.split("[.]");
					 value =split[0];
				}
				testdata.put(key, value);
				
				
				if (testdata.containsValue("")) {
					testdata.remove(reader.getCellData(TestDataSheetName,j,1));
				}			
			}
			return testdata;
			
		//System.out.println(testdata);
		//System.out.println(testdata.get("AssetModelType"));
	}
	
  public void updateTestData(String DataSetID,String ColumnName,String TestDataValue) {
	  int cellRowNum = reader.getCellRowNum(TestDataSheetName,TestDataColumnName,DataSetID);
	  reader.setCellData(TestDataSheetName, ColumnName, cellRowNum, TestDataValue);

}
  public static HashMap<String, HashMap<String, HashMap<String, String>>> getTestDataAllSheets(String path) {
	 
	  ExcelReader reader = new ExcelReader(path);
	  dataset = new HashMap<String, HashMap<String, String>>();
	  testDataMap = new HashMap<String,HashMap<String, HashMap<String, String>>>();
	//  System.out.println(reader.getNoOfSheets());
	  for (int i = 0; i <reader.getNoOfSheets()-1 ; i++) {
		//System.err.println(reader.getSheetName(i)+"  "+reader.getRowCount(reader.getSheetName(i)));
		  if (!reader.getCellData(reader.getSheetName(i), "DataSet ID", 1).isBlank()
				||!reader.getCellData(reader.getSheetName(i), "DataSet ID", 1).isEmpty()) {
			//  System.out.println(reader.getSheetName(i));
				  excelData = new ExcelDataAllSheets(path,reader.getSheetName(i),"DataSet ID");
				  ExcelTest excelTest = new ExcelTest(path,reader.getSheetName(i) , "DataSet ID");
				  List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
				 // int rowCount = reader.getRowCount(reader.getSheetName(i));
				//  System.err.println(reader.getRowCount(reader.getSheetName(i)));
				  for (String string : testCaseTagsfromExcel) {
					//  System.out.println(string);
						  ExcelDataAllSheets.dataset.put(string, excelData.getTestdata(string)); 
			}
				  ExcelDataAllSheets.testDataMap.put(reader.getSheetName(i), ExcelDataAllSheets.dataset);
		}
		  
		  
	  }
	  return ExcelDataAllSheets.testDataMap;

}
  public static void main(String[] args) {
	  
	    String path = System.getProperty("user.dir") +"\\TestData\\FMSTestData.xlsx";
		HashMap<String, HashMap<String, HashMap<String, String>>> testDataAllSheets = getTestDataAllSheets(path);
		System.out.println(testDataAllSheets.get("FacilitiesManagement").get("AT_FM_062_D1").get("RequestID"));
		System.out.println(testDataAllSheets.get("RequestForFinancing_482").get("AT_RF_164_D1").get("TotalLimit"));
		
	
	    
}
   
}
