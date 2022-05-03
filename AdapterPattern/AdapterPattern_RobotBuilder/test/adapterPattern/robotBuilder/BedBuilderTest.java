package adapterPattern.robotBuilder;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class BedBuilderTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	/**
	 * Test method for BedBuilder constructor, is not null.
	 */
	@Test
	public void testCanInstantiateABed(){
		BedBuilder bedBuilder = new BedBuilder();
		assertNotNull(bedBuilder);
	}
	
	/**
	 * Test method for BedBuilder constructor, is null.
	 */
	@Test
	public void testCanInstantiateANullBed(){
		BedBuilder bedBuilder = null;
		assertNull(bedBuilder);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedCollectionName()}.
	 */
	@Test
	public void testGetBedCollectionNameWithName() {
		BedBuilder bedBuilder = new BedBuilder();
		bedBuilder.setBedCollectionName("Ikea");
		String result = bedBuilder.getBedCollectionName();
		assertEquals("Ikea", result);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedCollectionName()}.
	 */
	@Test
	public void testGetBedCollectionNameWithoutName() {
		BedBuilder bedBuilder = new BedBuilder();
		bedBuilder.setBedCollectionName(null);
		String result = bedBuilder.getBedCollectionName();
		assertNull(result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedColor()}.
	 */
	@Test
	public void testGetBedColorWithColor() {
		BedBuilder bedBuilder = new BedBuilder();
		String expResult = "red";
		bedBuilder.setBedColor("red");
		String result = bedBuilder.getBedColor();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedColor()}.
	 */
	@Test
	public void testGetBedColorWithoutColor() {
		BedBuilder bedBuilder = new BedBuilder();
		bedBuilder.setBedColor(null);
		String result = bedBuilder.getBedColor();
		assertNull(result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedParts()}.
	 */
	@Test
	public void testGetBedPartsWithParts() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bedBuilder.setBedParts(bedParts);
		
		assertEquals(bedParts, bedBuilder.getBedParts());
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedParts()}.
	 */
	@Test
	public void testGetBedPartsWithoutParts() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = null;
	
		bedBuilder.setBedParts(bedParts);
		
		assertEquals(bedParts, bedBuilder.getBedParts());
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedTools()}.
	 */
	@Test
	public void testGetBedWithTools() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bedBuilder.setBedTools(bedTools);
		
		assertEquals(bedTools, bedBuilder.getBedTools());
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#getBedTools()}.
	 */
	@Test
	public void testGetBedWithoutTools() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = null;
	
		bedBuilder.setBedTools(bedTools);
		
		assertEquals(bedTools, bedBuilder.getBedTools());
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedCollectionName(java.lang.String)}.
	 */
	@Test
	public void testSetBedCollectionName() {
		BedBuilder bedBuilder = new BedBuilder();
		String result = "Ikea";
		bedBuilder.setBedCollectionName(result);
		assertEquals(bedBuilder.getBedCollectionName(), result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedCollectionName(java.lang.String)}.
	 */
	@Test
	public void testSetBedCollectionNameWithNullName() {
		BedBuilder bedBuilder = new BedBuilder();
		String result = null;
		bedBuilder.setBedCollectionName(result);
		assertEquals(bedBuilder.getBedCollectionName(), result);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedColor(java.lang.String)}.
	 */
	@Test
	public void testSetBedColor() {
		BedBuilder bedBuilder = new BedBuilder();
		String result = "green";
		bedBuilder.setBedColor(result);
		assertEquals(bedBuilder.getBedColor(), result);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedColor(java.lang.String)}.
	 */
	@Test
	public void testSetBedColorWithNullColor() {
		BedBuilder bedBuilder = new BedBuilder();
		String result = null;
		bedBuilder.setBedColor(result);
		assertEquals(bedBuilder.getBedColor(), result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedParts(java.util.List)}.
	 */
	@Test
	public void testSetBedParts() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bedBuilder.setBedParts(bedParts);
		
		assertEquals(bedBuilder.getBedParts(), bedParts);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedParts(java.util.List)}.
	 */
	@Test
	public void testSetBedPartsWithNullParts() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = null;
	
		bedBuilder.setBedParts(bedParts);
		
		assertEquals(bedBuilder.getBedParts(), bedParts);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedTools(java.util.List)}.
	 */
	@Test
	public void testSetBedTools() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bedBuilder.setBedTools(bedTools);
		
		assertEquals(bedBuilder.getBedTools(), bedTools);
	}
	
	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#setBedTools(java.util.List)}.
	 */
	@Test
	public void testSetBedToolsWithNullTools() {
		BedBuilder bedBuilder = new BedBuilder();
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = null;

		bedBuilder.setBedTools(bedTools);
		
		assertEquals(bedBuilder.getBedTools(), bedTools);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#showBedDetails()}.
	 */
	@Test
	public void testShowBedDetails() {
		System.setOut(new PrintStream(outputStreamCaptor));
		
		BedBuilder bedBuilder = new BedBuilder();
		
		String result = "Ikea";
		bedBuilder.setBedCollectionName(result);
		
		String result2 = "red";
		bedBuilder.setBedColor(result2);
		
		bedBuilder.showBedDetails();
		String expectedOutput = "\tBuilded Bed: \n Collection Name: Ikea\n Color: red\n Parts: null\n Tools: " +null;

		assertEquals(expectedOutput, "\t"+outputStreamCaptor.toString().trim());
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedBuilder#checkBedPartsAndTools()}.
	 */
	@Test
	public void testCheckBedPartsAndToolsReturnTrue() {
		BedBuilder bedBuilder = new BedBuilder();

		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bedBuilder.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bedBuilder.setBedTools(bedTools);
		
		assertTrue(bedBuilder.checkBedPartsAndTools());
		
		
	}
	
	public void testCheckBedPartsAndToolsReturnFalse() {
		BedBuilder bedBuilder = new BedBuilder();

		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bedBuilder.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bedBuilder.setBedTools(bedTools);
		
		assertTrue(bedBuilder.checkBedPartsAndTools());
		
		
	}

}
