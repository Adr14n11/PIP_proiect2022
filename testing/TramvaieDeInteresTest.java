package url_read;

import org.junit.Assert;
import org.junit.Test;

public class TramvaieDeInteresTest {
    url_read.TramvaieDeInteres tramvaieDeInteres= new url_read.TramvaieDeInteres(0, 0d, 0d);

    @Test
    public void testAfisare() throws Exception {
        tramvaieDeInteres.afisare();
    }

    @Test
    public void testAfisare_lista_tramvaie() throws Exception {
        TramvaieDeInteres.afisare_lista_tramvaie(new java.util.Vector(java.util.Arrays.asList(new url_read.TramvaieDeInteres(0, 0d, 0d))));
    }

    @Test
    public void testTramvaieApropiateDeZona() throws Exception {
        java.util.Vector<url_read.TramvaieDeInteres> result = TramvaieDeInteres.TramvaieApropiateDeZona(new url_read.ZoneDeInteres("locatie", 0d, 0d), new java.util.Vector(java.util.Arrays.asList(new url_read.TramvaieDeInteres(0, 0d, 0d))));
        Assert.assertEquals(new java.util.Vector(java.util.Arrays.asList(new url_read.TramvaieDeInteres(0, 0d, 0d))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme