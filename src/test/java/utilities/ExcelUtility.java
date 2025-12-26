package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getCellValue(String xlPath, String sheetname, int rowNum, int colNum) {
		try (FileInputStream fis = new FileInputStream(xlPath); Workbook wb = WorkbookFactory.create(fis)) {
			Sheet sheet = wb.getSheet(sheetname);
			if (sheet == null)
				return "";

			Row row = sheet.getRow(rowNum);
			if (row == null)
				return "";

			Cell cell = row.getCell(colNum);
			if (cell == null)
				return "";

			DataFormatter formatter = new DataFormatter();
			return formatter.formatCellValue(cell);

		}

		catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public static int getRowCount(String xlPath, String sheetName) {
		try (FileInputStream fis = new FileInputStream(xlPath); Workbook wb = WorkbookFactory.create(fis)) {
			Sheet sheet = wb.getSheet(sheetName);
			return (sheet != null) ? sheet.getLastRowNum() : 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String getProperty(String path, String key) {

		try (FileInputStream fis = new FileInputStream(path)) {
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key, "");

		}

		catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
