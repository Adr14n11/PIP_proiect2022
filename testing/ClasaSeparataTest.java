package url_read;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.*;

public class ClasaSeparataTest {
    @Mock
    java.util.Vector<url_read.TramvaieDeInteres> vTramvaie_t1;
    @Mock
    java.util.Vector<url_read.TramvaieDeInteres> vTramvaie_t2;
    @Mock
    url_read.ZoneDeInteres piataUnirii;
    @Mock
    url_read.ZoneDeInteres piataMihEmin;
    @Mock
    url_read.ZoneDeInteres palas;
    @Mock
    url_read.ZoneDeInteres uaic;
    @InjectMocks
    url_read.ClasaSeparata clasaSeparata;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFunctie() throws Exception {
        clasaSeparata.functie();
    }

    @Test
    public void testFunctieUAIC() throws Exception {
        when(piataUnirii.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(piataMihEmin.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(palas.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(uaic.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");

        java.lang.String result = clasaSeparata.functieUAIC();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testFunctiePalas() throws Exception {
        when(piataUnirii.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(piataMihEmin.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(palas.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(uaic.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");

        java.lang.String result = clasaSeparata.functiePalas();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testFunctiePiataMEminescu() throws Exception {
        when(piataUnirii.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(piataMihEmin.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(palas.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(uaic.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");

        java.lang.String result = clasaSeparata.functiePiataMEminescu();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testFunctiePiataUnirii() throws Exception {
        when(piataUnirii.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(piataMihEmin.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(palas.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");
        when(uaic.seApropieTramvaiDeZona(any(), any(), any())).thenReturn("seApropieTramvaiDeZonaResponse");

        java.lang.String result = clasaSeparata.functiePiataUnirii();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme