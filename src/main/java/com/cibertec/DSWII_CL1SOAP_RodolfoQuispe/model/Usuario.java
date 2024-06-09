package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;

    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private byte activo;


}