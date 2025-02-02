package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        list.addCity(new City("Vancouver","British Columbia"));
        assertTrue(list.hasCity(new City("Vancouver","British Columbia")));
        assertFalse(list.hasCity(new City("Edmonton","Alberta")));
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Vancouver","British Columbia"));
        assertEquals(listSize + 1,list.getCount());
        list.deleteCity(new City("Vancouver","British Columbia"));
        assertEquals(listSize,list.getCount());
    }

    @Test
    public void getCountTest(){
        list = MockCityList();
        assertEquals(0,list.getCount());
        list.addCity(new City("Vancouver","British Columbia"));
        assertEquals(1,list.getCount());
        list.deleteCity(new City("Vancouver","British Columbia"));
        assertEquals(0,list.getCount());
    }

}
