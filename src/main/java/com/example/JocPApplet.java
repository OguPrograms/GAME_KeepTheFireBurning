package com.example;
import processing.core.PApplet;
import processing.core.PImage;

public class JocPApplet extends PApplet {
    PImage gota, gota2, paraguas, steam, fuego1, fuego2, fuego3;
    gota g1=new gota();
    gota g2=new gota();
    gota g3=new gota();
    gota g4=new gota();
    particulasFuego p1=new particulasFuego();
    particulasFuego p2=new particulasFuego();
    particulasFuego p3=new particulasFuego();
    particulasFuego p4=new particulasFuego();

    int millis=0, segons=0, vidas=3, fireX=width/2, fireVelocity=4, fireSize=15;
    
    @Override
    public void settings() {
        size(500,500);
    }
    @Override
    public void setup(){
        gota=loadImage("gota.png");
        gota2=loadImage("Gota2.png");
        paraguas=loadImage("Paraguas.png");
        steam=loadImage("Steam.png");
        fuego1=loadImage("Fire1.png");
        fuego2=loadImage("Fire2.png");
        fuego3=loadImage("Fire3.png");
    }
    @Override
    public void draw(){
        if (vidas<=0){
            background(0);
            textSize(40);
            text("GAME OVER", width/2-110, height/2-20);
            textSize(20);
            text("SCORE: "+segons, width/2-40, height/2+10);
            if (mousePressed){
                vidas=3;
                millis=millis();
                g1.reset();
                g2.reset();
                g3.reset();
                g4.reset();
            }
        }
        else{
            if (g1.colisionFuego(fireX,fireSize)||g2.colisionFuego(fireX,fireSize)||g3.colisionFuego(fireX,fireSize)||g4.colisionFuego(fireX,fireSize)){
                vidas-=1;
                if(vidas==3)fireSize=15;
                else if(vidas==2)fireSize=12;
                else fireSize=9;
                if (g1.colisionFuego(fireX,fireSize))g1.reset();
                else if (g2.colisionFuego(fireX,fireSize))g2.reset();
                else if (g3.colisionFuego(fireX,fireSize))g3.reset();
                else g4.reset();
            }
            int px=mouseX-15, py=mouseY-10;
            background(0);
            tint(p1.o);
            image(steam, p1.x, p1.y);
            tint(p2.o);
            image(steam, p2.x, p2.y);
            tint(p3.o);
            image(steam, p3.x, p3.y);
            tint(p4.o);
            image(steam, p4.x, p4.y);
            tint(255);
            if (vidas==3)image(fuego1, fireX, height-30);
            else if (vidas==2)image(fuego2, fireX, height-30);
            else image(fuego3, fireX, height-30);
            image(paraguas,px-15,py-10);
            if (g1.paraguas) image(gota2,g1.x,g1.y-5);
            else image(gota,g1.x,g1.y);
            if (g2.paraguas) image(gota2,g2.x,g2.y-5);
            else image(gota,g2.x,g2.y);
            if (g3.paraguas) image(gota2,g3.x,g3.y-5);
            else image(gota, g3.x, g3.y);
            if (g4.paraguas) image(gota2,g4.x,g4.y-5);
            else image(gota, g4.x, g4.y);
            textSize(10);
            text(segons, 10, 20);
            if (fireX>=width-20) fireVelocity=-3;
            else if (fireX<=0) fireVelocity=3;
            else if (fireX<width-50&&fireX>50&&Math.random()>0.985){
                if (fireVelocity==3) fireVelocity=-3;
                else fireVelocity=3;
            }
            fireX=fireX+fireVelocity;
            g1.actualizar(px, py);
            g2.actualizar(px, py);
            g3.actualizar(px, py);
            g4.actualizar(px, py);
            if (p1.o<100)p1.actualizarX(fireX);
            if (p2.o<100)p2.actualizarX(fireX);
            if (p3.o<100)p3.actualizarX(fireX);
            if (p4.o<100)p4.actualizarX(fireX);
            p1.actualizarY();
            p2.actualizarY();
            p3.actualizarY();
            p4.actualizarY();
            segons=(millis()-millis)/1000;
        }
    }
    public static void main (String[]args){
        JocPApplet pApplet= new JocPApplet();
        JocPApplet.runSketch(new String[]{ "bon", "dia"}, pApplet);
    }
}