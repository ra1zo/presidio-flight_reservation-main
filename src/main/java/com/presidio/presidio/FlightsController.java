package com.presidio.presidio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlightsController {

    @Autowired
    private FlightsDao flightsDao;

    @GetMapping("/addFlight")
    public String render_add_flight(Model model){
        model.addAttribute("flights", new flights());
        return "addFlight";
    }
    @PostMapping("/addFlight")
    public String add_flight(Model model, @ModelAttribute("flight") flights flights){
        flightsDao.save(flights);
        model.addAttribute("flights", new flights());
        return "redirect:/addFlight";
    }

    
    @GetMapping("/manageFlight")
    public String render_manage_flight(Model model){
        List<flights> flights = flightsDao.list();
        model.addAttribute("flights", flights);
        return "manageFlight";
    }   


    
    @GetMapping("/deleteFlight")
    public String render_delete_flight(@RequestParam(value ="flight_id") String flight_id) {
        flightsDao.delete(flight_id);

        return "redirect:/manageFlight";
    }
}
