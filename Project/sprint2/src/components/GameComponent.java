package components;

import animals.Animal;

import javax.swing.*;

public abstract class GameComponent extends JPanel{

    public Animal animal;

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public ImageIcon getImage(){return null;}
}
