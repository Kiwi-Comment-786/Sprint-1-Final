package com.example.ezio.loginandcomments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Ezio on 10/09/2017.
 */

public class Comments<Comment> {

   /* private static String path = "java:/";

    public int shopID;

    protected int numComments;
    protected Comment[] comment;
    private final int INITAL_CAPACITY = 20;

    private void expandCapacity()
    {  Comment[] largerArray =(Comment[])(new Object[comment.length*2]);//unchecked
        // copy the elements array to the largerArray
        for (int i=0; i<numComments; i++)
            largerArray[i] = comment[i];
        comment = largerArray;
    }

    public void setShopID(int shopID){
        this.shopID = shopID;
    }

    public Comments(){

        numComments = 0;
        comment = (Comment[])(new Object(INITAL_CAPACITY));
    }

    public Comments(Collection<? extends Comment> c){
        this();
        for(Comment comment:c)
            add(comment);
    }

    public void add(Comment element){
        if (numComments >= comment.length)
            expandCapacity();
        comment[numComments++] = element;
    }


    public class Comment {

        String comments;

        public Comment(String comments){
            setComments(comments);
        }

        public void setComments(String comments){
            this.comments = comments;
        }

        public String getCommentsnt(){
            return comments;
        }
    }*/

}
