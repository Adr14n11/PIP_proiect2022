package tramvaie;

public class Main {

	public static void main(String[] args) {
		
		//am creat cateva zone de interes
		TramvaieDeInteres Cod2216_momentul1 = new TramvaieDeInteres("Tramvaiul 13", 47.148753, 27.620484); //tramvaiul1 in momentul de timp 1
		TramvaieDeInteres Cod2216_momentul2 = new TramvaieDeInteres("Tramvaiul 13", 47.147880, 27.603558); //tramvaiul1 in momentuld e timp 2
		 
		// afisam elementele create:
		Cod2216_momentul1.afisare();
		Cod2216_momentul2.afisare();
		
	}

}