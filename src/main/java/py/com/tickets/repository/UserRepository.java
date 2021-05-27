package py.com.tickets.repository;

import org.springframework.stereotype.Repository;

import py.com.tickets.entity.User;

@Repository("userRepository")
public interface UserRepository extends GenericRepository<User>  {

	public abstract User findByUsername(String username);
	
}
