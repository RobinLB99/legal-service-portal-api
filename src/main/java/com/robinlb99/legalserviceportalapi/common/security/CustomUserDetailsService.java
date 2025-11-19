package com.robinlb99.legalserviceportalapi.common.security;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Servicio para cargar los detalles de un usuario para Spring Security.
 * Implementa la interfaz UserDetailsService para proporcionar una forma de
 * encontrar un usuario por su nombre de usuario.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Construye un nuevo CustomUserDetailsService con el repositorio de usuarios proporcionado.
     *
     * @param usuarioRepository El repositorio de usuarios a utilizar.
     */
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Carga un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Un objeto UserDetails que representa al usuario encontrado.
     * @throws UsernameNotFoundException Si no se encuentra ningún usuario con el nombre de usuario proporcionado.
     */
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
            .findByUsername(username)
            .orElseThrow(() ->
                new UsernameNotFoundException(
                    "Usuario '" + username + "' no encontrado"
                )
            );
        return User.builder()
            .username(usuario.getUsername())
            .password(usuario.getPassword_hash())
            .roles(usuario.getRol().name())
            .accountLocked(!usuario.isActivo())
            .build();
    }
}
