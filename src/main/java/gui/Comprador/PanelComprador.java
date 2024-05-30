package main.java.gui.Comprador;

import main.java.logic.Comprador;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    //Comprador comprador = new Comprador()
    public PanelComprador(){

        this.setBackground(Color.cyan);

        this.setBounds(600,0,600,800);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}

