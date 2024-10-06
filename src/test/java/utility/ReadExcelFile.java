package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {
    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;
}
