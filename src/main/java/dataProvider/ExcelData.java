package dataProvider;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelData {
	private String TestDataSheetName;
	private String TestDataColumnName;
	private ExcelReader reader;
	public ExcelData(String FileName,String TestDataSheetName,String TestDataColumnName) {
		this.TestDataSheetName=TestDataSheetName;
		this.TestDataColumnName=TestDataColumnName;
		reader = new ExcelReader(FileName);
	}
	public Map<String, String> getTestdata(String DataSetID) {
		Map<String,String> testdata = new LinkedHashMap<String,String>();
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
   
}
