import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt(),
                numberOfA = 0,
                numberOfB = 0,
                numberOfC = 0,
                numberOfD = 0;

        for (int i = 0; i < numberOfElements; i++) {
            int element = scanner.nextInt();

            switch (element) {
                case 5:
                    numberOfA++;
                    break;
                case 4:
                    numberOfB++;
                    break;
                case 3:
                    numberOfC++;
                    break;
                case 2:
                    numberOfD++;
                    break;
                default: //do nothing;
            }
        }

        System.out.println(numberOfD + " " + numberOfC + " " + numberOfB + " " + numberOfA);
    }
}