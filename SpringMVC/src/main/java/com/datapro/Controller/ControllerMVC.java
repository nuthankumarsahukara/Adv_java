package com.datapro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.datapro.Model.Data;
import com.datapro.Repo.DataRepo;

@Controller
public class ControllerMVC {
	@Autowired
	private DataRepo repo;
	
	@GetMapping(value = "/")
	public String getHome() {
		return "Home";
	}
	
	@PostMapping(value="/submited")
	public String getSubmited(Data data,Model model) {	
		repo.save(data);
		model.addAttribute("data",repo.findAll());
		return "submited";
	}
	
	@GetMapping(value="/submited")
	public String getData(Data data,Model model) {	
		model.addAttribute("data",repo.findAll());
		return "submited";
	}
	
	@GetMapping("/edit/{id}")
	public String getUpdated(@PathVariable Long id,Model model) {
		Data existing = repo.findById(id).orElseThrow();
        model.addAttribute("data", existing);
		return "edit";
	}
	
	@PostMapping("/update")
    public String updateData(Data data) {
        repo.save(data);
        return "redirect:/submited";
    }
	
	@GetMapping("/delete/{id}")
	public String getDelete(@PathVariable Long id) {
		repo.deleteById(id);
		return "redirect:/submited";
	}	

}
