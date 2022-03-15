package adapterPattern.robotBuilder;

import java.util.ArrayList;
import java.util.List;

import adapterPattern.robotBuilder.bed.Bed;
import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;
import adapterPattern.robotBuilder.table.Table;

//it fulfills the builder's requirement in order to assemble a table
//and also makes less change in the current code

//the adapter wraps a Bed object (the type it supposes to be adapted).

public class BedToTableAdapterBuilder implements Table {

	private String TableCollectionName;
	private String TableColor;
	private List<PartEnum> TableParts;
	private List<ToolEnum> TableTools;
	
	private final Bed bed;
	
	public BedToTableAdapterBuilder(Bed bed) { //passing the Bed object in its constructor, and assigned it to the Table interface
		this.bed = bed;
		setProp(); //is used to set the Bed properties into the Table's object
	}
	
	@Override
	public String getTableCollectionName() {
		return TableCollectionName;
	}

	@Override
	public String getTableColor() {
		return TableColor;
	}

	@Override
	public List<PartEnum> getTableParts() {
		return TableParts;
	}

	@Override
	public List<ToolEnum> getTableTools() {
		return TableTools;
	}

	@Override
	public void setTableCollectionName(String TableCollectionName) {
		this.TableCollectionName = TableCollectionName;	
	}

	@Override
	public void setTableColor(String TableColor) {
		this.TableColor = TableColor;
	}

	@Override
	public void setTableParts(List<PartEnum> TableParts) {
		this.TableParts = TableParts;
	}

	@Override
	public void setTableTools(List<ToolEnum> TableTools) {
		this.TableTools = TableTools;
	}

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
	
	private void setProp(){ //reusing the existing code and adding properties
		
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