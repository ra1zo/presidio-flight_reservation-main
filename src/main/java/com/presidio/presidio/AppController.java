package com.presidio.presidio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BookingDao bookingsDao;




    @GetMapping("/booking")
    public String render_booking(Model model){
        model.addAttribute("bookings", new Booking());
        return "booking";
    }

    @PostMapping("/booking")
    public String add_booking(Model model, @ModelAttribute("bookings") Booking booking){
        bookingsDao.save(booking);
        model.addAttribute("bookings", new Booking());
        return "redirect:/booking_success";
    }

    @GetMapping("/booking_success")
    public String render_booking_success(Model model){
        model.addAttribute("bookings", new Booking());
        return "booking_success";
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
      repo.save(user);

      return "register_success";
    }





}
