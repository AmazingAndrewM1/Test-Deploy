package com.github.amazingandrewm1.testdeploy;

import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;

public class AnimatedPanel extends JPanel{
    private int mouseX = 0;
    private int mouseY = 0;

    public AnimatedPanel(){
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me){
                mouseX = me.getX();
                mouseY = me.getY();
                repaint();
            }

            @Override public void mousePressed(MouseEvent me){}
            @Override public void mouseReleased(MouseEvent me){}
            @Override public void mouseEntered(MouseEvent me){}
            @Override public void mouseExited(MouseEvent me){}
        });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        String text = "Mouse Coordinates: (" + mouseX + ", " + mouseY + ")";
        g.drawString(text, 100, 100);
    }
}
