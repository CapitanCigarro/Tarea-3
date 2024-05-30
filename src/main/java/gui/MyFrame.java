package main.java.gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    PanelPrincipal principal;
    public MyFrame(){
        super();
        principal = new PanelPrincipal();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setTitle("Maquina Expendedora");
        this.setVisible(true);

        this.add(principal);

    }
}
