package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelData {
	
	
	@DataProvider(name = "loginUserNames")
	public static String[][] readCustomerData() throws IOException {

		String Path1 = System.getProperty("user.dir");
		String Path = Path1 + "\\src\\main\\java\\TestDataExcel\\LoginUserNames.xlsx";
		System.out.println(Path);

		FileInputStream fs = new FileInputStream(Path);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("LoginUsers");

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		return testData;

	}


}
