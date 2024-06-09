package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;

    private String nomrol;

}