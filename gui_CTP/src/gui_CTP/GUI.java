package gui_CTP;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import url_read.Compare;
import url_read.ReadFromWeb;
import url_read.TramvaieDeInteres;
import url_read.ZoneDeInteres;
import url_read.ClasaSeparata;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.Scrollbar;
import javax.swing.JPanel;


public class GUI extends ClasaSeparata{

	private JFrame frame;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		JTextArea txtrAlegeZonaPreferata = new JTextArea();
		txtrAlegeZonaPreferata.setForeground(Color.WHITE);
		txtrAlegeZonaPreferata.setFont(new Font("SansSerif", Font.PLAIN, 22));
		txtrAlegeZonaPreferata.setEditable(false);
		txtrAlegeZonaPreferata.setBackground(new Color(0, 165, 80));
		txtrAlegeZonaPreferata.setText("Alege zona cea mai apropiata de locatia ta!");
//RadioButtons		
		JRadioButton rdbtn1 = new JRadioButton("Piata Unirii");
		rdbtn1.setForeground(Color.WHITE);
		rdbtn1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rdbtn1.setBackground(new Color(0, 128, 0));
		
		JRadioButton rdbtn2 = new JRadioButton("Piata Mihai Eminescu");
		rdbtn2.setBackground(new Color(0, 128, 0));
		rdbtn2.setForeground(Color.WHITE);
		rdbtn2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdbtn3 = new JRadioButton("Palas Mall");
		rdbtn3.setBackground(new Color(0, 128, 0));
		rdbtn3.setForeground(Color.WHITE);
		rdbtn3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdbtn4 = new JRadioButton("Universitate");
		rdbtn4.setBackground(new Color(0, 128, 0));
		rdbtn4.setForeground(Color.WHITE);
		rdbtn4.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
//ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn1);
		group.add(rdbtn2);
		group.add(rdbtn3);
		group.add(rdbtn4);

//JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(245, 245, 220));
		textArea.setForeground(Color.BLACK);
		//textArea.setEnabled(false);
		textArea.setEditable(false);
		
		JPanel panel = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
								.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
								.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
							.addGap(28)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtn2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtn3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtn4)
							.addGap(33)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		
//ActionListener general
		ActionListener a1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				if(arg0.getSource()==rdbtn1) {
					try {
						textArea.append(clasaSeparataPiataUnirii());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(arg0.getSource()==rdbtn2) {
					try {
						textArea.append(clasaSeparataPiataMEminescu());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(arg0.getSource()==rdbtn3) {;
					try {
						textArea.append(clasaSeparataPalas());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(arg0.getSource()==rdbtn4) {
					try {
						textArea.append(clasaSeparataUAIC());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		rdbtn1.addActionListener(a1);
		rdbtn2.addActionListener(a1);
		rdbtn3.addActionListener(a1);
		rdbtn4.addActionListener(a1);
	}
}
