/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author Administrator
 */
public class Matrix {

    protected Double[][] _matrix = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrix m = new Matrix(10, 10);
    }

    public Matrix(int row_num, int col_num) {
        if (row_num > 0 && col_num > 0) {
            _matrix = new Double[row_num][col_num];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Double getElementAt(int x, int y) {
        return _matrix[x][y];
    }

    public void setElementAt(int x, int y, Double val) {
        if (x < _matrix.length && y < _matrix[x].length) {
            _matrix[x][y] = val;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
