package finalassignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static finalassignment2.EvolutionResult.ROWS;
import static finalassignment2.EvolutionResult.COLUMNS;

/*
 * This class members offer the following functionality:
 * 		1. Finding the state of Individual cell
 * 		2. Finding the state of Whole Grid after one Evolution
 */
public class CellBehavior {
	
	//Initializing a grid of length(no. of rows) and width(no. of columns)
	private static boolean[][]	gridStatus = new boolean[ROWS][COLUMNS];
	
	//Pattern on the Grid after checking all automats for one Evolution
	public static boolean[][] changeGridState(boolean[][] gridStatus) {
		CellBehavior.gridStatus = gridStatus;
		boolean[][] newAliveGrid = generateFreshGrid(false);
		for (int i=gridStatus.length-1; i>=0; i--) {
			for (int j=gridStatus[i].length-1; j>=0 ; j--) {
				newAliveGrid[i][j] = findSingleAutomatState(i, j);
			}
		}
		return newAliveGrid;
	}
	
	// Generates a new grid of automats with state of your choice
	public static boolean[][] generateFreshGrid(boolean state){
		boolean[][] newArray = new boolean[gridStatus.length][gridStatus[0].length];
		for (int i = 0; i < gridStatus.length; i++) {
			for (int j = 0; j < gridStatus[i].length; j++) {
				newArray[i][j] = state;
			}
		}
		return newArray;
	}
	
	//Individual automat state based on its neighbors
	public static boolean findSingleAutomatState(int rowPos, int colPos) {
		/* Defining the neighbors for the automat a[r][c]; r=row, c=column
		 * 8 neighbors are:
		 * a[r-1][c-1],   a[r-1][c],	a[r-1][c+1]
		 * a[r][c-1], 					a[r][c+1]
		 * a[r+1][c-1],   a[r+1][c], 	a[r+1][c+1]
		 */
		boolean topLeft = fetchNeighborState(rowPos-1, colPos-1);
		boolean topMiddle = fetchNeighborState(rowPos-1, colPos);
		boolean topRight = fetchNeighborState(rowPos-1, colPos+1);
		boolean left = fetchNeighborState(rowPos, colPos-1);
		boolean right = fetchNeighborState(rowPos, colPos+1);
		boolean bottomLeft = fetchNeighborState(rowPos+1, colPos-1);
		boolean bottomMiddle = fetchNeighborState(rowPos+1, colPos);
		boolean bottomRight = fetchNeighborState(rowPos+1, colPos+1);
		List<Boolean> statusList = new ArrayList();
		Collections.addAll(statusList, 
				topLeft, topMiddle, topRight,
				left, right,
				bottomLeft, bottomMiddle, bottomRight);
		int aliveCount = Collections.frequency(statusList, true);
		boolean flag = false;
		//If the current cell under consideration is dead
		if(gridStatus[rowPos][colPos]==false) {
			if(aliveCount==3)
				flag = true;
		}
		//If the current cell under consideration is alive
		else {
			if(aliveCount<2 || aliveCount>3)
				flag = false;
			else
				flag = true;
		}
		return flag;
	}
	
	//To take care of cells along the edges
	public static boolean fetchNeighborState(int rowPos, int columnPos) {
		boolean b = false;
		try {
			b = gridStatus[rowPos][columnPos];
			return b;
		} catch (IndexOutOfBoundsException e) {
			return b;
		}
	}
}
