// Lab24bst.java
// This is the student version of the lab24b assignment.


import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class Lab24b {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Gfx gfx = new Gfx();
        gfx.setSize(900,700);
        gfx.addWindowListener(new WindowAdapter() {public void
        windowClosing(WindowEvent e) {System.exit(0);}});
        gfx.show();
    }
}

class Gfx extends Frame {
    public void paint(Graphics g) {

    }
}

//screen size = 1280, 720
class Circle {
    int size , incX,  incY, timeDelay, tlX, tlY;

    public Circle(int size, int incX, int incY, int timeDelay) {
        this.size = size;
        this.incX = incX;
        this.incY = incY;
        this.tlX = (1280/2);
        this.tlY = (720/2);
        this.timeDelay = timeDelay;
    }

    public void delay(double n){

       try{
           Thread.sleep(20);
       }catch(Exception e){
           Thread.currentThread().interrupt();
       }
    }
    public void drawCircle(Graphics g){
        g.drawOval(tlX,tlY,size,size);

    }
    public void settlX() {

    }
}