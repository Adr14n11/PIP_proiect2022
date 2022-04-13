package zoneDeInteres;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Vector<ZoneDeInteres> v = new Vector<ZoneDeInteres>();
		
		ZoneDeInteres piataUnirii =  new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326);
		ZoneDeInteres piataMihEmin = new ZoneDeInteres("Piata Mihai Eminescu", 47.1688202139377, 27.576766289313785);
		ZoneDeInteres palas = new ZoneDeInteres("Palas Mall", 47.1552297978438, 27.5875265897513);
		ZoneDeInteres uaic = new ZoneDeInteres("Universitatea Alexandru Ioan Cuza", 47.1747724305297, 27.5724000042106);
		
		v.add(piataUnirii);
		v.add(piataMihEmin);
		v.add(palas);
		v.add(uaic);
		
		
		piataUnirii.afisare();
		piataMihEmin.afisare();
		palas.afisare();
		uaic.afisare();
	}

}
