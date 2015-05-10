/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

import java.util.Comparator;

/**
 *
 * @author Administrator
 */
public class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }
    
}
