package adapterPattern.robotBuilder.bed;

import java.util.List;

import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;

//Currently, the code is exposed to the Bed interface.

public interface Bed {

	//it contains set of setters and getters used to get information about the bed

	public String getBedCollectionName();
	public String getBedColor();
	public List<PartEnum> getBedParts();
	public List<ToolEnum> getBedTools();
	
	public void setBedCollectionName(String BedCollectionName);
	public void setBedColor(String BedColor);
	public void setBedParts(List<PartEnum> bedParts);
	public void setBedTools(List<ToolEnum> BedTools);
	
	public void showBedDetails(); 
	public boolean checkBedPartsAndTools();
}