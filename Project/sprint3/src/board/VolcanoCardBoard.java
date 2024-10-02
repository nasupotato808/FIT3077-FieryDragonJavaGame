package board;

import animals.Animal;
import animals.AnimalFactory;
import components.VolcanoCard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * {@code board.VolcanoCardBoard} is a class that handle the initialisation of {@code Animal} for VolcanoCard's instances.
 *
 * Created by:
 * @author Tay Ming Hui
 *
 * Modified by:
 * @author Koe Rui En
 * @author Wong Jia Xuan
 */
public class VolcanoCardBoard{

    /**
     * a list of VolcanoCard's instances
     */
    public ArrayList<VolcanoCard> volcanos;

    /**
     * Constructor of the board.VolcanoCardBoard class.
     *
     **/
    public VolcanoCardBoard(){
        this.volcanos = new ArrayList<>();
    }

    /**
     * Return a list of instances of VolcanoCard.
     *
     * @return a list of instances of VolcanoCard
     */
    public ArrayList<VolcanoCard> getVolcanos() {
        return volcanos;
    }

    /**
     * Initialise VolcanoCards with different types of Animals.
     *
     */
    public void setupVolcanoAnimals(){
        // create volcano cards' animals
        for (Animal animal: AnimalFactory.createVolcanoCardAnimal()){
            volcanos.add(new VolcanoCard(animal));
        }
    }

}
