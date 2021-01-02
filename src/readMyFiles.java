import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readMyFiles {
	public static String[][] details = new String[50][50];
	public static String[][] fdetails = new String[50][50];
	public static String[] Headings = new String[50];
	public static File output;
	public static File  input;
	public static String Loc;
	public static XSSFWorkbook inbook;
	public static Cell cells;
	public static XSSFWorkbook book;
	public static int i,j,nr,nc,ncv;

	public static void main(String[] arg,String fileLoc) {

		nc=0;
		File input = new File(fileLoc);
		try(FileInputStream in = new FileInputStream(input)) {

			inbook = new XSSFWorkbook(in);
			XSSFSheet sheet = inbook.getSheetAt(0);
			nr=sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			ncv= row.getPhysicalNumberOfCells();
			String[][] details = new String[50][50];
			for(i=0;i<nr;i++) {
				XSSFRow rows = sheet.getRow(i);
				for(j=0;j<ncv;j++) {
					Cell cell = rows.getCell(j);
					if(cell.toString() == "" ||cell.toString() == null) {
						details[i][j] = "0";
					}
					else {
						details[i][j] = cell.toString();
						fdetails[i][j] = details[i][j];
					}
				}
			}
			inbook.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


}


