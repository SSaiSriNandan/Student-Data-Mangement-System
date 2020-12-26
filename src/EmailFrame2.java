
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailFrame2 {

	private JFrame frame;
	String Loc;
	private JTextField textFieldAttachments;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String st) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailFrame2 window = new EmailFrame2(st);
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
	public EmailFrame2(String s) {
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
		
//		String[] headings = FileMails.getHeadings();
//		String[][] details = FileMails.getDetails();
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
		
		JLabel lblLabel = new JLabel("E-mail");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLabel.setBounds(10, 10, 300, 32);
		frame.getContentPane().add(lblLabel);
		
		JLabel lblMessage = new JLabel("Mail Body");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMessage.setBounds(12, 61, 184, 32);
		frame.getContentPane().add(lblMessage);
		
		Loc = s;
		
		JLabel File = new JLabel("New label");
		File.setFont(new Font("Tahoma", Font.BOLD, 12));
		File.setBounds(320, 10, 250, 32);
		frame.getContentPane().add(File);
		File.setText(Loc);
		
		JButton btnNextStu = new JButton("Next");
		btnNextStu.setBounds(369, 365, 97, 25);
		frame.getContentPane().add(btnNextStu);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBounds(12, 116, 560, 150);
		frame.getContentPane().add(textArea);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fs = new JFileChooser(new File("f:\\"));
				fs.setDialogTitle("Select Attachments file");
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
						textFieldAttachments.setText(Loc);
					}catch(Exception e3) {
						JOptionPane.showMessageDialog(null, e3.getMessage());
					}
				}	
			}
		});
		btnBrowse.setBounds(392, 283, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		textFieldAttachments = new JTextField();
		textFieldAttachments.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAttachments.setText("Attachments");
		textFieldAttachments.setBounds(10, 279, 379, 32);
		frame.getContentPane().add(textFieldAttachments);
		textFieldAttachments.setColumns(10);
	}
}
