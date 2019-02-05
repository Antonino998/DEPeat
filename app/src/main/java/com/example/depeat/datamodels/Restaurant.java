package com.example.depeat.datamodels;

public class Restaurant {
    private String name;
    private String indirizzo;
    private String minOrd;
    private String imgUrl;

    public Restaurant(String name,String indirizzo,String minOrd,String imgUrl){
        this.name=name;
        this.indirizzo=indirizzo;
        this.minOrd=minOrd;
        this.imgUrl=imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
