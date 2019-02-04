package com.example.depeat.datamodels;

public class Restaurant {
    private String name;
    private String indirizzo;
    private String minOrd;

    public Restaurant(String name,String indirizzo,String minOrd){
        this.name=name;
        this.indirizzo=indirizzo;
        this.minOrd=minOrd;
    }

    public String getName() {
        return name;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getMinOrd() {
        return minOrd;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setMinOrd(String minOrd) {
        this.minOrd = minOrd;
    }
}
