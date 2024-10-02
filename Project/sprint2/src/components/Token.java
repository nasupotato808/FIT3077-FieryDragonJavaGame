package components;

import animals.Animal;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class Token extends GameComponent {

    public String dragonColour;

    public int position;

    public int currentSteps;

    //public Timer timer;

    ImageIcon tokenImage;

    Point imageCorner;

    Point prevPt;

    DragListener dragListener;

    public Token(String dragonColour) {
        this.dragonColour = dragonColour;
        this.currentSteps = 0;
        //this.timer = new Timer(100,this);
        this.position = 0;
        imageCorner = new Point(0,0);
        if (Objects.equals(this.getDragonColour(), "Green")){
            imageCorner = new Point(0,290);
        }
        ClickListener clickListener = new ClickListener();
        dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public String toString() {
    return dragonColour ;
    }

    public String getDragonColour() {
        return dragonColour;
    }

    public String getAnimalName(Animal animal) {
        if (Objects.equals(animal.getAnimalName(), "salamander")){
            return "White";
        } else if (Objects.equals(animal.getAnimalName(), "bat")) {
            return "Blue";
        } else if (Objects.equals(animal.getAnimalName(), "babydragon")){
            return "Green";
        } else if (Objects.equals(animal.getAnimalName(), "spider")){
            return "Yellow";
        }
        return "";
    }

    public void setDragonColour(String colour){
        this.dragonColour = colour;
    }

    public int getPosition() {
        return position;
    }

    public int getCurrentSteps() {
        return currentSteps;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String filename = "/images/"+this.getDragonColour().toLowerCase()+"_dragon.png";
        tokenImage = new ImageIcon(new ImageIcon(getClass().getResource(filename)).getImage().getScaledInstance(45,65,Image.SCALE_SMOOTH));
        tokenImage.paintIcon(this,g,(int)(imageCorner.getX()), (int)(imageCorner.getY()));
        //g.drawImage(tokenImage, x,y,45,65,null);
        if(currentSteps==25){
            this.removeMouseMotionListener(dragListener);
        }
    }

    private class ClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point currentPt = e.getPoint();
            imageCorner.translate((int)(currentPt.getX()-prevPt.getX()), (int)(currentPt.getY()-prevPt.getY()));
            prevPt = currentPt;
            repaint();
            int xpt = (int)prevPt.getX();
            int ypt = (int)prevPt.getY();
            if (5<xpt && xpt<24 && 325<ypt && ypt<345){
                currentSteps = 25;
            }
        }
    }





}



