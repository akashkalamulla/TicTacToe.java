import java.util.Scanner;

public class App {
    private static char[] board = new char[9];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            playerMove(currentPlayer);
            printBoard();

            if (isVictory(currentPlayer)) {
                System.out.println(currentPlayer + " Wins! Congratulations!");
                break;
            } else if (isDraw()) {
                System.out.println("The game is a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    private static void printBoard() {
        System.out.println();
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println();
    }

    private static void playerMove(char icon) {
        int number = (icon == 'X') ? 1 : 2;
        System.out.println("Your turn player " + number);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (board[choice - 1] == ' ') {
            board[choice - 1] = icon;
        } else {
            System.out.println();
            System.out.println("That space is taken!");
        }
    }

    private static boolean isVictory(char icon) {
        if ((board[0] == icon && board[1] == icon && board[2] == icon) ||
                (board[3] == icon && board[4] == icon && board[5] == icon) ||
                (board[6] == icon && board[7] == icon && board[8] == icon) ||
                (board[0] == icon && board[3] == icon && board[6] == icon) ||
                (board[1] == icon && board[4] == icon && board[7] == icon) ||
                (board[2] == icon && board[5] == icon && board[8] == icon) ||
                (board[0] == icon && board[4] == icon && board[8] == icon) ||
                (board[2] == icon && board[4] == icon && board[6] == icon)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isDraw() {
        for (char space : board) {
            if (space == ' ') {
                return false;
            }
        }
        return true;
    }
}