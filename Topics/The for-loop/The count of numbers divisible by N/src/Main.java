import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int divideBy = scanner.nextInt();
        int count = 0;
        
        for (int i = start; i <= end; i++) {
            if( i % divideBy == 0 ){
                count++;
            }
        }
        System.out.println(count);
    }
}
