package url_read;

import org.junit.Assert;
import org.junit.Test;


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
        String result = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d));
        String result1 = ZoneDeInteres.seApropieTramvaiDeZona(new ZoneDeInteres(null, 0d, 0d), new TramvaieDeInteres(0, 0d, 0d), new TramvaieDeInteres(1, 1, 1));
        Assert.assertEquals("Tramvaiul se indeparteaza de zona de interes", result);
        Assert.assertEquals("Tramvaiul se apropie de zona de interes", result1);
    }
}
