package pkg.springboot.controller;

import java.nio.charset.StandardCharsets;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.hash.Hashing;

import pkg.springboot.model.UrlData;
import pkg.springboot.repository.UrlRepo;

@Controller
public class UrlController {

	@Autowired
	UrlRepo urlRepo;
	
	@RequestMapping(value ="/", method= RequestMethod.GET)
	public String home()
	{
		return "home";
		
	}
	
	@RequestMapping(value ="/addUrl", method =RequestMethod.POST)
	public String addUrl(UrlData urldata)
	{
		UrlValidator urlValidator = new UrlValidator(new String[] {"http","https"});
		
		if(urlValidator.isValid(urldata.getFullUrl()) )
		{
			String id =Hashing.murmur3_32().hashString(urldata.getFullUrl(),StandardCharsets.UTF_8).toString();
			urldata.setShortUrl("user/"+id);
		}	
		urlRepo.save(urldata);
		return "home";
	}
	
	@RequestMapping("user/{id}")
	public RedirectView  getUrl(@PathVariable String id) throws Exception {
		UrlData urldata = urlRepo.findById("user/"+id).orElseThrow(Exception::new);
		RedirectView redirectView = new RedirectView();
		String fullname = urldata.getFullUrl();
	    redirectView.setUrl(fullname);
		return redirectView;
		
	}
	
}
