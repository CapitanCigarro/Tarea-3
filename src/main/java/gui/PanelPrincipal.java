package main.java.gui;


import javax.swing.*;

import main.java.logic.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPrincipal extends JPanel implements MouseListener {
    private PanelComprador com;
    private PanelExpendedor exp;
    private Expendedor expendedor;

    public PanelPrincipal(){
        expendedor = new Expendedor(5);
        expendedor = new Expendedor(5);
        exp = new PanelExpendedor(expendedor);
        com = new PanelComprador(expendedor, exp);

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

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        if(x <= 600) {
            exp.rellenar();

        }
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
