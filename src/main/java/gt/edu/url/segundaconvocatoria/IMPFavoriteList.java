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
public class IMPFavoriteList<E> implements FavoriteList {

    protected static class IT<E> {
    private E value;
    public int count = 0;
    /** Constructs new item with initial count of zero. */
    public IT(E val) { value = val; }
    public int getCount() { return count; }
    public E getValue() { return value; }
    public void increment() { count++; }
    // debug utility
    public String toString() { return "(" + value + ":" + count + ")"; }
  }
    protected E value(Position<IT<E>> p) { return p.getElement().getValue(); }
    PositionalList lista = new LinkedPositionalList1<>();
    protected Position<IT<E>> findPosition(E e) {
    Position<IT<E>> walk = lista.first();
    while (walk != null && !e.equals(value(walk)))
      walk = lista.after(walk);
    return walk;
  }
    protected int counter(Position<IT<E>> p) {return p.getElement().getCount();}
    
    protected void Elevar(Position<IT<E>> p) {
    int cnt = counter(p);                           // revised count of accessed item
    Position<IT<E>> walk = p;
    while (walk != lista.first() && counter(lista.before(walk)) < cnt)
      walk = lista.before(walk);                   // found smaller count ahead of item
    if (walk != p)
      lista.addBefore(walk, lista.remove(p));       // remove/reinsert item
  }
    
    @Override
    public void access(Object e) {
        Position<IT<E>> p = findPosition((E) e);     
    if (p == null)
      p = lista.addLast(new IT<E>((E) e));         
    p.getElement().increment();                  
    Elevar(p);                    
    }

    @Override
    public void remove(Object e) {
       Position<IT<E>> p = findPosition((E) e);       
    if (p != null)
      lista.remove(p);
    }

    @Override
    public Iterable getFavorites(int k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
