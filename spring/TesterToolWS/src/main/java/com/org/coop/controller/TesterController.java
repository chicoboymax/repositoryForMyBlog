package com.org.coop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.org.coop.beans.InputBean;
import com.org.coop.canonical.beans.UIModel;
 
@Controller
public class TesterController {
 
	private static final Logger log = Logger.getLogger(TesterController.class); 
	
	
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to Tester Tool. ");
        return "welcome";
    }
    
    @RequestMapping(value = { "/jsonTester" }, method = {RequestMethod.GET,RequestMethod.POST})
    public String jsonTester(@ModelAttribute("inputBean") InputBean inputBean, 
    		BindingResult result, Errors errors, ModelMap model, RedirectAttributes attr, 
    		HttpServletRequest request, HttpServletResponse response) {
        return "jsonTester";
    }
    
    @RequestMapping(value = { "/restTester" }, method = {RequestMethod.GET,RequestMethod.POST})
    public String restTester(@ModelAttribute("inputBean") InputBean inputBean, 
    		BindingResult result, Errors errors, ModelMap model, RedirectAttributes attr, 
    		HttpServletRequest request, HttpServletResponse response) {
    	if(inputBean.getRequestMethod() != null && inputBean.getRequestMethod().size() > 0) {
    		String requestMethod = inputBean.getRequestMethod().get(0);
    		RestTemplate restTemplate = new RestTemplate();
    		
    		try {
	    		switch(requestMethod) {
		    		case "GET" :
		    			String jsonResp = restTemplate.getForObject(inputBean.getUrl(), String.class);
		    			inputBean.setJsonOutput(jsonResp);
		    			break;
		    		case "POST" :
		    			HttpHeaders headers = new HttpHeaders();
		        		headers.setContentType(MediaType.APPLICATION_JSON);
		    			HttpEntity<String> entity = new HttpEntity<String>(inputBean.getJsonInput(), headers);
		    			ResponseEntity<String> responseObj = restTemplate.exchange(inputBean.getUrl(), HttpMethod.POST, entity, String.class);
//		    			UIModel result1 = responseObj.getBody();
//		    			String answer = restTemplate.postForObject(inputBean.getUrl(), entity, String.class);
		    			log.debug(responseObj.getBody());
		    			inputBean.setJsonOutput(responseObj.getBody());
		    			break;
		    		case "DELETE" :
		    			break;
		    		case "PUT" :
		    			break;
	    		}
    		} catch (Exception e) {
    			log.error("Exception occured: ", e);
    			e.printStackTrace();
    			inputBean.setJsonOutput(e.toString());
			}
    	}
        return "serviceTester";
    }
    
    @RequestMapping(value = { "/verifyJson" }, method = {RequestMethod.POST,RequestMethod.GET})
    public String verifyJson(@ModelAttribute("inputBean") InputBean inputBean,
    		BindingResult result, Errors errors, Model model,RedirectAttributes attr,
			HttpServletRequest request,
			HttpServletResponse response) {
        model.addAttribute("greeting", "Hi, Welcome to JSON Tester Tool. ");
        String inJson = inputBean.getJsonInput();
        Gson gson = new Gson();
        try {
        	UIModel ui = gson.fromJson(inJson, UIModel.class);
        	inputBean.setJsonOutput("Input is correct");
        } catch (Exception e) {
        	log.debug("Exception occured: ", e);
        	inputBean.setJsonOutput("Input is incorrect:" + e);
        }
        
//        result.rejectValue("errorMsg", "Incorrect answer");
    	attr.addFlashAttribute("org.springframework.validation.BindingResult.inputBean", result);
		attr.addFlashAttribute("inputBean", inputBean);
    	return "redirect:jsonTester";
    }
    
}
