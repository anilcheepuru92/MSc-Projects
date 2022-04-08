package finalassignment2;

/*
 * This class members offer the following functionality:
 * 		1. Stores the Data required for the logic
 * 		2. Choosing the correct pattern to start with
 * 		3. Logic to iterate till the required evolution
 */
public class EvolutionResult {
	public static final int ROWS = 40;
	public static final int COLUMNS = 40;
	public static final boolean[][] EXAMPLEPATTERN = CellBehavior.generateFreshGrid(false);
	public static final boolean[][] PATTERN1 = CellBehavior.generateFreshGrid(false);
	public static final boolean[][] PATTERN2 = CellBehavior.generateFreshGrid(false);
	public static final boolean[][] PATTERN3 = CellBehavior.generateFreshGrid(false);
	
	//Iterates if necessary to fetch the required pattern
	public static boolean[][] getFinalPattern(String reqPattern, int reqEvolution) throws Exception {
		boolean[][] gridWithPattern = getInitialPattern(reqPattern);
		if (reqEvolution==1) {			//1 implies the original pattern itself
			return gridWithPattern;
		}
		for (int i = 1; i <= reqEvolution-1; i++) {
			boolean[][] pattern = CellBehavior.changeGridState(gridWithPattern);
			gridWithPattern = pattern;
		}
		return gridWithPattern;
	}
	
	//Returns the correct pattern to start with based on user input
	public static boolean[][] getInitialPattern(String reqPattern) throws Exception{
		//Example Pattern: 
		EXAMPLEPATTERN[(ROWS/2)-2][1] = true;
		EXAMPLEPATTERN[(ROWS/2)-1][2] = true;	
		EXAMPLEPATTERN[(ROWS/2)][0] = true;		
		EXAMPLEPATTERN[(ROWS/2)][1] = true;
		EXAMPLEPATTERN[(ROWS/2)][2] = true;
		//Pattern1
		PATTERN1[(ROWS/2)-1][(COLUMNS/2)-2] = true;
		PATTERN1[(ROWS/2)-1][(COLUMNS/2)-1] = true;
		PATTERN1[(ROWS/2)][(COLUMNS/2)-2] = true;
		PATTERN1[(ROWS/2)][(COLUMNS/2)-1] = true;
		//Pattern2
		PATTERN2[(ROWS/2)-2][ (COLUMNS/2)-2] = true;
		PATTERN2[(ROWS/2)-2][ (COLUMNS/2)-1] = true;
		PATTERN2[(ROWS/2)-2][ (COLUMNS/2)] = true;
		PATTERN2[(ROWS/2)-2][ (COLUMNS/2)+1] = true;
		PATTERN2[(ROWS/2)-1][ (COLUMNS/2)-3] = true;
		PATTERN2[(ROWS/2)-1][ (COLUMNS/2)+1] = true;
		PATTERN2[(ROWS/2)][ (COLUMNS/2)+1] = true;
		PATTERN2[(ROWS/2)+1][ (COLUMNS/2)-3] = true;
		PATTERN2[(ROWS/2)+1][ (COLUMNS/2)] = true;
		//Pattern3
		PATTERN3[(ROWS/2)-5][ (COLUMNS/2)+1] = true;
		PATTERN3[(ROWS/2)-4][ (COLUMNS/2)] = true;
		PATTERN3[(ROWS/2)-3][ (COLUMNS/2)] = true;
		PATTERN3[(ROWS/2)-3][ (COLUMNS/2)+1] = true;
		PATTERN3[(ROWS/2)-3][ (COLUMNS/2)+2] = true;
		PATTERN3[(ROWS/2)+1][ (COLUMNS/2)-1] = true;
		PATTERN3[(ROWS/2)+1][ (COLUMNS/2)] = true;
		PATTERN3[(ROWS/2)+2][ (COLUMNS/2)-1] = true;
		PATTERN3[(ROWS/2)+2][ (COLUMNS/2)] = true;
		boolean[][] gridWithPattern;
		switch (reqPattern) {
			case "example":
				gridWithPattern = EXAMPLEPATTERN;
				break;
			case "pattern1":
				gridWithPattern = PATTERN1;
				break;
			case "pattern2":
				gridWithPattern = PATTERN2;
				break;
			case "pattern3":
				gridWithPattern = PATTERN3;
				break;
			default:
				throw new Exception("PATTERN NAME IS INVALID. CHECK AND TRY AGAIN");
		}
		return gridWithPattern;
	}

}
