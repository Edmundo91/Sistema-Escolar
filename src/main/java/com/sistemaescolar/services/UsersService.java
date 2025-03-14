package com.sistemaescolar.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.UsersDTO;
import com.sistemaescolar.exceptions.RoleNotFoundException;
import com.sistemaescolar.exceptions.UserNotFoundException;
import com.sistemaescolar.exceptions.UserNullException;
import com.sistemaescolar.models.Role;
import com.sistemaescolar.models.Users;
import com.sistemaescolar.repositories.RoleRepository;
import com.sistemaescolar.repositories.UsersRepository;

@Service
public class UsersService {

@Autowired
private UsersRepository userRepository; 

@Autowired
private RoleRepository roleRepository;

public Users SalvarUser(UsersDTO usersDTO) { 
	
	if (usersDTO.getNome() == null || usersDTO.getEmail() == null || usersDTO.getSenha() == null  
		|| usersDTO.getPosto() == null) { 
		throw new UserNullException(); 
	}
	
	
	Users users = new Users(); 
	
	users.setNome(usersDTO.getNome()); 
	users.setEmail(usersDTO.getEmail());
	users.setSenha(usersDTO.getSenha()); 
	users.setDataNascimento(LocalDate.parse(usersDTO.getDataNascimento())); 
	
	
	List<Role> roleEntities = usersDTO.getPostoAsEnum().stream()
	        .<Role>map(roleName -> roleRepository.findByName(roleName)
	         .orElseThrow(() -> new RoleNotFoundException()))
	        .collect(Collectors.toList());
	
	    users.setCargo(roleEntities);

	return userRepository.save(users);
	
}
	
// Buscar user por ID
public Users buscarUserPorId(Long id) {
	 return userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException());
}


// Buscar user pelo nome
public List<Users> buscarUserPorNome(String nome) {
    
	List<Users> users = userRepository.findByNomeContainingIgnoreCase(nome);
   
	if(users.isEmpty()) { 
		throw new UserNotFoundException(); 
		
	}
	
	return users;

}

// deleta user pelo id
public String DeleteUser(Long id) { 
	
	if(!userRepository.existsById(id)) {
		
     	throw new UserNotFoundException();
	}
	
	userRepository.deleteById(id);
	
	return "usuario deletado";
	
}


}
