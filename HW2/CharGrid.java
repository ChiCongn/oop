package HW2;
// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid a grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int upperLeftCornerX = 0, upperLeftCornerY = 0;
		int lowerRightCornerX = 0, lowerRightCornerY = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == ch) {
					upperLeftCornerX = i + 1;
					upperLeftCornerY = j + 1;
					break;
				}
			}
			if (upperLeftCornerX != 0) break;
		}
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (grid[i][j] == ch) {
					lowerRightCornerX = i + 1;
					lowerRightCornerY = j + 1;
					break;
				}
			}
			if (lowerRightCornerX != 0) break;
		}

		return (lowerRightCornerX - upperLeftCornerX + 1) * (lowerRightCornerY - upperLeftCornerY + 1);
	}

	private boolean check(int row, int col) {
		char c = grid[row][col];
		int top = 0, bot = 0, right = 0, left = 0;
		int rightBound = grid[0].length;
		int botBound = grid.length;
		int k = row - 1;
		while (k >= 0 && grid[k][col] == c) { // top
			top++;
			k--;
		}
		k = row + 1;
		while (k < botBound && grid[k][col] == c) { // bot
			bot++;
			k++;
		}
		k = col - 1;
		while (k >= 0 && grid[row][k] == c) { // left
			left++;
			k--;
		}
		k = col + 1;
		while (k < rightBound && grid[row][k] == c) { // right
			right++;
			k++;
		}
		if (top < 1) return false;
		return ((top == bot) && (right == left) && (right == top));
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] != ' ' && check(i, j)) {
					count++;
				}
			}
		}
		return count;
	}
	
}
