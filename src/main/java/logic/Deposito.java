package main.java.logic;

import java.util.ArrayList;

/**Representa un deposito generico para objetos del tipo especificado.
 * @author Benjamin Molina
 * @author Nícholas García
 * @param <T> El tipo de elementos que contendra el deposito.
 */
public class Deposito<T> {
    private ArrayList<T> al;

    /**Crea un deposito generico.
     */
    public Deposito() {
        al = new ArrayList<>();

    }

    /**Añade un elemento del tipo especificado a el contenedor generico.
     * @param a Elemento a agregar.
     */
    public void addElemento(T a) {
        al.add(a);

    }

    /**Quita un objeto del deposito.
     * @return Un elemento del deposito.
     */
    public T getElemento() {
        if (al.size() == 0) {
            return null;

        }

        return al.remove(0);

    }   

}