package animals;

public abstract class Animal {

    public String animalName;

    public int maxMovement;

    public boolean isBackwardable;

    public Animal(){
        this.isBackwardable = false;
    }

    public String getAnimalName() {
        return animalName;
    }

    @Override
    public String toString() {
        return getAnimalName();
    }

    public boolean isBackwardable() {
        return this.isBackwardable;
    }
}
