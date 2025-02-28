package com.sistemaescolar.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sistemaescolar.exceptions.UserNotFoundException;
import com.sistemaescolar.exceptions.UserNullException;
import com.sistemaescolar.models.User;
import com.sistemaescolar.repositories.UserRepository;

@Service
public class UserService {

private UserRepository userRepository; 


public User SalvarUser(User user) { 
	
	if (user.getNome() == null || user.getEmail() == null || user.getSenha() == null  
		|| user.getCargo() == null) { 
		throw new UserNullException(); 
	}
	
	return userRepository.save(user);
	
}
	
// Buscar user por ID
public User buscarUserPorId(Long id) {
	 return userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException());
}


// Buscar user pelo nome
public List<User> buscarUserPorNome(String nome) {
    
	List<User> users = userRepository.findByNomeContainingIgnoreCase(nome);
   
	if(users.isEmpty()) { 
		throw new UserNotFoundException(); 
		
	}
	
	return users;

}


public void DeleteUser(Long id) { 
	
	if(!userRepository.existsById(id)) {
		
     	throw new UserNotFoundException();
	}
	
	userRepository.deleteById(id);
	
}


}
