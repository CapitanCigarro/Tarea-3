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
        this.setForeground(Color.white);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);

        if (prod.getClass().getName().contains("Moneda")){
            Moneda m = (Moneda) prod;
            this.setText(String.valueOf(m.getSerie()));

        }else{
            Producto prodCast = (Producto) prod;
            this.setText(String.valueOf(prodCast.getSerie()));
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
