package com.caisse.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caisse.projet.Model.Client;

import com.caisse.projet.Service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class ClientController {
	 @Autowired  private ClientService cliService;
	 
	 
	 @GetMapping("/clients")
	    public List<Client> list() {
		 System.out.println("Get all Clients...");
	             return cliService.getAll();
	   }
	 	 
	 @GetMapping("/clients/{id}")
	 public ResponseEntity<Client> post(@PathVariable int id) {
	        Optional<Client> four = cliService.findByCode(id);
	        return four.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                            .build());
	    }
	    
	 @PostMapping("/clients")
	    public long save(@RequestBody Client Client) {
		
	        return cliService.save(Client);
	    }

	 @PutMapping("/clients/{code}")
	    public void update(@PathVariable int code, @RequestBody Client Client) {
	      
	            cliService.update(code, Client);
	     
	    }

	    @DeleteMapping("/clients/{code}")
	    public void delete(@PathVariable int code) {
	        cliService.delete(code);
	    }
	

}
