package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "especialidad")
@Data
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEspecialidad;

    private String Titulo;
    private String Funcion;
    private Date FechGraduacion;
    private int IdMedico;


}
