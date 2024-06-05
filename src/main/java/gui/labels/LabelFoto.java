package main.java.gui.labels;

import main.java.logic.Deposito;
import main.java.logic.Producto;

import javax.swing.*;
import java.awt.*;

public class LabelFoto extends JLabel {

    int serie;
    Producto prod;
    Deposito depo;
    public LabelFoto(Producto p, Deposito argDepo, String fileName){
        super();
        this.prod = p;
        this.depo = argDepo;
        this.setIcon(new ImageIcon(fileName));
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
