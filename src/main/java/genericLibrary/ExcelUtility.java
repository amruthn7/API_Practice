package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	DataFormatter df;
	Sheet sheet;
	Workbook wb;

	public Object[][] getExcelData(String sheetName) {
		try {
			df=new DataFormatter();

			fis= new FileInputStream("D:\\Eclipse Workspace\\Selenium Workspaces\\SDET Workspace\\RmgYantra\\Data\\TestData.xlsx");

			wb= WorkbookFactory.create(fis);
			sheet= wb.getSheet(sheetName);

			Object[][] a= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];//4,3
			for (int i = 0; i < a.length; i++) { //0
				for (int j = 0; j < a[i].length; j++) { //0, 1,2,3
					a[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j)); //[0][0]=amr, [0][1]=dell11, [0][2]=created, [0][3]=2
				}															  //[1][0]=amr, [1][1]=dell12, [1][2]=completed, [1][3]=3
			}

			wb.close();
			return a;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	return null;
	}
	
	public void close() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

