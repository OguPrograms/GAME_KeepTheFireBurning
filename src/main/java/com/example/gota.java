package com.example;

public class gota {
    int y=0;
    float x=(float)Math.random()*500;
    int velocidad=(int)(Math.random()*10)+5, esperar=0;
    boolean paraguas=false;
    
    public void actualizar(int px, int py){
        if (esperar==0){
            if (paraguas||y>500){
                y=-20;
                x=(float)Math.random()*500;
                paraguas=false;
                velocidad=(int)(Math.random()*10)+5;
            }else if(x>=px-35&&x<=px+35&&y>=py-10&&y<=py+10){
                paraguas=true;
                esperar=5;
            }else y+=velocidad;
        }else esperar-=1;
    }
    public boolean colisionFuego(int fireX, int fireSize){
        if (x<=fireX+fireSize&&x>=fireX-fireSize&&y<=570&&y>=490) return true;
        return false;
    }
    public void reset(){
        y=0;
        x=(float)Math.random()*500;
        velocidad=(int)(Math.random()*10)+5;
    }
}
