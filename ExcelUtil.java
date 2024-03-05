package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
		public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\OrgnizationFile.xlsx");
			Workbook wb = WorkbookFactory.create(fis);   
			Sheet sh = wb.getSheet(sheetname);
			Row rw = sh.getRow(rownum);	
			Cell cll = rw.getCell(cellnum);
			String data = cll.getStringCellValue();
			return data;
		}

	}


