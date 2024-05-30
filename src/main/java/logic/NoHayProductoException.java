package main.java.logic;

/** Excepcion dedicada al caso en cual se intenta comprar un producto que no esta disponible en el expendedor.
 * @author Nícholas García
 * @author Benjamin Molina
*/
public class NoHayProductoException extends Exception {
    /**
     * @param errorMessage mensaje de error
     */
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);

    }

}