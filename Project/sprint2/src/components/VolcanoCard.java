package components;

import animals.Animal;
import javax.swing.*;
import java.awt.*;

public class VolcanoCard extends GameComponent {

    public Animal animal;
    public boolean isOccupied;


    public VolcanoCard(Animal animal){
        this.setAnimal(animal);
        this.animal = animal;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public Animal getAnimal() {
        return this.animal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //String filename = "./images/"+getAnimal().toString()+"_1.png";
        Image volcanoCardImage = new ImageIcon(getClass().getResource("/images/"+this.getAnimal().toString()+"_1.png")).getImage();
        g.drawImage(volcanoCardImage,0,0,60,60,null);
    }
}
