package main.java.logic;

/** Representa una moneda
 * @author Nícholas García
 * @author Benjamin Molina
*/
public abstract class Moneda implements Comparable<Moneda> {
    private int serie;
    private static int monedasExistentes = 0;
    public Moneda() {
        this.serie = monedasExistentes;
        ++monedasExistentes;

    }
    public int getSerie() {
        return this.serie;


    }
    /**Obtiene el valor de la moneda
     * @return un int que representa el valor de la moneda
    */
    public abstract int getValor();

    /**
     * @param m La Moneda con la que se compara la moneda actual.
     * @return Diferencia entre el valor de la moneda actual y la moneda a comparar.
     */
    @Override
    public int compareTo(Moneda m) {
        return this.getValor() - m.getValor();

    }

}