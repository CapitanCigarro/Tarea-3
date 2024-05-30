package main.java.logic;

/** Excepcion para cuando se intenta comprar sin una moneda.
 * @author Nícholas García
 * @author Benjamin Molina
*/





public class PagoIncorrectoException extends Exception {
    /**
     * @param errorMessage mensaje de error
     */
    public PagoIncorrectoException(String errorMessage) {
        super(errorMessage);

    }

}


