package main.java.gui.Comprador;

import main.java.logic.*;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    //Comprador comprador = new Comprador()
    private JComboBox<String> listaElecciones;
    private String[] elecciones  = {ListProd.COCACOLA.getSabor() + " : " + String.valueOf(ListProd.COCACOLA.getPrecio()),
                                    ListProd.FANTA.getSabor() + " : " + String.valueOf(ListProd.FANTA.getPrecio()),
                                    ListProd.SPRITE.getSabor() + " : " + String.valueOf(ListProd.SPRITE.getPrecio()),
                                    ListProd.SNICKERS.getSabor() + " : " + String.valueOf(ListProd.SNICKERS.getPrecio()),
                                    ListProd.SUPER8.getSabor() + " : " + String.valueOf(ListProd.SUPER8.getPrecio())
    };


    public PanelComprador(){

        this.setBackground(Color.cyan);

        this.setBounds(600,0,600,800);

        iniciarComponentes();

    }

    public void iniciarComponentes() {
        
        this.listaElecciones = new JComboBox<String>(this.elecciones);
        this.listaElecciones.setBounds(0, 0, 100, 100); // TODO
        this.add(this.listaElecciones);



    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}

