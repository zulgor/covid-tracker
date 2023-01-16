package com.coforge.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;



@javax.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "userdata")
public class Entity {
    @Id
    private int ecod;
    private String ou;
    private String name;
    private String location;
    private String service_line;
    private String doj;
    private String pa;
    private String vbu;
    @OneToOne(cascade = CascadeType.ALL)
    private perDetails details;

}
