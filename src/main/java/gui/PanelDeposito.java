package main.java.gui;

import main.java.logic.Deposito;
import main.java.logic.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelDeposito extends JPanel {

    String fileName;
    Deposito depo;
    public PanelDeposito(Deposito argDepo,String fileName){
        super();
        this.setBounds(50,20,500,60);
        this.depo = argDepo;
        this.fileName = fileName;
        this.addLabels();

    }

    public void addLabels(){
        for(Object prod : depo.getLista()){
            this.add(new LabelFoto((Producto) prod, depo,fileName));
        }
    }

    public void reajustLabesl() {
        this.removeAll();
        for(Object prod : depo.getLista()) {
            this.add(new LabelFoto(prod, depo, fileName));

        }

        this.repaint();
 
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
