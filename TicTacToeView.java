import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Class TicTacToeView, The view part of the user-interface for the TicTacToe Game, 
 * built from the Swing and AWT frameworks.
 *
 * @author Jason Keah
 * @version Version 1, April 8, 2023
 */
public class TicTacToeView extends JFrame
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private Container contentPane;
    protected JLabel labelField;
    protected JLabel statField;
    private JMenuItem newGame;
    protected static JPanel p1;
    protected static ArrayList<JButton> board; 
    public static final String EMPTY = " ";  
    
    private JButton square1x1;
    private JButton square1x2;
    private JButton square1x3;
    private JButton square2x1;
    private JButton square2x2;
    private JButton square2x3;
    private JButton square3x1;
    private JButton square3x2;
    private JButton square3x3;
    
    AudioClip theme;
    
    

    /**
     * Constructor for objects of class TicTacToeView. builds the UI frame.
     */
    public TicTacToeView()
    {
        // initialise instance variables
        frame = new JFrame("Window title");
        contentPane = frame.getContentPane();
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);

        
        labelField = new JLabel("Welcome to TicTacToe, Player X turn");
        contentPane.add(labelField, BorderLayout.SOUTH);
        labelField.setVisible(true);
        
        statField = new JLabel("Statistics \t player X wins: \t Player O wins:");
        contentPane.add(statField, BorderLayout.NORTH);
        statField.setVisible(true);

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        newGame = new JMenuItem("New Game");
        fileMenu.add(newGame);

        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        
        p1 = new JPanel();
        GridLayout boardLayout = new GridLayout(3,3, 3, 3);
        p1.setLayout(boardLayout);
        
        square1x1 = new JButton(EMPTY);
        square1x2 = new JButton(EMPTY);
        square1x3 = new JButton(EMPTY);
        square2x1 = new JButton(EMPTY);
        square2x2 = new JButton(EMPTY);
        square2x3 = new JButton(EMPTY);
        square3x1 = new JButton(EMPTY);
        square3x2 = new JButton(EMPTY);
        square3x3 = new JButton(EMPTY);
        
        board = new ArrayList<JButton>();
        
        board.add(square1x1);
        board.add(square1x2);
        board.add(square1x3);
        board.add(square2x1);
        board.add(square2x2);
        board.add(square2x3);
        board.add(square3x1);
        board.add(square3x2);
        board.add(square3x3);
        
        board.get(0);
        
        
        for (int i = 0; i < board.size(); i++) {
            p1.add(board.get(i));
            
        }
        
        
        
        frame.add(p1);
        frame.pack();
        
        
        URL urlClick = TicTacToeView.class.getResource("TicTacToeTheme.wav"); // train sound
        theme = Applet.newAudioClip(urlClick);
        theme.loop();
        
        
       

        
    }
    
    /**
     * creates the action listeners for the board full of JButtons
     * 
     * @ param listenForButtonClicks, the action listener for the board 
     */
    public void buildBoard(ActionListener listenForButtonClicks){
        for (int i = 0; i < board.size(); i++) {
            board.get(i).addActionListener(listenForButtonClicks);
            
        }
    }
    
    /**
     * creates the action listeners for the new game button 
     * 
     * @ param listenForNewGame, the action listener for the new game button 
     * 
     */
    void addGameListener(ActionListener listenForNewGame) {
        newGame.addActionListener(listenForNewGame);
    }
}
