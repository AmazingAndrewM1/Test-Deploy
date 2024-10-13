package com.github.amazingandrewm1.testdeploy;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class TestDeploy{
    private static JFrame frame;

    public TestDeploy() {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("SimpleMouse");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new BorderLayout());
            frame.add(new AnimatedPanel(), BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
