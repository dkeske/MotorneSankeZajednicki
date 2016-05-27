/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domen.AbstractObjekat;
import domen.MotorneSanke;

/**
 *
 * @author Daniel
 */
public class Main {
    public static void main(String[] args) {
        AbstractObjekat o = new MotorneSanke();
        System.out.println(o.getClass());
    }
}
