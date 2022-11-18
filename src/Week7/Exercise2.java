package Week7;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        int row;
        int column;
        int scale;

        System.out.println("How many row do you want?");
        row = myObj.nextInt();
        System.out.println("How many column do you want?");
        column = myObj.nextInt();
        System.out.println("Choose scale of number (less than 10)");
        scale = myObj.nextInt();

        int[][] original = makeOriginal(row, column, scale);
        int[][] transpose = makeTranspose(row, column, original);

        System.out.println("Your original 2-D array is ");
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
                System.out.print(original[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Your transpose 2-D array is ");
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static int[][] makeTranspose(int row, int column, int[][] original) {

        int[][] transpose = new int[column][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                transpose[i][j] = original[j][i];
            }
        }
        return transpose;
    }


    private static int[][] makeOriginal(int row, int column, int scale) {

        int[][] original = new int[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                original[i][j] = (int) (Math.random()*scale) + 1;
            }
        }
        return original;
    }
}
