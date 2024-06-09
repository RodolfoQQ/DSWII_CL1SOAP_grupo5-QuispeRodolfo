package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.convert;

import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model.Usuario;
import com.cibertec.ws.objects.Usuariows;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConvert {

    public Usuario convertUsuarioWsToUsuario(Usuariows usuariows) {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(usuariows.getIdusuario());
        usuario.setNomusuario(usuariows.getNomusuario());
        usuario.setEmail(usuariows.getEmail());
        usuario.setPassword(usuariows.getPassword());
        usuario.setNombres(usuariows.getNombres());
        usuario.setApellidos(usuariows.getApellidos());
        usuario.setActivo(usuariows.getActivo());
        return usuario;
    }

    public List<Usuario> convertUsuarioWsToUsuario(List<Usuariows> usuariowsList) {
        List<Usuario> usuarioList = new ArrayList<>();
        usuariowsList.forEach(usuariows -> {
            usuarioList.add(convertUsuarioWsToUsuario(usuariows));
        });
        return usuarioList;
    }

    public Usuariows convertUsuarioToUsuarioWs(Usuario usuario) {
        Usuariows usuariows = new Usuariows();
        usuariows.setIdusuario(usuario.getIdusuario());
        usuariows.setNomusuario(usuario.getNomusuario());
        usuariows.setEmail(usuario.getEmail());
        usuariows.setPassword(usuario.getPassword());
        usuariows.setNombres(usuario.getNombres());
        usuariows.setApellidos(usuario.getApellidos());
        usuariows.setActivo(usuario.getActivo());
        return usuariows;
    }

    public List<Usuariows> convertUsuarioToUsuarioWs(List<Usuario> usuarioList) {
        List<Usuariows> usuariowsList = new ArrayList<>();
        usuarioList.forEach(usuario -> {
            usuariowsList.add(convertUsuarioToUsuarioWs(usuario));
        });
        return usuariowsList;
    }
}

