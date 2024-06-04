package main.java.gui;

import main.java.gui.labels.LabelTest;
import main.java.logic.Bebida;
import main.java.logic.Deposito;
import main.java.logic.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelDeposito extends JPanel {

    Deposito depo;
    public PanelDeposito(Deposito argDepo){
        super();
        this.setBackground(Color.ORANGE);
        this.setBounds(50,20,500,50);
        this.depo = argDepo;
        this.addLabels();

    }

    public void addLabels(){
        for(Object prod : depo.getLista()){
            this.add(new LabelTest((Producto) prod, depo));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
