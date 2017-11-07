package vuzee.security.repositories;

import org.springframework.data.repository.CrudRepository;

import vuzee.security.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
	User findByUserName(String userName);
}
