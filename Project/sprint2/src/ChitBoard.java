import animals.Animal;
import animals.AnimalFactory;
import components.ChitCard;

import java.util.ArrayList;
import java.util.Collections;

public class ChitBoard {

    public ArrayList<ChitCard> chits;

    public ChitBoard(){
        this.chits = new ArrayList<>();
    }

    public ArrayList<ChitCard> getChits() {
        return this.chits;
    }

    public void createBoard(){
        for (Animal animal: AnimalFactory.createChitCardAnimal()){
            for(int i = 1; i <= animal.maxMovement; i++ ){
                this.chits.add(new ChitCard(animal, i));
            }
        }
    }

    public void shuffleChits(){
        Collections.shuffle(chits);
    }

    public void startGame(){
        createBoard();
        shuffleChits();
    }


}
