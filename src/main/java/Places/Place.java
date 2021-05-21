package Places;

import Animals.Animal;
import Behaviors.Behaviors;
import Unils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Place {

    public int id ;
    public String name ;
    public int PlaceCapacity ;
    public List<Behaviors> behaviors ;
    public List<Animal> animals ;

    public Place(int id,String name, int placeCapacity, List<Behaviors> behaviors ) {
        this.id = id;
        this.name = name;
        this.PlaceCapacity = placeCapacity;
        this.behaviors = behaviors;
        animals = new ArrayList<>();
    }

    public void addNewAnimal(Animal animal) {
        if (addCheck(animal))
            animals.add(animal);
    }

    public void showAllAnimal(){
        for(var item : animals) {
            System.out.println(item.toString());
        }
    }

    private boolean addCheck(Animal animal){
        if(animals.size() +1 > PlaceCapacity) {
            System.out.println("Overflow");
            return false;
        }
        for (var item : behaviors) {
            if(item.equals(Utils.fromIdToAnimalBehavior(animal.getBehaviorId()))){
                System.out.println("Successful");
                return true;
            }
        }

        System.out.println("You tried to add animal with another behavior");
        return false;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
