package org.prakash;
import java.util.Arrays;

import org.prakash.manyToMany.Alien;
import org.prakash.manyToMany.AlienService;
import org.prakash.manyToMany.Laptop;

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

        Alien prakash = new Alien(3,"Prakash","Java", Arrays.asList(mac, window));
        Alien barnwal = new Alien(4, "barnwal", "TypeScript", Arrays.asList(window));



        //used for OneToMany
        // mac.setAlien(alien);
        // window.setAlien(alien);

        mac.setAliens(Arrays.asList(prakash));
        window.setAliens(Arrays.asList(barnwal));

        prakash.setLaptops(Arrays.asList(mac, window));
        barnwal.setLaptops(Arrays.asList(window, mac));



        AlienService.createAlien(Arrays.asList(prakash, barnwal), Arrays.asList(mac, window));

    }
}