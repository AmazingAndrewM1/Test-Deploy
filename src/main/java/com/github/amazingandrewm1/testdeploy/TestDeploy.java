package com.github.amazingandrewm1.testdeploy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TestDeploy extends JFrame{
    public TestDeploy() {
        setLayout(new BorderLayout());
        add(new Board(), BorderLayout.CENTER);
    }

    private static final class Board extends JComponent {
        private final int NUM_ROWS = 8;
        private final int NUM_COLUMNS = 8;
        private final int SQUARE_SIZE = 50;
        private int rNum = 0;
        private int cNum = 0;

        public Board(){
            this.setPreferredSize(new Dimension(SQUARE_SIZE * NUM_COLUMNS, SQUARE_SIZE * NUM_ROWS));

            JLabel testLabel = new JLabel("Hi");
            testLabel.setLocation(120, 210);
            testLabel.setVisible(true);

            for (int r = 0; r < NUM_ROWS; ++r){
                for (int c = 0; c < NUM_COLUMNS; ++c){
                    JButton button = new JButton();
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setSize(SQUARE_SIZE, SQUARE_SIZE);
                    button.setLocation(SQUARE_SIZE * c, SQUARE_SIZE * r);

                    final int R_FINAL = r;
                    final int C_FINAL = c;
                    button.addActionListener((ActionEvent e) -> {
                        rNum = R_FINAL;
                        cNum = C_FINAL;
                        repaint();
                    });
                    this.add(button);
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2D = (Graphics2D) g;
            boolean isLight = true;
            for (int r = 0; r < NUM_ROWS; ++r){
                for (int c = 0; c < NUM_COLUMNS; ++c){
                    if (isLight){
                        g2D.setColor(Color.WHITE);
                        isLight = false;
                    }
                    else{
                        g2D.setColor(Color.BLACK);
                        isLight = true;
                    }
                    g2D.fillRect(c * SQUARE_SIZE, r * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                isLight = !isLight;
            }

            Font currentFont = g2D.getFont();
            g2D.setFont(currentFont.deriveFont(currentFont.getSize() * 1.5F));
            g2D.setColor(Color.RED);
            String text = "(" + rNum + ", " + cNum + ")";
            g2D.drawString(text, 100, 125);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestDeploy frame = new TestDeploy();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
