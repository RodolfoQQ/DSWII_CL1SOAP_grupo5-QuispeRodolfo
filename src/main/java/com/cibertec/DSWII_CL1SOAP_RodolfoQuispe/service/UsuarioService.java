package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.service;

import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.convert.UsuarioConvert;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model.Usuario;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.repository.UsuarioRepository;
import com.cibertec.ws.objects.Usuariows;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConvert usuarioConvert;

    @Override
    public List<Usuariows> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioConvert.convertUsuarioListToUsuariowsList(usuarios);
    }

    @Override
    public Usuariows obtenerUsuarioPorId(int id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> usuarioConvert.convertUsuarioToUsuariows(usuario)).orElse(null);
    }

    @Override
    public Usuariows registrarActualizarUsuario(Usuariows usuariows) {
        Usuario usuario = usuarioConvert.convertUsuariowsToUsuario(usuariows);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return usuarioConvert.convertUsuarioToUsuariows(nuevoUsuario);
    }
}


