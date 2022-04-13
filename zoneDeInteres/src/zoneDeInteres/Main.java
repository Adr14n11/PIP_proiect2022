package zoneDeInteres;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<ZoneDeInteres> v = new Vector<ZoneDeInteres>();
		
		ZoneDeInteres piataUnirii =  new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326);
		ZoneDeInteres piataMihEmin = new ZoneDeInteres("Piata Mihai Eminescu", 47.1688202139377, 27.576766289313785);
		ZoneDeInteres palas = new ZoneDeInteres("Palas Mall", 47.1552297978438, 27.5875265897513);
		
		if(v.contains(palas))
		System.out.println("Zona exista deja!");
		else v.add(palas);
		
		v.add(piataUnirii);
		v.add(piataMihEmin);
		v.add(palas);
		
		
		
		piataUnirii.afisare();
		piataMihEmin.afisare();
		palas.afisare();
	}

}
