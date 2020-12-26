import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class List {

	private JFrame frame;
	private JTextField FileNameTextField;
	String Loc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List(st);
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
	public List(String s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String s) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FrontFrame.main(null);
			}
		});
		btnHome.setBounds(335, 228, 97, 25);
		frame.getContentPane().add(btnHome);
		
		JLabel lblLabel = new JLabel("Select the File");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(0, 0, 300, 32);
		frame.getContentPane().add(lblLabel);
		
		FileNameTextField = new JTextField();
		FileNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FileNameTextField.setBounds(10, 80, 350, 32);
		frame.getContentPane().add(FileNameTextField);
		FileNameTextField.setColumns(10);
		FileNameTextField.setText("Select a File");
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JFileChooser fs = new JFileChooser(new File("f:\\"));
				fs.setDialogTitle("Select file");
				fs.setFileFilter(new FileTypeFilter(".dir", "Folder"));
				fs.setFileFilter(new FileTypeFilter(".txt", "Text"));
				fs.setFileFilter(new FileTypeFilter(".xlsx", "Excel"));
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File fi = fs.getSelectedFile();
					Loc = fi.getPath();
					FileNameTextField.setText(Loc);
					
				}	
			}
		});
		btnBrowse.setBounds(264, 115, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			List.GoTo(s);
				
			}
		});
		btnBack.setBounds(234, 228, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(FileNameTextField.getText() == null) {
					JOptionPane.showMessageDialog(null, "Select a File");
				}
				else {
					frame.dispose();
					List.GoTo(s,Loc);
				}
					
			}

		});
		btnSelect.setBounds(90, 115, 97, 25);
		frame.getContentPane().add(btnSelect);	
			
	}
	private static void GoTo(String s) {
		if(s=="Att")
			FileFrame.main(null,s);
		else if(s=="Marks")
			FileFrame.main(null,s);
		else if(s=="Exam")
			FileFrame.main(null,s);
		else if(s=="E-Mail")
			FileFrame.main(null,s);
		
	}
	private static void GoTo(String s,String Loc) {
		if(s=="Att")
			AttendenceFrame2.main(null,Loc);
		else if(s=="Marks")
			MarksFrame2.main(null,Loc);
		else if(s=="Exam")
			ExamFrame2.main(null,Loc);
		else if(s=="E-Mail")
			EmailFrame2.main(null,Loc);
		
	}
}
