import animals.Animal;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class ChitCardManager implements MouseListener {

    public ChitBoard gameBoard;

    public BoardSetup boardSetup;

    public Map<JLabel, Integer> labelIndexMap;

    public Animal animal;
    public int movement;

    public ChitCardManager(){
        this.boardSetup = new BoardSetup();
        this.labelIndexMap = new HashMap<>();

    }

    public void chitCardSetup(){
        gameBoard = new ChitBoard();
        gameBoard.startGame();
        for (int i = 0; i < gameBoard.getChits().size(); i++){
            JLabel chitcard = new JLabel();
            chitcard.addMouseListener(this);
            gameBoard.getChits().get(i).flipCard(false);
            chitcard.setIcon(gameBoard.getChits().get(i).getImage());
            boardSetup.getChitCardPanel().add(chitcard);
            labelIndexMap.put(chitcard, i);
        }
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public int getMovement() {
        return this.movement;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public BoardSetup getBoardSetup(){
        return this.boardSetup;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel clickedChit = (JLabel) e.getSource();
        int index = labelIndexMap.get(clickedChit);
        clickedChit.setIcon(gameBoard.getChits().get(index).getImage());
        if(!gameBoard.getChits().get(index).isFlipped()){
            this.setAnimal(gameBoard.getChits().get(index).getAnimal());
            this.setMovement(gameBoard.getChits().get(index).getMovement());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
