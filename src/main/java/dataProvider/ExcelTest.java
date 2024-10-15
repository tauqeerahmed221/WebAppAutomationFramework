package dataProvider;

import java.util.ArrayList;
import java.util.List;

import dataProvider.ExcelReader;

public class ExcelTest {
	String path;
	String sheetName;
	String columnName;

	public ExcelTest(String path, String sheetName, String columnName) {
		this.path = path;
		this.sheetName = sheetName;
		this.columnName = columnName;
	}

	public  List<String> getTestCaseTagsfromExcel() {
		ExcelReader excelReader = new ExcelReader(path);
		List<String> li = new ArrayList<String>();
		int rowCount = excelReader.getRowCount(sheetName);
		for (int i = 2; i <=rowCount; i++) {
			String cellData = excelReader.getCellData(sheetName, columnName, i);
			if (cellData.contains(".0")) {
				String[] split = cellData.split("[.]");
				cellData =split[0];
			}
			if (!(cellData.isBlank())) {
				li.add(cellData);
			}
			
		}
		return li;
	}

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\TestData\\FMSTestData.xlsx";
		ExcelTest excelTest = new ExcelTest(path, "TestExecution", "TestCaseID");
		List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
		for (String string : testCaseTagsfromExcel) {
			System.out.println(string);
		}
	}

}
