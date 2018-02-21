// Lab33ast.java
// This is the student Version of the Lab33a assignment.


import java.awt.*;
import java.awt.event.*;


public class LinkedListLab {
    public static void main(String args[]) {
        GfxLL gfx = new GfxLL();
        gfx.setSize(1000,750);
        gfx.addWindowListener(new WindowAdapter() {public void
        windowClosing(WindowEvent e) {System.exit(0);}});
        gfx.show();
    }
}


class GfxLL extends Frame {

    private int td = 200;		// time delay to slow down graphics display

    public void paint (Graphics g) {
        g.setFont(new Font("ARIAL",Font.BOLD,28));
        g.drawString("LAB 33A 80/100 POINT VERSION",300,50);
        g.setFont(new Font("ARIAL",Font.BOLD,20));
        g.drawString("DRAWING A LINKED LIST AS A STACK",50,215);
        //	g.drawString("DRAWING A LINKED LIST AS A QUEUE",50,415);   	// for 100 point version only
        drawStack(g);
        //	drawQueue(g);												// for 100 point version only
    }

    public void drawStack(Graphics g) {
        GfxNode bottom = new GfxNode(g, 400, 270, 'L',183,td);
        bottom.drawPointer(g, 'P', 20, 50);
        /*GfxNode next = new GfxNode(g, 250,270, 'S', 182, td );
        next.delay(next.delayTIme);
        next.resetBox(g,next.item);
        bottom.eraseP(g);
        next.drawP(g,next.item);
        next.drawLink(g,bottom,next.item);
        GfxNode appeartip = new GfxNode(g, 100, 270, 'P', 182,td);
        appeartip.delay(appeartip.delayTIme);
        appeartip.resetBox(g,appeartip.item);
        next.eraseP(g);
        appeartip.drawP(g,appeartip.item);
        appeartip.drawLink(g,next,appeartip.item);*/
    }
	/*  for 100 point version only
	public void drawQueue(Graphics g)
	{

	}
	*/
}


