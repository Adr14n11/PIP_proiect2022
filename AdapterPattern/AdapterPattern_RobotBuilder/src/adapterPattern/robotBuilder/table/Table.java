package adapterPattern.robotBuilder.table;

import java.util.List;

import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;

/**
 * The new interface (Target)
 *
 */

public interface Table {

	/**
	 * Gets the table collection name.
	 * @return the collection name of the table 
	 */
	public String getTableCollectionName();
	
	/**
	 * Gets the table color.
	 * @return the color of the table 
	 */
	public String getTableColor();
	
	/**
	 * Gets the table parts.
	 * @return the parts needed for the table
	 */
	public List<PartEnum> getTableParts();
	
	/**
	 * Gets the table tools.
	 * @return the tools needed for the table
	 */
	public List<ToolEnum> getTableTools();
		
	/**
	* Sets the table collection name.
	*
	* @param TableCollectionName The collection name of the table.
	*/
	public void setTableCollectionName(String TableCollectionName);
	
	/**
	* Sets the table color.
	*
	* @param TableColor The color of the table.
	*/
	public void setTableColor(String TableColor);
	
	/**
	* Sets the table parts.
	*
	* @param TableParts The parts of the table.
	*/
	public void setTableParts(List<PartEnum> TableParts);
	
	/**
	* Sets the table tools.
	*
	* @param TableTools The tools of the table.
	*/
	public void setTableTools(List<ToolEnum> TableTools);
		
	/**
	 * Shows the table details and what's needed for the build.
	 */
	public void showTableDetails();
	
	/**
	 * Checks if the table has the required parts and tools for the build.
	 */
	public boolean checkTablePartsAndTools(List<PartEnum> TableParts, List<ToolEnum> TableTools);
}