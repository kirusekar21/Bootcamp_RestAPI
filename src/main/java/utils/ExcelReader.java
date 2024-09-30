package utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
public class ExcelReader {
	

        public static void main(String[] args) throws IOException {
	        // Read user IDs from Excel
	        String excelFilePath = "\\src\\test\\resources\\testData\\post_values.xlsx";
	        FileInputStream fis = new FileInputStream(excelFilePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            String userId = row.getCell(0).getStringCellValue();

	        }

	        workbook.close();
	        fis.close();
	    }
	}
//public class ExcelReader {
//
//    public List<String[]> readExcel(String filePath) throws IOException {
//        List<String[]> data = new ArrayList<>();
//        FileInputStream fis = new FileInputStream(new File(filePath));
//        Workbook workbook = WorkbookFactory.create(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Read the first sheet
//
//        for (Row row : sheet) {
//            String[] rowData = new String[row.getPhysicalNumberOfCells()];
//            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
//                Cell cell = row.getCell(i);
//                rowData[i] = cell.toString(); // Convert cell value to String
//            }
//            data.add(rowData);
//        }
//        workbook.close();
//        return data;
//    }
//}

