
package model;

import java.util.ArrayList;


public interface DAO<E, I> {
    public int add(E bean);
    public int delete(E bean, I integer);
    public int update(E bean, I integer);
    public ArrayList<E> findAll(); 
}
