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

public class ListNew {

	private JFrame frame;
	private JTextField textFieldStuName;
	private JTextField textFieldUsn;
	String Loc;
	int i=0;
	private JTextField textFieldDates;
	static int n=0;
	static int dats=0;
	public static String name[] = new String[50];
	public static String USN[] = new String[50];
	static String dates[] = new String[50];

	public static void main(String[] args, String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListNew window = new ListNew(st);
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
	public ListNew(String s) {
			initialize(s);
		
	}

	
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
				//JOptionPane.showMessageDialog(null, s);
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
				FileAtt.makeData();
				
			}
		});
		btnNext.setBounds(12, 365, 97, 25);
		frame.getContentPane().add(btnNext);
		
		JLabel lblSubject = new JLabel("Dates");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubject.setBounds(10, 168, 125, 32);
		frame.getContentPane().add(lblSubject);

		textFieldDates = new JTextField();
		textFieldDates.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt3) {
				if(evt3.getKeyCode() == KeyEvent.VK_ENTER) {
					dates[dats] = textFieldDates.getText();
					dats++;
					textFieldDates.setText(null);	
					textFieldDates.requestFocus();
				}}
		});
		textFieldDates.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldDates.setColumns(10);
		textFieldDates.setBounds(10, 203, 250, 32);
		frame.getContentPane().add(textFieldDates);
				
	}
	public static String[] getName() {
		return name;
	}
	public static String[] getUsn() {
		return USN;
	}
	public static int getN() {
		return n;
	}
	public static String[] getDates() {
		return dates;
	}
	public static int getNodates() {
		return dats;
	}
}
