import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.convert.UsuarioConvert;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.model.Usuario;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.repository.UsuarioRepository;
import com.cibertec.DSWII_CL1SOAP_RodolfoQuispe.service.IUsuarioService;
import com.cibertec.ws.objects.Usuariows;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConvert usuarioConvert;

    @Override
    public List<Usuariows> listarUsuarios() {
        return usuarioConvert.convertUsuarioToUsuarioWs(
                usuarioRepository.findAll());
    }

    @Override
    public Usuariows obtenerUsuarioPorId(int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(value ->
                        usuarioConvert.convertUsuarioToUsuarioWs(value))
                .orElse(null);
    }

    @Override
    public Usuariows registrarActualizarUsuario(Usuariows usuarioWs) {
        Usuario nuevoUsuario = usuarioRepository.save(
                usuarioConvert.convertUsuarioWsToUsuario(usuarioWs));
        if (nuevoUsuario == null)
            return null;
        return usuarioConvert.convertUsuarioToUsuarioWs(nuevoUsuario);
    }
}
