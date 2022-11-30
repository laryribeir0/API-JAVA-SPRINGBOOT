package com.desafio.service;

import com.desafio.entities.Usuario;
import com.desafio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;



	public Usuario buscarUsuario(String usuario) {
		Optional<Usuario> optional = usuarioRepository.findByUsuario(usuario);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return optional.get();
		}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return buscarUsuario(username);
	}

	public Usuario buscarUsuarioPorId(Long idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		
		if(optional.isEmpty()) {
			throw new RuntimeException("Usuario não encontrado");
		}
		
		return optional.get();
	}


}
