import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileFrame window = new FileFrame(s);
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
	public FileFrame(String st) {
		initialize(st);
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
		btnHome.setBounds(323, 218, 97, 25);
		frame.getContentPane().add(btnHome);
		
		JLabel lblLabel = new JLabel("Attendance List");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 422, 32);
		frame.getContentPane().add(lblLabel);
		if(s == "Att")
			lblLabel.setText("Attendance List");
		else if(s == "Marks")
			lblLabel.setText("Marks List");
		else if(s == "Exam")
			lblLabel.setText("Exam Qualification List");
		else if(s == "E-Mail")
			lblLabel.setText("Email List");
		
		JButton btnExistFile = new JButton("Existing File");
		btnExistFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if(s=="Att") 
					FileAtt.readData();
				else if(s=="Marks")
					FileMarks.readData();
				else if(s=="Exam")
					FileAtt.readData();
				else if(s=="E-Mail")
					FileMails.readData();
			}
		});
		btnExistFile.setBounds(148, 141, 115, 25);
		frame.getContentPane().add(btnExistFile);
		
		JButton btnNewFile = new JButton("New File");
		btnNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
//				NewList.main(null, s);
				if(s=="Att") 
					ListNew.main(null,s);
				else if(s=="Marks")
					ListNewM.main(null,s);
				else if(s=="Exam")
					ListNew.main(null,s);
				else if(s=="E-Mail")
					ListNewE.main(null,s);
			}
		});
		btnNewFile.setBounds(45, 141, 97, 25);
		frame.getContentPane().add(btnNewFile);
		
		JLabel lblNewLabel = new JLabel("Select file");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(12, 94, 150, 30);
		frame.getContentPane().add(lblNewLabel);
	}

}
