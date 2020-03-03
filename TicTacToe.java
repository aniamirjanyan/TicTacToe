import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static final int krestik = 1, nolik = 2, datark = 0;
    public static final int rows = 3, cols =3;
    public static int[][] board = new int[rows][cols];
    public static Scanner in = new Scanner(System.in);
// ------------ MAIN
    public static void main(String[] args) {
        printBoard();
        System.out.println("You are X. Computer is O.");
        while (true){
            turn();
            printBoard();
            if(gameOver())
            {
                break;
            }
            random();
            printBoard();
            if(gameOver())
            {
                break;
            }
        }
    }
// ------------ Our turn
    public static void turn() {
        System.out.println("input the first coordinate (rows-0-2): ");
        int row = in.nextInt();
        System.out.println("input the second coordinate (columns-0-2): ");
        int col = in.nextInt();
        //check for valid number
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (board[row][col] == 0) {
                board[row][col] = krestik;
            } else {
                System.out.println("input an empty space coordinates");
                turn();
            }
        } else {
            System.out.println("please input a valid coordinate");
            turn();
        }
    }
// ------------ Computer is playing
    public static void random() {
        Random rand = new Random();
        int r1 = rand.nextInt(3);
        int r2 = rand.nextInt(3);
        if (board[r1][r2] == datark) {
            board[r1][r2] = nolik;
        } else { random();}
    }
// ------------ Printing the board
    public static void printBoard() {
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                System.out.print(printNshan(board[row][col]));
                if (col != cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row != rows - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }
// ------------ Symbols according to the numbers
    public static String printNshan(int nshan) {
        switch (nshan) {
            case datark:
                return "   ";
            case nolik:
                return " O ";
            case krestik:
                return " X ";
        }
        return "";
    }
    // ----------- Checks if there is a winner
    public static boolean gameOver () {
        int sum = 0;
        // ---- checking the rows
        for (int i = 0; i < (board.length); i++) {
            for (int j = 0; j < (board.length-1); j++) {
                if (board[i][j] == board[i][j + 1] && board[i][j] != 0) {
                    sum += 1;
                }
                if (sum == 2) {
                    System.out.println(printNshan(board[i][j]) + "has won!");
                    return true;
                }
            }
            sum = 0;
        }
        sum = 0;
        // ---- checking the columns
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < (board.length - 1); j++) {
                if (board[j][i] == board[j + 1][i] && board[j][i] != 0) {
                    sum += 1;
                }
                if (sum == 2) {
                    System.out.println(printNshan(board[j][i]) + "has won!");
                    return true;
                }
            }
            sum = 0;
            // ---- ankyunagic
            if (i == 0) {
                for (int k = i, g = i; k < (board.length - 1); k++, g++) {
                    if (board[k][g] == board[k + 1][g + 1] && board[k + 1][g + 1] != 0) {
                        sum += 1;
                    }
                }
                    if (sum == 2) {
                        System.out.println(printNshan(board[i][i]) + "has won!");
                    return true;
                    }
            }
            sum = 0;
            // ---- hakarak ankyunagic
            if (i == (board.length-1)) {
                for (int k = 0, g = i; k < (board.length-1); k++, g--) {
                    if (board[k][g] == board[k + 1][g - 1] && board[k + 1][g - 1] != 0) {
                        sum += 1;
                    }
                }
                    if (sum == 2) {
                        System.out.println(printNshan(board[0][i]) + "has won!");
                        return true;
                    }
            }
        }
        sum = 0;
        // --------------- draw
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        System.out.println("nichya");
        return true;
    }
}
