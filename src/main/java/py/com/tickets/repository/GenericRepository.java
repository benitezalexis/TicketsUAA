/**
 * <h1>facilabs</h1>
 * <h3>py.com.tkksys.facilabs.repository - GenericRepository.java</h3>
 * 
 * @description 
 * @author Wilson Ferreira - wirxon@gmail.com - (https://gitlab.com/wirxon)
 * @version 1.0.2020
 */
package py.com.tickets.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T>  extends JpaRepository<T, Serializable>{

}
