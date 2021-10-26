import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();

        int matrix[][] = new int[rows][seats];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < seats; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int numberOfTicketToBuy = scanner.nextInt(), rowToUse = 0;

        for(int row = 0; row < rows; row++) {
            int seatAvailableInTheRow = 0;
            if( rowToUse != 0){
                break;
            }
            for(int seat = 0; seat < seats; seat++) {
                if( matrix[row][seat] == 0 ){
                    ++seatAvailableInTheRow;
                    if( seatAvailableInTheRow == numberOfTicketToBuy){
                        rowToUse = row + 1;
                        break;
                    }
                }else{
                    seatAvailableInTheRow = 0;
                }
            }
        }

        System.out.println(rowToUse);
    }
}