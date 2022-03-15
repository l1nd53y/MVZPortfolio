package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Criminal;
import com.example.demo.repository.CriminalRepository;
import com.example.demo.service.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*") //Cross-origin resource sharing (CORS) "allows you to specify in a flexible way what kind of cross domain requests are authorized"
@RestController // "Every request handling method of the controller class automatically serializes return objects into HttpResponse"
@RequestMapping("/api/criminals") // Used to map web requests to Spring Controller methods
public class CriminalController {

    @Autowired // allows Spring to resolve and inject collaborating beans into our bean
    private CriminalService criminalService;

    @Autowired
    private CriminalRepository criminalRepository;

//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }

    @GetMapping // Annotation for mapping HTTP GET requests onto specific handler methods
    public List<Criminal> getAllCriminals(){
        return criminalRepository.findAll();
    }

    // build create user REST API
    @PostMapping // Annotation for mapping HTTP POST requests onto specific handler methods
    public Criminal createCriminal(@RequestBody Criminal criminal) {
        return this.criminalService.save(criminal);
    }

    // build get user by id REST API
    @GetMapping("{id}") // Annotation for mapping HTTP GET requests onto specific handler methods
    public ResponseEntity<Criminal> getCriminalById(@PathVariable  long id){
        Criminal criminal = criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal does not exist with id:" + id));
        return ResponseEntity.ok(criminal);
    }

    // build update user REST API
    @PutMapping("{id}") // Annotation for mapping HTTP PUT requests onto specific handler methods
    public ResponseEntity<Criminal> updateCriminal(@PathVariable long id,@RequestBody Criminal criminalDetails) { //@PathVariable annotation to extract the templated part of the URI (id), @RequestBody maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object
        Criminal updateCriminal = criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal does not exist with id: " + id));

        updateCriminal.setName(criminalDetails.getName());
        updateCriminal.setMod(criminalDetails.getMod());
        updateCriminal.setImageLink(criminalDetails.getImageLink());

        criminalRepository.save(updateCriminal);

        return ResponseEntity.ok(updateCriminal);
    }

    // build delete user REST API
    @DeleteMapping("{id}") // Annotation for mapping HTTP DELETE requests onto specific handler methods.
    public ResponseEntity<HttpStatus> deleteCriminal(@PathVariable long id){

        Criminal criminal = criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal does not exist with id: " + id));

        criminalRepository.delete(criminal);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

}
