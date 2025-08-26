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

import com.datapro.Model.Employee;
import com.datapro.Model.Login;
import com.datapro.Repository.EmployeeRepo;
import com.datapro.Repository.LoginRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controllers{
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private LoginRepo repos;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("emp_photo"); // Prevent Spring from binding it directly
    }
	
	@GetMapping("/register")
	public String getregister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String getRegister(@ModelAttribute Login data,Model model) {
		repos.save(data);
		return "login";
	}
	
	@GetMapping("/")
	public String getIndex() {
		return "redirect:/login";
	}
	
	
	@PostMapping("/login")
	public String getLogin(@RequestParam("email_id") String email_id,
						   @RequestParam("password") String password,
						   HttpSession session,
						   Model model
							) {
		Login user = repos.findByEmailIdAndPassword(email_id, password);
		if (user != null) {
	        session.setAttribute("username", email_id); // Store in session
	        return "redirect:/list";
	    } else {
	        model.addAttribute("error", "Invalid username or password");
	        return "login";
	    }
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // Clear session
	    return "redirect:/login";
	}
	
	@PostMapping("/list")
	public String getSubmited(@ModelAttribute Employee data,
	                          @RequestParam("emp_photo") MultipartFile photoFile,
	                          Model model,HttpSession session) {
		if (session.getAttribute("username") == null) {
	        return "redirect:/login";
	    }
	    try {
	        if (!photoFile.isEmpty()) {
	            data.setEmp_photo(photoFile.getBytes()); // manually set the byte[]
	        }
	        repo.save(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return "redirect:/list";
	}

	@GetMapping(value="/index")
	public String getIndexPage() {
		return "index";
	}
	 
	 @GetMapping(value = "/list")
	    public String getData(Model model,HttpSession session) {
		 	if (session.getAttribute("username") == null) {
		        return "redirect:/login";
		    }
	        model.addAttribute("data", repo.findAll());
	        return "list";
	    }
	 
	 @GetMapping(value="/delete/{emp_id}")
	 	public String getDelete(@PathVariable Integer emp_id,HttpSession session) {
		 if (session.getAttribute("username") == null) {
		        return "redirect:/login";
		 }
		 repo.deleteById(emp_id);
		 return "redirect:/list";
	 }
	 
	 @GetMapping(value="/edit/{emp_id}")
	 	public String getUpdate(@PathVariable Integer emp_id,Model model,HttpSession session) {
		 if (session.getAttribute("username") == null) {
		        return "redirect:/login";
		    }
		 	model.addAttribute("data", repo.findById(emp_id).orElse(null));
		 return "EditPage";
	 }
	 
	 @PostMapping("/update")
	 public String updateEmployee(@ModelAttribute("employee") Employee updatedEmp,
	                              @RequestParam("emp_photo") MultipartFile photoFile,HttpSession session) {
		 
		 if (session.getAttribute("username") == null) {
		        return "redirect:/login";
		 }
		 
	     Employee existingEmp = repo.findById(updatedEmp.getEmp_id()).orElse(null);
	     if (existingEmp == null) {
	         return "redirect:/list";
	     }

	     
	     existingEmp.setEmp_name(updatedEmp.getEmp_name());
	     existingEmp.setEmp_gender(updatedEmp.getEmp_gender());
	     existingEmp.setEmp_email(updatedEmp.getEmp_email());
	     existingEmp.setEmp_dept(updatedEmp.getEmp_dept());
	     existingEmp.setEmp_sal(updatedEmp.getEmp_sal());
	     existingEmp.setEmp_phone(updatedEmp.getEmp_phone());

	     
	     if (!photoFile.isEmpty()) {
	         try {
	             existingEmp.setEmp_photo(photoFile.getBytes());
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }

	     repo.save(existingEmp);
	     return "redirect:/list";
	 }
}