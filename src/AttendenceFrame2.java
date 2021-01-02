import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AttendenceFrame2 {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	private JTextField textFieldPercentage;
	private JTextField textFieldDate;
	public static int r,c,i,j ;
	String Loc;
	String[][] detail = new String[50][50];
	String[][] updates = new String[50][50];

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

		String[][] detail = FileAtt.getDetails();
		String[] percent = FileAtt.getpercent();
		r = FileAtt.nr;
		c = FileAtt.nc;
		i = 1;
		j=3;
		updates = detail;

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
		textFieldStuName.setText(detail[1][1]);

		textFieldUsn = new JTextField();
		textFieldUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUsn.setBounds(352, 95, 218, 32);
		frame.getContentPane().add(textFieldUsn);
		textFieldUsn.setColumns(10);
		textFieldUsn.setText(detail[1][2]);

		textFieldDate = new JTextField();
		textFieldDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt2) {
				if(evt2.getKeyCode() == KeyEvent.VK_ENTER) {
					updates[0][j] = textFieldDate.getText();
					i=1;
					textFieldStuName.setText(detail[i][1]);
					textFieldUsn.setText(detail[i][2]);
				}
			}
		});
		textFieldDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldDate.setBounds(80, 140, 260, 32);
		frame.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		textFieldDate.setText(detail[0][3]);

		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStudentName.setBounds(12, 61, 184, 32);
		frame.getContentPane().add(lblStudentName);

		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsn.setBounds(352, 67, 125, 25);
		frame.getContentPane().add(lblUsn);

		textFieldPercentage = new JTextField();
		textFieldPercentage.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldPercentage.setBounds(10, 251, 207, 32);
		frame.getContentPane().add(textFieldPercentage);
		textFieldPercentage.setColumns(10);

		JButton btnPercentage = new JButton("Percentage");
		btnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPercentage.setText(percent[i]);
			}
		});
		btnPercentage.setBounds(225, 255, 115, 25);
		frame.getContentPane().add(btnPercentage);

		JButton btnPresent = new JButton("Present");
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldStuName.setText(detail[i][1]);
				textFieldUsn.setText(detail[i][2]);
				textFieldDate.setText(detail[0][j]);
				updates[i][j] = "1.0";
				i++;
				if(i>=r) {
					j++;
					i=1;

					if(j>=c) {
						textFieldStuName.setText("done");
						textFieldUsn.setText("done");
						textFieldDate.setText("done");
					}
				}
			}
		});
		btnPresent.setBounds(10, 198, 97, 25);
		frame.getContentPane().add(btnPresent);

		JButton btnAbsent = new JButton("Absent");
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldStuName.setText(detail[i][1]);
				textFieldUsn.setText(detail[i][2]);
				textFieldDate.setText(detail[0][j]);
				updates[i][j] = "0.0";
				i++;
				if(i>=r) {
					j++;
					i=1;

					if(j>=c) {
						textFieldStuName.setText("done");
						textFieldUsn.setText("done");
						textFieldDate.setText("done");
					}
				}
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
		btnNextStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileAtt.writeData(updates, Loc);
				JOptionPane.showMessageDialog(null,Loc+ " is created");
			}
		});
		btnNextStu.setBounds(364, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(10, 140, 70, 32);
		frame.getContentPane().add(lblDate);

		JButton btnAddDate = new JButton("Add Date");
		btnAddDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(j==c) {
					textFieldDate.setText(null);
					textFieldStuName.setText(null);
					textFieldUsn.setText(null);
					textFieldDate.requestFocus();
					c++;

				}
			}
		});
		btnAddDate.setBounds(10, 303, 97, 25);
		frame.getContentPane().add(btnAddDate);

		JButton btnNextDate = new JButton("Next Date");
		btnNextDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j++;
				i=1;
				textFieldStuName.setText(detail[i][1]);
				textFieldUsn.setText(detail[i][2]);
				textFieldDate.setText(detail[0][j]);
				if(j == c ) {
					textFieldStuName.setText("done");
					textFieldUsn.setText("done");
					textFieldDate.setText("done");
				}
			}
		});
		btnNextDate.setBounds(122, 303, 97, 25);
		frame.getContentPane().add(btnNextDate);

	}
}
