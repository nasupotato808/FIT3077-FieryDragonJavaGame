package main;

import Popups.DecisionPanel;
import Popups.WinningPopupPanel;
import board.BoardSetup;
import board.CaveCardManager;
import board.ChitCardManager;
import board.VolcanoCardManager;
import buttons.ExitButton;
import buttons.InfoButton;
import buttons.MusicButton;
import components.GameComponent;
import components.Token;
import fonts.Display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Objects;


/**
 * The {@code Main.Game} class represents the main logic and user interface for the Fiery Dragons game.
 * It extends {@link JFrame} to provide a graphical user interface and manages game components,
 * player tokens, and the game flow.
 *
 * Created by:
 * @author Tay Ming Hui
 *
 * Modified by:
 * @author Koe Rui En
 * @author Wong Jia Xuan
 */
public class Game extends JFrame implements Runnable{

    /**
     * the number of players in the game.
     **/
    private int number_of_players = 4;

    /**
     * the list of player tokens.
     **/
    private ArrayList<Token> players;

    /** the list of tokens in the game.
     **/
    private ArrayList<Token> tokens;

    /**
     * the setup for the game board
     **/
    private BoardSetup boardSetup;

    /**
     * manages chit cards for the game
     **/
    private ChitCardManager chitCardManager;

    /**
     * manages volcano cards for the game
     **/
    private VolcanoCardManager volcanoCardManager;

    /**
     * manages cave cards for the game
     **/
    private CaveCardManager caveCardManager;

    /** winner of the game
     * */
    private Token winner;

    /**
     * list of player's names
     **/
    private ArrayList<String> names;

    /**
     * label to indicate next player
     **/
    private JLabel currentPlayerLabel = new JLabel();

    /**
     * label to indicate player chooses to continue its turn or not
     **/
    private JLabel turnLabel = new JLabel();

    /**
     * Constructs a new {@code Main.Game} instance, initializing the game state and user interface.
     */
    public Game(ArrayList<String> names){

        this.players = new ArrayList<>();
        this.names = names;
        startGame();
        setupGame();

        this.setBackground(Color.ORANGE);
        this.setSize(1080,720);
        this.setTitle("Fiery Dragons");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // run game in a separate worker
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                Game.this.run();
                return null;
            }
        };

        this.setVisible(true);

        this.number_of_players = 0;
        this.tokens = caveCardManager.getShuffledToken();

        // run game
        worker.execute();
    }

    /**
     * A getter to get the ChitCard manager.
     *
     * @return the ChitCard manager.
     */
    public ChitCardManager getChitCardManager() {
        return this.chitCardManager;
    }

    /**
     * Starts the game by initializing player tokens and setting up the game.
     */
    public void startGame(){
        ArrayList<String> colour = new ArrayList<>();
        colour.add("Blue");
        colour.add("White");
        colour.add("Yellow");
        colour.add("Green");
        Collections.shuffle(colour);
        number_of_players = this.names.size();
        for (int i = 0; i < number_of_players; i++) {
            players.add(new Token(colour.get(i)));
        }
    }

    /**
     * Checks if any player has won the game.
     *
     * @return {@code true} if a player has won, {@code false} otherwise.
     */
    public boolean checkWin(){
        for (Token token: tokens){
            if(token.getPath() != null) {
                if (token.getCurrentSteps() == token.getPath().size()-1) {
                    this.winner = token;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Validates the flipped chit card for the given token and calculates its movement.
     *
     * @param token the token to validate the chit card for.
     * @return the new position of the token or a special value indicating no movement.
     */
    public int validateFlippedChit(Token token){
        // check flipped chit card and animal on chit card is not null
        if(getChitCardManager().getFlippedAnimal() != null && getChitCardManager().getFlippedChit() != null) {
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds (0.5 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String animalName = getChitCardManager().getFlippedAnimal().getAnimalName();
            String currentPositionAnimal = token.getPath().get(token.getPosition()).getAnimal().getAnimalName();
            int movement = getChitCardManager().getChitMovement();
            // check animal on volcano same as animal on chit card
            if (Objects.equals(currentPositionAnimal, animalName)) {
                if (token.getCurrentSteps() + movement >= token.getPath().size()) {
                    getChitCardManager().clearAnimal();
                    return 0;
                } else{

                    if ((token.getPosition() + movement) >= 26) {
                        if (token.getCurrentSteps()+movement == 26) {
                            token.setCurrentSteps(movement);
                            return 26;
                        } else {
                            if (token.getPosition() == 25 && !(token.getPath().get(movement + 1).isOccupied())){
                                token.setCurrentSteps(movement);
                                return movement + 1;
                            } else if (token.getPosition() == 24 && !token.getPath().get(movement).isOccupied()) {
                                if (token.getCurrentSteps() == 24){
                                    token.setCurrentSteps(movement);
                                } else {
                                    token.setCurrentSteps(movement + 1);
                                }
                                return movement;

                            } else if (token.getPosition() == 23 && !token.getPath().get(movement).isOccupied()){
                                if (token.getCurrentSteps() == 23){
                                    token.setCurrentSteps(movement);
                                } else {
                                    token.setCurrentSteps(movement + 1);
                                }
                                return movement;
                            } else {
                                getChitCardManager().clearAnimal();
                                return 0;
                            }
                        }
                    } else {
                        if (!token.getPath().get(token.getPosition() + movement).isOccupied()) {
                            if (token.getPosition() + movement == 25) {
                                System.out.println(token.getCurrentSteps());
                                if (token.getCurrentSteps() >= 22){

                                    token.setCurrentSteps(movement);
                                } else{

                                    token.setCurrentSteps(movement + 1);
                                    //return token.getPosition() + movement + 1;
                                }
                            } else{
                                token.setCurrentSteps(movement);
                            }
                            return token.getPosition() + movement;
                        } else {
                            getChitCardManager().clearAnimal();
                            return 0;
                        }
                    }
                }
            }
            else if (Objects.equals("piratedragon", animalName)) {
                if(token.getPosition() != 0){
                    if (token.getPosition() - movement <= 0){
                        if (!token.getPath().get(token.getPath().size() + token.getPosition() - movement - 3).isOccupied()) {
                            token.setCurrentSteps(-(movement + 1));
                            getChitCardManager().clearAnimal();
                            return (token.getPath().size() + token.getPosition() - movement - 3);
                        }
                        else{
                            getChitCardManager().clearAnimal();
                            return 0;
                        }
                    } else{
                        if (!token.getPath().get(token.getPosition() - movement).isOccupied()) {
                            if (token.getPosition() == 25){
                                if(token.getCurrentSteps()!= 25) {
                                    token.setCurrentSteps(-(movement + 1));
                                } else{
                                    token.setCurrentSteps(-movement);
                                }
                            } else {
                                token.setCurrentSteps(-movement);
                            }
                            getChitCardManager().clearAnimal();
                            return token.getPosition() - movement;
                        } else{
                            getChitCardManager().clearAnimal();
                            return 0;
                        }
                    }
                } else {
                    getChitCardManager().clearAnimal();
                    return 0;
                }
            } else {
                getChitCardManager().clearAnimal();
                return 0;
            }
        }
        return -1;
    }

    /**
     * Executes the main game loop, handling player turns and movements.
     */
    public void execute(){
        while (!checkWin()) {
            int currentPlayer = 0;
            while (currentPlayer < this.tokens.size()) {
                Token currentToken = this.tokens.get(currentPlayer);
                currentPlayerLabel.setText(this.names.get(currentPlayer)+"'s "+currentToken.getDragonColour() +" Dragon turn");
                int num = caveCardManager.parseCave(currentToken);
                // 24 volcano cards
                ArrayList<GameComponent> tokenPath = volcanoCardManager.getVolcanoPath(num);
                tokenPath.add(0,currentToken.getBornCave()); // Add at the beginning
                tokenPath.add(currentToken.getBornCave()); // start from cave, along volcano path, enter cave
                // set token path
                currentToken.setPath(tokenPath);
                // get movement for token to move
                enableChitPanel();
                int movement = validateFlippedChit(currentToken);
                if (movement != -1){
                    disableChitPanel();
                }
                // if the player can move either forward/backward

                if (movement > 0) {
                    disableChitPanel();
                    if (!currentToken.getPath().get(movement).isOccupied()) {
                        currentToken.getPath().get(movement).setOccupied(true);
                        int previousPosition = currentToken.getPosition();
                        Point target = currentToken.getPath().get(movement).getPoint();
                        JPanel tokenPanel = boardSetup.getToken(num);
                        currentToken.setPosition(movement);
                        currentToken.getPath().get(previousPosition).setOccupied(false);
                        tokenPanel.setLocation(target);
                        try {
                            Thread.sleep(400); // Sleep for 500 milliseconds (0.5 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tokenPanel.repaint();

                        if (currentToken.getCurrentSteps() == 26) {
                            break;
                        }
                        // if all chits are uncovered
                        if (chitCardManager.getChitList().size() == 16) {
                            JOptionPane.showOptionDialog(this, "You have uncovered all chits !", "Full", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                            turnLabel.setText("");
                            chitCardManager.setFlipBack(true);
                            try {
                                Thread.sleep(300); // Sleep for 1000 milliseconds (1 second)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            currentPlayer++;
                        } else {
                            if (!new DecisionPanel().takingDecision()) {
                                turnLabel.setText("");
                                chitCardManager.setFlipBack(true);
                                try {
                                    Thread.sleep(500); // Sleep for 500 milliseconds (0.5 second)
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                currentPlayer++;
                            } else {
                                turnLabel.setText("");
                                turnLabel.setText(this.names.get(currentPlayer) + " has continued its turn.");
                                chitCardManager.setFlipBack(false);
                                chitCardManager.clearAnimal();
                            }
                        }
                    } else {
                        turnLabel.setText("");
                        chitCardManager.setFlipBack(true);
                        try {
                            Thread.sleep(300); // Sleep for 1000 milliseconds (1 second)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        currentPlayer++;
                    }
                } else if (movement == 0) {
                    disableChitPanel();
                    turnLabel.setText("");
                    chitCardManager.setFlipBack(true);
                    try {
                        Thread.sleep(300); // Sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentPlayer++;
                }

            }
        }
        new WinningPopupPanel(winner, this).takingDecision();
    }

    /**
     * Sets up the game by initializing the managers for chit cards, volcano cards, and cave cards,
     * and adds the game components to the game board.
     */
    public void setupGame(){
        this.chitCardManager = new ChitCardManager();
        this.chitCardManager.chitCardSetup();
        volcanoCardManager = new VolcanoCardManager(chitCardManager.getBoardSetup());
        volcanoCardManager.volcanoCardSetup();
        caveCardManager = new CaveCardManager(volcanoCardManager.getBoardSetup(), this.players);
        caveCardManager.caveSetup();

        currentPlayerLabel.setFont(new Display().getFont().deriveFont(Font.BOLD, 28f));
        currentPlayerLabel.setBackground(null);
        currentPlayerLabel.setBounds(15,15,500,35);
        currentPlayerLabel.setForeground(Color.black);

        turnLabel.setFont(new Display().getFont().deriveFont(Font.BOLD, 16f));
        turnLabel.setBackground(null);
        turnLabel.setBounds(15,50,500,25);
        turnLabel.setForeground(Color.black);

        InfoButton infoButton = new InfoButton(this);
        MusicButton musicButton = new MusicButton();
        ExitButton exitButton = new ExitButton(this);

        this.add(infoButton);
        this.add(musicButton);
        this.add(exitButton);

        this.add(currentPlayerLabel);
        this.add(turnLabel);
        this.add(chitCardManager.getBoardSetup());
        this.add(volcanoCardManager.getBoardSetup());
        this.add(caveCardManager.getBoardSetup());

        boardSetup = caveCardManager.getBoardSetup();
    }

    /**
     * Disable ChitCard to be flipped.
     *
     **/
    public void disableChitPanel(){
        chitCardManager.disableChitPanel(true);
    }

    /**
     * Enable ChitCard to be flipped.
     *
     **/
    public void enableChitPanel(){
        chitCardManager.disableChitPanel(false);
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        this.execute();
    }
}
