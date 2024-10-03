
package HW2;//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private boolean[][] grid;
	private int length;
	private int width;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid a grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
		length = grid.length;
		width = grid[0].length;
	}

	/**
	 * check whether this row is full.
	 * @param row the current row
	 * @return true if this row is full, otherwise false
	 */
	private boolean isFull(int row) {
		for (int col = 0; col < width; col++) {
			if (!grid[row][col]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * pour data which is in the upper cell down.
	 * @param row the deleted row
	 */
	private void pourDown(int row) {
		for (int i = row; i > 0; i--) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = grid[i - 1][j];
			}
		}
		for (int j = 0; j < width; j++) {
			grid[0][j] = false;
		}
	}

	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for (int i = 0; i < length; i++) {
			if (isFull(i)) {
				pourDown(i);
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	public boolean[][] getGrid() {
		return grid;
	}
}
