import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.awt.Image;


/**
 * Cass TIcTacToeController 
 * 
 * The controller part of the user-interface for the TicTacToe game, 
 * built from the Swing and AWT frameworks.
 * 
 * This version of the controller is the listerner for the games GUI's buttons.
 *
 * @author Jason keah
 * @version April 8, 2023
 */
public class TIcTacToeController
{
    private TicTacToeModel model;
    private TicTacToeView view;
    
    
    
    public static final String EMPTY = " ";
    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; 
    
    
 
    private String player;   // current player (PLAYER_X or PLAYER_O)

    private String winner;   // winner: PLAYER_X, PLAYER_O, TIE, EMPTY = in progress

    
    
    private static ImageIcon xIcon = new ImageIcon("Letter_X.jpg");
    private static ImageIcon oIcon = new ImageIcon("Letter_O.jpg");
    
    JButton sampleButton = new JButton();
    
    
    
    
    private int playerXWins ;
    private int playerOWins ;
    
    AudioClip onclick;
    AudioClip theme;
   
    
    private static boolean playerXTurn = true;
    
    /**
     * Constructor for the Tictactoe Controller 
     * 
     * @ param model The view class of the tictactoe frame
     * @ param view the model class of the tictactoe frame
     */
    
    TIcTacToeController (TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        this.view.buildBoard(new playerListener()); 
        this.view.addGameListener(new newGamePlayerListener()); 
        model.setBoard(view.board);
        playerXWins = 0;
        playerOWins = 0;
    }
    
    
    /**
     * Class playerListener
     * This action listener inherits from actionlistener and is called when 
     * the user clicks on a square in the tictactoe grid GUI. It then marks 
     * it as an x or o
     * 
     * 
     */
    class playerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            Object player = e.getSource();
            for (int i = 0; i < view.board.size(); i++) {
                if (player.equals(view.board.get(i)) && view.board.get(i).getLabel().equals(EMPTY)) {
                    
                    if (playerXTurn) {
                        view.board.get(i).setLabel(PLAYER_X);
                        ImageIcon newimg = new ImageIcon (xIcon.getImage().getScaledInstance(view.board.get(i).getWidth(), view.board.get(i).getHeight(), java.awt.Image.SCALE_SMOOTH));
                        view.board.get(i).setIcon(newimg);
                        URL urlClick2 = TIcTacToeController.class.getResource("PressXO.wav");
                        theme = Applet.newAudioClip(urlClick2);
                        theme.play();
            
                        
                        playerXTurn = false;
                        
                    }
                    else {
                        view.board.get(i).setLabel(PLAYER_O);
                        ImageIcon newimg2 = new ImageIcon (oIcon.getImage().getScaledInstance(view.board.get(i).getWidth(), view.board.get(i).getHeight(), java.awt.Image.SCALE_SMOOTH));
                        view.board.get(i).setIcon(newimg2);
                        URL urlClick2 = TIcTacToeController.class.getResource("PressXO.wav");
                        theme = Applet.newAudioClip(urlClick2);
                        theme.play();
                        playerXTurn = true;
                    }
                    model.playerMoves += 1;
                }
                
            }  
            model.gameResult();
            
            if (model.haveWinner()) {
                    if (playerXTurn) {
                        view.labelField.setText("Player O wins");
                        playerOWins += 1;
                    }
                    else {
                        view.labelField.setText("Player X wins");
                        playerXWins += 1;
                        
                    }
                } else if (model.playerMoves == 9) {
                    view.labelField.setText("We have a tie");
                }
                else {
                    if (playerXTurn) {
                        view.labelField.setText("Player X turn");
                    }
                    else {
                        view.labelField.setText("Player O turn");
                    }
                }
            
        }
    } 
    
    /**
     * This action listener is called when the user clicks on new game in the 
     * TicTacToe GUI and resets the board 
     * 
     * 
     */
    class newGamePlayerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i<view.board.size(); i++) {
                view.board.get(i).setIcon(null);
                view.board.get(i).setLabel(EMPTY);
                view.board.get(i).setEnabled(true);
            }
            model.playerMoves = 0;
            view.labelField.setText("player X turn");
            view.statField.setText("Statistics \t Player X wins:" + playerXWins + "\t Player O wins:" + playerOWins);   
            playerXTurn = true;
        }
    }

    
}
