package com.tkksys.backendninja.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tkksys.backendninja.entity.UserRol;
import com.tkksys.backendninja.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.tkksys.backendninja.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	private User buildUser(com.tkksys.backendninja.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
		
	}
	
	/**
	 * METODO QUE TRANSFORMARA EL  Set<UserRol> userRole A UN LISTADO DE List<GrantedAuthority> QUE SPRING SECURITY NECESITA 
	 * PARA SABER LOS ROLES DEL USUARIO AUTENTICADO
	 * @param userRole
	 * @return
	 */
	private List<GrantedAuthority> buildAuthorities (Set<UserRol> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRol userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
	}

}
