/**
 * <h1>tickets</h1>
 * <h3>py.com.tickets.repository - RoleRepository.java</h3>
 * 
 * @description 
 * @author Wilson Ferreira - wirxon@gmail.com - (https://gitlab.com/wirxon)
 * @version 1.0.2021
 */
package py.com.tickets.repository;

import org.springframework.stereotype.Repository;

import py.com.tickets.entity.UserRol;

@Repository("roleRepository")
public interface RoleRepository extends GenericRepository<UserRol> {

}
