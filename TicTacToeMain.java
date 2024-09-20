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
/**
 * Class TicTacTe Main, the main call for the TicTacToe game linking the model control and view 
 * to create an instance of the game
 *
 * @author Jason Keah
 * @version April 8, 2023
 */
public class TicTacToeMain
{
    public static void main(String[] args) {
      TicTacToeModel model = new TicTacToeModel();
      TicTacToeView view = new TicTacToeView();
      TIcTacToeController controller = new TIcTacToeController(model, view);
      
      view.setVisible(true);
      /* Register the view as an observer of the model. */
      // model.addObserver(view);       

      // controller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      

      /* Update the view to reflect the initial state of the model. */
      // view.update(model, null);
   }
}
