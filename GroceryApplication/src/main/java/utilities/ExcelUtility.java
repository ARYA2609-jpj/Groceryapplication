package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility {

    static XSSFWorkbook w;  //Book1
    static XSSFSheet s;     //sheets   

    public static String getStringData(int a, int b, String sheet) throws IOException //a is a row,b is a column or cell
    {
        FileInputStream fis = new FileInputStream(Constants.TESTDATAFILE);

        w = new XSSFWorkbook(fis);
        s = w.getSheet(sheet);

        XSSFRow r = s.getRow(a);
        XSSFCell c = r.getCell(b);

        w.close();
        return c.getStringCellValue();
    }

    public static String getIntegerData(int a, int b, String sheet) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\aryas\\git\\Groceryapplication\\GroceryApplication\\src\\test\\resources/TestData.xlsx");

        w = new XSSFWorkbook(fis);
        s = w.getSheet(sheet);

        XSSFRow r = s.getRow(a);
        XSSFCell c = r.getCell(b);

        int y = (int) c.getNumericCellValue();
        w.close();
        return String.valueOf(y);
    }
}
