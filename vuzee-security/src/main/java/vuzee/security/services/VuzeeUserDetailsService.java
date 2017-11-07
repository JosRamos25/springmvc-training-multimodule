package vuzee.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import vuzee.security.models.AuthenticatedUser;
import vuzee.security.models.VuzeeUser;

public interface VuzeeUserDetailsService extends UserDetailsService  {
	
	public AuthenticatedUser registerNewAccount(VuzeeUser userDto) throws EmailExistsException;
	
}
