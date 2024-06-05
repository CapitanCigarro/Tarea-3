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

    /**
     * Quita un elemento en la posicion i
     * @param i Indice de elemento que se desea borrar
     */

    public T quitarElemento(int i) {
        return al.remove(i);

    }

    public ArrayList getLista(){
        return al;
    }
    /**
     * Retorna un elemento sin borrarlo del deposito
     * @param i int indice del elemento a retornar
     * @return Elemento de indice i en el deposito
     */

    public T verElemento(int i) {
        if (al.isEmpty()) {
            return null;

        }

        return al.get(i);

    }
    
    /**
     * Retorna si el Deposito esta vacio o no
     * @return Boolean
     */

    public boolean isEmpty() {
        return al.isEmpty();

    }

    /**
     * Retorna tamaño  del deposito
     * @return int Tamaño del deposito
     */

    public int getSize() {
        return al.size();

    }

    public void clear() {
        al.clear();

    }

}