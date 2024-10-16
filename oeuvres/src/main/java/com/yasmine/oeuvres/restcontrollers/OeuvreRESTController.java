package com.yasmine.oeuvres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yasmine.oeuvres.entities.Oeuvre;
import com.yasmine.oeuvres.service.OeuvreService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OeuvreRESTController {
	
	@Autowired
	OeuvreService oeuvreService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public List<Oeuvre> getAllOeuvres() { 
	return oeuvreService.getAllOeuvres(); 
	} 
	
	@RequestMapping(value="/{idOeuvre}",method = RequestMethod.GET) 
	public Oeuvre getOeuvreByIdOeuvre(@PathVariable("idOeuvre") Long idOeuvre) {  
	    return oeuvreService.getOeuvre(idOeuvre); 
	} 

	
	@RequestMapping(method = RequestMethod.POST) 
	public Oeuvre createOeuvre(@RequestBody Oeuvre oeuvre) { 
	return oeuvreService.saveOeuvre(oeuvre); 
	} 
	
	 @RequestMapping(value="/{idOeuvre}", method = RequestMethod.PUT) 
	    public Oeuvre updateOeuvre(@PathVariable("idOeuvre") Long idOeuvre, @RequestBody Oeuvre oeuvre) { 
	        oeuvre.setIdOeuvre(idOeuvre);  // Ensure the correct ID is set
	        return oeuvreService.updateOeuvre(oeuvre); 
	    }
	
	@RequestMapping(value="/{idOeuvre}",method = RequestMethod.DELETE) 
	public void deleteOeuvre(@PathVariable("idOeuvre") Long idOeuvre) 
	{ 
	oeuvreService.deleteOeuvreByIdOeuvre(idOeuvre); 
	} 
	
	@RequestMapping(value="/oeuvsExp/{idExposition}",method = RequestMethod.GET) 
	public List<Oeuvre> getOeuvressByIdExposition(@PathVariable("idExposition") Long idExposition) { 
	return oeuvreService.findByExpositionIdExposition(idExposition); 
	}
	
	
	@RequestMapping(value="/oeuvresByTitle/{titre}", method = RequestMethod.GET) 
	public List<Oeuvre> findByTitreOeuvreContains(@PathVariable("titre") String titre) { 
	    return oeuvreService.findByTitreOeuvreContains(titre); 
	}
}
