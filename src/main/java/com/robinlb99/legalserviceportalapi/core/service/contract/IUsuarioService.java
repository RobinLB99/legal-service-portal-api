package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.domain.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.dto.UsuarioRequestDTO;
import org.springframework.data.domain.Page;

public interface IUsuarioService {
    Usuario crearUsuario(UsuarioRequestDTO usuarioRequest);

    void actualizarPassword(Long id, String nuevoPassword);

    void actualizarPerfilUsuario(Long idUsuario);

    Usuario obtenerUsuarioPorId(Long id);

    Usuario obtenerUsuarioPorUsername(String username);

    void desactivarUsuarioPorId(Long id);

    void desactivarUsuarioPorUsername(String username);

    void activarUsuarioPorId(Long id);

    void activarUsuarioPorUsername(String username);

    Page<Usuario> obtenerUsuariosPaginados(int numeroPagina, int tamanioPagina);
}
