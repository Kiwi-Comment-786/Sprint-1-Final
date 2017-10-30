package com.example.shrad.kiwicommentapplication;

/**
 * Created by shrad on 23/10/2017.
 */
public class Comments {
    private String Shop_ID;
    private String content;
    private String name;
    private float rating;

    public Comments(){
        setShop_ID(null);
        setContent(null);
        setRating(0);
    }

    public Comments(String name, float rating, String content,String shop_ID){
       // setShop_ID(null);
        setName(name);
        setRating(rating);
        setContent(content);
        setShop_ID(shop_ID);
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public  void setName(String name){ this.name = name;}

    public String getName(){ return  this.name;}

    public void setShop_ID(String Shop_ID){
        this.Shop_ID = Shop_ID;
    }

    public String getShop_ID(){
        return Shop_ID;
    }

    public void setRating(float rating){this.rating = rating;}

    public float getRating(){return  this.rating;}

}

