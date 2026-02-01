package org.prakash.manyToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity()
@Table(name = "alien")
public class Alien
{
    @Id
    private int aid;
    private String aname;
    private String tech;
    @ManyToMany
    private List<Laptop> laptops;
}
