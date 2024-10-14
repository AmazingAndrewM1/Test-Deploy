package com.github.amazingandrewm1.testdeploy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestDeploy extends JFrame {

    private int mouseX = 0;
    private int mouseY = 0;
    private final AnimatedPanel animatedPanel;

    public TestDeploy() {
        animatedPanel = new AnimatedPanel();
        animatedPanel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me){
                mouseX = me.getX();
                mouseY = me.getY();
                animatedPanel.repaint();
            }

            @Override public void mousePressed(MouseEvent me){}
            @Override public void mouseReleased(MouseEvent me){}
            @Override public void mouseEntered(MouseEvent me){}
            @Override public void mouseExited(MouseEvent me){}
        });

        setLayout(new BorderLayout());
        add(animatedPanel, BorderLayout.CENTER);
        add(new JButton("Start"), BorderLayout.NORTH);
        add(new JButton("Stop"), BorderLayout.SOUTH);
    }

    class AnimatedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            String text = "Mouse Coordinates: (" + mouseX + ", " + mouseY + ")";
            g.drawString(text, 100, 100);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestDeploy frame = new TestDeploy();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
