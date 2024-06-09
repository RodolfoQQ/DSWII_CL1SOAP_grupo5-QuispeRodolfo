package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "medico")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdMedico;

    private String NomMedico;
    private String ApeMedico;
    private Date FechNacMedico;


}