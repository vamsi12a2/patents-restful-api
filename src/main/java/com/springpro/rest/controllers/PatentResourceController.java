package com.springpro.rest.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springpro.rest.dao.Patent;
import com.springpro.rest.dao.PatentID;
import com.springpro.rest.exceptions.PatentNotFoundException;
import com.springpro.rest.models.AuthenticationBodyModel;
import com.springpro.rest.services.AuthenticateService;
import com.springpro.rest.services.PatentService;

@RestController
@RequestMapping("/")
public class PatentResourceController {

	@Autowired
	PatentService patentService;
	@Autowired
	MessageSource messages;
	@Autowired
	AuthenticateService authenticationService;
	
	@RequestMapping(method = RequestMethod.GET,path = "/test")
	public String home(@RequestHeader(name="Accept-Language",required=false) String locale) {
		return messages.getMessage("message.hello.world", new String[] {"Application is up and running !!!"},new Locale(locale==null?"":locale));
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "/authenticate",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationBodyModel authBody){	
		authenticationService.authenticate(authBody);
		return new ResponseEntity<String>("success",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping (method = RequestMethod.GET,path="patents")
	public ResponseEntity<CollectionModel<Patent>> getAllPatents(@RequestParam(required = false,name="size") Integer size){	
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPatents(null));
		if(size!=null)
			return new ResponseEntity<>(CollectionModel.of(patentService.getPatents(size),link.withRel("all-patents")),HttpStatus.OK);
		return new ResponseEntity<>(CollectionModel.of(patentService.getPatents(),link.withRel("all-patents")),HttpStatus.OK);
	}

	@RequestMapping (method = RequestMethod.GET,path = "/patents/{patent_id}")
	public ResponseEntity<EntityModel<Patent>> getPatent(@PathVariable String patent_id,@RequestParam(required=true) String applicationssn,
			@RequestParam(required=true) String casenumber){
		PatentID id = new PatentID(patent_id,applicationssn,casenumber);
		if(patentService.getPatent(id)==null) 
						throw new PatentNotFoundException("Patent with patent number "+patent_id+" not found");
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPatents(null));
		return  new ResponseEntity<>(EntityModel.of(patentService.getPatent(id),link.withRel("all-patents")),HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST,path = "patents")
	public ResponseEntity<List<Patent>> savePatent(@Valid @RequestBody Patent patent){
		patentService.createPatent(patent);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping (method = RequestMethod.PUT,path = "patents")
	public ResponseEntity<List<Patent>> updatePatent(@Valid @RequestBody Patent patent){
			patentService.updatePatent(patent);
			return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping (method = RequestMethod.DELETE,path = "patents")
	public ResponseEntity<String> deletePatent(@Valid @RequestBody Patent patent){
			patentService.deletePatent(patent);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
