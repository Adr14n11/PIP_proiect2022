package adapterPattern.robotBuilder;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import adapterPattern.robotBuilder.bed.Bed;

public class BedToTableAdapterBuilderTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	/**
	 * BedToTableAdapterBuilder constructor is not null.
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#BedToTableAdapterBuilder(adapterPattern.robotBuilder.bed.Bed)}.
	 */
	@Test
	public void testCanInstantiateABedToTableAdapter(){
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		assertNotNull(bedToTableAdapterBuilder);
	}
	
	/**
	 * BedToTableAdapterBuilder constructor is null.
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#BedToTableAdapterBuilder(adapterPattern.robotBuilder.bed.Bed)}.
	 */
	@Test
	public void testCanInstantiateANullBedToTableAdapter(){
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = null;
		assertNull(bedToTableAdapterBuilder);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#getTableCollectionName()}.
	 */
	@Test
	public void testGetTableCollectionNameWithName() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableCollectionName("Ikea");
		String result = bedToTableAdapterBuilder.getTableCollectionName();
		assertEquals("Ikea", result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#getTableColor()}.
	 */
	@Test
	public void testGetTableColor() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableColor("white");
		String result = bedToTableAdapterBuilder.getTableColor();
		assertEquals("white", result);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#getTableParts()}.
	 */
	@Test
	public void testGetTableParts() {
        Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableParts(bedParts);

		assertEquals(bedParts, bedToTableAdapterBuilder.getTableParts());
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#getTableTools()}.
	 */
	@Test
	public void testGetTableTools() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableTools(bedTools);

		assertEquals(bedTools, bedToTableAdapterBuilder.getTableTools());
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#setTableCollectionName(java.lang.String)}.
	 */
	@Test
	public void testSetTableCollectionName() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableCollectionName("Ikea");
		String result = bedToTableAdapterBuilder.getTableCollectionName();
		assertEquals(result, "Ikea");
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#setTableColor(java.lang.String)}.
	 */
	@Test
	public void testSetTableColor() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableColor("white");
		String result = bedToTableAdapterBuilder.getTableColor();
		assertEquals(result, "white");
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#setTableParts(java.util.List)}.
	 */
	@Test
	public void testSetTableParts() {
        Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableParts(bedParts);

		assertEquals(bedToTableAdapterBuilder.getTableParts(), bedParts);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#setTableTools(java.util.List)}.
	 */
	@Test
	public void testSetTableTools() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.setTableTools(bedTools);

		assertEquals(bedToTableAdapterBuilder.getTableTools(), bedTools);
	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#showTableDetails()}.
	 */
	@Test
	public void testShowTableDetails() {
		System.setOut(new PrintStream(outputStreamCaptor));
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		bedToTableAdapterBuilder.showTableDetails();
		String expectedOutput = "\tBuilded Table: \n Collection Name: Ikea\n Color: green\n Parts: [TableTop, Leg, Leg, Leg, Leg]\n Tools: [Hammer, ImbusKey, NailsPackOf5, ScrewsPackOf4]";

		assertEquals(expectedOutput, "\t"+outputStreamCaptor.toString().trim());	}

	/**
	 * Test method for {@link adapterPattern.robotBuilder.BedToTableAdapterBuilder#checkTablePartsAndTools(java.util.List, java.util.List)}.
	 */
	@Test
	public void testCheckTablePartsAndTools() {
		Bed bed = new BedBuilder();
		
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("green");
		
		List<adapterPattern.robotBuilder.enums.PartEnum> bedParts = new ArrayList <adapterPattern.robotBuilder.enums.PartEnum>();
		
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Seat);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Backrest);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Handle);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
		bedParts.add(adapterPattern.robotBuilder.enums.PartEnum.Leg);
	
		bed.setBedParts(bedParts);
		
		List<adapterPattern.robotBuilder.enums.ToolEnum> bedTools = new ArrayList <adapterPattern.robotBuilder.enums.ToolEnum>();
		
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.Screwdriver);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ImbusKey);
		bedTools.add(adapterPattern.robotBuilder.enums.ToolEnum.ScrewsPackOf7);
	
		bed.setBedTools(bedTools);
		
		BedToTableAdapterBuilder bedToTableAdapterBuilder = new BedToTableAdapterBuilder(bed);
		assertTrue(bedToTableAdapterBuilder.checkTablePartsAndTools(bedToTableAdapterBuilder.getTableParts(), bedToTableAdapterBuilder.getTableTools()));
	}

}
