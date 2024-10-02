package animals;

import java.util.ArrayList;
import java.util.Arrays;

public class AnimalFactory {

    public static ArrayList<Animal> createChitCardAnimal(){
        ArrayList<Animal> animalFactory = new ArrayList<>();
        animalFactory.add(new Bat());
        animalFactory.add(new Spider());
        animalFactory.add(new Salamander());
        animalFactory.add(new BabyDragon());
        // add twice pirate dragon because 2 same chits
        animalFactory.add(new PirateDragon());
        animalFactory.add(new PirateDragon());

        return animalFactory;
    }

    public static ArrayList<Animal> createCaveAnimal(){
        ArrayList<Animal> animalFactory = new ArrayList<>();
        animalFactory.add(new Bat());
        animalFactory.add(new Spider());
        animalFactory.add(new Salamander());
        animalFactory.add(new BabyDragon());

        return animalFactory;
    }

    public static ArrayList<Animal> createVolcanoCardAnimalTop(){
        Animal[] group = {new Bat(), new Salamander(),new BabyDragon(), new Bat(), new Spider(), new BabyDragon()};
        return new ArrayList<>(Arrays.asList(group));
    }

    public static ArrayList<Animal> createVolcanoCardAnimalRight(){
        Animal[] group = {new Salamander(), new Bat(), new Salamander(), new Spider(), new Bat(), new BabyDragon()};
        return new ArrayList<>(Arrays.asList(group));
    }

    public static ArrayList<Animal> createVolcanoCardAnimalBottom(){
        Animal[] group = {new Spider(), new Bat(), new BabyDragon(), new Salamander(), new Spider(), new Salamander(),};
        return new ArrayList<>(Arrays.asList(group));
    }

    public static ArrayList<Animal> createVolcanoCardAnimalLeft(){
        Animal[] group = {new Spider(), new Bat(), new Spider(), new BabyDragon(), new Salamander(), new BabyDragon()};
        return new ArrayList<>(Arrays.asList(group));
    }

}
