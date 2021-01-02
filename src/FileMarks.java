import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileMarks {
	public static String[][] details = new String[50][50];
	public static String[] percentages = new String[50];
	public static File output;
	public static File  input;
	public static File update;
	public static String Loc;
	public static XSSFWorkbook inbook;
	public static Cell cells;
	public static XSSFWorkbook upbook;
	public static int i,j,nr,nc,np,pcount;

	public static void main(String[] args) {
		makeData();
	}

	@SuppressWarnings("resource")
	public static void makeData() {

		XSSFWorkbook inbook = new XSSFWorkbook();
		XSSFSheet sheet = inbook.createSheet("Sheet1");
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

		ns = ListNewM.getNoSubs()+3; 

		for(i=0;i<n;i++) {
			row = sheet.createRow(i+1);
			for(j=0;j<ns;j++) {
				Cell cell = row.createCell(j);
				if(cell.getColumnIndex()==0)
					cell.setCellValue(i+1);
				else if(cell.getColumnIndex()==1)
					cell.setCellValue(names[i]);
				else if(cell.getColumnIndex()==2)
					cell.setCellValue(USNs[i]);
				else if(cell.getColumnIndex()>=3)
					cell.setCellValue("0.0");
			}
		}
		JFileChooser sf = new JFileChooser();
		sf.setDialogTitle("Save as");
		sf.setSelectedFile(new File(".xlsx"));
		if(sf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File output = sf.getSelectedFile();
			Loc = output.getPath();
			try(FileOutputStream out = new FileOutputStream(output)){
				inbook.write(out);
				out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileMarks.readData();
	}

	public static void readData() {


		JFileChooser Sf = new JFileChooser();
		Sf.setDialogTitle("Select File");
		Sf.setSelectedFile(new File(".xlsx"));
		if(Sf.showOpenDialog(null)   == JFileChooser.APPROVE_OPTION) {
			input = Sf.getSelectedFile();
			Loc = input.getPath();
			readMyFiles.main(null, Loc);
			details = readMyFiles.fdetails;
			nr = readMyFiles.nr;
			nc = readMyFiles.ncv;
		}
		MarksFrame2.main(null, Loc);
	}

	public static void writeData(String[][] updates,String upLoc) {

		upbook = new XSSFWorkbook();
		XSSFSheet sheet = upbook.createSheet("Sheet1");
		XSSFRow wrow;
		int i,j,nr,nc;
		nr = MarksFrame2.r;
		nc = MarksFrame2.c;


		for(i=0;i<nr;i++) {
			wrow = sheet.createRow(i);
			for(j=0;j<nc;j++) {
				Cell wcell = wrow.createCell(j);
				wcell.setCellValue(updates[i][j]);
			}
		}

		update = new File(upLoc);
		try(FileOutputStream up = new FileOutputStream(update)){
			upbook.write(up);
			up.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] getpercentages() {
		return percentages;
	}
	public static String[][] getDetails() {
		return details;
	}
	public static int getnr() {
		return nr;
	}
	public static int getnc() {
		return nc;
	}

}



