import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListNewM {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	String Loc;
	int i=0;
	static int n=0;
	static int subs=0;
	static String name[] = new String[50];
	static String USN[] = new String[50];
	static String subjects[] = new String[50];

	private JTextField textFieldSubjects;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListNewM window = new ListNewM(st);
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
	public ListNewM(String s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String s) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(240, 240, 240));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);



		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FrontFrame.main(null);
			}
		});
		btnHome.setBounds(485, 378, 97, 25);
		frame.getContentPane().add(btnHome);

		JLabel lblLabel = new JLabel("New List");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 300, 32);
		frame.getContentPane().add(lblLabel);

		textFieldStuName = new JTextField();
		textFieldStuName.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldStuName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt1) {
				if(evt1.getKeyCode() == KeyEvent.VK_TAB || evt1.getKeyCode() == KeyEvent.VK_ENTER) {
					name[i] = textFieldStuName.getText();
					textFieldUsn.requestFocus();
				}
			}

		});
		textFieldStuName.setBounds(12, 123, 345, 32);
		frame.getContentPane().add(textFieldStuName);
		textFieldStuName.setColumns(10);

		textFieldUsn = new JTextField();
		textFieldUsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldUsn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt2) {
				if(evt2.getKeyCode() == KeyEvent.VK_ENTER) {
					USN[i] = textFieldUsn.getText();
					i++;
					n++;
					textFieldStuName.setText(null);	
					textFieldUsn.setText(null);
					textFieldStuName.requestFocus();

				}
			}
		});
		textFieldUsn.setBounds(369, 123, 201, 32);
		frame.getContentPane().add(textFieldUsn);
		textFieldUsn.setColumns(10);

		JLabel lblNewLabel = new JLabel("Student name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 61, 184, 32);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(369, 61, 125, 25);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel File = new JLabel("New label");
		File.setFont(new Font("Tahoma", Font.BOLD, 12));
		File.setBounds(320, 10, 250, 32);
		frame.getContentPane().add(File);
		File.setText(Loc);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileFrame.main(null, s);
			}
		});
		btnBack.setBounds(385, 378, 97, 25);
		frame.getContentPane().add(btnBack);



		JButton btnNext = new JButton("Create");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
				FileMarks.makeData();

			}
		});
		btnNext.setBounds(12, 365, 97, 25);
		frame.getContentPane().add(btnNext);

		JLabel lblSubject = new JLabel("Subjects");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubject.setBounds(10, 168, 125, 32);
		frame.getContentPane().add(lblSubject);

		textFieldSubjects = new JTextField();
		textFieldSubjects.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt3) {
				if(evt3.getKeyCode() == KeyEvent.VK_ENTER) {
					subjects[subs] = textFieldSubjects.getText();
					subs++;
					textFieldSubjects.setText(null);	
					textFieldSubjects.requestFocus();
				}}
		});
		textFieldSubjects.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSubjects.setColumns(10);
		textFieldSubjects.setBounds(10, 203, 250, 32);
		frame.getContentPane().add(textFieldSubjects);
	}
	public static String[] getName() {
		return name;
	}
	public static String[] getUsn() {
		return USN;
	}
	public static String[] getSubs() {
		return subjects;
	}
	public static int getN() {
		return n;
	}
	public static int getNoSubs() {
		return subs;
	}
	
}
