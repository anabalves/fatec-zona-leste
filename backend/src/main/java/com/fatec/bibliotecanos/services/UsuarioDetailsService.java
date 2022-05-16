package com.fatec.bibliotecanos.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
