package com.mova.mongoapi.controllers;

import java.net.InetAddress;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mova.mongoapi.Repository.BalancerRepository;
import com.mova.mongoapi.model.Balancer;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * REST controller for handling balancer-related requests.
 * Provides endpoints to add and list balancer entries.
 */
@RestController
@RequestMapping(path="/balancer")
public class BalancerController {

    private static final Logger logger = LoggerFactory.getLogger(BalancerController.class);
    private final BalancerRepository balancerRepository;

    /**
     * Constructs a BalancerController with the specified repository.
     * @param balancerRepository The repository for Balancer data operations.
     */
    public BalancerController(BalancerRepository balancerRepository) {
        this.balancerRepository = balancerRepository;
    }

    /**
     * A simple health-check/greeting endpoint.
     * @return A greeting string "hola".
     */
    @GetMapping(path="/")
    public String saludo() {
        return "hola";
    }
    
    /**
     * Creates and saves a new Balancer entry with the current server's details.
     * @return A confirmation message indicating which server saved the entry.
     */
    @GetMapping(path="/add")
    public String grabar(){

        Balancer balancer = new Balancer();

        String hostname = "";
        String comment = "";
        try{
            hostname = InetAddress.getLocalHost().getHostName();
            comment = InetAddress.getLocalHost().getHostAddress();
        }
        catch(Exception e){
            logger.error("Error retrieving host details", e);
        }

        balancer.setServidor(hostname);
        balancer.setHora(new java.util.Date().toString());
        balancer.setComentario("Version 1 "+comment);

        balancerRepository.save(balancer);

        String mensajeRespuesta = "SAVED from::"+hostname;
        return mensajeRespuesta;
    }

    /**
     * Retrieves all Balancer entries from the database.
     * @return A list of all Balancer objects.
     */
    @GetMapping(path="/list")
    public List<Balancer> list() {
        return balancerRepository.findAll();
    }

}
