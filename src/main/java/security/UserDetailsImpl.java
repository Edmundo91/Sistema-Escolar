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
        return user.getCargo()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    } 
    

    @Override
    public String getPassword() {
        return user.getSenha();
    } // Retorna a credencial do usuário que criamos anteriormente

    @Override
    public String getUsername() {
        return user.getEmail();
    } // Retorna o nome de usuário do usuário que criamos anteriormente

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
