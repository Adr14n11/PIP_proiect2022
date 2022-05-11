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

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.json.JSONArray;
import org.json.JSONObject;

public class GUI {

	private JFrame frame;
	static Vector<ZoneDeInteres> vZone = new Vector<ZoneDeInteres>();	//vector cu elemente de tip ZoneDeInteres
	static Vector<TramvaieDeInteres> vTramvaie_t1 = new Vector<TramvaieDeInteres>();	//vector de tramvaie la momentul 1
	static Vector<TramvaieDeInteres> vTramvaie_t2 = new Vector<TramvaieDeInteres>();	//vector de tramvaie la momentul 2
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
		ZoneDeInteres piataUnirii =  new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326); 				//zona1
    	ZoneDeInteres piataMihEmin = new ZoneDeInteres("Piata Mihai Eminescu", 47.1688202139377, 27.576766289313785);		//zona2
    	ZoneDeInteres palas = new ZoneDeInteres("Palas Mall", 47.1552297978438, 27.5875265897513);							//zona3
    	ZoneDeInteres uaic = new ZoneDeInteres("Universitatea Alexandru Ioan Cuza", 47.1747724305297, 27.5724000042106);	//zona4
    	
    	//adaugare zone create intr-un vector
    	vZone.add(piataUnirii);
    	vZone.add(piataMihEmin);
    	vZone.add(palas);
    	vZone.add(uaic);
    	
    	int counter =0;
    	
    	String url = "https://gps.sctpiasi.ro/json"; 		//URL-ul nostru
        String creare_lista_json_start_I_s ="{ lista:"; 	//Simboluri inceput
        String creare_lista_json_start_E_s =" }"; 			//Simboluri sfarsit
        String concatenat_final_s; 							//Continutul url-ului in varianta lista de json
        String aux;
        String de_comparat = "22"; 							//String folosit pentru a cauta tramvaiele cu name-ul care ne intereseaza
        
        aux =  ReadFromWeb.readFromWeb(url); 				//Continutul url-ului    
        
        concatenat_final_s = creare_lista_json_start_I_s + aux;
        concatenat_final_s = concatenat_final_s + creare_lista_json_start_E_s;       
        JSONObject jsnobject = new JSONObject(concatenat_final_s); 		//From string to json       
        JSONArray jsonArray = jsnobject.getJSONArray("lista"); 			//Citim lista    
        
        String[] lista_filtrata = new String[40];		//Lista filtrata dupa id       
        double[] latitudini = new double[40];    
        double[] longitudini = new double[40];
        int[] ID = new int[40];
        	        
        for (int i = 0; i < jsonArray.length(); i++) {
        	JSONObject explrObject = jsonArray.getJSONObject(i);
            String latitudine = explrObject.getString("vehicleLat");
            String longitudine = explrObject.getString("vehicleLong");       	 
            String aux_1 = explrObject.getString("vehicleName");  
            String aux_2 = explrObject.getString("vehicleName");    
            
            aux_2 = aux_2+"-"+latitudine; 		//Concatenare
            aux_2 = aux_2+"-"+longitudine;
            int aux_3 = Compare.stringCompare(aux_2, de_comparat);
                        
            if(aux_3==1){           	
            	lista_filtrata[counter]=aux_2;
            	latitudini[counter] = Double.parseDouble(latitudine);		//Transformam string-ul latitudine in double
            	latitudine+="-";
            	longitudini[counter] = Double.parseDouble(longitudine);		//Transformam string-ul longitudine in double
            	longitudine+="-";
            	ID[counter]= Integer.parseInt(aux_1);						//Transformam string-ul vehicleName in int
            	counter = counter +1;
            }               
        }

        for(int i=0;i<counter;i++){ 
            TramvaieDeInteres tramvai = new TramvaieDeInteres(ID[i], latitudini[i], longitudini[i]);
            vTramvaie_t1.add(tramvai);         		
        }
            	
        System.out.println("\n\tLista initiala de tramvaie:\n");
        TramvaieDeInteres.afisare_lista_tramvaie(vTramvaie_t1);

        int counter2 =0;  
        Thread.sleep(16500);        
        String aux2 =  ReadFromWeb.readFromWeb(url); 		//Continutul url-ului 
        
        String concatenat_final_s2 = creare_lista_json_start_I_s + aux2;
        concatenat_final_s2 = concatenat_final_s2 + creare_lista_json_start_E_s;       
        JSONObject jsnobject2 = new JSONObject(concatenat_final_s2); 		//From string to json       
        JSONArray jsonArray2 = jsnobject2.getJSONArray("lista"); 			//Citim lista    
            
        String[] lista_filtrata2 = new String[40];			//Lista filtrata dupa id       
        double[] latitudini2 = new double[40];    
        double[] longitudini2 = new double[40];
        int[] ID2 = new int[40];

        for (int i = 0; i < jsonArray2.length(); i++) {
        	JSONObject explrObject2 = jsonArray2.getJSONObject(i);
            String latitudine2 = explrObject2.getString("vehicleLat");
            String longitudine2 = explrObject2.getString("vehicleLong");       	 
             
            String aux_12 = explrObject2.getString("vehicleName");  
            String aux_22 = explrObject2.getString("vehicleName");    
            aux_22 = aux_22+"-"+latitudine2; 		//Concatenare
            aux_22 = aux_22+"-"+longitudine2;
            int aux_32 = Compare.stringCompare(aux_22, de_comparat);
                            
            if(aux_32==1){           	
            	lista_filtrata2[counter2]=aux_22;
            	latitudini2[counter2] = Double.parseDouble(latitudine2);	//Transformam string-ul latitudine in double
                latitudine2+="-";
                longitudini2[counter2] = Double.parseDouble(longitudine2);	//Transformam string-ul longitudine in double
                longitudine2+="-";
                ID2[counter2]= Integer.parseInt(aux_12);					//Transformam string-ul vehicleName in int
                counter2 = counter2 +1;
            }               
        }

        //for(int i=0;i<counter2;i++){      	        	
        //	TramvaieDeInteres tramvai2 = new TramvaieDeInteres( ID2[i], latitudini2[i], longitudini2[i] );
         //   vTramvaie_t2.add(tramvai2);		
        //}
                	
        //System.out.println("\n\tLista de tramvaie dupa un timp de 16.5s:\n");
        //TramvaieDeInteres.afisare_lista_tramvaie(vTramvaie_t2);
   
        //vTramvaie = TramvaieDeInteres.convertire_vehicleName(vTramvaie);
                
        //Vector<TramvaieDeInteres> tramvaie_t2_ordonate = TramvaieDeInteres.TramvaieApropiateDeZona(uaic,vTramvaie_t2); //lista de tramvaie ordonata la momentul2 pentru a fi folosita mai departe
        
        //returnare date la momentul 1 pentru cel mai apropiat tramvai:
        //TramvaieDeInteres tramvai_t1 = new TramvaieDeInteres(0, 0, 0);
        //for (int i = 0; i < vTramvaie_t1.size(); i++){
        //	if (vTramvaie_t1.elementAt(i).vehicleName == tramvaie_t2_ordonate.elementAt(0).vehicleName)
        //		tramvai_t1 = vTramvaie_t1.elementAt(i);
        //}
        
        //testare daca tramvaiul cel mai apropiat de zona se insdeparteaza sau se apropie
        //System.out.println("\n");
        //ZoneDeInteres.seApropieTramvaiDeZona(uaic, tramvai_t1,tramvaie_t2_ordonate.elementAt(0));
        //System.out.println("\n\t");
        //tramvai_t1.afisare();
        //System.out.println("\n\t");
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
		txtrAlegeZonaPreferata.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtrAlegeZonaPreferata.setEditable(false);
		txtrAlegeZonaPreferata.setBackground(new Color(0, 165, 80));
		txtrAlegeZonaPreferata.setText("Alege zona cea mai apropiata de locatia ta!");
//RadioButtons		
		JRadioButton rdbtn1 = new JRadioButton("Piata Unirii");
		rdbtn1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		JRadioButton rdbtn2 = new JRadioButton("Piata Mihai Eminescu");
		rdbtn2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
		JRadioButton rdbtn3 = new JRadioButton("Palas Mall");
		rdbtn3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
		JRadioButton rdbtn4 = new JRadioButton("Universitate");
		rdbtn4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
//ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn1);
		group.add(rdbtn2);
		group.add(rdbtn3);
		group.add(rdbtn4);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(txtrAlegeZonaPreferata, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addGap(94))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING)
						.addComponent(rdbtn4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtn3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtn1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtn2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(476))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(txtrAlegeZonaPreferata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(rdbtn1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtn2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtn3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtn4)
					.addGap(33)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(36))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		//ActionListener general
		
		ActionListener a1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==rdbtn1) {
					textArea.setVisible(true);
				}
				if(arg0.getSource()==rdbtn2) {
					textArea.setVisible(true);
				}
				if(arg0.getSource()==rdbtn3) {
					textArea.setVisible(true);
				}
				if(arg0.getSource()==rdbtn4) {
					textArea.setVisible(true);
				}
			}
		};
		rdbtn1.addActionListener(a1);
		rdbtn2.addActionListener(a1);
		rdbtn3.addActionListener(a1);
		rdbtn4.addActionListener(a1);
	}
}
