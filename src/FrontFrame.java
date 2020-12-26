       import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontFrame window = new FrontFrame();
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
	public FrontFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(30, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(161, 13, 230, 50);
		lblNewLabel.setHorizontalAlignment(0);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAttendanceList = new JButton("Attendance list");
		btnAttendanceList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "Namaste");
			frame.dispose();
			FileFrame.main(null,"Att");
			}
		});
		btnAttendanceList.setBounds(55, 115, 125, 25);
		frame.getContentPane().add(btnAttendanceList);
		
		JButton btnMarksList = new JButton("Marks list");
		btnMarksList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileFrame.main(null,"Marks");
			}
		});
		btnMarksList.setBounds(175, 115, 125, 25);
		frame.getContentPane().add(btnMarksList);
		
		JButton btnExamQualification = new JButton("Exam Qualification");
		btnExamQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileFrame.main(null,"Exam");
			}
		});
		btnExamQualification.setBounds(295, 115, 145, 25);
		frame.getContentPane().add(btnExamQualification);
		
		JButton btnEMail = new JButton("E-mail");
		btnEMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FileFrame.main(null,"E-Mail");
			}
		});
		btnEMail.setBounds(435, 115, 100, 25);
		frame.getContentPane().add(btnEMail);
		
		JLabel lblNewLabel_1 = new JLabel("Select the required Function that you want to perform");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(55, 58, 480, 32);
		lblNewLabel_1.setHorizontalAlignment(0);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
