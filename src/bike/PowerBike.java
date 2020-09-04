package bike;

import java.util.Date;
import java.util.logging.Logger;

import utils.Configs;
import utils.Utils;


public class PowerBike extends SingleBike{
    
    private int remainingTime = 100;

    private static Logger LOGGER = null;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        LOGGER = Logger.getLogger(PowerBike.class.getName());
    }

    public PowerBike(){

    }

    public PowerBike(String id, int numOfSaddle, int numOfPedal, int numOfBackSeat, String type){
        super(id, numOfSaddle, numOfPedal, numOfBackSeat, type);
    }

    public void calRemainingTime(Date start, Date end) {
        int spending_minutes = (int) Utils.getMinutes(start, end);
        if(spending_minutes > this.remainingTime){
            this.remainingTime = 0;
        }else{
            this.remainingTime = this.remainingTime - spending_minutes;
        }
    }

    public double calMoney(Date start, Date end){
        return super.calMoney(start, end)*1.5;
    }

    public void displayInfo() {
        String info = "The info of the bike " + id + ":\n"
        + "Bike ID: " + id + "\n"
        + "Bike Saddles: " + numOfSaddle + "\n"
        + "Bike Pedals: " + numOfPedal + "\n"
        + "Bike Type: " + type + "\n"
        + "Bike BackSeat: " + numOfBackSeat
        + "Motor: new" + "\n"
        + "Estimated Remaining Percent: " + (this.remainingTime/Configs.MAXIMUM_MINUTE_FOR_POWER_BIKE)*100 + "%" + "\n"
        + "Estimated Remaining Time: " + this.remainingTime;
        LOGGER.info(info);
    }

    public String displayTripInfo(Date start, Date end){
        String info = super.displayTripInfo(start, end);
        info +=  "Motor: new" + "\n"
        + "Estimated Remaining Percent: " + (this.remainingTime/Configs.MAXIMUM_MINUTE_FOR_POWER_BIKE)*100 + "%" + "\n"
        + "Estimated Remaining Time: " + this.remainingTime;
        if (this instanceof PowerBike){
            LOGGER.info(info);
        }
        return info;
    }

}