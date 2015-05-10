/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

public class ArrayList<T> {

    protected Object[] _arr = null;
    private int _lastIndex = 0;
    private final int APPENDIX = 5;

    public ArrayList(int numOfElem) {
        _arr = new Object[numOfElem];
    }

    ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(T elem) {
        if (_lastIndex >= _arr.length) {
            extendArray();
        }
        _arr[_lastIndex++] = elem;
    }

    private void extendArray() {
        Object[] _newTab = new Object[_arr.length + APPENDIX];
        System.arraycopy(_arr, 0, _newTab, 0, _arr.length);
        _arr = _newTab;
    }

    public int length() {
        return _lastIndex;
    }

    public T get(int index) {
        if (index < _arr.length) {
            return (T) _arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList al = new ArrayList(2);

        for (int i = 0; i < 35; i++) {
            al.add(i);
        }

        for (int i = 0; i < al.length(); i++) {
            System.out.println(al.get(i));
        }

    }

}
