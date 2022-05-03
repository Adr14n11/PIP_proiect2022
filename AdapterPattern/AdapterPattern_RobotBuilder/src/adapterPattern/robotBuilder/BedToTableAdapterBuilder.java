package adapterPattern.robotBuilder;

import java.util.ArrayList;
import java.util.List;

import adapterPattern.robotBuilder.bed.Bed;
import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;
import adapterPattern.robotBuilder.table.Table;

/**
 *It fulfills the builder's requirement in order to assemble a table
 *and also makes less change in the current code
 *the adapter wraps a Bed object (the type it supposes to be adapted).
 */
public class BedToTableAdapterBuilder implements Table {

	private String TableCollectionName;
	private String TableColor;
	private List<PartEnum> TableParts;
	private List<ToolEnum> TableTools;
	
	private final Bed bed;
	
	/** 
	 * @param bed A Bed object passed to the constructor and it supposes to be adapted.
	 */
	public BedToTableAdapterBuilder(Bed bed) { 
		this.bed = bed;
		setProp(); 
	}
	
	/**
	 * Gets the table collection name.
	 * @return the collection name of the table 
	 */
	@Override
	public String getTableCollectionName() {
		return TableCollectionName;
	}

	/**
	 * Gets the table color.
	 * @return the color of the table 
	 */
	@Override
	public String getTableColor() {
		return TableColor;
	}

	/**
	 * Gets the table parts.
	 * @return the parts needed for the table
	 */
	@Override
	public List<PartEnum> getTableParts() {
		return TableParts;
	}

	/**
	 * Gets the table tools.
	 * @return the tools needed for the table
	 */
	@Override
	public List<ToolEnum> getTableTools() {
		return TableTools;
	}

	/**
	* Sets the table collection name.
	*
	* @param TableCollectionName The collection name of the table.
	*/
	@Override
	public void setTableCollectionName(String TableCollectionName) {
		this.TableCollectionName = TableCollectionName;	
	}

	/**
	* Sets the table color.
	*
	* @param TableColor The color of the table.
	*/
	@Override
	public void setTableColor(String TableColor) {
		this.TableColor = TableColor;
	}

	/**
	* Sets the table parts.
	*
	* @param TableParts The parts of the table.
	*/
	@Override
	public void setTableParts(List<PartEnum> TableParts) {
		this.TableParts = TableParts;
	}

	/**
	* Sets the table tools.
	*
	* @param TableTools The tools of the table.
	*/
	@Override
	public void setTableTools(List<ToolEnum> TableTools) {
		this.TableTools = TableTools;
	}

	/**
	 * Shows the table details and what's needed for the build.
	 */
	@Override
	public void showTableDetails() {
		System.out.println("\tBuilded Table: \n"+" Collection Name: "+TableCollectionName+"\n Color: "+TableColor+"\n Parts: "+TableParts+"\n Tools: "+TableTools);
	}

	/**
	 * Checks if the table has the required parts and tools for the build.
	 */
	@Override
	public boolean checkTablePartsAndTools(List<PartEnum> TableParts, List<ToolEnum> TableTools) {
		if(TableParts.size() == 5 && TableTools.size() == 4)
			return true;
		return false;
	}
	
	/**
	 * Reusing the existing code and adding properties.
	 * Is used to set the Bed properties into the Table's object.
	 */
	private void setProp(){ 
		
		List<PartEnum> newPartList = new ArrayList<PartEnum>();
		newPartList.add(PartEnum.TableTop);
		newPartList.addAll(this.bed.getBedParts().subList(3, 7));
		
		List<ToolEnum> newToolList = new ArrayList<ToolEnum>();
		newToolList.add(ToolEnum.Hammer);
		newToolList.addAll(this.bed.getBedTools().subList(1, 2));
		newToolList.add(ToolEnum.NailsPackOf5);
		newToolList.add(ToolEnum.ScrewsPackOf4);
		
		
		setTableCollectionName(this.bed.getBedCollectionName());
		setTableColor(this.bed.getBedColor());
		setTableParts(newPartList);
		setTableTools(newToolList);
		checkTablePartsAndTools(newPartList, newToolList);
	}
}