package LinkedList;

import java.awt.*;
import java.awt.event.*;

public class Lab33ast {

    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        GfxApp gfx = new GfxApp();
        gfx.setSize(1000, 750);
        gfx.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        gfx.show();
    }

}

@SuppressWarnings("serial")
class GfxApp extends Frame {

    @SuppressWarnings("unused")
    private int td = 200; // time delay to slow down graphics display

    public void drawString(Graphics g, String s, int a, int b, int delay){
        String temp = "";
        for(char ch: s.toCharArray()){
            temp += ch;
            g.drawString(temp, a, b);
            try{Thread.sleep(delay);}catch(Exception e){}
        }
    }

    public void paint(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 28));
        drawString(g, "LAB 33A 100 POINT VERSION", 300, 50, 50);
        g.setFont(new Font("ARIAL", Font.BOLD, 20));
        delay();
        drawString(g, "DRAWING A LINKED LIST AS A STACK", 50, 215, 50);
        drawStack(g);
        delay();
        drawString(g, "DRAWING A LINKED LIST AS A QUEUE", 50, 415, 50);
        drawQueue(g); // for 100 point version only
    }

    public void drawStack(Graphics g) {
        delay();
        GfxNode p = new GfxNode(g, 450 + 250, 215, 'P', 0, 0);
        p.drawNull(g, 0);
        p.enterData(g, 'A', 0);
        GfxNode temp = p;
        delay();
        p.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 450 + 200, 215, 'P', 0, 0);
        p.enterData(g, 'B', 0);
        delay();
        p.drawLink(g, temp, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 450 + 150, 215, 'P', 0, 0);
        p.enterData(g,'C', 0);
        delay();
        p.drawLink(g, temp, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 450 + 100, 215, 'P', 0, 0);
        p.enterData(g, 'D', 0);
        delay();
        p.drawLink(g, temp, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 450 + 50, 215, 'P', 0, 0);
        p.enterData(g, 'E', 0);
        delay();
        p.drawLink(g, temp, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
    }

    public void drawQueue(Graphics g) {
        delay();
        GfxNode p = new GfxNode(g, 500, 415, 'P', 0, 0);
        p.drawPointer(g, 'F', 14, 0);
        p.enterData(g, 'A', 0);
        p.drawPointer(g, 'T', 24, 0);
        GfxNode temp = p;
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 550, 415, 'P', 0, 0);
        p.enterData(g, 'B', 0);
        delay();
        temp.drawLink(g, p, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 600, 415, 'P', 0, 0);
        p.enterData(g, 'C', 0);
        delay();
        temp.drawLink(g, p, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 650, 415, 'P', 0, 0);
        p.enterData(g, 'D', 0);
        delay();
        temp.drawLink(g, p, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
        delay();
        p.drawPointer(g, 'P', 1, 9);
        p = new GfxNode(g, 700, 415, 'P', 0, 0);
        p.enterData(g, 'E', 0);
        delay();
        temp.drawLink(g, p, 0);
        temp.drawPointer(g, 'T', 24, 9);
        temp = p;
        temp.drawPointer(g, 'T', 24, 0);
    }

    public void delay(){
        for(double i = 0; i < 1; i+= .000000002);
    }

}
