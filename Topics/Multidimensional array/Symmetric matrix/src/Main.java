import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = scanner.nextInt();

        int matrix[][] = new int[dimension][dimension];

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        final String SYMETRIC_NO = "NO";
        final String SYMETRIC_YES = "YES";

        boolean isSymetric = true;

        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                isSymetric &= matrix[i][j] == matrix[j][i];
            }
        }

        if (isSymetric) {
            System.out.println(SYMETRIC_YES);
        } else {
            System.out.println(SYMETRIC_NO);
        }
    }
}