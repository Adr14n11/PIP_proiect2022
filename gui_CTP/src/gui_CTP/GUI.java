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
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GUI extends ClasaSeparata{

	private JFrame frame;
	public static Mapa example;
	//private static com.teamdev.jxmaps.Map map;
	
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
					example = new Mapa("Iasi");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */

	public GUI() throws IOException {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Tramvaie PESA - IASI");
		frame.getContentPane().setBackground(new Color(0, 165, 80));
		frame.setBounds(100, 100, 800, 500);
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
		BufferedImage img = ImageIO.read(new File("png-clipart-tram-transport-car-tram-mode-of-transport-public-transport-thumbnail.png"));
		JLabel pic = new JLabel(new ImageIcon(img));
		panel.add(pic);		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtn1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(rdbtn2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(rdbtn3, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(rdbtn4, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
							.addGap(28)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(321, Short.MAX_VALUE)
					.addGap(255))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
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
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		
//ActionListener general
		ActionListener a1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				if(arg0.getSource()==rdbtn1) {
					try {
						textArea.append(functiePiataUnirii());
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
						textArea.append(functiePiataMEminescu());
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
						textArea.append(functiePalas());
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
						textArea.append(functieUAIC());
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