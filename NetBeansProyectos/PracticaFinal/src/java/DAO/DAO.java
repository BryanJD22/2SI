/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public interface DAO<E, I> {
    public int add(E bean);
    public int delete(E bean, I integer);
    public int update (E bean, I integer);
    public ArrayList<E> findAll();
    
    
}
