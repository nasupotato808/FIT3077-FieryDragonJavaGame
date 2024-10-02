package animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A factory class to manufacture all the game components comprising animals including volcano cards, chit cards and caves.
 *
 * Created by:
 * @author Tay Ming Hui
 *
 * Modified by:
 * @author Koe Rui En
 */
public class AnimalFactory {

    /**
     * Create different types of Animal on the ChitCard, add them to the animalFactory list and return the list.
     *
     * @return return a list of Animal on the ChitCard
     */
    public static ArrayList<Animal> createChitCardAnimal(){
        ArrayList<Animal> animalFactory = new ArrayList<>();

        // add all animals to the list
        animalFactory.add(new Bat());
        animalFactory.add(new Spider());
        animalFactory.add(new Salamander());
        animalFactory.add(new BabyDragon());
        // add twice pirate dragon because 2 same chits
        animalFactory.add(new PirateDragon());
        animalFactory.add(new PirateDragon());

        return animalFactory;
    }

    /**
     * Create different types of Animal on the CaveCard, add them to the animalFactory list and return the list.
     *
     * @return return a list of Animal on the CaveCard
     */
    public static ArrayList<Animal> createCaveAnimal(){
        ArrayList<Animal> animalFactory = new ArrayList<>();

        // add all animals to the list
        animalFactory.add(new Bat());
        animalFactory.add(new Spider());
        animalFactory.add(new Salamander());
        animalFactory.add(new BabyDragon());

        return animalFactory;
    }

    /**
     * Create different types of Animal on the VolcanoCard, add them to the animalFactory list and return the list.
     *
     * @return return a list of Animal on the VolcanoCard
     */
    public static ArrayList<Animal> createVolcanoCardAnimal(){
        // volcano card with no cuts/caves
        Animal [] noCave1 = {new Spider(), new Bat(), new Salamander()};
        Animal [] noCave2 = {new BabyDragon(), new Salamander(), new Bat()};
        Animal [] noCave3 = {new Bat(), new BabyDragon(), new Salamander()};
        Animal [] noCave4 = {new Salamander(), new BabyDragon(), new Spider()};
        ArrayList<Animal[]> noCaveGroup = new ArrayList<>();
        noCaveGroup.add(noCave1);
        noCaveGroup.add(noCave2);
        noCaveGroup.add(noCave3);
        noCaveGroup.add(noCave4);
        Collections.shuffle(noCaveGroup);

        // volcano card with cuts/caves
        Animal [] withCave1 = {new BabyDragon(), new Bat(), new Spider()};
        Animal [] withCave2 = {new Salamander(), new Spider(), new Bat()};
        Animal [] withCave3 = {new Spider(), new Salamander(), new BabyDragon()};
        Animal [] withCave4 = {new Bat(), new BabyDragon(), new Spider()};
        ArrayList<Animal[]> withCaveGroup = new ArrayList<>();
        withCaveGroup.add(withCave1);
        withCaveGroup.add(withCave2);
        withCaveGroup.add(withCave3);
        withCaveGroup.add(withCave4);
        Collections.shuffle(withCaveGroup);

        // add all animals to the list
        ArrayList<Animal> volcanoAnimals = new ArrayList<>();
        for (int i = 0; i <= 3; i++){
            volcanoAnimals.addAll(Arrays.asList(noCaveGroup.get(i)));
            volcanoAnimals.addAll(Arrays.asList(withCaveGroup.get(i)));
        }

        return volcanoAnimals;

    }

}
