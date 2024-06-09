package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.service;

import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model.Usuario;
import com.cibertec.ws.objects.Usuariows;

import java.util.List;

public interface IUsuarioService {

    List<Usuariows> listarUsuarios();

    Usuariows obtenerUsuarioPorId(int id);

    Usuariows registrarActualizarUsuario(Usuariows usuario);


}
