import java.util.Scanner;

class b {
    public static void main(String[] args) {
        XO g = new XO();
        g.play();        
    }
}
class XO {
    private final int MINIMUM_NUM = 5;
    private int gameCounter = 0;
    private String[] board = makeBoard();
    private Scanner scanner = new Scanner(System.in);
    private String location;
    String[] makeBoard() {
        String[] s = new String[9];
        for (int i=0; i<9; i++) {
            s[i] = (i + 1) + "";
        }
        return s;
    }
    void showBord() {
        int i = 0;
        System.out.println(board[i] + " | " + board[i+1] + " | " + board[i+2]);
        System.out.println(board[i+3] + " | " + board[i+4] + " | " + board[i+5]);
        System.out.println(board[i+6] + " | " + board[i+7] + " | " + board[i+8]);
    }
    void takeInput() {
        showBord();
        System.out.println("Enter location 1 : 9");
        location = scanner.nextLine();
        for (int j=0; j<board.length; j++) {
            if (board[j].equals(location)) {
                board[j] = (gameCounter % 2 == 0) ? "X" : "O";
                break;
            }
        }
        gameCounter++;
    }
    void play() {
        for (int i=0; i<MINIMUM_NUM; i++) {
            takeInput();
        }
        while (!isFinished() && gameCounter < 9) {
            takeInput();
        }
        showBord();
    }
    boolean isFinished() {
        for (int i=0; i<3; i++) {
            if ((board[0 + 3*i].equals(board[1 + 3*i]) && board[0 + 3*i].equals(board[2 + 3*i]))) {
                return true;
            }
        }
        for (int i=0; i<3; i++) {
            if ((board[i].equals(board[i + 3])) && (board[i].equals(board[i + 6]))) {
                return true;
            }
        }
        if ((board[0].equals(board[4])) && (board[0].equals(board[8]))) {
            return true;
        }
        if ((board[2].equals(board[4])) && (board[2].equals(board[6]))) {
            return true;
        }
        return false;
    }
}