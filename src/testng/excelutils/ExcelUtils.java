package testng.excelutils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class reads data from Excel sheet and returns it as Object [][].
 * It can be used from TestNG DataProvider method in order to return test paramters from Excel file.
 * @author tgreen
 *
 */
public class ExcelUtils
{

	//===========================================================================================================
	// 					 				Class Members
	//===========================================================================================================

	private static XSSFSheet m_excelSheet;
	private static XSSFWorkbook m_excelWorkbook;
	private static XSSFCell m_cell;
	//private static Log m_log = new Log();									// Log object - will be used to log all message to the console

	/**
	 * This method reads data from excel file and returns it as Object [][].
	 * @param FilePath	full path to an excel file (*.xlsx)
	 * @param SheetName	the sheet name to use
	 * @return	the data from the specified excel sheet as Object [][]
	 * @throws Exception
	 */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception
	{

//		System.out.println("\n\t\t* * In ExcelUtils - getTableArray(). FilePath=" + FilePath + ", SheetName=" + SheetName);
		String[][] tabArray = null;

		try
		{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet
			m_excelWorkbook = new XSSFWorkbook(ExcelFile);

			m_excelSheet = m_excelWorkbook.getSheet(SheetName);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = m_excelSheet.getLastRowNum();

			// Check the number of columns in the excel according to the first row
			int totalCols = m_excelSheet.getRow(startRow).getPhysicalNumberOfCells();
			tabArray = new String[totalRows][totalCols];
			ci = 0;

			//System.out.println("Reading parameters from excel:");
			for (int i = startRow; i <= totalRows; i++, ci++)
			{
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++)
				{
					tabArray[ci][cj] = getCellData(i, j);
//					System.out.println(tabArray[ci][cj]);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
			m_cell = m_excelSheet.getRow(RowNum).getCell(ColNum);
			int dataType = m_cell.getCellType();
			if (dataType == 3)
			{
				return "";
			}
			String CellData = m_cell.getStringCellValue();
			return CellData;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			throw (e);
		}

	}
}