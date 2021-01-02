import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MarksFrame2 {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	public static JTextField textFieldSubject;
	public static JTextField textFieldMarks;
	public static int r,c,i,j ;
	public String[][] details = new String[50][50];
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
					MarksFrame2 window = new MarksFrame2(st);
					window .frame.setVisible(true);
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

		String[][] detail = FileMarks.getDetails();
		//		String[] percent = FileMarks.getpercent();
		r = FileMarks.nr;
		c = FileMarks.nc;
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

		JLabel lblLabel = new JLabel("Marks List2");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 300, 32);
		frame.getContentPane().add(lblLabel);

		textFieldStuName = new JTextField();
		textFieldStuName.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldStuName.setBounds(12, 123, 345, 32);
		frame.getContentPane().add(textFieldStuName);
		textFieldStuName.setColumns(10);
		textFieldStuName.setText(detail[1][1]);

		textFieldUsn = new JTextField();
		textFieldUsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldUsn.setBounds(369, 123, 201, 32);
		frame.getContentPane().add(textFieldUsn);
		textFieldUsn.setColumns(10);
		textFieldUsn.setText(detail[1][2]);

		textFieldSubject = new JTextField();
		textFieldSubject.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt2) {
				if(evt2.getKeyCode() == KeyEvent.VK_ENTER) {
					//					if(j == c) {
					updates[0][j] = textFieldSubject.getText();
					i=1;
					textFieldStuName.setText(detail[i][1]);
					textFieldUsn.setText(detail[i][2]);
					textFieldMarks.requestFocus();
					//					}
				}
			}
		});
		textFieldSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldSubject.setBounds(10, 215, 250, 32);
		frame.getContentPane().add(textFieldSubject);
		textFieldSubject.setColumns(10);
		textFieldSubject.setText(detail[0][3]);

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
					textFieldStuName.setText(detail[i][1]);
					textFieldUsn.setText(detail[i][2]);
					textFieldSubject.setText(detail[0][j]);
					updates[i][j] = textFieldMarks.getText();
					textFieldMarks.setText(null);
					i++;
				}
				if(i>=r) {
					j++;
					i=1;

					if(j >= c ) {
						textFieldStuName.setText("done");
						textFieldUsn.setText("done");
						textFieldSubject.setText("done");
					}}
			}
		});
		textFieldMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldMarks.setBounds(285, 215, 230, 32);
		frame.getContentPane().add(textFieldMarks);
		textFieldMarks.setColumns(10);

		JButton btnNextStu = new JButton("Next");
		btnNextStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileMarks.writeData(updates, Loc);
				JOptionPane.showMessageDialog(null,Loc+ " is created");
			}
		});
		btnNextStu.setBounds(369, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);

		JButton btnAddSub = new JButton("Add Subject");
		btnAddSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(j==c) {
					textFieldSubject.setText(null);
					textFieldStuName.setText(null);
					textFieldUsn.setText(null);
					textFieldSubject.requestFocus();
					c++;

				}
			}
		});
		btnAddSub.setBounds(10, 268, 115, 25);
		frame.getContentPane().add(btnAddSub);

		JButton btnNextSub = new JButton("Next Subject");
		btnNextSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j++;
				i=1;
				textFieldStuName.setText(detail[i][1]);
				textFieldUsn.setText(detail[i][2]);
				textFieldSubject.setText(detail[0][j]);
				updates[i][j] = textFieldMarks.getText();
				textFieldMarks.setText(null);
				textFieldMarks.requestFocus();
				if(j == c ) {
					textFieldStuName.setText("done");
					textFieldUsn.setText("done");
					textFieldSubject.setText("done");
				}
			}
		});
		btnNextSub.setBounds(285, 268, 115, 25);
		frame.getContentPane().add(btnNextSub);

		JButton btnNextStudent = new JButton("Next Student");
		btnNextStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldStuName.setText(detail[i][1]);
				textFieldUsn.setText(detail[i][2]);
				textFieldSubject.setText(detail[0][j]);
				updates[i][j] = textFieldMarks.getText();
				textFieldMarks.setText(null);
				textFieldMarks.requestFocus();
				i++;
				if(i>=r) {
					j++;
					i=1;

					if(j == c ) {
						textFieldStuName.setText("done");
						textFieldUsn.setText("done");
						textFieldSubject.setText("done");
					}}
			}
		});
		btnNextStudent.setBounds(400, 268, 115, 25);
		frame.getContentPane().add(btnNextStudent);

		//		JButton btnSubWise = new JButton("Subject Wise");
		//		btnSubWise.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				j++;
		//				textFieldSubject.setText(details[0][j]);
		//			}
		//		});
		//		btnSubWise.setBounds(12, 272, 125, 25);
		//		frame.getContentPane().add(btnSubWise);
		//		
		//		JButton btnStuWise = new JButton("Studend wise");
		//		btnStuWise.setBounds(137, 272, 123, 25);
		//		frame.getContentPane().add(btnStuWise);

	}
}
