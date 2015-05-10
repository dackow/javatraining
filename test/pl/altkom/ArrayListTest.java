/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ArrayListTest {

    public ArrayListTest() {
    }

    /**
     * Test of add method, of class ArrayList.
     */
    @Test
    public void testAdd() {
        ArrayList al = new ArrayList(10);
        for (int i = 0; i < 15; i++) {
            al.add(i);
        }

        assert al._arr[12].equals(12) : "add test";
    }

    public void testBadElement() {
        ArrayList<String> l = new ArrayList<>(2);
        l.add("a");
        l.add("b");
        l.add("c");

        assert !(l.get(1).equals("b"));
    }

    /**
     * Test of length method, of class ArrayList.
     */
    @Test
    public void testLength() {
        ArrayList<String> l = new ArrayList<>(2);
        l.add("a");
        l.add("b");
        l.add("c");

        assert l.length() == 3;
    }

    /**
     * Test of get method, of class ArrayList.
     */
    @Test
    public void testGet() {
        ArrayList al = new ArrayList(10);
        al.add(12);
        assert (Integer) al.get(0) == 12;

    }

}
