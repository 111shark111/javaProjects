package com.example.geektrust.Service;

import com.example.geektrust.Model.Destination;
import com.example.geektrust.Model.Gridgame;
import com.example.geektrust.Model.Source;

import java.awt.*;

public class MainService {

    Source source ;
    Destination destination ;
    Gridgame gridgame;
    public void mainService(String[] parts) {
        String command = parts[0];
        switch (command){
            case "SOURCE" : {
                this.source = new Source(parts[1],parts[2],parts[3]);
                break;
            }
            case "DESTINATION":{
                this.destination = new Destination(parts[1],parts[2]);
                break;
            }
            case "PRINT_POWER":{
                this.gridgame = new Gridgame(source,destination);
                this.gridgame.printPower();
                break;
            }
        }
    }
}
