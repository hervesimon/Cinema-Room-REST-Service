class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int x = twoDimArray.length - 1;
        int y = twoDimArray[x].length - 1;

        System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][y]);
        System.out.println(twoDimArray[x][0] + " " + twoDimArray[x][y]);
    }
}