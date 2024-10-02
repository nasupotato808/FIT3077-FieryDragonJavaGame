package components;

import animals.Animal;

import javax.swing.*;
import java.awt.*;

public class ChitCard extends GameComponent {

    public boolean isFlipped;
    public int movement;

    public Image chitCardImage;

    public ChitCard(Animal animal, int movement) {
        this.setAnimal(animal);
        this.animal = animal;
        this.movement = movement;

    }

    public int getMovement() {
        return this.movement;
    }

    public void flipCard(boolean flip){
        this.isFlipped = flip;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    @Override
    public ImageIcon getImage(){
        if (isFlipped) {
            String name = "./images/" + getAnimal().toString() + "_" + this.getMovement() + ".png";
            chitCardImage = new ImageIcon(getClass().getResource("/images/" + this.getAnimal().toString() + "_" + this.getMovement() + ".png")).getImage();
            flipCard(false);
        } else {
            chitCardImage = new ImageIcon(getClass().getResource("/images/chitcardback.png")).getImage();
            flipCard(true);
        }
        chitCardImage = chitCardImage.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        return new ImageIcon(chitCardImage);
    }
}
