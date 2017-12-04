/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.segundaconvocatoria;

/**
 *
 * @author Pablo Herrera
 */
public class IMPDoubleStack<E> implements DoubleStack<E>{

    private class NodoPila {
    E dato;
    NodoPila siguiente;
    public NodoPila(E d){
        dato = d;
        siguiente = null;
    }
    }
    
    private NodoPila cimaR;
    private NodoPila cimaB;
    int tamañored;
    int tamañoble;
    
    public IMPDoubleStack(){
        cimaR = null;
        cimaB = null;
        tamañored = 0;
        tamañoble = 0;
    }
    @Override
    public boolean isEmpty() {
        return cimaR==null&&cimaB==null;
    }

    @Override
    public int redSize() {
        return tamañored;
    }

    @Override
    public void redPush(E e) {
         NodoPila nuevo = new NodoPila(e);
         nuevo.siguiente = cimaR;
         cimaR = nuevo;
         tamañored++;
    }

    @Override
    public E redTop() {
       return cimaR.dato;
    }

    @Override
    public E redPop() {
         E auxiliar=cimaR.dato;
         cimaR = cimaR.siguiente;
         tamañored--;
         return auxiliar;
    }

    @Override
    public int blueSize() {
        return tamañoble;
    }

    @Override
    public void bluePush(E e) {
         NodoPila nuevo = new NodoPila(e);
         nuevo.siguiente = cimaB;
         cimaB = nuevo;
         tamañoble++;
    }

    @Override
    public E blueTop() {
       return cimaB.dato;
    }

    @Override
    public E bluePop() {
         E auxiliar=cimaB.dato;
         cimaB = cimaB.siguiente;
         tamañoble--;
         return auxiliar;
    }
    
}
