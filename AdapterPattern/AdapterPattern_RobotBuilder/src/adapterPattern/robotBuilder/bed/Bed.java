package adapterPattern.robotBuilder.bed;

import java.util.List;

import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;

/**
 * Currently, the code is exposed to the Bed interface.
 * It contains set of setters and getters used to get information about the bed.
 * {@link #getBedCollectionName()}
 * {@link #getBedColor()}
 * {@link #getBedParts()}
 * {@link #getBedTools()}
 * {@link #setBedCollectionName(String)}
 * {@link #setBedColor(String)}
 * {@link #setBedParts(List)}
 * {@link #setBedTools(List)}
 */
public interface Bed {

	/**
	 * Gets the bed collection name.
	 * @return the collection name of the bed
	 */
	public String getBedCollectionName();
	
	/**
	 * Gets the bed color.
	 * @return the color of the bed
	 */
	public String getBedColor();
	
	/**
	 * Gets the bed parts.
	 * @return the parts needed for the bed
	 */
	public List<PartEnum> getBedParts();
	
	/**
	 * Gets the bed tools.
	 * @return the tools needed for the bed
	 */
	public List<ToolEnum> getBedTools();
	
	/**
	 * Sets the bed collection name.
	 * @param BedCollectionName The collection name of the bed.
	 */
	public void setBedCollectionName(String BedCollectionName);
	
	/**
	 * Sets the bed color.
	 * @param BedColor The color of the bed.
	 */
	public void setBedColor(String BedColor);
	
	/**
	 * Sets the bed parts.
	 * @param BedParts The parts of the bed.
	 */
	public void setBedParts(List<PartEnum> bedParts);
	
	/**
	 * Sets the bed tools.
	 * @param BedTools The tools of the bed.
	 */
	public void setBedTools(List<ToolEnum> BedTools);
	
	/**
	 * Shows the bed details and what's needed for the build.
	 */
	public void showBedDetails(); 
	
	/**
	 * Checks if the bed has the required parts and tools for the build.
	 */
	public boolean checkBedPartsAndTools();
}