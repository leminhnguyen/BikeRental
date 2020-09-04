package bike;

import java.util.Date;
import java.util.logging.Logger;

public class DoubleBike extends SingleBike{

    private static Logger LOGGER = null;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        LOGGER = Logger.getLogger(PowerBike.class.getName());
    }

    public DoubleBike(){

    }
    
    public DoubleBike(String id, int numOfSaddle, int numOfPedal, int numOfBackSeat, String type){
        super(id, numOfSaddle, numOfPedal, numOfBackSeat, type);
    }

    public double calMoney(Date start, Date end){
        return super.calMoney(start, end)*1.5;
    }

    public String displayTripInfo(Date start, Date end){
        String info = super.displayTripInfo(start, end);
        if(this instanceof DoubleBike){
            LOGGER.info(info);
        }
        return info;
    }
}