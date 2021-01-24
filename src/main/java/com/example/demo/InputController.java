package com.example.demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InputController {

  public static void init() {
    try {
      UserController.initialize();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  private ArrayList<String> reccomended = new ArrayList<>();
  private ArrayList<String> taken = new ArrayList<>();
  @GetMapping("/input")
  public String greetingForm(Model model) {
    model.addAttribute("stringholder", new StringHolder());
    return "input";
  }

  @PostMapping("/stringholder")
  public String greetingSubmit(@ModelAttribute StringHolder stringholder, Model model) {
    model.addAttribute("stringholder", stringholder);
    taken.add(stringholder.getValue());
    model.addAttribute("stringholder2", stringFormater(taken));
    return "input";
  }
  private StringHolder stringFormater(ArrayList<String> strings){
    String result = "";
    for(int i = 0; i < strings.size(); i++){
      result += "----------\n"+strings.get(i)+"\t\n";
    }
    result += "----------";
    return new StringHolder(result);
  }
}