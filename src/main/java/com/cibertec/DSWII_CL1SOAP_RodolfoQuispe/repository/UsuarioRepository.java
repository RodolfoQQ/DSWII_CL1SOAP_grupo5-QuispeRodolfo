package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.repository;

import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}