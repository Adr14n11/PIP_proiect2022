package gui_CTP;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tramvaie PESA - IASI");
		frame.getContentPane().setBackground(new Color(0, 165, 80));
		frame.setBounds(100, 100, 675, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrAlegeZonaPreferata = new JTextArea();
		txtrAlegeZonaPreferata.setForeground(Color.WHITE);
		txtrAlegeZonaPreferata.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtrAlegeZonaPreferata.setEditable(false);
		txtrAlegeZonaPreferata.setBackground(new Color(0, 165, 80));
		txtrAlegeZonaPreferata.setText("Alege zona cea mai apropiata de locatia ta!");
		txtrAlegeZonaPreferata.setBounds(158, 50, 409, 30);
		frame.getContentPane().add(txtrAlegeZonaPreferata);
//RadioButtons		
		JRadioButton rdbtn1 = new JRadioButton("zona 1");
		rdbtn1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		rdbtn1.setBounds(49, 134, 103, 21);
		frame.getContentPane().add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("zona 2");
		rdbtn2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn2.setBounds(202, 134, 103, 21);
		frame.getContentPane().add(rdbtn2);
		
		JRadioButton rdbtn3 = new JRadioButton("New radio button");
		rdbtn3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn3.setBounds(356, 134, 103, 21);
		frame.getContentPane().add(rdbtn3);
		
		JRadioButton rdbtn4 = new JRadioButton("New radio button");
		rdbtn4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn4.setBounds(512, 134, 103, 21);
		frame.getContentPane().add(rdbtn4);
		
		JRadioButton rdbtn5 = new JRadioButton("New radio button");
		rdbtn5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn5.setBounds(49, 272, 103, 21);
		frame.getContentPane().add(rdbtn5);
		
		JRadioButton rdbtn6 = new JRadioButton("New radio button");
		rdbtn6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn6.setBounds(202, 272, 103, 21);
		frame.getContentPane().add(rdbtn6);
		
		JRadioButton rdbtn7 = new JRadioButton("New radio button");
		rdbtn7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn7.setBounds(356, 272, 103, 21);
		frame.getContentPane().add(rdbtn7);
		
		JRadioButton rdbtn8 = new JRadioButton("New radio button");
		rdbtn8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtn8.setBounds(512, 272, 103, 21);
		frame.getContentPane().add(rdbtn8);
		
//ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn1);
		group.add(rdbtn2);
		group.add(rdbtn3);
		group.add(rdbtn4);
		group.add(rdbtn5);
		group.add(rdbtn6);
		group.add(rdbtn7);
	}
}
