package py.com.tickets.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.com.tickets.entity.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
