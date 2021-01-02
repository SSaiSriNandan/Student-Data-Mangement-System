import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileAtt {
	public static  String[][] details = new String[50][50];
	public static String[] percentages = new String[50];
	public static String[] percentage = new String[50];
	public static File output;
	public static File  input;
	public static File update;
	public static String Loc;
	public static XSSFWorkbook inbook;
	public static Cell cells;
	public static XSSFWorkbook book;
	public static int i,j,nr,nc,np,pcount;
	public static void main(String[] args) {
		readData();
	}

	public static void makeData() {

		book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		XSSFRow row;
		int i,j,n,ns,nd;
		row = sheet.createRow(0);
		Cell cell0 = row.createCell(0); 
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		cell0.setCellValue("Si.No.");
		cell1.setCellValue("Student Name");
		cell2.setCellValue("USN");
		String names[] = ListNew.getName();
		String USNs[] = ListNew.getUsn();
		String dates[] = ListNew.getDates();
		ns = ListNew.getNodates(); 
		n = ListNew.getN();

		for(i=0;i<ns;i++) {
			Cell cellsub = row.createCell(i+3);
			cellsub.setCellValue(dates[i]);
		}
		n = ListNew.getN();
		nd = ListNew.getNodates()+3;

		for(i=0;i<n;i++) {
			row = sheet.createRow(i+1);
			for(j=0;j<nd;j++) {
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
			output = sf.getSelectedFile();
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
		FileAtt.readData();
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
			np = nc - 3;
			for(i=1;i<nr;i++) {
				pcount = 0;
				for(j=3;j<nc;j++) {
					if(Double.valueOf(details[i][j]) == 1 )
						pcount++;
				}
				if(np>0)
					percentage[i] = String.valueOf(100*pcount/np) ; 
				percentages[i] =percentage[i]+"%";
			}

		}
		AttendenceFrame2.main(null, Loc);
	}

	public static void writeData(String[][] updates,String upLoc) {

		book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		XSSFRow row;
		int i,j,wnr,wnc;
		wnr = AttendenceFrame2.r;
		wnc = AttendenceFrame2.c;


		for(i=0;i<wnr;i++) {
			row = sheet.createRow(i);
			for(j=0;j<wnc;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(updates[i][j]);
			}
		}

		update = new File(upLoc);
		try(FileOutputStream up = new FileOutputStream(update)){
			book.write(up);
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
	public static String[] getpercent() {
		return percentages;
	}

}
