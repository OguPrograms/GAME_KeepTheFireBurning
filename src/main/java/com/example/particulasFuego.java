package com.example;

public class particulasFuego {
    int x=0, y=470, o=(int)Math.random()*100;
    public void actualizarX(int fireX){
        x=fireX+(int)(Math.random()*10);
        y=470;
        o=270;
    }
    public void actualizarY(){
        y=y-1;
        o=o-(int)(Math.random()*10+5);
    }
}
