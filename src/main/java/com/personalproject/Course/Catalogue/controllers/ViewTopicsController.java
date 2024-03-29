package com.personalproject.Course.Catalogue.controllers;

import com.personalproject.Course.Catalogue.models.Topic;
import com.personalproject.Course.Catalogue.services.FetchTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewTopicsController {


    @Autowired
    FetchTopicsService fetchTopicsService;

    @GetMapping("/languages")
    public String getLanguages(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Language");
        model.addAttribute("topics",topics);
        model.addAttribute("category","language");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/libraries")
    public String getLibraries(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Library");
        model.addAttribute("topics",topics);
        model.addAttribute("category","library");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/frameworks")
    public String getFrameworks(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Framework");
        model.addAttribute("topics",topics);
        model.addAttribute("category","framework");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/databases")
    public String getDatabases(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Database");
        model.addAttribute("topics",topics);
        model.addAttribute("category","database");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/design")
    public String getDesign(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Design");
        model.addAttribute("topics",topics);
        model.addAttribute("category","design");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/theory")
    public String getTheory(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Theory");
        model.addAttribute("topics",topics);
        model.addAttribute("category","theory");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }
    @GetMapping("/tools")
    public String getTools(Model model){
        List<Topic> topics = fetchTopicsService.fetchTopic("Tool");
        model.addAttribute("topics",topics);
        model.addAttribute("category","tool");
        model.addAttribute("loggedinUsername",getLoggedInUsername());
        return "topic_list";
    }

    public String getLoggedInUsername(){
        Object secUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUserName;
        if(secUser instanceof String){              //user is not logged in
            loggedInUserName="";
        }
        else{
            User user = (User)secUser;
            loggedInUserName = user.getUsername();
        }
        return loggedInUserName;
    }
}
