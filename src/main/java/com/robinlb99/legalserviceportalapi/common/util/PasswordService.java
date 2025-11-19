package com.robinlb99.legalserviceportalapi.common.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Servicio para la codificación y verificación de contraseñas.
 * Proporciona métodos para hashear contraseñas y verificar si una contraseña
 * en texto plano coincide con un hash guardado.
 */
@Service
public class PasswordService {
    
    private final PasswordEncoder passwordEncoder;

	/**
	 * Construye un nuevo PasswordService con el codificador de contraseñas proporcionado.
	 *
	 * @param passwordEncoder El codificador de contraseñas a utilizar.
	 */
	public PasswordService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
    /**
     * Hashea una contraseña en texto plano.
     *
     * @param rawPassword La contraseña en texto plano a hashear.
     * @return El hash de la contraseña codificada.
     */
    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verifica si una contraseña en texto plano coincide con un hash guardado.
     *
     * @param rawPassword La contraseña en texto plano a verificar.
     * @param savedHash El hash de la contraseña guardada.
     * @return true si la contraseña coincide, false en caso contrario.
     */
    public boolean verifyPassword(String rawPassword, String savedHash) {
        return passwordEncoder.matches(rawPassword, savedHash);
    }
}

