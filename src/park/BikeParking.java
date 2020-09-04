package park;

import java.util.ArrayList;
import java.util.List;

import bike.*;


public class BikeParking {
    
    private String id;
    private List<SingleBike> bikes;

    public BikeParking(){

    }

    public void setId(String id){
        this.id = id;
    }

    public void setBikes(List<SingleBike> bikes){
        this.bikes = bikes;
    }

    public BikeParking(String id, List<SingleBike> bikes){
        this.id = id;
        this.bikes = bikes;
    }

    public void addBike(SingleBike sb){
        bikes.add(sb);
    }

    public void removeBike(SingleBike sb){
        bikes.remove(sb);
    }

    public void displayParkInfo(){
        System.out.println("The bikes in the park");
        for (SingleBike singleBike : bikes) {
            System.out.println(singleBike.getId() + " - " + singleBike.getType());
        }
    }
}