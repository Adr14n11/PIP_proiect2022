package adapterPattern.robotBuilder.table;

import java.util.List;

import adapterPattern.robotBuilder.enums.PartEnum;
import adapterPattern.robotBuilder.enums.ToolEnum;

//The new interface (Target)

public interface Table {

	public String getTableCollectionName();
	public String getTableColor();
	public List<PartEnum> getTableParts();
	public List<ToolEnum> getTableTools();
		
	public void setTableCollectionName(String TableCollectionName);
	public void setTableColor(String TableColor);
	public void setTableParts(List<PartEnum> TableParts);
	public void setTableTools(List<ToolEnum> TableTools);
		
	public void showTableDetails();
	public boolean checkTablePartsAndTools(List<PartEnum> TableParts, List<ToolEnum> TableTools);
}