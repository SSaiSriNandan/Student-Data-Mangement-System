import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileExam {


	public static String[] percentages = new String[50];
	public static String[] percentage = new String[50];
	public static String[][] mpercentage = new String[50][50];
	public static String[][] mpercentages = new String[50][50];
	public static String[][] egets = new String[50][50];
	public static String[][] eget = new String[50][50];
	public static int ar,ac,ai,aj,anp,mr,mc,mi,mj,er,ec,ei,ej,pcount;
	private static XSSFWorkbook newbook;
	private static File update;
	private static XSSFWorkbook samebook;
	private static File sameupdate;


	public static void main(String[] arg,String Aloc,String Mloc, String s ) {

		readMyFiles.main(null, Aloc);
		String[][] agets;
		ar = readMyFiles.nr;
		ac = readMyFiles.ncv;
		agets = readMyFiles.fdetails;
		anp = ac-3; 

		for(ai=1;ai<ar;ai++) {
			pcount = 0;
			for(aj=3;aj<ac;aj++) {
				if(Double.valueOf(agets[ai][aj]) == 1 )
					pcount++;
			}
			if(anp>0)
				percentage[ai] = String.valueOf(100*pcount/anp) ; 
			percentages[ai] =percentage[ai]+"%";
		}

		//		---------------------------------------------------------------------------------------------

		readMyFiles.main(null, Mloc);
		String[][] mgets;
		mr = readMyFiles.nr;
		mc = readMyFiles.ncv;
		mgets = readMyFiles.fdetails;
		mpercentage = mgets;

		for(mi=1;mi<mr;mi++) {
			for(mj=3;mj<mc;mj++) {
				double per = Double.valueOf(mgets[mi][mj]);
				mpercentage[mi][mj] = String.valueOf(per);
				mpercentages[mi][mj] = mpercentage[mi][mj]+"%";
			}
		}

		//		---------------------------------------------------------------------------------------------

		String[][] egets = new String[50][50];
		er = ar;
		ec = ac;

		for(ei=0;ei<er;ei++) {
			for(ej=0;ej<mc;ej++) {
				String a,m;
				a = String.valueOf(agets[ei][ej]);
				m = String.valueOf(mgets[ei][ej]);
				if( a == m) {
					egets[ei][ej] = a;
				}
				else {
					System.out.println(agets[0][ej] +"at"+"["+(ei+1)+","+(ej+1)+"]"+" Doesn't Match");
				}

			}
		}

		for(ei=0;ei<er;ei++) {
			for(ej=0;ej<mc;ej++) {
				String m;
				double mp,ap;
				m = String.valueOf(mgets[ei][ej]);
				if(ei==0 ) 
					egets[ei][ej] = m;
				else if (ej<3) 
					egets[ei][ej] = m;
				else {
					mp = Double.valueOf(mpercentage[ei][ej]);
					ap = Double.valueOf(percentage[ei]);
					if(ap>=75) {
						if(mp>=40) 
							egets[ei][ej] = "Qualified";
						else
							egets[ei][ej] = "Failed";
					}
					else {
						if(mp>=40) 
							egets[ei][ej] = "Low attandance";
						else
							egets[ei][ej] = "Not-Qualified ";
					}
				}
//				System.out.println("["+ei+"]["+ej+"]"+egets[ei][ej]);
				eget[ei][ej] = egets[ei][ej];
			}
		}

		//		---------------------------------------------------------------------------------------------
		if(s == "new") 
			FileExam.writeData(eget);
		else if(s == "same")
			FileExam.makeData(eget);
	}
	public static void writeData(String[][] wupdates) {

		newbook = new XSSFWorkbook();
		XSSFSheet sheet = newbook.createSheet("Sheet1");
		XSSFRow row;
		int wi,wj,wnr,wnc;
		wnr = er;
		wnc = ec;
		//		wupdates = egets;


		for(wi=0;wi<wnr;wi++) {
			row = sheet.createRow(wi);
			for(wj=0;wj<wnc;wj++) {
				Cell cell = row.createCell(wj);
				cell.setCellValue(wupdates[wi][wj]);
			}
		}

		JFileChooser wf = new JFileChooser();
		wf.setDialogTitle("Save as");
		wf.setSelectedFile(new File(".xlsx"));
		if(wf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			update = wf.getSelectedFile();
			//			Loc = output.getPath();
			try(FileOutputStream up = new FileOutputStream(update)){
				newbook.write(up);
				up.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void makeData(String[][] mupdates) {

		samebook = new XSSFWorkbook();
		XSSFSheet samesheet = samebook.createSheet("Sheet1");
		XSSFRow samerow;
		int si,sj,snr,snc;
		snr = er;
		snc = ec;
		//		mupdates = egets;


		for(si=0;si<snr;si++) {
			samerow = samesheet.createRow(si);
			for(sj=0;sj<snc;sj++) {
				Cell cell = samerow.createCell(sj);
				cell.setCellValue(mupdates[si][sj]);
			}
		}

		JFileChooser sf = new JFileChooser();
		sf.setDialogTitle("Select file");
		sf.setSelectedFile(new File(".xlsx"));
		if(sf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			sameupdate = sf.getSelectedFile();
			try(FileOutputStream up = new FileOutputStream(sameupdate)){
				samebook.write(up);
				up.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

