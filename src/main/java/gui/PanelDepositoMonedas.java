package main.java.gui;

import main.java.gui.labels.LabelFoto;
import main.java.logic.*;

public class PanelDepositoMonedas extends PanelDeposito{
    private String originalFileName;
    public PanelDepositoMonedas(Deposito depo, String fileName) {
        super(depo, fileName);
        originalFileName = this.fileName;

    }

    @Override
    public void addLabels() {
        for(Object prod : depo.getLista()){
            Moneda m = (Moneda) prod;
            if(m.getClass() == Moneda100.class) {
                this.fileName += "Moneda100.png";

            }

            if (m.getClass() == Moneda500.class) {
                this.fileName += "Moneda500.png";

            }

            if(m.getClass() == Moneda1000.class) {
                this.fileName += "Moneda1000.png";

            }

            this.add(new LabelFoto(m, depo, this.fileName));

        }

    }

    @Override
    public void reajustLabesl() {
        this.removeAll();
        for(Object prod : depo.getLista()) {
            Moneda m = (Moneda) prod;

            if(m.getClass() == Moneda100.class) {
                this.fileName = originalFileName + "Moneda100 - 1.png";

            }

            if (m.getClass() == Moneda500.class) {
                this.fileName = originalFileName + "Moneda500 - 1.png";

            }

            if(m.getClass() == Moneda1000.class) {
                this.fileName = originalFileName + "Moneda1000 - 1.png";

            }
            
            this.add(new LabelFoto(m, depo, this.fileName));

        }

        this.repaint();
 
    }

    
}
