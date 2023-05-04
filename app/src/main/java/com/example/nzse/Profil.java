package com.example.nzse;

import java.util.ArrayList;

public class Profil {
    //Atribute
    private String Name;
    private String LastName;
    private Boolean isReg;
    //private ArrayList<ChargingStation> favorites; //.get()

    //constructors
    private Profil(){
        this.Name = "Johannes";
        this.LastName = "Jaeger";
        this.isReg = false;
    }

    //Singleton Pattern
    private static Profil sProfil;
    public static Profil get(){
        if(sProfil == null){
            sProfil = new Profil();
        }
        return sProfil;
    }


    //getters
    public String getName(){return Name;}
    public String getLastName(){return LastName;}
    public Boolean getIsReg(){return isReg;}
    //public ArrayList<String> getRewards(){return favorites;}


    //setters
    public void setName(String n){this.Name = n;}
    public void setLastName(String n){this.LastName = n;}
    public void setIsReg(Boolean n){this.isReg = n; }

}
