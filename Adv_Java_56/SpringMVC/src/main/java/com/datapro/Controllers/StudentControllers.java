package com.datapro.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.datapro.Model.Login;
import com.datapro.Model.Student;
import com.datapro.Repository.LoginRepo;
import com.datapro.Repository.StudentRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentControllers {
	@Autowired
	StudentRepo repo;
	
	@Autowired
	LoginRepo repos;
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("std_photo");
    }	
	
	
	@GetMapping("/")
	public String getData() {
		return "Login";
	}
	
	@GetMapping("/index")
	public String getindex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String getLoginDetails(@RequestParam String email,
								  @RequestParam String password,
								  HttpSession session,Model model) {
		Login user = repos.findByEmailAndPassword(email, password);
		if (user != null) {
	        session.setAttribute("username", email); // Store in session
	        return "redirect:/list";
	    } else {
	        model.addAttribute("error", "Invalid username or password");
	        return "Login";
	    }
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "Register";
	}
	
	@PostMapping("/register")
	public String getregister(@ModelAttribute Login data,Model model) {
		repos.save(data);
		return "Login";
	}
	
	@PostMapping("/list")
	public String getPostData(@ModelAttribute Student std,
							  @RequestParam("std_photo") MultipartFile photoFile,
							  Model model,HttpSession session) {
		
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
		
		try {
			if(!photoFile.isEmpty()) {
				std.setStd_photo(photoFile.getBytes());				
			}
			repo.save(std);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list";
	}
	
	@GetMapping(value="/list")
	public String getListData(Model model,HttpSession session) {
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
		model.addAttribute("data",repo.findAll());
		return "list";
	}
	
	@GetMapping("/delete/{std_id}")
	public String getDelete(@PathVariable Long std_id,HttpSession session) {
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
		repo.deleteById(std_id);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{std_id}")
	public String getEdit(@PathVariable Long std_id,Model model,HttpSession session) {
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
		model.addAttribute("data",repo.findById(std_id).orElse(null));
		return "edit";
	}
	
	@PostMapping("/update")
	public String getUpdate(@ModelAttribute Student std,
			  				@RequestParam("std_photo") MultipartFile photoFile,
			  				HttpSession session) {
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
		
		Student existingStd = repo.findById(std.getStd_id()).orElse(null);
		
		if (existingStd == null) {
	         return "redirect:/list";
	    }
		
		existingStd.setStd_name(std.getStd_name());
		existingStd.setStd_date(std.getStd_date());
		existingStd.setStd_gender(std.getStd_gender());
		existingStd.setStd_email(std.getStd_email());
		existingStd.setStd_course(std.getStd_course());
		existingStd.setStd_phone(std.getStd_phone());
		
		if (!photoFile.isEmpty()) {
	         try {
	             existingStd.setStd_photo(photoFile.getBytes());
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }

	     repo.save(existingStd);
	     return "redirect:/list";

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); 
	    return "redirect:/login";
	}

}
