package org.prakash;
import java.util.Arrays;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        Laptop mac = new Laptop();
        mac.setRam(64);
        mac.setLid(1);
        mac.setBrand("Apple");
        mac.setModel("M4");

        Laptop window = new Laptop();
        window.setRam(16);
        window.setLid(2);
        window.setBrand("windows");
        window.setModel("XPS");

        Alien alien = new Alien(3,"Prakash","average", Arrays.asList(mac, window));

        mac.setAlien(alien);
        window.setAlien(alien);

        AlienService.createAlien(alien);

    }
}