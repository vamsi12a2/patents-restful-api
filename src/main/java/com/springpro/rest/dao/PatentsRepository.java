package com.springpro.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PatentsRepository extends JpaRepository<Patent, PatentID> {

	List<Patent> findByPatentIDPatentNumber(String patent_id);
	
	@Query(value="Select * from nasa.patents limit :size",nativeQuery = true)
	List<Patent> findAll(@Param("size") Integer size);
	
	Patent findByPatentID(PatentID patentID);

}
