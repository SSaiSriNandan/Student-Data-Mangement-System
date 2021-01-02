import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileMails {
	public static  String[][] details = new String[50][50];
	public static  String[][] updates = new String[50][50];
	public static File output;
	public static File  input;
	public static File update;
	public static String Loc;
	public static XSSFWorkbook inbook;
	public static Cell cells;
	public static XSSFWorkbook upbook;
	public static int i,j,nr,nc,np,pcount;
	private static XSSFRow wrow;
	public static void main(String[] args) {
		readData();
	}

	public static void makeData() {

		inbook = new XSSFWorkbook();
		XSSFSheet sheet = inbook.createSheet("Sheet1");
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
		cell3.setCellValue("E-Mail Adrress");
		String names[] = ListNewE.getName();
		String USNs[] = ListNewE.getUsn();
		String mails[] = ListNewE.getMail();
		n = ListNewE.getN();


		for(i=0;i<n;i++) {
			row = sheet.createRow(i+1);
			for(j=0;j<4;j++) {
				Cell cell = row.createCell(j);
				if(cell.getColumnIndex()==0)
					cell.setCellValue(i+1);
				else if(cell.getColumnIndex()==1)
					cell.setCellValue(names[i]);
				else if(cell.getColumnIndex()==2)
					cell.setCellValue(USNs[i]);
				else if(cell.getColumnIndex()==3)
					cell.setCellValue(mails[i]);
			}
		}
		JFileChooser sf = new JFileChooser();
		sf.setDialogTitle("Save as");
		sf.setSelectedFile(new File(".xlsx"));
		if(sf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			output = sf.getSelectedFile();
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
		FileMails.readData();
	}

	public static void readData() {


		nc=0;

		JFileChooser Sf = new JFileChooser();
		Sf.setDialogTitle("Select file");
		Sf.setSelectedFile(new File(".xlsx"));
		if(Sf.showOpenDialog(null)   == JFileChooser.APPROVE_OPTION) {
			input = Sf.getSelectedFile();
			Loc = input.getPath();
			readMyFiles.main(null, Loc);
			details = readMyFiles.fdetails;
			nr = readMyFiles.nr;
			nc = readMyFiles.ncv;

		}
		EmailFrame2.main(null, Loc);
	}

	public static void writeData() {

		upbook = new XSSFWorkbook();
		XSSFSheet wsheet = upbook.createSheet("Sheet1");
		int i,j,wnr,wnc;
		wnr = SendMail.r;
		wnc = SendMail.c;
		updates = SendMail.updates;
		String upLoc = SendMail.upLoc;


		for(i=0;i<wnr;i++) {
			wrow = wsheet.createRow(i);
			for(j=0;j<wnc;j++) {
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


	public static String[][] getDetails() {
		return details;
	}

}
