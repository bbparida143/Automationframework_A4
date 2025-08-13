package Viger.Generic.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is contains a method to read data from excel file provided with sheetname, row, cell
 */
public class ExcelFileUtility {
	/**
	 * this method is used to read data from excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String toReadDataFromExcelFile(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\vtigerdata.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
	}

}
