/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Person implements Comparable<Person>, Serializable{
    private final String _firstName;

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }
    private final String _lastName;

    public Person(String _firstName, String _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
    }
    
    public Person() {
        this("default", "default");
    }

    public void displayData(){
        System.out.println(String.format("Last name: %s, first name: %s", _lastName,_firstName));
    }

    @Override
    public String toString() {
        return "Person{" + "_firstName=" + _firstName + ", _lastName=" + _lastName + '}';
    }
    
    
    
    @Override
    public int compareTo(Person o) {
        return _lastName.compareToIgnoreCase(o._lastName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this._firstName);
        hash = 23 * hash + Objects.hashCode(this._lastName);
        return hash;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this._firstName, other._firstName)) {
            return false;
        }
        if (!Objects.equals(this._lastName, other._lastName)) {
            return false;
        }
        return true;
    }

   
    
    
    
    public static void main(String[] args) {
        List<Person> al = new ArrayList<>();
        al.add(new Person("Mark", "Knopfler"));
        al.add(new Person("Zbigniew", "Zielinski"));
        al.add(new Person("Tomasz", "Podhajski"));
        al.add(new Person("Rafal", "Hanf"));
        al.add(new Person("Waldemar", "Dacko"));
        
        //Arrays.sort(al);
        Collections.sort(al,new PersonComparator());
        
        for(Person p : al){
            System.out.println(p);
        }
        
        
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("xxx.ser"))) {
                oos.writeObject(al.get(0));
            }
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
