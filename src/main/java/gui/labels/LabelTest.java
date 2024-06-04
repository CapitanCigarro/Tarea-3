package main.java.gui.labels;

import main.java.logic.Deposito;
import main.java.logic.Producto;

import javax.swing.*;
import java.awt.*;

public class LabelTest extends JLabel {

    int serie;
    Producto prod;
    Deposito depo;
    public LabelTest(Producto p,Deposito argDepo){
        super();
        this.prod = p;
        this.depo = argDepo;
        this.setText("C");
    }

    @Override
    public void paintComponent(Graphics g) {
        if (depo.getLista().contains(prod)) {
            super.paintComponent(g);
        } else {
            this.getParent().remove(this);
        }
    }


}
