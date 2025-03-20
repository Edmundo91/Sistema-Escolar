package com.sistemaescolar.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GLobalExceptionHandler extends ResponseEntityExceptionHandler  {

	//Exceção para a requisição incompleta
	@ExceptionHandler(AlunoNullException.class)
	public ResponseEntity<Object> SaveAlunoNull(){  
		
		Map<String, Object> body = new HashMap<String, Object>(); 
		
		body.put("message", "verifique os campos que precisam ser preenchidos"); 
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}
	
	//Exceção para quando o aluno não for encontrado
	@ExceptionHandler(AlunoNotFoundException.class)
	public ResponseEntity<Object> GetAlunoNull(){ 
		
        Map<String, Object> body = new HashMap<String, Object>(); 
		
		body.put("message", "nenhum aluno encontrado"); 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		
		
	}
	
	
	//Exceção para a requisição incompleta 
		@ExceptionHandler(UserNullException.class)
		public ResponseEntity<Object> SaveUserNull(){  
			
			Map<String, Object> body = new HashMap<String, Object>(); 
			
			body.put("message", "verifique os campos que precisam ser preenchidos"); 
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
			
		}
	
	
		//Exceção para quando o user não for encontrado
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<Object> GetUserNull(){ 
			
	        Map<String, Object> body = new HashMap<String, Object>(); 
			
			body.put("message", "nenhum usuário encontrado"); 
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
			
			
		}
	
		//Exceção para requisição incompleta 
		@ExceptionHandler(TurmaNullException.class)
		public ResponseEntity<Object> SaveTurmaNull(){  
			
			Map<String, Object> body = new HashMap<String, Object>(); 
			
			body.put("message", "verifique os campos que precisam ser preenchidos"); 
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
			
		}
		
		
		
		//Exceção para quando a turma não for encontrada
				@ExceptionHandler(TurmaNotFoundException.class)
				public ResponseEntity<Object> TurmaNull(){ 
					
			        Map<String, Object> body = new HashMap<String, Object>(); 
					
					body.put("message", "nenhuma turma encontrada"); 
					
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
					
					
				}
		
		
		
		
				@ExceptionHandler(NotGenerateTokenException.class)
				public ResponseEntity<Object> NotGenerateToken(){  
					
					Map<String, Object> body = new HashMap<String, Object>(); 
					
					body.put("message", "erro na geração do token"); 
					
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
					
				}
				
				
				
				
				
		
}
