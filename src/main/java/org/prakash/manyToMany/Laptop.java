package org.prakash.manyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "laptop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
    @ManyToMany(mappedBy = "laptops")
    private List<Alien> aliens;

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
