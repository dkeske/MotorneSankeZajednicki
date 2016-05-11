/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domen.MotorneSanke;
import domen.TipSanki;

/**
 *
 * @author Daniel
 */
public class Test {
    public static void main(String[] args) {
        MotorneSanke ms = new MotorneSanke("200", "BWA", "3", new TipSanki("201", "GTX", "Touring", 1.5));
        String m = ms.vratiParametre();
        System.out.println(m);
    }
}
