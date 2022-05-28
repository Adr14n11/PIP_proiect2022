package testing;

import org.junit.Assert;
import org.junit.Test;

import url_read.ClasaSeparata;
import url_read.TramvaieDeInteres;
import url_read.ZoneDeInteres;

public class ClasaSeparataTest {
	
	ClasaSeparata clasa = new ClasaSeparata();	
	
	@Test
    public void testFunctie() throws Exception {
         clasa.functie();
       
    }
	
	@Test
    public void testFunctieUAIC() throws Exception {
		try{
		Thread.sleep(16000);
		String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(1, 1, 1));
		String resultFinal = clasa.functieUAIC();
		Assert.assertEquals(result, resultFinal);
		}catch(NullPointerException e)
		{
			System.out.println("caught");
		
		}
		
	}
	@Test
    public void testFunctiePalas() throws Exception {
		try{
		Thread.sleep(16000);
		String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(1, 1, 1));
		String resultFinal = clasa.functiePalas();
		Assert.assertEquals(result, resultFinal);
		}catch(NullPointerException e)
		{
			System.out.println("caught");
		
		}
	
	}
	@Test
    public void testFunctiePiataMEminescu() throws Exception {
		try{
		Thread.sleep(16000);
		String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(1, 1, 1));
		String resultFinal = clasa.functiePiataMEminescu();
		Assert.assertEquals(result, resultFinal);
		}catch(NullPointerException e)
		{
			System.out.println("caught");
		
		}
		
	}
	@Test
    public void testFunctiePiataUnirii() throws Exception {
		try{
		Thread.sleep(16000);
		String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(1, 1, 1));
		String resultFinal = clasa.functiePiataUnirii();
		Assert.assertEquals(result, resultFinal);
		}catch(NullPointerException e)
		{
			System.out.println("caught");
		
		}
		
	}

}
