
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class AttendenceFrame2 {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	private JTextField textFieldPercentage;
	String Loc;
	private JTextField textFieldDate;
	int i = 1;
	String d1,d2,d3;
	String[][] detail = new String[50][50];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendenceFrame2 window = new AttendenceFrame2(st);
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
	public AttendenceFrame2(String s) {
		
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
		String[][] detail = FileAtt.getDetails();
//		int nc = headings.length;
//		int nr = details[0].length + 1;
		String d1=(detail[0][1]);
		String d2=(detail[0][2]);
		String d3=(detail[0][3]);
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FrontFrame.main(null);
			}
		});
		btnHome.setBounds(473, 365, 97, 25);
		frame.getContentPane().add(btnHome);
		
		JLabel lblLabel = new JLabel("Attendance List");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 230, 32);
		frame.getContentPane().add(lblLabel);
		
		textFieldStuName = new JTextField();
		textFieldStuName.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldStuName.setBounds(12, 95, 328, 32);
		frame.getContentPane().add(textFieldStuName);
		textFieldStuName.setColumns(10);
		textFieldStuName.setText(d1);
		
		textFieldUsn = new JTextField();
		textFieldUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUsn.setBounds(352, 95, 218, 32);
		frame.getContentPane().add(textFieldUsn);
		textFieldUsn.setColumns(10);
		textFieldUsn.setText(d2);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(80, 140, 260, 32);
		frame.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		textFieldDate.setText(d3);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStudentName.setBounds(12, 61, 184, 32);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsn.setBounds(352, 67, 125, 25);
		frame.getContentPane().add(lblUsn);
		
		textFieldPercentage = new JTextField();
		textFieldPercentage.setBounds(10, 251, 207, 32);
		frame.getContentPane().add(textFieldPercentage);
		textFieldPercentage.setColumns(10);
		
		JButton btnPercentage = new JButton("Percentage");
		btnPercentage.setBounds(225, 255, 115, 25);
		frame.getContentPane().add(btnPercentage);
		
		JButton btnPresent = new JButton("Present");
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldStuName.setText(detail[i][2]);
				textFieldUsn.setText(detail[i][3]);
				textFieldDate.setText(detail[i][4]);
				i++;
			}
		});
		btnPresent.setBounds(10, 198, 97, 25);
		frame.getContentPane().add(btnPresent);
		
		JButton btnAbsent = new JButton("Absent");
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldStuName.setText(detail[i][2]);
				textFieldUsn.setText(detail[i][3]);
				textFieldDate.setText(detail[i][4]);
				i++;
			}
		});
		btnAbsent.setBounds(122, 198, 97, 25);
		frame.getContentPane().add(btnAbsent);
		
		Loc = s;
		
		JLabel File = new JLabel("New label");
		File.setFont(new Font("Tahoma", Font.BOLD, 12));
		File.setBounds(320, 10, 250, 32);
		frame.getContentPane().add(File);
		File.setText(Loc);
		
		JButton btnNextStu = new JButton("Next");
		btnNextStu.setBounds(364, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(10, 140, 70, 32);
		frame.getContentPane().add(lblDate);
		
	}
}
