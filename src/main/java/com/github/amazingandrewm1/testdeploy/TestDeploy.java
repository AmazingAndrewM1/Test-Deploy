package com.github.amazingandrewm1.testdeploy;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class TestDeploy extends JFrame{
    public TestDeploy() {
        setLayout(new BorderLayout());
        add(new AnimatedPanel(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestDeploy frame = new TestDeploy();
            frame.setTitle("SimpleMouse");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
