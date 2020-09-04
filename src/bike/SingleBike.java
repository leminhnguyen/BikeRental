package bike;

import java.util.Date;
import java.util.logging.Logger;

import utils.Utils;

public class SingleBike {
    
    private static Logger LOGGER = Logger.getLogger(SingleBike.class.getName());
    protected int numOfSaddle;
    protected String id;
    protected int numOfPedal;
    protected int numOfBackSeat;
    protected String type;

    public SingleBike(){
        
    }

    public SingleBike(String id, int numOfSaddle, int numOfPedal, int numOfBackSeat, String type){
        this.id = id;
        this.numOfBackSeat  = numOfBackSeat;
        this.numOfPedal = numOfPedal;
        this.numOfSaddle = numOfSaddle;
        this.type = type;
    }

    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }

    public void displayInfo() {
        String info = "The info of the bike " + id + ":\n"
        + "Bike ID: " + id + "\n"
        + "Bike Saddles: " + numOfSaddle + "\n"
        + "Bike Pedals: " + numOfPedal + "\n"
        + "Bike Type: " + type + "\n"
        + "Bike BackSeat: " + numOfBackSeat;
        LOGGER.info(info);
        
    }

    public String displayTripInfo(Date start, Date end){
        double money = calMoney(start, end);
        String info = "---------- The trip info ----------" + "\n"
            + "Start Time: " + Utils.DATE_FORMATER.format(start) + "\n"
            + "End Time" + Utils.DATE_FORMATER.format(end) + "\n"
            + "Total Money: " + money; 
        if (this instanceof SingleBike){
            LOGGER.info(info);
        }
        return info;
    }

    public double calMoney(Date start, Date end) {
        long spending_minutes = Utils.getMinutes(start, end);
        if (spending_minutes < 10){
            return 0;
        }else if(spending_minutes <= 30){
            return 10000;
        }else{
            return 10000 + ( (double)(spending_minutes-30)/3 ) * 3000;
        }
    }
}