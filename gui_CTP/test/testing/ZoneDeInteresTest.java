package testing;

import org.junit.Assert;
import org.junit.Test;

import url_read.TramvaieDeInteres;
import url_read.ZoneDeInteres;


public class ZoneDeInteresTest {
	
    ZoneDeInteres zoneDeInteres= new ZoneDeInteres("locatie", 500, 200);

    @Test
    public void testAfisare() throws Exception {
        zoneDeInteres.afisare();
    }

    @Test
    public void testDistanta() throws Exception {
    	double result = ZoneDeInteres.Distanta(new ZoneDeInteres(null, 500, 200), new TramvaieDeInteres(0, 500, 200));	
    	Assert.assertEquals(0d, result, 0);   	 
    }

    @Test
    public void testSeApropieTramvaiDeZona() throws Exception {
        String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326), new TramvaieDeInteres(2216, 47.165825, 27.573357), new TramvaieDeInteres(2216, 47.165805, 27.573247));
        String result1 = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres("Piata Unirii", 47.1656266707948 , 27.5808940217326), new TramvaieDeInteres(2216, 47.165805, 27.573247), new TramvaieDeInteres(2216, 47.165825, 27.573357));
        Assert.assertEquals("Tramvaiul se indeparteaza de zona de interes!", result);
        Assert.assertEquals("Tramvaiul se apropie de zona de interes!", result1);
    }
}
