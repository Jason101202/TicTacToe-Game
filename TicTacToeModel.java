import javax.swing.JButton;
import java.util.ArrayList;

/**
 * Class TicTacToeModel .
 *
 * Models the squares for the tictactoe game seeing if there is any winners or 
 * ties in the game and resetting the board once a player has won or a tie has
 * occured
 * @author Jason keah
 * @version april 8 2023
 */
public class TicTacToeModel
{
    
    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static final String EMPTY = " ";  // empty cell
    public static int playerMoves = 0;
    
    
    protected static ArrayList<JButton> board; 
    
    TicTacToeModel () {}
    
    /** Sets the board of JButtons for the model to use and organize
     * 
     * @ param board, the bpard of JButtons passed to model
     */
    public void setBoard(ArrayList<JButton> board) {
        this.board = board;
    }
    
    /** Checks if there is a winner in the inputs of the board of JButton
     * 
     * @ return, true if there is a winner or false otherwise
     * 
     */
    public static boolean haveWinner() {


        for (int i = 0; i < 3; i++) {

            // check columns
            if (board.get(i).getLabel().equals(board.get(i+3).getLabel()) && board.get(i).getLabel().equals(board.get(i+6).getLabel()) && !board.get(i).getLabel().equals(EMPTY)) {
                
                return true;
            }
            // check rows
            if (board.get(i*3).getLabel().equals(board.get(i*3+1).getLabel()) && board.get(i*3).getLabel().equals(board.get(i*3+2).getLabel()) && !board.get(i*3).getLabel().equals(EMPTY)) {
                
                return true;
            }
        }

        // check diagonals 1
        if (board.get(0).getLabel().equals(board.get(4).getLabel()) && board.get(0).getLabel().equals(board.get(8).getLabel()) && !board.get(0).getLabel().equals(EMPTY)) {
            return true;
        }

        // check diagonals 2
        if (board.get(2).getLabel().equals(board.get(4).getLabel()) && board.get(2).getLabel().equals(board.get(6).getLabel())&& !board.get(2).getLabel().equals(EMPTY)) {
            return true;
        }

        

        return false;
    };
    
    /**
     *  Disables the entire board once the game has reached a result
     */
     public static void gameResult() {
        if (haveWinner() || playerMoves == 9) {
            for (JButton butt : board) {

                butt.setEnabled(false);
                

            }
        }
    }
}
