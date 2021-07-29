package com.example.recyclerview_fragments;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars= new ArrayList<Car>();
        cars.add(new Car("volkswagen","Polo","Chuck Norris","0123456789"));
        cars.add(new Car("mercedes","E200","Peter Pollok","0123456789"));
        cars.add(new Car("nissan","Almera","Chris James","0123456789"));
        cars.add(new Car("mercedes","E180","John Rambo","0123456789"));
        cars.add(new Car("volkswagen","Kombi","Peter Parker","0123456789"));
        cars.add(new Car("nissan","Navara","Paul Bunting","0123456789"));

    }
}
