import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
       new XO().play();
    }
}
class XO {
    private static final int MINIMUM_NUM_OF_TRY = 5;
    private int gameCounter = 0;
    private char[] board = makeBoard();
    private Scanner scanner = new Scanner(System.in);
    private char location;

    private char[] makeBoard() {
        char[] initialBoard = new char[9];
        for (int i=0; i<9; i++) {
            initialBoard[i] = (char)(i + 1 + '0');
        }
        return initialBoard;
    }
    private void showBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
    private void takeInput() {
        boolean isFouned = false;
        while (!isFouned) {
            showBoard();
            System.out.println("Enter location 1 : 9");
            location = (scanner.nextLine().trim()).charAt(0);
            if (!Character.isDigit(location)) {
                System.out.println("Enter a valid number");
                continue;
            }
            for (int j=0; j<board.length; j++) {
                if (board[j] == location) {
                    isFouned = true;
                    board[j] = (gameCounter % 2 == 0) ? 'X' : 'O';
                    break;
                }
            }
        }
        gameCounter++;
    }
    public void play() {
        for (int i=0; i<MINIMUM_NUM_OF_TRY; i++) {
            takeInput();
        }
        while (!isFinished() && gameCounter < 9) {
            takeInput();
        }
        endGame();
    }
    private boolean isFinished() {
        for (int i=0; i<3; i++) { // horizontal check
            if ((board[3*i] == (board[1 + 3*i]) && board[3*i] == (board[2 + 3*i]))) {
                return true;
            }
        }
        for (int i=0; i<3; i++) { // vertical check
            if ((board[i] == (board[i + 3])) && (board[i] == (board[i + 6]))) {
                return true;
            }
        }
        if ((board[0] == (board[4])) && (board[0] == (board[8]))) { // diagonal check
            return true;
        }
        if ((board[2] == (board[4])) && (board[2] == (board[6]))) { // diagonal check
            return true;
        }
        return false;
    }
    public void endGame() {
        showBoard();
        System.out.println("Game ended");
        if (gameCounter < 9 || isFinished()) {
            System.out.println(((gameCounter % 2 == 0) ? "O won" : "X won"));
        }
        else {
            System.out.println("DRAW");
        }
    }
}