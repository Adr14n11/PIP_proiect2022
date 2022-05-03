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

	/**
	 * Gets the bed collection name.
	 * @return the collection name of the bed
	 */
	@Override
	public String getBedCollectionName() {
		return BedCollectionName;
	}

	/**
	 * Gets the bed color.
	 * @return the color of the bed
	 */
	@Override
	public String getBedColor() {
		return BedColor;
	}

	/**
	 * Gets the bed parts.
	 * @return the parts needed for the bed
	 */
	@Override
	public List<PartEnum> getBedParts() {
		return BedParts;
	}

	/**
	 * Gets the bed tools.
	 * @return the tools needed for the bed
	 */
	@Override
	public List<ToolEnum> getBedTools() {
		return BedTools;
	}

	/**
	 * Sets the bed collection name.
	 * @param BedCollectionName The collection name of the bed.
	 */
	@Override
	public void setBedCollectionName(String BedCollectionName) {
		this.BedCollectionName = BedCollectionName;
	}

	/**
	 * Sets the bed color.
	 * @param BedColor The color of the bed.
	 */
	@Override
	public void setBedColor(String BedColor) {
		this.BedColor = BedColor;
	}

	/**
	 * Sets the bed parts.
	 * @param BedParts The parts of the bed.
	 */
	@Override
	public void setBedParts(List<PartEnum> BedParts) {
		this.BedParts = BedParts;
	}

	/**
	 * Sets the bed tools.
	 * @param BedTools The tools of the bed.
	 */
	@Override
	public void setBedTools(List<ToolEnum> BedTools) {
		this.BedTools = BedTools;
	}

	/**
	 * Shows the bed details and what's needed for the build.
	 */
	@Override
	public void showBedDetails() {
		System.out.println("\tBuilded Bed: \n"+" Collection Name: "+BedCollectionName+"\n Color: "+BedColor+"\n Parts: "+BedParts+"\n Tools: "+BedTools);
	}

	/**
	 * Checks if the bed has the required parts and tools for the build.
	 */
	@Override
	public boolean checkBedPartsAndTools() {
		if(BedParts.size() == 7 && BedTools.size() == 3)
			return true;
		return false;
	}
}
