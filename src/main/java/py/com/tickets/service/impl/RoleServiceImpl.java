/**
 * <h1>tickets</h1>
 * <h3>py.com.tickets.service.impl - RoleServiceImpl.java</h3>
 * 
 * @description 
 * @author Wilson Ferreira - wirxon@gmail.com - (https://gitlab.com/wirxon)
 * @version 1.0.2021
 */
package py.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.tickets.entity.UserRol;
import py.com.tickets.repository.RoleRepository;
import py.com.tickets.service.RoleService;

@Service
public class RoleServiceImpl extends GenericServiceImpl<UserRol> implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleRepository getRepository() {
		return roleRepository;
	}

}
