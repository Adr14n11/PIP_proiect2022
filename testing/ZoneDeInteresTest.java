package url_read;

import org.junit.Assert;
import org.junit.Test;

public class ZoneDeInteresTest {
    url_read.ZoneDeInteres zoneDeInteres= new url_read.ZoneDeInteres("locatie", 0d, 0d);

    @Test
    public void testAfisare() throws Exception {
        zoneDeInteres.afisare();
    }

    @Test
    public void testDistanta() throws Exception {
        double result = ZoneDeInteres.Distanta(new url_read.ZoneDeInteres(null, 0d, 0d), new url_read.TramvaieDeInteres(0, 0d, 0d));
        Assert.assertEquals(0d, result);
    }

    @Test
    public void testSeApropieTramvaiDeZona() throws Exception {
        java.lang.String result = ZoneDeInteres.seApropieTramvaiDeZona(new url_read.ZoneDeInteres(null, 0d, 0d), new url_read.TramvaieDeInteres(0, 0d, 0d), new url_read.TramvaieDeInteres(0, 0d, 0d));
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme