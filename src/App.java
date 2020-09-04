import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 

import bike.*;
import park.*;
import utils.Utils;

public class App {

    private static Logger LOGGER = null;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        LOGGER = Logger.getLogger(App.class.getName());
    }

    public static String toTimeStr(Date time) {
        int hour = time.getHours();
        int min = time.getMinutes();
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
          sb.append(0).append(hour);
        } else {
          sb.append(hour);
        }
        sb.append(":");
        if (min < 10) {
          sb.append(0).append(min);
        } else {
          sb.append(min);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        // ArrayList bikes1 = new ArrayList<SingleBike>();
        // bikes1.add(new SingleBike("bike1", 1, 2, 1, "single"));
        // bikes1.add(new SingleBike("bike2", 1, 2, 1, "single"));
        // BikeParking park = new BikeParking("park1", bikes1);
        // park.displayParkInfo();

        // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Date start = new Date();
        // Date end = new Date(start.getTime() + 10*60*1000);
        // LOGGER.info("start: " + dateFormat.format(start));
        // LOGGER.info("end: " + dateFormat.format(end));
        // LOGGER.info("minutes: " + Utils.getMinutes(start, end));
        // for (int i=0; i<bikes1.size(); i++){
        //     ((SingleBike) bikes1.get(i)).displayInfo();
        // }
        Utils.readBarCode("barcode");

    }
}
