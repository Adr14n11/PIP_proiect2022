package adapterPattern.robotBuilder;

import java.util.List;

import adapterPattern.robotBuilder.bed.Bed;
import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;

/**The following class defines the implementation to the Bed interface*/
public class BedBuilder implements Bed{
	
	private String BedCollectionName;
	private String BedColor;
	private List<PartEnum> BedParts;
	private List<ToolEnum> BedTools;

	@Override
	public String getBedCollectionName() {
		return BedCollectionName;
	}

	@Override
	public String getBedColor() {
		return BedColor;
	}

	@Override
	public List<PartEnum> getBedParts() {
		return BedParts;
	}

	@Override
	public List<ToolEnum> getBedTools() {
		return BedTools;
	}

	@Override
	public void setBedCollectionName(String BedCollectionName) {
		this.BedCollectionName = BedCollectionName;
	}

	@Override
	public void setBedColor(String BedColor) {
		this.BedColor = BedColor;
	}

	@Override
	public void setBedParts(List<PartEnum> BedParts) {
		this.BedParts = BedParts;
	}

	@Override
	public void setBedTools(List<ToolEnum> BedTools) {
		this.BedTools = BedTools;
	}

	@Override
	public void showBedDetails() {
		System.out.println("\tBuilded Bed: \n"+" Collection Name: "+BedCollectionName+"\n Color: "+BedColor+"\n Parts: "+BedParts+"\n Tools: "+BedTools);
	}

	@Override
	public boolean checkBedPartsAndTools() {
		if(BedParts.size() == 7 && BedTools.size() == 3)
			return true;
		return false;
	}
}
