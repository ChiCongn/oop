package HW1;

public class Transpose {
    public static void main(String[] args) {
        if (args.length < 1){
            throw new IllegalArgumentException(" Enter the size of matrix!");
        }
        int n = Integer.parseInt(args[0]);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = n * i + j + 1;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        // transpose
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("The matrix after transposing");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
