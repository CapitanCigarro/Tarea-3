package main.java.logic;

/** Representa una bebida CocaCola.
 * @author Nícholas García
 * @author Benjamin Molina
*/

public class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    
    /** 
     * @return String "Sabor" del producto para poder identificarlo
    */
    public String consumir() {
        return "cocacola";

    }

}
