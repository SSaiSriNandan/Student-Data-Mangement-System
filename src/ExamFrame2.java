
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ExamFrame2 {

	private JFrame frame;
	private JTextField TextFieldAttListName;
	private JTextField TextFieldMarkListName;
	String Loc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamFrame2 window = new ExamFrame2(st);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExamFrame2(String s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String s) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FrontFrame.main(null);
			}
		});
		btnHome.setBounds(473, 365, 97, 25);
		frame.getContentPane().add(btnHome);
		
		JLabel lblLabel = new JLabel("Exam Qualification");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 300, 32);
		frame.getContentPane().add(lblLabel);
		
		TextFieldAttListName = new JTextField();
		TextFieldAttListName.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextFieldAttListName.setBounds(12, 123, 345, 32);
		frame.getContentPane().add(TextFieldAttListName);
		TextFieldAttListName.setColumns(10);
		
		JLabel lblAttList = new JLabel("Attendance List");
		lblAttList.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAttList.setBounds(12, 61, 200, 32);
		frame.getContentPane().add(lblAttList);
		
		Loc = s;
		
		JLabel File = new JLabel("New label");
		File.setFont(new Font("Tahoma", Font.BOLD, 12));
		File.setBounds(320, 10, 250, 32);
		frame.getContentPane().add(File);
		File.setText(Loc);
		
		JButton btnBrowseA = new JButton("Browse");
		btnBrowseA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fs = new JFileChooser(new File("f:\\"));
				fs.setDialogTitle("Select Attendance file");
				fs.setFileFilter(new FileTypeFilter(".dir", "Folder"));
				fs.setFileFilter(new FileTypeFilter(".txt", "Text"));
				fs.setFileFilter(new FileTypeFilter(".xlsx", "Excel"));
				int result = fs.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File fi = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(fi.getPath());
						fw.flush();
						fw.close();
						Loc = fi.getPath();
						TextFieldAttListName.setText(Loc);
					}catch(Exception e3) {
						JOptionPane.showMessageDialog(null, e3.getMessage());
					}
				}	
			}
		});
		btnBrowseA.setBounds(260, 170, 97, 25);
		frame.getContentPane().add(btnBrowseA);
		
	
		JLabel IblMarkList = new JLabel("Marks List");
		IblMarkList.setFont(new Font("Tahoma", Font.BOLD, 24));
		IblMarkList.setBounds(10, 203, 184, 32);
		frame.getContentPane().add(IblMarkList);
		
		TextFieldMarkListName = new JTextField();
		TextFieldMarkListName.setFont(new Font("Tahoma", Font.BOLD, 20));
		TextFieldMarkListName.setBounds(12, 253, 345, 32);
		frame.getContentPane().add(TextFieldMarkListName);
		TextFieldMarkListName.setColumns(10);
		
		JButton btnBrowseB = new JButton("Browse");
		btnBrowseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JFileChooser fs = new JFileChooser(new File("f:\\"));
				fs.setDialogTitle("Select Marks file");
				fs.setFileFilter(new FileTypeFilter(".dir", "Folder"));
				fs.setFileFilter(new FileTypeFilter(".txt", "Text"));
				fs.setFileFilter(new FileTypeFilter(".xlsx", "Excel"));
				int result = fs.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File fi = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(fi.getPath());
						fw.flush();
						fw.close();
						Loc = fi.getPath();
						TextFieldAttListName.setText(Loc);
					}catch(Exception e3) {
						JOptionPane.showMessageDialog(null, e3.getMessage());
					}
				}	
			}
		});
		btnBrowseB.setBounds(260, 300, 97, 25);
		frame.getContentPane().add(btnBrowseB);
		
		JButton btnNextStu = new JButton("Next");
		btnNextStu.setBounds(369, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);
	}

}
