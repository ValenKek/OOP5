package Zoo;
import Places.Place;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Place> places;

    public Zoo(){
        places = new ArrayList<>();
    }
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public boolean addPlace(Place place){
        return places.add(place);
    }
    int calculateAllAnimalsFoodExpenses() {
        int result = 0;
        for (var place : places) {
            for (var animal : place.animals) {
                result += animal.getCost();
            }
        }
        return result;
    }

}
