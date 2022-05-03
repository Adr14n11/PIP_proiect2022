package adapterPattern.robotBuilder;

import java.util.ArrayList;
import java.util.List;

//The application is initially configured for the robot to assemble a bed, then we want it to assemble a table.

import adapterPattern.robotBuilder.bed.Bed;
import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;
import adapterPattern.robotBuilder.table.Table;

/**
 * This is the class that creates the bed parts and tools and builds the bed. After that it checks if the bed build was successfully.
 * Then using the bed configuration for building the table. Also after that it checks the build.
 */
public class RobotBuilder {

	/** 
	 * The main class.
	 */
	public static void main(String[] args) {
		
		List<PartEnum> bedListParts = new ArrayList<PartEnum>();
		bedListParts.add(PartEnum.Seat);
		bedListParts.add(PartEnum.Backrest);
		bedListParts.add(PartEnum.Handle);
		bedListParts.add(PartEnum.Leg);
		bedListParts.add(PartEnum.Leg);
		bedListParts.add(PartEnum.Leg);
		bedListParts.add(PartEnum.Leg);
		
		List<ToolEnum> bedListTools = new ArrayList<ToolEnum>();
		bedListTools.add(ToolEnum.Screwdriver);
		bedListTools.add(ToolEnum.ImbusKey);
		bedListTools.add(ToolEnum.ScrewsPackOf7);

		Bed bed = new BedBuilder();
		bed.setBedCollectionName("Ikea");
		bed.setBedColor("Black");
		bed.setBedParts(bedListParts);
		bed.setBedTools(bedListTools);
		
		if(bed.checkBedPartsAndTools())
		{
			System.out.println("\tSuccesfully Build");
			bed.showBedDetails();
		}
		else
			System.out.println("!!Failed build, please check the parts and tool");
		
		Table table = new BedToTableAdapterBuilder(bed);
		
		if(table.checkTablePartsAndTools(table.getTableParts(),table.getTableTools())){
			System.out.println("\n\tSuccesfully Build");
			table.showTableDetails();
		}
		else
			System.out.println("!!Failed build, please check the parts and tool");
	}
}
