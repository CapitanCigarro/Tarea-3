package main.java.gui.labels;

import main.java.logic.Deposito;
import main.java.logic.Moneda;
import main.java.logic.Producto;

import javax.swing.*;
import java.awt.*;

public class LabelFoto extends JLabel {

    int serie;
    Object prod;
    Deposito depo;
    public LabelFoto(Object p, Deposito argDepo, String fileName){
        super();
        this.prod = p;
        this.depo = argDepo;
        this.setIcon(new ImageIcon(fileName));

        try {
            Moneda m = (Moneda) prod;
            JLabel serie = new JLabel();
            serie.setText(String.valueOf(m.getSerie()));
            serie.setForeground(Color.white);
            this.add(serie);
            this.setLayout(null);
            

        } catch (Exception e) {
            
        }

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
