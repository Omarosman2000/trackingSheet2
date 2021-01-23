package com.example.demo;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InputController {

  @GetMapping("/input")
  public String greetingForm(Model model) {
    model.addAttribute("stringholder", new StringHolder());
    return "input";
  }

  @PostMapping("/stringholder")
  public String greetingSubmit(@ModelAttribute StringHolder stringholder, Model model) {
    model.addAttribute("stringholder", stringholder);
    System.out.println(stringholder.getValue());
    return "input";
  }

}