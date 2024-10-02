import animals.Animal;
import animals.AnimalFactory;
import components.VolcanoCard;
import java.util.ArrayList;

public class VolcanoCardBoard{

    public ArrayList<VolcanoCard> volcanos;

    //public Map<JLabel, Integer> labelIndexMap;

    public VolcanoCardBoard(){
        this.volcanos = new ArrayList<>();
    }

    public ArrayList<VolcanoCard> getVolcanos() {
        return volcanos;
    }

    public void createVolcanoTop(){
        for (Animal animal: AnimalFactory.createVolcanoCardAnimalTop()){
            volcanos.add(new VolcanoCard(animal));
        }
    }

    public void createVolcanoRight(){
        for (Animal animal: AnimalFactory.createVolcanoCardAnimalRight()){
            volcanos.add(new VolcanoCard(animal));
        }
    }
    public void createVolcanoBottom(){
        for (Animal animal: AnimalFactory.createVolcanoCardAnimalBottom()){
            volcanos.add(new VolcanoCard(animal));
        }
    }
    public void createVolcanoLeft(){
        for (Animal animal: AnimalFactory.createVolcanoCardAnimalLeft()){
            volcanos.add(new VolcanoCard(animal));
        }
    }

}
