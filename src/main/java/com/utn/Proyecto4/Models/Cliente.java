package com.utn.Proyecto4.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    protected int Id;
    protected String sistemaOp;
    protected String browser;
}
