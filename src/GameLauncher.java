import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        XO g = new XO();
        g.play();
    }
}
class XO {
    private final int MINIMUM_NUM = 5;
    private int gameCounter = 0;
    private char[] board = makeBoard();
    private Scanner scanner = new Scanner(System.in);
    private char location;
    private char[] makeBoard() {
        char[] initialBoard = new char[9];
        // for (int i=0; i<9; i++) {
            initialBoard[0] = '1';
            initialBoard[1] = '2';
            initialBoard[2] = '3';
            initialBoard[3] = '4';
            initialBoard[4] = '5';
            initialBoard[5] = '6';
            initialBoard[6] = '7';
            initialBoard[7] = '8';
            initialBoard[8] = '9';
        // }
        return initialBoard;
    }
    private void showBord() {
        int i = 0;
        System.out.println(board[i] + " | " + board[i+1] + " | " + board[i+2]);
        System.out.println(board[i+3] + " | " + board[i+4] + " | " + board[i+5]);
        System.out.println(board[i+6] + " | " + board[i+7] + " | " + board[i+8]);
    }
    private void takeInput() {
        boolean isFouned = false;
        showBord();
        while (!isFouned) {
            System.out.println("Enter location 1 : 9");
            location = (scanner.nextLine().trim()).charAt(0);
            if (!Character.isDigit(location)) {
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
        for (int i=0; i<MINIMUM_NUM; i++) {
            takeInput();
        }
        while (!isFinished() && gameCounter < 9) {
            takeInput();
        }
        showBord();
    }
    private boolean isFinished() {
        for (int i=0; i<3; i++) {
            if ((board[0 + 3*i] == (board[1 + 3*i]) && board[0 + 3*i] == (board[2 + 3*i]))) {
                return true;
            }
        }
        for (int i=0; i<3; i++) {
            if ((board[i] == (board[i + 3])) && (board[i] == (board[i + 6]))) {
                return true;
            }
        }
        if ((board[0] == (board[4])) && (board[0] == (board[8]))) {
            return true;
        }
        if ((board[2] == (board[4])) && (board[2] == (board[6]))) {
            return true;
        }
        return false;
    }
}