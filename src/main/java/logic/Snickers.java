package main.java.logic;

/**Representa un Snickers.
 * @author Nícholas García
 * @author Benjamin Molina
*/
public class Snickers extends Dulce {
    /**Crea un snickers con el numero de serie especificado
     * @param serie numero de serie a asignar al snicker
     */
    public Snickers(int serie) {
        super(serie);

    }

    public String consumir() {
        return "snickers";
    
    }

}
