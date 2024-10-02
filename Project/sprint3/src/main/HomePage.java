package main;

import Popups.PlayerInfoDialog;
import buttons.InfoButton;
import buttons.MusicButton;
import fonts.Display;
import javax.swing.*;
import java.awt.*;

/**
 * The {@code Main.Main.HomePage} class is to display for players to start the Fiery Dragons game.
 *
 * Created by:
 * @author Koe Rui En
 *
 * Modified by:
 * @author Tay Ming Hui
 * @author Wong Jia Xuan
 */
public class HomePage extends JFrame {

    // get font
    /**
     * new Font imported from other resources
     */
    private Font font = new Display().getFont();
    /**
     * panel to set up the main home panel
     */
    private JPanel homePanel;
    /**
     * panel for the game title
     */
    private JPanel gameTitlePanel;
    /**
     * panel for the button
     */
    private JPanel buttonPanel;

    // constructor
    /**
     * Constructor for the Main.Main.HomePage class.
     *
     */
    public HomePage(){

        //setup main home panel
        setupHomePanel();

        // initialise home page
        this.setSize(1080,720);
        this.setTitle("Fiery Dragons");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    // setup home panel
    /**
     * Configure the main homePanel to be added to Main.Main.HomePage.
     */
    public void setupHomePanel(){

        // add panel of home page
        homePanel = new JPanel();
        homePanel.setLayout(null);
        homePanel.setBackground(Color.ORANGE);

        // add title
        setGameTitle();
        // add start button
        setStartButton();
        // add help and music button
        setupButtons();
        setImage();

        // add to frame
        add(homePanel);

    }

    // set home page title
    /**
     * Set game title to be added to gameTitlePanel.
     */
    public void setGameTitle() {

        gameTitlePanel = new JPanel();
        // set panel transparent
        gameTitlePanel.setOpaque(false);
        gameTitlePanel.setLayout(new BorderLayout());
        gameTitlePanel.setBounds(1080/2-410, 720/2-200, 800, 200);

        // set title
        JLabel gameTitle = new JLabel();
        // set title
        gameTitle.setText("Fiery Dragons");
        // set title's font
        Font newFont = font.deriveFont(Font.PLAIN, 120);
        gameTitle.setFont(newFont);
        // align the title game to the center
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        // set title size
        gameTitle.setSize(451, 100);
        // Set text color to green
        gameTitle.setForeground(new Color(0, 123, 42));

        // add to home panel
        gameTitlePanel.add(gameTitle, BorderLayout.CENTER);
        homePanel.add(gameTitlePanel);

    }

    // add start button to home page
    /**
     * Configure button title to be added to buttonPanel.
     */
    public void setStartButton() {

        buttonPanel = new JPanel();
        // set panel transparent
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBounds(1080 / 2 - 120, 740 / 2 , 200, 100);

        JButton startButton = new JButton("START");
        // Set text color to white
        startButton.setForeground(Color.WHITE);
        // set button size
        startButton.setPreferredSize(new Dimension(200, 70));
        startButton.setFocusable(false);
        // set button font
        Font newFont = font.deriveFont(Font.PLAIN, 45);
        startButton.setFont(newFont);
        startButton.setBackground(new Color(0, 169, 57));

        startButton.setOpaque(true);
        startButton.setBorderPainted(false);

        // add action listener to the button
        startButton.addActionListener(e -> {

            if (e.getSource() == startButton) {
                new PlayerInfoDialog(this);
                dispose();
            }
        });

        // add to frame
        buttonPanel.add(startButton);
        homePanel.add(buttonPanel);

    }

    /**
     * Set background image to be added to the homePanel.
     */
    public void setImage(){

        JPanel imagePanel = new JPanel();
        // set panel transparent
        imagePanel.setOpaque(false);
        imagePanel.setBackground(null);
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        imagePanel.setBounds(1080/2+85, 720/2-40, 300, 160);

        String filename = "/images/dragon.png";
        ImageIcon dragonImage = new ImageIcon(new ImageIcon(getClass().getResource(filename)).getImage().getScaledInstance(280,160,Image.SCALE_SMOOTH));

        JLabel labelImage = new JLabel(dragonImage);

        imagePanel.add(labelImage);
        homePanel.add(imagePanel);

    }

    /**
     * Configure help and info button to be added to homePanel.
     */
    public void setupButtons(){
        InfoButton infoButton = new InfoButton(this);
        MusicButton musicButton = new MusicButton();
        homePanel.add(infoButton);
        homePanel.add(musicButton);
    }

}