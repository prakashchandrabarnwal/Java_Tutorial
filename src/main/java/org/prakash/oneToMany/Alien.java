package org.prakash.oneToMany;

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
    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER) //by default its FetchType.LAZY
    private List<Laptop> laptops;
}
