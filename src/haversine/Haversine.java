package haversine;

import java.util.Scanner;


public class Haversine {

 
    public static void main(String[] args) {

        Scanner userInput = new Scanner (System.in);
        
        System.out.println("Provide lat 1");
        String lat1 = userInput.next();
        System.out.println("Provde long 1");
        String lon1 = userInput.next();
        System.out.println("Provide lat 2");
        String lat2 = userInput.next();
        System.out.println("Provide long 2");
        String lon2 = userInput.next();
        
        
        
        double latitude1 = Double.parseDouble(lat1);
        double latitude2 = Double.parseDouble(lat2);
        double longitude1 = Double.parseDouble(lon1);
        double longitude2 = Double.parseDouble(lon2);
        
        //Uses Haversine formula to calculate the great-circle distance between two points – that is, the shortest distance over the earth’s surface
        //a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
        //c = 2 ⋅ atan2( √a, √(1−a) )
        //d = R ⋅ c
        //where	φ is latitude, λ is longitude, R is earth’s radius (mean radius = 6,371km);
        //Note: that angles need to be in radians to pass to trig functions!
        //Note: I have removed code to include height parameters
    
        final int R = 6371; // Radius of the earth in km. If final assigned, it can never be changed

        double latDistance = Math.toRadians(latitude2 - latitude1); //converts an angle measured in degrees to an approximately equivalent angle measured in radians. The conversion from degrees to radians is generally inexact.
        double lonDistance = Math.toRadians(longitude2 - longitude1);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) 
                
                 + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) 
                
                 * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distanceInKm = R * c; // convert to meters
        double distanceInM = R * c * 1000; // convert to meters
        
        System.out.println(distanceInKm);
        System.out.println(distanceInM);
        
        
        
        
    }
    
}
