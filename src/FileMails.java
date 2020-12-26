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

public class FileMails {
	private static String[][] details = null;
	private static String[] Headings = null;
	static File output;
	static File  input;
	static String Loc;
	private static XSSFWorkbook inbook;
	private static Cell cells;
	public static void main(String[] args) {
		makeData();
	}

	public static void makeData() {

		//			String path = "F:\\test.xlsx";
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		XSSFRow row;
		int i,j,n;
		row = sheet.createRow(0);
		Cell cell0 = row.createCell(0); 
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		Cell cell3 = row.createCell(3);
		cell0.setCellValue("Si.No.");
		cell1.setCellValue("Student Name");
		cell2.setCellValue("USN");
		cell3.setCellValue("E-mail");
		String names[] = ListNewE.getName();
		String USNs[] = ListNewE.getUsn();
		String Mails[] = ListNewE.getMail(); 
		n = ListNewE.getN();
		
		

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
				else if(cell.getColumnIndex()==3)
					cell.setCellValue(Mails[i]);
				
			}
		}
		//			try {
		//				FileOutputStream out = new FileOutputStream("data.xlsx");
		//				book.write(out);
		//				out.close();
		//				System.out.println("done");
		//			} catch (FileNotFoundException e) {
		//				e.printStackTrace();
		//				System.out.println("no");
		//			} catch (IOException e) {
		//				e.printStackTrace();
		//				System.out.println("no");
		//
		//			}
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
		EmailFrame2.main(null, Loc);
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
//			Iterator<Row> rowIt = sheet.iterator();
//			
//			while(rowIt.hasNext()) {
//				Row row = rowIt.next();
				XSSFRow row = sheet.getRow(0);
				ncv= row.getPhysicalNumberOfCells();
				Iterator<Cell> cellIt = row.iterator();
				
				while(cellIt.hasNext()) {
					cells = cellIt.next();
					Headings[nc] = cells.toString();
					nc++;
					System.out.println(cells.toString()+";");
					
				}
//				System.out.println(nc);
				System.out.println(ncv);
				System.out.println(nr);
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
		EmailFrame2.main(null, Loc);
	}
	public static String[] getHeadings() {
		return Headings;
	}
	public static String[][] getDetails() {
		return details;
	}
}



