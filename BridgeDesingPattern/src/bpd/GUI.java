package bpd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class GUI {

	private JFrame frame;
	
	//Initializari
	String s= new String();
	Color verdeButon = new Color(80, 87, 79);//predefinirea unei culori - butoane

	Caracteristica c1 = new Autor();
	Caracteristica c2 = new Culoare();
	Caracteristica c3 = new Coperta();
	Caracteristica c4 = new Pret();
	
	Carte carte11 = new Thriller(c1,"Thriller");
	Carte carte21 = new Actiune(c1,"Actiune");
	Carte carte31 = new Clasic(c1,"Clasic");
	Carte carte41 = new Istorie(c1,"Istorie");
	Carte carte51 = new Ghid(c1,"Ghid de calatorie");
	Carte carte61 = new Filosofie(c1,"Filosofie");
	
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
		// Configurare interfata grafica
		frame = new JFrame("Libraria de pe colt");
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(500, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		ArrayList<String> cartItems= new  ArrayList<String>();// Lista cosului de cumparaturi
		
//GIF
		URL url = new URL("https://c.tenor.com/_of49PJ8GosAAAAC/hello-hi.gif");
	    Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		label.setBorder(new MatteBorder(2, 1, 2, 2, (Color) new Color(80, 87, 79)));
		label.setBounds(-2, 106, 1000, 294);
		frame.getContentPane().add(label);
//TEXTE		
		JTextArea txtrMesaj1 = new JTextArea();
		txtrMesaj1.setText(" Bun venit! Apasa pe butonul de mai jos pentru a incepe cumparaturile!");
		txtrMesaj1.setBounds(78, 460, 857, 31);
		txtrMesaj1.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrMesaj1.setEditable(false);
		frame.getContentPane().add(txtrMesaj1);
		
		JTextArea txtrMesaj2 = new JTextArea();
		txtrMesaj2.setText(" Alege o carte din cele doua categorii:");
		txtrMesaj2.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrMesaj2.setBounds(243,162, 466, 31);
		txtrMesaj2.setVisible(false);
		frame.getContentPane().add(txtrMesaj2);
		
		JTextArea txtrMesaj3 = new JTextArea();
		txtrMesaj3.setBackground(Color.WHITE);
		txtrMesaj3.setRows(2);
		txtrMesaj3.setText(" Acum ca ai ales genul cartii, sa mai aplicam cateva filtre cautarilor tale:");
		txtrMesaj3.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrMesaj3.setBounds(78, 99, 840, 31);
		txtrMesaj3.setVisible(false);
		frame.getContentPane().add(txtrMesaj3);
		
//BUTOANE
		
		//Butonul pentru afisarea produselor din cosul de cumparaturi
		JButton btnCart = new JButton("");
		btnCart.setBackground(new Color(255, 250, 240));
		btnCart.setBounds(850, 4, 85, 61);
		frame.getContentPane().add(btnCart);
		BufferedImage myPicture0 = ImageIO.read(new File(".\\src\\resources\\cos.png"));//imaginea cos
		JLabel picLabel0 = new JLabel(new ImageIcon(myPicture0));
		btnCart.add(picLabel0);  

		//Buton pentru golirea cosului de cumparaturi
		JButton btnClean = new JButton("Goleste cosul!");
		btnClean.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClean.setForeground(Color.BLACK);
		btnClean.setBackground(new Color(255, 250, 240));
		btnClean.setBounds(710, 16, 128, 35);
		frame.getContentPane().add(btnClean);
		 
		//Buton pentru incepere
		JButton btnApasama = new JButton("Apasa-ma!");
		btnApasama.setBounds(402, 535, 156, 55);
		btnApasama.setForeground(Color.white);
		btnApasama.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnApasama.setBackground(verdeButon);
		frame.getContentPane().add(btnApasama);
		
		//Buton pentru afisarea categoriei Fictiune
		JButton btnFictiune = new JButton("Fictiune");
		btnFictiune.setBounds(141, 266, 150, 40);
		btnFictiune.setVisible(false);
		btnFictiune.setForeground(Color.white);
		btnFictiune.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFictiune.setBackground(verdeButon);
		frame.getContentPane().add(btnFictiune);
		
		//Buton pentru afisarea categoriei Non-Fictiune
		JButton btnNonfictiune = new JButton("Non-fictiune");
		btnNonfictiune.setBounds(674, 266, 150, 40);
		btnNonfictiune.setVisible(false);
		btnNonfictiune.setForeground(Color.white);
		btnNonfictiune.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNonfictiune.setBackground(verdeButon);
		frame.getContentPane().add(btnNonfictiune);
		
		//Buton pentru cumparararea produsului
		JButton btnCumpara = new JButton("Cumpara");
		btnCumpara.setBounds(284, 568, 193, 47);
		btnCumpara.setForeground(Color.white);
		btnCumpara.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCumpara.setBackground(verdeButon);
		btnCumpara.setVisible(false);
		frame.getContentPane().add(btnCumpara);
		
		//Buton pentru revenirea la meniul 2 - Categorii
		JButton btnInapoi = new JButton("Inapoi la categorii");
		btnInapoi.setBounds(504, 568, 205, 47);
		btnInapoi.setForeground(Color.white);
		btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInapoi.setBackground(verdeButon);
		btnInapoi.setVisible(false);
		frame.getContentPane().add(btnInapoi);
		
		//Buton pentru parcurgerea meniurilor 
		JButton btnMaiDeparte = new JButton("Mai departe");
		btnMaiDeparte.setBounds(408, 504, 150, 47);
		btnMaiDeparte.setForeground(Color.white);
		btnMaiDeparte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMaiDeparte.setBackground(verdeButon);
		btnMaiDeparte.setBackground(verdeButon);
		btnMaiDeparte.setVisible(false);
		frame.getContentPane().add(btnMaiDeparte);
		
		//Grupuri de butoane pentru cele 2 categorii
		ButtonGroup gbFictiune= new ButtonGroup();
		ButtonGroup gbNonFictiune = new ButtonGroup();
		
//FICTIUNE		
		Panel panel1 = new Panel();
		panel1.setBounds(141, 333, 157, 207);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JRadioButton rdbtnThriller = new JRadioButton("Thriller");
		rdbtnThriller.setBounds(31, 9, 87, 31);
		panel1.add(rdbtnThriller);
		rdbtnThriller.setBackground(verdeButon.brighter().brighter());
		rdbtnThriller.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnThriller.setVisible(false);
		gbFictiune.add(rdbtnThriller);
		
		JRadioButton rdbtnActiune = new JRadioButton("Actiune");
		rdbtnActiune.setBounds(31, 64, 91, 31);
		panel1.add(rdbtnActiune);
		rdbtnActiune.setBackground(verdeButon.brighter().brighter());
		rdbtnActiune.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnActiune.setVisible(false);
		gbFictiune.add(rdbtnActiune);
		
		JRadioButton rdbtnClasic = new JRadioButton("Clasic");
		rdbtnClasic.setBounds(31, 116, 75, 31);
		rdbtnClasic.setBackground(verdeButon.brighter().brighter());
		panel1.add(rdbtnClasic);
		rdbtnClasic.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnClasic.setVisible(false);
		gbFictiune.add(rdbtnClasic);

//NON_FICTIUNE
		Panel panel2 = new Panel();
		panel2.setBounds(657, 333, 241, 212);
		frame.getContentPane().add(panel2);
		
		JRadioButton rdbtnIstorie = new JRadioButton("Istorie");
		rdbtnIstorie.setBounds(31, 9, 81, 31);
		rdbtnIstorie.setVisible(false);
		panel2.setLayout(null);
		rdbtnIstorie.setBackground(verdeButon.brighter().brighter());
		rdbtnIstorie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel2.add(rdbtnIstorie);
		gbNonFictiune.add(rdbtnIstorie);
		
		JRadioButton rdbtnGhid = new JRadioButton("Ghiduri de calatorie");
		rdbtnGhid.setBounds(31, 61, 193, 31);
		rdbtnGhid.setVisible(false);
		rdbtnGhid.setBackground(verdeButon.brighter().brighter());
		rdbtnGhid.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel2.add(rdbtnGhid);
		gbNonFictiune.add(rdbtnGhid);
		
		JRadioButton rdbtnFilosofie = new JRadioButton("Filosofie");
		rdbtnFilosofie.setBounds(31, 115, 95, 31);
		rdbtnFilosofie.setVisible(false);
		rdbtnFilosofie.setBackground(verdeButon.brighter().brighter());
		rdbtnFilosofie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel2.add(rdbtnFilosofie);
		gbNonFictiune.add(rdbtnFilosofie);
	
		panel2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rdbtnIstorie, rdbtnGhid, rdbtnFilosofie}));

		
//AUTOR		
		JTextArea txtAutor = new JTextArea();
		txtAutor.setText("Cum ai vrea sa fie autorul?");
		txtAutor.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtAutor.setBounds(60, 200, 328, 31);
		txtAutor.setVisible(false);
		frame.getContentPane().add(txtAutor);
		
		JCheckBox chckbxRoman = new JCheckBox("Roman");
		chckbxRoman.setBounds(31, 250, 113, 30);
		chckbxRoman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxRoman.setVisible(false);
		chckbxRoman.setBackground(verdeButon.brighter().brighter());
		frame.getContentPane().add(chckbxRoman);
		
		JCheckBox chckbxFrancez = new JCheckBox("Francez");
		chckbxFrancez.setBounds(166, 250, 113, 30);
		chckbxFrancez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFrancez.setBackground(verdeButon.brighter().brighter());
		chckbxFrancez.setVisible(false);
		frame.getContentPane().add(chckbxFrancez);
		
		JCheckBox chckbxEnglez = new JCheckBox("Englez");
		chckbxEnglez.setBounds(313, 250, 113, 30);
		chckbxEnglez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxEnglez.setBackground(verdeButon.brighter().brighter());
		chckbxEnglez.setVisible(false);
		frame.getContentPane().add(chckbxEnglez);
		
		ButtonGroup cbg = new ButtonGroup();
		cbg.add(chckbxEnglez);
		cbg.add(chckbxFrancez);
		cbg.add(chckbxRoman);
		
//CULOARE
		JTextArea txtCuloare= new JTextArea();
		txtCuloare.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtCuloare.setText("Ce culoare ai vrea sa fie?");
		txtCuloare.setBounds(570, 200, 328, 31);
		txtCuloare.setVisible(false);
		frame.getContentPane().add(txtCuloare);
		
		JCheckBox chckbxGalben= new JCheckBox("Galben");
		chckbxGalben.setBounds(539, 250, 113, 30);
		chckbxGalben.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxGalben.setBackground(verdeButon.brighter().brighter());
		chckbxGalben.setVisible(false);
		frame.getContentPane().add(chckbxGalben);
		
		JCheckBox chckbxRosu = new JCheckBox("Rosu");
		chckbxRosu.setBounds(677, 250, 113, 30);
		chckbxRosu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxRosu.setBackground(verdeButon.brighter().brighter());
		chckbxRosu.setVisible(false);
		frame.getContentPane().add(chckbxRosu);
		
		JCheckBox chckbxAlbastru= new JCheckBox("Albastru");
		chckbxAlbastru.setBounds(820, 250, 113, 30);
		chckbxAlbastru.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxAlbastru.setBackground(verdeButon.brighter().brighter());
		chckbxAlbastru.setVisible(false);
		frame.getContentPane().add(chckbxAlbastru);
	
		ButtonGroup cbg1 = new ButtonGroup();
		cbg1.add(chckbxGalben);
		cbg1.add(chckbxAlbastru);
		cbg1.add(chckbxRosu);
		
//COPERTA
		JTextArea txtCoperta= new JTextArea();
		txtCoperta.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtCoperta.setText("Cum ai vrea sa fie coperta?");
		txtCoperta.setBounds(60, 400, 328, 31);
		txtCoperta.setVisible(false);
		frame.getContentPane().add(txtCoperta);
		
		JCheckBox chckbxBrosata= new JCheckBox("Brosata");
		chckbxBrosata.setBounds(30, 450, 113, 30);
		chckbxBrosata.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBrosata.setBackground(verdeButon.brighter().brighter());
		chckbxBrosata.setVisible(false);
		frame.getContentPane().add(chckbxBrosata);
		
		JCheckBox chckbxCartonata = new JCheckBox("Cartonata");
		chckbxCartonata.setBounds(166, 450, 113, 30);
		chckbxCartonata.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCartonata.setBackground(verdeButon.brighter().brighter());
		chckbxCartonata.setVisible(false);
		frame.getContentPane().add(chckbxCartonata);
		
		JCheckBox chckbxEbook= new JCheckBox("Ebook");
		chckbxEbook.setBounds(313, 450, 113, 30);
		chckbxEbook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxEbook.setBackground(verdeButon.brighter().brighter());
		chckbxEbook.setVisible(false);
		frame.getContentPane().add(chckbxEbook);
		
		ButtonGroup cbg2 = new ButtonGroup();
		cbg2.add(chckbxBrosata);
		cbg2.add(chckbxCartonata);
		cbg2.add(chckbxEbook);
		
//PRET
		JTextArea txtPret= new JTextArea();
		txtPret.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtPret.setText("Cum ai vrea sa fie pretul?");
		txtPret.setBounds(570, 400, 328, 31);
		txtPret.setVisible(false);
		frame.getContentPane().add(txtPret);
		
		JCheckBox chckbxSub50delei= new JCheckBox("Sub 50 de lei");
		chckbxSub50delei.setBounds(572, 449, 150, 33);
		chckbxSub50delei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSub50delei.setBackground(verdeButon.brighter().brighter());
		chckbxSub50delei.setVisible(false);
		frame.getContentPane().add(chckbxSub50delei);
		
		JCheckBox chckbxPeste50delei = new JCheckBox("Peste 50 de lei");
		chckbxPeste50delei.setBounds(754, 448, 156, 35);
		chckbxPeste50delei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxPeste50delei.setBackground(verdeButon.brighter().brighter());
		chckbxPeste50delei.setVisible(false);
		frame.getContentPane().add(chckbxPeste50delei);
		
		ButtonGroup cbg3 = new ButtonGroup();
		cbg3.add(chckbxSub50delei);
		cbg3.add(chckbxPeste50delei);

		ActionListener a1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnCart){
					try{
						System.out.println("Cosul de cumparaturi: ");
						System.out.println(cartItems);//se afiseaza produsele din cos - elementele listei
						}catch(Exception e){e.printStackTrace();}
					}
				if(arg0.getSource()==btnClean){
					try{
						cartItems.clear();//se goleste lista
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Cosul de cumparaturi a fost golit!","Informare",JOptionPane.INFORMATION_MESSAGE);
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}catch(Exception e){e.printStackTrace();}
					}
				if(arg0.getSource()==btnApasama){
				try{
					btnApasama.setVisible(false);
					txtrMesaj1.setVisible(false);
					btnFictiune.setVisible(true);
					btnNonfictiune.setVisible(true);
					btnMaiDeparte.setVisible(true);
					label.setVisible(false);
					txtrMesaj2.setVisible(true);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==btnFictiune){
					try{
						rdbtnThriller.setVisible(true);
						rdbtnActiune.setVisible(true);
						rdbtnClasic.setVisible(true);
						rdbtnGhid.setEnabled(false);
						rdbtnIstorie.setEnabled(false);
						rdbtnFilosofie.setEnabled(false);
						rdbtnActiune.setEnabled(true);
						rdbtnThriller.setEnabled(true);
						rdbtnClasic.setEnabled(true);
					}catch(Exception e){e.printStackTrace();}
				}
				
				if(arg0.getSource()==btnNonfictiune){
					try{
						rdbtnIstorie.setVisible(true);
						rdbtnGhid.setVisible(true);
						rdbtnFilosofie.setVisible(true);
						rdbtnActiune.setEnabled(false);
						rdbtnThriller.setEnabled(false);
						rdbtnClasic.setEnabled(false);
						rdbtnGhid.setEnabled(true);
						rdbtnIstorie.setEnabled(true);
						rdbtnFilosofie.setEnabled(true);
						}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==btnCumpara){
					try{
						System.out.println("Produsul a fost adaugat in cos");
						cbg.clearSelection();
						cbg1.clearSelection();
						cbg2.clearSelection();
						cbg3.clearSelection();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==btnInapoi){
					try{
						txtAutor.setVisible(false);
						txtCoperta.setVisible(false);
						txtCuloare.setVisible(false);
						txtPret.setVisible(false);
						chckbxEnglez.setVisible(false);
						chckbxFrancez.setVisible(false);
						chckbxRoman.setVisible(false);
						chckbxRosu.setVisible(false);
						chckbxGalben.setVisible(false);
						chckbxAlbastru.setVisible(false);
						chckbxBrosata.setVisible(false);
						chckbxCartonata.setVisible(false);
						chckbxEbook.setVisible(false);
						chckbxSub50delei.setVisible(false);
						chckbxPeste50delei.setVisible(false);
						btnMaiDeparte.setVisible(true);
						btnCumpara.setVisible(false);
						btnInapoi.setVisible(false);
						txtrMesaj2.setVisible(true);
						txtrMesaj3.setVisible(false);
						btnFictiune.setVisible(true);
						btnNonfictiune.setVisible(true);
						panel1.setVisible(true);
						rdbtnThriller.setVisible(true);
						rdbtnClasic.setVisible(true);
						rdbtnActiune.setVisible(true);
						panel2.setVisible(true);
						rdbtnGhid.setVisible(true);
						rdbtnIstorie.setVisible(true);
						rdbtnFilosofie.setVisible(true);
						
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnThriller){
					try{
						s=rdbtnThriller.getText();
						cartItems.add(s);
						carte11.afiseazaDetalii();
						
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnActiune){
					try{
						s=rdbtnActiune.getText();
						cartItems.add(s);
						carte21.afiseazaDetalii();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnClasic){
					try{
						s=rdbtnClasic.getText();
						cartItems.add(s);
						carte31.afiseazaDetalii();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnIstorie){
					try{
						s=rdbtnIstorie.getText();
						cartItems.add(s);
						carte41.afiseazaDetalii();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnGhid){
					try{
						s=rdbtnGhid.getText();
						cartItems.add(s);
						carte51.afiseazaDetalii();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==rdbtnFilosofie){
					try{
						s=rdbtnFilosofie.getText();
						cartItems.add(s);
						carte61.afiseazaDetalii();
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==btnMaiDeparte){
					try{
						if(!rdbtnActiune.isSelected() && !rdbtnThriller.isSelected() && !rdbtnClasic.isSelected() && !rdbtnGhid.isSelected() && !rdbtnIstorie.isSelected() && !rdbtnFilosofie.isSelected()){
							System.out.println("Alege o carte din cele doua categorii!");
						}
						else{
						panel1.setVisible(false);
						panel2.setVisible(false);
						gbFictiune.clearSelection();
						gbNonFictiune.clearSelection();
						btnFictiune.setVisible(false);
						btnNonfictiune.setVisible(false);
						txtrMesaj3.setVisible(true);
						txtAutor.setVisible(true);
						txtCoperta.setVisible(true);
						txtCuloare.setVisible(true);
						txtPret.setVisible(true);
						chckbxEnglez.setVisible(true);
						chckbxFrancez.setVisible(true);
						chckbxRoman.setVisible(true);
						chckbxRosu.setVisible(true);
						chckbxGalben.setVisible(true);
						chckbxAlbastru.setVisible(true);
						chckbxBrosata.setVisible(true);
						chckbxCartonata.setVisible(true);
						chckbxEbook.setVisible(true);
						chckbxSub50delei.setVisible(true);
						chckbxPeste50delei.setVisible(true);
						btnMaiDeparte.setVisible(false);
						btnCumpara.setVisible(true);
						btnInapoi.setVisible(true);
						txtrMesaj2.setVisible(false);
						}
					}catch(Exception e){e.printStackTrace();}
				}
				
				if(arg0.getSource()==chckbxRoman){
					try{
						s=chckbxRoman.getText();
						cartItems.add(s);
						c1.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxEnglez){
					try{
						s=chckbxEnglez.getText();
						cartItems.add(s);
						c1.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxFrancez){
					try{
						s=chckbxFrancez.getText();
						cartItems.add(s);
						c1.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxAlbastru){
					try{
						s=chckbxAlbastru.getText();
						cartItems.add(s);
						c2.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxGalben){
					try{
						s=chckbxGalben.getText();
						cartItems.add(s);
						c2.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxRosu){
					try{
						s=chckbxRosu.getText();
						cartItems.add(s);
						c2.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxCartonata){
					try{
						s=chckbxCartonata.getText();
						cartItems.add(s);
						c3.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxBrosata){
					try{
						s=chckbxBrosata.getText();
						cartItems.add(s);
						c3.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxEbook){
					try{
						s=chckbxEbook.getText();
						cartItems.add(s);
						c3.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxPeste50delei){
					try{
						s=chckbxPeste50delei.getText();
						cartItems.add(s);
						c4.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==chckbxSub50delei){
					try{
						s=chckbxSub50delei.getText();
						cartItems.add(s);
						c4.afisareCaracteristica();
						System.out.println(s);
					}catch(Exception e){e.printStackTrace();}
				}
				if(arg0.getSource()==gbFictiune){
					try{
						
					}catch(Exception e){e.printStackTrace();}
				}
			}
	};
	btnCart.addActionListener(a1);
	btnClean.addActionListener(a1);
	btnApasama.addActionListener(a1);
	btnFictiune.addActionListener(a1);
	btnNonfictiune.addActionListener(a1);
	btnCumpara.addActionListener(a1);
	rdbtnThriller.addActionListener(a1);
	rdbtnGhid.addActionListener(a1);
	rdbtnActiune.addActionListener(a1);
	rdbtnClasic.addActionListener(a1);
	rdbtnIstorie.addActionListener(a1);
	rdbtnFilosofie.addActionListener(a1);
	btnMaiDeparte.addActionListener(a1);
	chckbxRoman.addActionListener(a1);
	chckbxEnglez.addActionListener(a1);
	chckbxFrancez.addActionListener(a1);
	chckbxAlbastru.addActionListener(a1);
	chckbxGalben.addActionListener(a1);
	chckbxRosu.addActionListener(a1);
	chckbxCartonata.addActionListener(a1);
	chckbxBrosata.addActionListener(a1);
	chckbxEbook.addActionListener(a1);
	chckbxPeste50delei.addActionListener(a1);
	chckbxSub50delei.addActionListener(a1);
	btnInapoi.addActionListener(a1);

	}
}
