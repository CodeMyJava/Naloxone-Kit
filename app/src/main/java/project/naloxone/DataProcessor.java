package project.naloxone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by John on 2017-11-24.
 */

// This class will be responsible for getting the data from the database and processing it into a hash map (for efficiency), may possibly use a different map later.
public class DataProcessor {
    public static HashMap<String, List<String>> getInfo()
    {
        //Key: references the category
        //Value = List of objects
        HashMap<String, List<String>> kit_details = new HashMap<String, List<String>>();
        List<String> free       = new ArrayList<String>();
        free.add("Free data test");


        List<String> trainAndSell    = new ArrayList<String>();
        trainAndSell.add("Train and sell data test");

        List<String> sell               = new ArrayList<String>();
        sell.add("sell data test");

        kit_details.put("Free",free);
        kit_details.put("Train and Sell",trainAndSell);
        kit_details.put("Sell",sell);

        return kit_details;
    }
}
