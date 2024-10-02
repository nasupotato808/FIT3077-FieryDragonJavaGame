import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinningPopupPanel extends JPanel {

    public WinningPopupPanel(){

        // winning message to be shown on the popup box
        JLabel winningMessage = new JLabel("Your Dragon has reach its cave!");
        //JLabel notWinningMessage = new JLabel("Your Dragon still on its way!");
        winningMessage.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        winningMessage.setForeground(Color.WHITE);
        winningMessage.setHorizontalAlignment(JLabel.CENTER);
        winningMessage.setVerticalAlignment(JLabel.CENTER);
        //this.setLayout(null);


        // Button to start a new game
        JButton startNewGameButton = new JButton("Start a new game");
        startNewGameButton.setBackground(Color.GREEN);
        startNewGameButton.setForeground(Color.black);
        //startNewGameButton.addActionListener(this);

        this.setBackground(Color.BLACK);

        this.add(winningMessage);
        this.add(startNewGameButton);
        this.setSize(300,300);
        this.setLayout(new GridLayout(2,1,20,10));



    }

}
