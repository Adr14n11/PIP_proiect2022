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
	 * 
	 * @param bed a Bed object passed to the constructor and it supposes to be adapted
	 */
	public BedToTableAdapterBuilder(Bed bed) { 
		this.bed = bed;
		/**
		 * @see #setProp()
		 * is used to set the Bed properties into the Table's object*/
		setProp(); 
	}
	
	/**
	 * @return the collection name of the table 
	 */
	@Override
	public String getTableCollectionName() {
		return TableCollectionName;
	}

	/**
	 * @return the color of the table 
	 */
	@Override
	public String getTableColor() {
		return TableColor;
	}

	/**
	 * @return the parts needed for the table
	 */
	@Override
	public List<PartEnum> getTableParts() {
		return TableParts;
	}

	/**
	 * @return the tools needed for the table
	 */
	@Override
	public List<ToolEnum> getTableTools() {
		return TableTools;
	}

	/**
	* Sets the Table Collection Name.
	*
	* @param TableCollectionName the collection name of the table
	*/
	@Override
	public void setTableCollectionName(String TableCollectionName) {
		this.TableCollectionName = TableCollectionName;	
	}

	/**
	* Sets the Table Color.
	*
	* @param TableColor the color of the table
	*/
	@Override
	public void setTableColor(String TableColor) {
		this.TableColor = TableColor;
	}

	/**
	* Sets the Table Parts.
	*
	* @param TableParts the parts of the table
	*/
	@Override
	public void setTableParts(List<PartEnum> TableParts) {
		this.TableParts = TableParts;
	}

	/**
	* Sets the Table Tools.
	*
	* @param TableTools the tools of the table
	*/
	@Override
	public void setTableTools(List<ToolEnum> TableTools) {
		this.TableTools = TableTools;
	}

	/**
	 * 
	 */
	@Override
	public void showTableDetails() {
		System.out.println("\tBuilded Table: \n"+" Collection Name: "+TableCollectionName+"\n Color: "+TableColor+"\n Parts: "+TableParts+"\n Tools: "+TableTools);
	}

	@Override
	public boolean checkTablePartsAndTools(List<PartEnum> TableParts, List<ToolEnum> TableTools) {
		if(TableParts.size() == 5 && TableTools.size() == 4)
			return true;
		return false;
	}
	
	private void setProp(){ /**reusing the existing code and adding properties*/
		
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