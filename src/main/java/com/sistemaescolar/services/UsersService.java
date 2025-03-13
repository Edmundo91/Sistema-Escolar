package com.sistemaescolar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistemaescolar.exceptions.UserNotFoundException;
import com.sistemaescolar.exceptions.UserNullException;
import com.sistemaescolar.models.Users;
import com.sistemaescolar.repositories.UsersRepository;

@Service
public class UsersService {

@Autowired
private UsersRepository userRepository; 


public Users SalvarUser(Users user) { 
	
	if (user.getNome() == null || user.getEmail() == null || user.getSenha() == null  
		|| user.getCargo() == null) { 
		throw new UserNullException(); 
	}
	
	return userRepository.save(user);
	
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
public void DeleteUser(Long id) { 
	
	if(!userRepository.existsById(id)) {
		
     	throw new UserNotFoundException();
	}
	
	userRepository.deleteById(id);
	
}


}
