package main.java.logic;

/** Excepcion para cuando se intenta comprar un producto con menos dinero del necesario.
 * @author Nícholas García
 * @author Benjamin Molina
*/
public class PagoInsuficienteException extends Exception {
    /**
     * @param errorMessage mensaje de error
     */
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);

    }

}