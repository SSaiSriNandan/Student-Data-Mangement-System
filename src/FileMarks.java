import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileMarks {
	public static String[][] details = new String[50][50];
	public static String[] Headings = null;
	static File output;
	static File  input;
	static String Loc;
	private static XSSFWorkbook inbook;
	private static Cell cells;
	public static void main(String[] args) {
		makeData();
	}

	@SuppressWarnings("resource")
	public static void makeData() {

		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		XSSFRow row;
		int i,j,n,ns;
		row = sheet.createRow(0);
		Cell cell0 = row.createCell(0); 
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		cell0.setCellValue("Si.No.");
		cell1.setCellValue("Student Name");
		cell2.setCellValue("USN");
		String names[] = ListNewM.getName();
		String USNs[] = ListNewM.getUsn();
		String subjects[] = ListNewM.getSubs();
		ns = ListNewM.getNoSubs(); 
		n = ListNewM.getN();

		for(i=0;i<ns;i++) {
			Cell cellsub = row.createCell(i+3);
			cellsub.setCellValue(subjects[i]);
		}

		for(i=0;i<n;i++) {
			row = sheet.createRow(i+1);
			for(j=0;j<3;j++) {
				Cell cell = row.createCell(j);
				if(cell.getColumnIndex()==0)
					cell.setCellValue(i+1);
				else if(cell.getColumnIndex()==1)
					cell.setCellValue(names[i]);
				else if(cell.getColumnIndex()==2)
					cell.setCellValue(USNs[i]);
			}
		}
		JFileChooser sf = new JFileChooser();
		sf.setDialogTitle("save as");
		sf.setSelectedFile(new File(".xlsx"));
		if(sf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File output = sf.getSelectedFile();
			Loc = output.getPath();
			try(FileOutputStream out = new FileOutputStream(output)){
				book.write(out);
				out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		MarksFrame2.main(null, Loc);
	}

	public static void readData() {

		int i,j,nr,nc,ncv;
		nc=0;
		String Headings[] = new String[50];

		JFileChooser Sf = new JFileChooser();
		Sf.setDialogTitle("save as");
		Sf.setSelectedFile(new File(".xlsx"));
		if(Sf.showOpenDialog(null)   == JFileChooser.APPROVE_OPTION) {
			input = Sf.getSelectedFile();
			Loc = input.getPath();
			try(FileInputStream in = new FileInputStream(input)) {

				inbook = new XSSFWorkbook(in);
				XSSFSheet sheet = inbook.getSheetAt(0);
				nr=sheet.getPhysicalNumberOfRows();
				XSSFRow row = sheet.getRow(0);
				ncv= row.getPhysicalNumberOfCells();
				Iterator<Cell> cellIt = row.iterator();

				while(cellIt.hasNext()) {
					cells = cellIt.next();
					Headings[nc] = cells.toString();
					nc++;

				}
				String[][] details = new String[50][50];
				for(i=1;i<nr;i++) {
					XSSFRow rows = sheet.getRow(i);
					for(j=0;j<ncv;j++) {
						Cell cell = rows.getCell(j);
						details[i][j] = cell.toString();
					}
				}
				//			}
				inbook.close();
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		MarksFrame2.main(null, Loc);
	}
	public static String[] getHeadings() {
		return Headings;
	}
	public static String[][] getDetails() {
		return details;
	}

}



