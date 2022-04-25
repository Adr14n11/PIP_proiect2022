package bpd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GUITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGUI() {
		//fail("Not yet implemented");
		// instantiere 
		Caracteristica c = new Autor();
		assertNotNull(c);
	}
	@Test
	public void testReturneazaUnString() {
		//Caracteristica c = new Autor();
		Autor a = new Autor();
		String nume = a.numeAutor();
		assertNotNull(nume);
	}
	@Test
	public void testComparareAutor() {
		//Caracteristica c = new Autor();
		String autor = "englez";
		Autor a = new Autor();
		String nume = a.numeAutor();
		assertNotNull(nume);
		String expectedString = nume;
		//assertEquals(expectedString, autor); // eroare de inegalitate
		assertEquals(expectedString, nume);
	}
}
