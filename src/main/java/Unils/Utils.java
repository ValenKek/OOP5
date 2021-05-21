package Unils;

import Animals.Animal;
import Behaviors.Behaviors;

import java.util.Date;
import java.util.Optional;

public class Utils {
    public static void calculateFoodExpenses(Date date, Animal animal){
        var dif = animal.getDate().getTime() - date.getTime();
        int differenceInDays = Math.toIntExact(dif / 3600);

        int result =  differenceInDays * animal.getCost();

        System.out.println("You need -> " + result + "$");
    }
    public static Behaviors fromIdToAnimalBehavior(int id){
        Behaviors behavior = null;
        switch (id){
            case 1:{
                behavior = Behaviors.Herbaceous;
                break;
            }
            case 2:{
                behavior = Behaviors.Predator;
                break;
            }
            default:
                break;
        }
        return behavior;
    }

}
