package com.company;

public class Tag {
    public int position;
    public char nextChar;


    public Tag(int position, char nextChar){
        this.position=position;
        this.nextChar=nextChar;
    }
    public Tag(){}
    public void setPosition(int position){
      this.position = position;

    }
    public int getPosition(){
        return position;
    }
    public void setNextChar(char nextChar){
     this.nextChar=nextChar;
    }
    public char getNextChar(){
        return nextChar;
    }
    public String toString(){
        return "<" +position+ ", " +nextChar+ ">";
    }
}