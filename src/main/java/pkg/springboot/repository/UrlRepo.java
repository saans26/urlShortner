package pkg.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import pkg.springboot.model.UrlData;

public interface UrlRepo extends CrudRepository<UrlData, String>{

	
}
