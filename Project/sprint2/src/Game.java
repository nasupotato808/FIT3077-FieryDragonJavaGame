import components.Token;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {
    public int number_of_players = 4;

    public static ArrayList<Token> players;

    public Game(){
        players = new ArrayList<>();
        startGame();
        setupGame();
        this.setBackground(Color.ORANGE);
        this.setSize(920,820);
        this.setTitle("Fiery Dragons");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.number_of_players = 4;
        //endGame();
    }


    public void startGame(){
        String[] colour = {"Blue", "White", "Yellow", "Green"};
        for (int i = 0; i < this.number_of_players; i++){
            players.add(new Token(colour[i]));
        }
    }

    public static boolean checkWin(){
        for (Token token: players){
            if(token.getCurrentSteps()==25){
                return true;
            }
        }
        return false;
    }

//    public static boolean endGame(){
//        if(checkWin()){
//            return true;
//        }
//        return false;
//    }

    public void setupGame(){

        ChitCardManager chitCardManager = new ChitCardManager();
        chitCardManager.chitCardSetup();
        VolcanoCardManager volcanoCardManager = new VolcanoCardManager(chitCardManager.getBoardSetup());
        volcanoCardManager.volcanoCardSetup();
        CaveCardManager caveCardManager = new CaveCardManager(volcanoCardManager.getBoardSetup(), players);
        caveCardManager.caveSetup();

        this.add(chitCardManager.getBoardSetup());
        this.add(volcanoCardManager.getBoardSetup());
        this.add(caveCardManager.getBoardSetup());


        //this.add(new board.BoardSetup());




    }
}
