package gui_CTP;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import url_read.ClasaSeparata;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;


import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class GUI extends ClasaSeparata{

	private JFrame frame;
	private JLabel clock;
	
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
		ProgressBar pb = new ProgressBar();  
	    pb.setVisible(true);  
	    pb.loop();
	}


	/**
	 * Create the application.
	 * @throws IOException 
	 */

	public void clock() {
		Thread clock1 = new Thread() {
			public void run()
			{
				try {
					for(;;) {
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					clock.setText("Time: "+hour+":"+minute+":"+second+"  Date: "+day+"/"+ month + "/" + year);
					
					sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		clock1.start();
		
	}
	public GUI() throws IOException {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Tramvaie PESA - IASI");
		frame.getContentPane().setBackground(new Color(0, 165, 80));
		frame.setBounds(100, 100, 846, 622);
		frame.setSize(1085, 725);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrAlegeZonaPreferata = new JTextArea();
		txtrAlegeZonaPreferata.setAutoscrolls(false);
		txtrAlegeZonaPreferata.setForeground(Color.WHITE);
		txtrAlegeZonaPreferata.setFont(new Font("SansSerif", Font.PLAIN, 24));
		txtrAlegeZonaPreferata.setEditable(false);
		txtrAlegeZonaPreferata.setBackground(new Color(0, 165, 80));
		txtrAlegeZonaPreferata.setText("Alege zona cea mai apropiata de locatia ta!");

	
		
//RadioButtons		
		JRadioButton rdbtn1 = new JRadioButton("Piata Unirii");
		rdbtn1.setForeground(Color.WHITE);
		rdbtn1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		rdbtn1.setBackground(new Color(0, 128, 0));
		
		JRadioButton rdbtn2 = new JRadioButton("Piata Mihai Eminescu");
		rdbtn2.setBackground(new Color(0, 128, 0));
		rdbtn2.setForeground(Color.WHITE);
		rdbtn2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		JRadioButton rdbtn3 = new JRadioButton("Palas Mall");
		rdbtn3.setBackground(new Color(0, 128, 0));
		rdbtn3.setForeground(Color.WHITE);
		rdbtn3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		JRadioButton rdbtn4 = new JRadioButton("Universitate");
		rdbtn4.setBackground(new Color(0, 128, 0));
		rdbtn4.setForeground(Color.WHITE);
		rdbtn4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
//ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn1);
		group.add(rdbtn2);
		group.add(rdbtn3);
		group.add(rdbtn4);

//JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setForeground(Color.BLACK);
		//textArea.setEnabled(false);
		textArea.setEditable(false);
//Panel	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 165, 80));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 165, 80));
		BufferedImage img1 = ImageIO.read(new File("New Project (2).png"));
		JLabel pic1 = new JLabel(new ImageIcon(img1));
		panel_1.add(pic1);
		
		
		clock = new JLabel("");
		clock.setForeground(Color.WHITE);
		clock.setFont(new Font("SansSerif", Font.ITALIC, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 165, 80));
		BufferedImage imgc = ImageIO.read(new File("clock.png"));
		JLabel picc = new JLabel(new ImageIcon(imgc));
		panel_2.add(picc);
		
		 

//GroupLayout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
								.addComponent(textArea))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(clock, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)))))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(31)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(clock, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(42))))))
		);
		frame.getContentPane().setLayout(groupLayout);
		
//ActionListener general
		ActionListener a1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				//panel.setVisible(true);
				if(arg0.getSource()==rdbtn1) {
					try {
						BufferedImage img = ImageIO.read(new File("ZonaPiataUnirii.jpg"));
						JLabel pic = new JLabel(new ImageIcon(img));
						panel.add(pic);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
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
						BufferedImage img2 = ImageIO.read(new File("MihaiEminescu1.jpg"));
						JLabel pic2 = new JLabel(new ImageIcon(img2));
						panel.add(pic2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
				
				if(arg0.getSource()==rdbtn3) {
					try {
						BufferedImage img3 = ImageIO.read(new File("palas.jpg"));
						JLabel pic3 = new JLabel(new ImageIcon(img3));
						panel.add(pic3);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
						BufferedImage img4 = ImageIO.read(new File("UnivCuza.jpg"));
						JLabel pic4 = new JLabel(new ImageIcon(img4));
						panel.add(pic4);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
