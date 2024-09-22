package HW1;

public class RandomWalker {
    private static boolean validate(int row, int col, int n){
        if (row < 0 || row >= n || col < 0 || col >= n) return false;
        return true;
    }
    public static void main(String[] args) {
        if (args.length < 1){
            throw new IllegalArgumentException("Enter the size of grid!");
        }
        int n = Integer.parseInt(args[0]);
        if (n < 1){
            throw new IllegalArgumentException(" Size of grid must be greater than zero! Please try again!");
        }
        // initialize
        boolean[][] visited = new boolean[n][n];
        int cellsNeedToVisit = n * n;
        int steps = 0;
        double probability = 0;
        int currentRow = n / 2, currentCol = n / 2;
        visited[currentRow][currentCol] = true;
        cellsNeedToVisit--;
        // random walk before all cells are touched
        while (cellsNeedToVisit > 0){
            steps++;
            probability = Math.random();
            // convention
            if (probability <= 0.25) currentRow++;
            else if (probability <= 0.5) currentRow--;
            else if (probability <= 0.75) currentCol++;
            else currentCol--;

            if (validate(currentRow, currentCol, n) && !visited[currentRow][currentCol]){
                visited[currentRow][currentCol] = true;
                cellsNeedToVisit--;
            }
        }
        System.out.println("Number of steps need to touch all cells is " + steps);
    }
}
