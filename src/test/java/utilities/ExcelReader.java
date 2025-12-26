package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	// File path to the Excel workbook
	private static final String EXCEL_FILE_PATH = "src/main/resources/TestData.xlsx";
//D:\BDDWithDDT\src\main\resources\TestData.xlsx
	/**
	 * Reads all data from a specific sheet in the Excel workbook.
	 * 
	 * @param sheetName The name of the sheet to read data from.
	 * @return A two-dimensional array of Objects containing the sheet data.
	 */
	public static Object[][] getTestData(String sheetName) {
		Workbook workbook = null;
		Object[][] data = null;

		try (FileInputStream file = new FileInputStream(EXCEL_FILE_PATH)) {
			// 1. Open the workbook
			workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the workbook.");
			}

			// Get total number of rows (excluding header) and columns
			// Assumes the first row (index 0) is the header.
			int rowCount = sheet.getLastRowNum(); // Last row index (0-based)
			int colCount = sheet.getRow(0).getLastCellNum(); // Last column index (1-based)

			// Initialize the 2D array: rows = rowCount, columns = colCount
			data = new Object[rowCount][colCount];

			// 2. Iterate through rows (starting from the *second* row, index 1)
			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue; // Skip if row is empty

				// 3. Iterate through columns
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

					// Convert cell content to String to handle different data types uniformly
					DataFormatter formatter = new DataFormatter();
					data[i - 1][j] = formatter.formatCellValue(cell);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}