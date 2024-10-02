package components;

import animals.Animal;

import javax.swing.*;
import java.awt.*;

public class CaveCard extends GameComponent {
    public Animal animal;

    public CaveCard(Animal animal){
        this.setAnimal(animal);
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String filename = "/images/cave_" + this.getAnimal().toString() + ".png";
        Image caveCardImage = new ImageIcon(getClass().getResource(filename)).getImage();
        g.drawImage(caveCardImage,0,0,100,100, null);
    }

}
