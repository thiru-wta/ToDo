package com.example.wtastudios.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WTA on 2/28/2017.
 */

public class GetListItems {


    public static HashMap<String,List<String>> getData() {
        HashMap<String, List<String>> listDetails= new HashMap<>();
        List<String> cars= new ArrayList<>();
        cars.add("item 1");
        cars.add("item 2");
        cars.add("item 3");
        cars.add("item 4");

        List<String> bikes= new ArrayList<>();
        bikes.add("item 1");
        bikes.add("item 2");
        bikes.add("item 3");
        bikes.add("item 4");

        List<String> phones= new ArrayList<>();
        phones.add("item 1");
        phones.add("item 2");
        phones.add("item 3");
        phones.add("item 4");

        listDetails.put("List 1",cars);
        listDetails.put("List 2",bikes);
        listDetails.put("List 3",phones);
        listDetails.put("List 4",cars);
        listDetails.put("List 5",bikes);
        listDetails.put("List 6",phones);

        return listDetails;
    }
}
