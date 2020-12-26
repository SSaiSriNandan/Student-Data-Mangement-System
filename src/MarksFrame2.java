
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MarksFrame2 {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	String Loc;
	private JTextField textFieldSubject;
	private JTextField textFieldMarks;
	int i = 1 ;
	int j = 1 ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarksFrame2 window = new MarksFrame2(st);
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
	public MarksFrame2(String s) {
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
		
//		String[] headings = FileAtt.getHeadings();
		String[][] details = FileAtt.getDetails();
//		int nc = headings.length;
//		int nr = details[0].length + 1;
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FrontFrame.main(null);
			}
		});
		btnHome.setBounds(473, 365, 97, 25);
		frame.getContentPane().add(btnHome);
		
		JLabel lblLabel = new JLabel("Marks List");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 300, 32);
		frame.getContentPane().add(lblLabel);
		
		textFieldStuName = new JTextField();
		textFieldStuName.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldStuName.setBounds(12, 123, 345, 32);
		frame.getContentPane().add(textFieldStuName);
		textFieldStuName.setColumns(10);
		textFieldStuName.setText(details[0][1]);
		
		textFieldUsn = new JTextField();
		textFieldUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUsn.setBounds(369, 123, 201, 32);
		frame.getContentPane().add(textFieldUsn);
		textFieldUsn.setColumns(10);
		textFieldUsn.setText(details[0][2]);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(10, 215, 250, 32);
		frame.getContentPane().add(textFieldSubject);
		textFieldSubject.setColumns(10);
		textFieldSubject.setText(details[0][3]);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStudentName.setBounds(12, 61, 184, 32);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsn.setBounds(369, 61, 125, 25);
		frame.getContentPane().add(lblUsn);
		
		Loc = s;
		
		JLabel File = new JLabel("New label");
		File.setFont(new Font("Tahoma", Font.BOLD, 12));
		File.setBounds(320, 10, 250, 32);
		frame.getContentPane().add(File);
		File.setText(Loc);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubject.setBounds(10, 175, 200, 32);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMarks.setBounds(285, 175, 149, 32);
		frame.getContentPane().add(lblMarks);
		
		textFieldMarks = new JTextField();
		textFieldMarks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt1) {
				if(evt1.getKeyCode() == KeyEvent.VK_ENTER) {
				textFieldStuName.setText(details[i][1]);
				textFieldUsn.setText(details[i][2]);
				textFieldSubject.setText(details[0][j]);
				i++;
				}
			}
		});
		textFieldMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldMarks.setBounds(285, 215, 230, 32);
		frame.getContentPane().add(textFieldMarks);
		textFieldMarks.setColumns(10);
		
		JButton btnNextStu = new JButton("Next");
		btnNextStu.setBounds(369, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);
		
		JButton btnSubWise = new JButton("Subject Wise");
		btnSubWise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j++;
				textFieldSubject.setText(details[0][j]);
			}
		});
		btnSubWise.setBounds(12, 272, 125, 25);
		frame.getContentPane().add(btnSubWise);
		
		JButton btnStuWise = new JButton("Studend wise");
		btnStuWise.setBounds(137, 272, 123, 25);
		frame.getContentPane().add(btnStuWise);
		
	}
}
