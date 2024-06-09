package com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.endpoint;


import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.exception.NotFoundException;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.service.UsuarioService;
import com.cibertec.ws.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UsuarioEndpoint {

    private static final String NAMESPACE_URL = "http://www.cibertec.com/ws/objects";
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioEndpoint(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getUsuariosRequest")
    @ResponsePayload
    public GetUsuariosResponse getUsuarios(@RequestPayload GetUsuariosRequest request) {
        GetUsuariosResponse response = new GetUsuariosResponse();
        response.getUsuarios().addAll(usuarioService.listarUsuarios());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request) {
        GetUsuarioResponse response = new GetUsuarioResponse();
        Usuariows usuariows = usuarioService.obtenerUsuarioPorId(request.getId());
        if (usuariows == null) {
            throw new NotFoundException("El usuario con el ID " + request.getId() + " no existe!");
        }
        response.setUsuario(usuariows);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "postUsuarioRequest")
    @ResponsePayload
    public PostUsuarioResponse saveUsuario(@RequestPayload PostUsuarioRequest request) {
        PostUsuarioResponse response = new PostUsuarioResponse();
        response.setUsuario(usuarioService.registrarActualizarUsuario(request.getUsuario()));
        return response;
    }
}