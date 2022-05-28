package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import org.junit.Test;

import url_read.TramvaieDeInteres;

public class TramvaieDeInteresTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	/**
	 *  Test method for TramvaieDeInteres constructor, is not null
	 */
	@Test
	public void testTramvaieDeInteres() {
		TramvaieDeInteres tramvai = new TramvaieDeInteres(1,2.00,3.00);
		assertNotNull(tramvai);
	}

	@Test
	public void testTramvaieDeInteresNull() {
		TramvaieDeInteres tramvai = null;
		assertNull(tramvai);
	}
	
	@Test
	public void testAfisare() {
	    System.setOut(new PrintStream(outContent));

		TramvaieDeInteres tramvai = new TramvaieDeInteres(1,2,3);
		
		String afisareAsteptata = "Vehicle name: 1, Latitudine: 2.0, Longitudine: 3.0";
		tramvai.afisare();
		
		assertEquals(afisareAsteptata, outContent.toString().trim() );
		
		
	}

	@Test
	public void testAfisare_lista_tramvaie() {
		System.setOut(new PrintStream(outContent));
		
		TramvaieDeInteres tramvai1 = new TramvaieDeInteres(1,2,3);
		TramvaieDeInteres tramvai2 = new TramvaieDeInteres(2,3,4);
		TramvaieDeInteres tramvai3 = new TramvaieDeInteres(3,4,5);
				
		Vector<TramvaieDeInteres> listaTramvaie = new Vector<TramvaieDeInteres>();	//vector de tramvaie la momentul 1
		listaTramvaie.add(tramvai1); 
		listaTramvaie.add(tramvai2); 
		listaTramvaie.add(tramvai3); 
		
		String newLine = System.lineSeparator();
		
		String afisareAsteptata = "Vehicle name: "+ tramvai1.vehicleName+ ", Latitudine: "+ tramvai1.latitudine+", Longitudine: "+ tramvai1.longitudine+ newLine +"Vehicle name: "+ tramvai2.vehicleName+ ", Latitudine: "+ tramvai2.latitudine+", Longitudine: "+ tramvai2.longitudine+ newLine +"Vehicle name: "+ tramvai3.vehicleName+ ", Latitudine: "+ tramvai3.latitudine+", Longitudine: "+ tramvai3.longitudine;
		
		TramvaieDeInteres.afisare_lista_tramvaie(listaTramvaie);

		assertEquals(afisareAsteptata, outContent.toString().trim() );
		
	}
}