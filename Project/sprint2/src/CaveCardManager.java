import animals.AnimalFactory;
import components.CaveCard;
import components.Token;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CaveCardManager {
    public BoardSetup boardSetup;
    public ArrayList<CaveCard> caves;

    public ArrayList<Token> tokens;


    public CaveCardManager(BoardSetup boardSetup, ArrayList<Token> tokens){
        this.boardSetup = boardSetup;
        this.caves = new ArrayList<>();
        this.tokens = tokens;
    }

    public void caveSetup(){
        for(int i = 0; i < AnimalFactory.createCaveAnimal().size(); i++){
            caves.add(new CaveCard(AnimalFactory.createCaveAnimal().get(i)));
        }

        //Collections.shuffle(caves);

        for (Token token: tokens){
            for (int i = 0; i < caves.size(); i++){
                if (Objects.equals(token.getDragonColour(), "White") && Objects.equals(caves.get(i).getAnimal().toString(), "salamander")){
                    token.setOpaque(false);
                    this.boardSetup.getToken(i).setLayout(new BorderLayout());
                    this.boardSetup.getToken(i).add(token, BorderLayout.CENTER);

                } else if (Objects.equals(token.getDragonColour(), "Blue") && Objects.equals(caves.get(i).getAnimal().toString(), "bat")) {
                    token.setOpaque(false);
                    this.boardSetup.getToken(i).setLayout(new BorderLayout());
                    this.boardSetup.getToken(i).add(token, BorderLayout.CENTER);

                } else if (Objects.equals(token.getDragonColour(), "Green") && Objects.equals(caves.get(i).getAnimal().toString(), "babydragon")) {
                    token.setOpaque(false);
                    this.boardSetup.getToken(i).setLayout(new BorderLayout());
                    this.boardSetup.getToken(i).add(token, BorderLayout.CENTER);

                } else if (Objects.equals(token.getDragonColour(), "Yellow") && Objects.equals(caves.get(i).getAnimal().toString(), "spider")) {
                    token.setOpaque(false);
                    this.boardSetup.getToken(i).setLayout(new BorderLayout());
                    this.boardSetup.getToken(i).add(token, BorderLayout.CENTER);
                }
            }

        }
        for (int i = 0; i < caves.size(); i++){
            JPanel cave = this.caves.get(i);
            cave.setOpaque(false);
            this.boardSetup.getCavePanel(i).setLayout(new BorderLayout());
            this.boardSetup.getCavePanel(i).add(cave, BorderLayout.CENTER);
        }
    }

    public BoardSetup getBoardSetup() {
        return this.boardSetup;
    }
}
