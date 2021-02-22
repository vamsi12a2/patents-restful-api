
package com.springpro.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpro.rest.dao.Patent;
import com.springpro.rest.dao.PatentID;
import com.springpro.rest.dao.PatentsRepository;
import com.springpro.rest.exceptions.PatentNotFoundException;


@Service
public class PatentService {
	
	@Autowired
	PatentsRepository patentRepo;
	
	public List<Patent> getPatents(){
		ArrayList<Patent> patents = new ArrayList<Patent>();
		patentRepo.findAll().forEach(patents::add);
		return patents;
	}

	public List<Patent> getPatents(Integer size){
		ArrayList<Patent> patents = new ArrayList<Patent>();
		patentRepo.findAll(size).forEach(patents::add);
		return patents;
	}

	public Patent getPatent(PatentID patent) {
		if(patent==null)
			throw new IllegalArgumentException("Patent object cannot be null");
		return patentRepo.findByPatentID(patent);
	}

	public Patent  createPatent(Patent patent) {
		if(patent==null)
			throw new IllegalArgumentException("Patent object cannot be null");
		return patentRepo.save(patent);
	}

	public Patent updatePatent(Patent patent) {
		if(patent==null)
			throw new IllegalArgumentException("Patent object cannot be null");
		if(getPatent(patent.getPatentID())==null)
			throw new PatentNotFoundException("Patent with patent id "+patent.getPatentID().getPatent_number()+" not found");
		return patentRepo.save(patent);
	}

	public void  deletePatent(@Valid Patent patent) {
		if(patent==null)
			throw new IllegalArgumentException("Patent object cannot be null");
		if(getPatent(patent.getPatentID())==null) 
			throw new PatentNotFoundException("Patent with patent id "+patent.getPatentID().getPatent_number()+" not found");
		patentRepo.delete(patent);
	}
}
