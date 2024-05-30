package main.java.gui;


import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(){
        exp = new PanelExpendedor();
        com = new PanelComprador();

        this.setBackground(Color.white);
        this.setBounds(0,0,1200,800);
        this.setLayout(null);

        this.add(exp);
        this.add(com);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        com.paintComponent(g);
        exp.paintComponent(g);
    }
}
