package org.prakash;

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
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;
}
