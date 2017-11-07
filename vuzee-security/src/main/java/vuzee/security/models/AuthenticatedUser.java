package vuzee.security.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import vuzee.security.entities.User;

public class AuthenticatedUser implements UserDetails{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long id;
	private List<GrantedAuthority> grantedAuthorities;
	private boolean isLocked;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param id
	 * @param grantedAuthorities
	 */
	public AuthenticatedUser(User user,List<GrantedAuthority> grantedAuthorities) {
		super();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.id = user.getId();
		this.grantedAuthorities = grantedAuthorities;
		this.isLocked = user.isLocked();
	}

	private static final long serialVersionUID = -8287402811446441839L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		 return password;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public  boolean hasPrivilege(String targetType, String permission) {
	    for (GrantedAuthority grantedAuth : getAuthorities()) {
	        if (grantedAuth.getAuthority().startsWith(permission)) {
	            if (grantedAuth.getAuthority().contains(targetType)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
}
