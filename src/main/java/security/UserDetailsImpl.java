package security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sistemaescolar.models.Users;

import lombok.Getter;

@Getter
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Users user; 

    public UserDetailsImpl(Users user) {
        this.user = user;
    }

   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
   /*mapeia o valor do atributo "cargo" do objeto user e retorna uma coleção que 
     estende GrantedAuthority. Para cada cargo (role), cria um novo SimpleGrantedAuthority, 
     que é a forma como o Spring Security representa permissões. 
      */
    	return user.getCargo()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    } 
    

    @Override
    public String getPassword() {
        return user.getSenha();
    } 

    @Override
    public String getUsername() {
        return user.getEmail();
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
	
	
	
}
