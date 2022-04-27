package tramvaie;

public class Main {

	public static void main(String[] args) {
		
		
		TramvaieDeInteres Cod2216_momentul1 = new TramvaieDeInteres("Tramvaiul 13", 47.148753, 27.620484); //tramvaiul1 in momentul de timp 1
		TramvaieDeInteres Cod2216_momentul2 = new TramvaieDeInteres("Tramvaiul 13", 47.147880, 27.603558); //tramvaiul1 in momentuld e timp 2
		 
		
		ZoneDeInteres uaic = new ZoneDeInteres("Universitatea Alexandru Ioan Cuza", 47.1747724305297, 27.5724000042106);		
			
		ZoneDeInteres.seApropieTramvaiDeZona(uaic, Cod2216_momentul1, Cod2216_momentul2); 
		
	}

}