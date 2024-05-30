package main.java.gui;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {

    public PanelExpendedor(){
        this.setBounds(0,0,600,800);
        this.setBackground(Color.black);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    
    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(mgr);
        

    }
}
