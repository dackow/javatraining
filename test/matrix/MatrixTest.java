/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class MatrixTest {

    public MatrixTest() {
    }

    /**
     * Test of main method, of class Matrix.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of getElementAt method, of class Matrix.
     */
    @Test
    public void testGetElementAt() {
        Matrix m = new Matrix(3, 3);
        m._matrix[1][2] = 13.0;
        
        assert m.getElementAt(1, 2) == 13.0 : "checks if the element was filled with correct value";
    }

    /**
     * Test of setElementAt method, of class Matrix.
     */
    @Test
    public void testSetElementAt() {
        Matrix m = new Matrix(3, 3);
        m.setElementAt(1, 1, 12.0);
        //assert m.getElementAt(1, 1) == 1 : "checks if the element with index 1,1 equals to 12";
        assert m._matrix[1][1] == 12.0 : "checks if the element with index 1,1 equals to 12";
    }

    @Test
    public void testSetElementAtError(){
        Matrix m = new Matrix(3, 3);
        m.setElementAt(1, 1, 12.0);
        //assert m.getElementAt(1, 1) == 1 : "checks if the element with index 1,1 equals to 12";
        assert !(m._matrix[1][1] == 1.0) : "checks if the element with index 1,1 is not equal to 12";        
    }
}
