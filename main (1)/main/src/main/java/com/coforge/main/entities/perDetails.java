package com.coforge.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@javax.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "perdetails")
public class perDetails {
    @Id
    private int ecod;
    private String  project;
    private String date;
    private String loc;
    private String working;
    private String number;
    private String date_action;
    private String family;
    private String pos;
    private String test;
    private String hosp;
    private String date_joined;
}

