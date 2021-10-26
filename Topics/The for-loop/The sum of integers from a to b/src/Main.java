import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int count = start + end;
        for (int i = start + 1; i < end; i++) {
            count += i;
        }
        System.out.println(count);
    }
}
