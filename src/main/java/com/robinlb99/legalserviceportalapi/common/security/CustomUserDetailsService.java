package com.robinlb99.legalserviceportalapi.common.security;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario '" + username + "' no encontrado"));
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword_hash())
                .roles(usuario.getRol().name())
                .accountLocked(!usuario.isActivo())
                .build();
    }
}
