package zoneDeInteres;

 //importam libraria pentru vectori:
import java.util.Vector;
import java.lang.Math;

public class Main {

	static void calculDistanta(ZoneDeInteres x, ZoneDeInteres y){
		final double fi1 = x.latitudine * Math.PI/180;
		final double fi2 = y.latitudine * Math.PI/180;
		final double lambda1 = x.longitudine * Math.PI/180;
		final double lambda2 = y.longitudine * Math.PI/180;
		double deltafi;
		double deltalambda; 
		double a,c,d;//d- distanta dintre cele doua zone de interes
		final double R=6371000;
		
		if(fi1>fi2) deltafi = fi1-fi2;
		else deltafi = fi2-fi1;
		
		if(lambda1>lambda2) deltalambda = lambda1-lambda2;
		else deltalambda = lambda2 - lambda1;
		
		a = Math.sin(deltafi/2)*Math.sin(deltafi/2) + Math.cos(fi1)*Math.cos(fi2)*Math.sin(deltalambda/2)*Math.sin(deltalambda/2);
		c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		d= R*c;
		
		System.out.println("distanta: " + d); //metrii
	}
	public static void main(String[] args) {
		Vector<ZoneDeInteres> v = new Vector<ZoneDeInteres>();	// am creat un vector ce va primi elemente de tip ZoneDeInteres
		
		//am creat cateva zone de interes
		ZoneDeInteres piataUnirii =  new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326); //zona1
		ZoneDeInteres piataMihEmin = new ZoneDeInteres("Piata Mihai Eminescu", 47.1688202139377, 27.576766289313785);		//zona2
		ZoneDeInteres palas = new ZoneDeInteres("Palas Mall", 47.1552297978438, 27.5875265897513);		//zona3
		ZoneDeInteres uaic = new ZoneDeInteres("Universitatea Alexandru Ioan Cuza", 47.1747724305297, 27.5724000042106);		//zona4
		
		
		//dupa crearea elementelor le adaugam in vector:
		v.add(piataUnirii);
		v.add(piataMihEmin);
		v.add(palas);
		v.add(uaic);
		
		// afisam elementele create:
		piataUnirii.afisare();
		piataMihEmin.afisare();
		palas.afisare();
		uaic.afisare();
		
		calculDistanta(piataUnirii, piataMihEmin);
		calculDistanta(palas, uaic);
	}

}
