package com.mova.mongoapi.controllers;

import java.net.InetAddress;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mova.mongoapi.Repository.BalancerRepository;
import com.mova.mongoapi.model.Balancer;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(path="/balancer")
public class BalancerController {

    @Autowired
    BalancerRepository balancerRepository;

    @GetMapping
    public @ResponseBody String saludo() {
        return "hola";
    }
    

    @GetMapping(path="/add")
    public @ResponseBody String grabar(){

        Random random = new Random();
        Balancer balancer = new Balancer();

        String hostname = "";
        String comment = "";
        try{
            hostname = InetAddress.getLocalHost().getHostName();
            comment = InetAddress.getLocalHost().getHostAddress();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        balancer.setId(random.nextInt(100));
        balancer.setServidor(hostname);
        balancer.setHora(new java.util.Date().toString());
        balancer.setComentario("Version 1 "+comment);

        balancerRepository.save(balancer);

        String mensajeRespuesta = "SAVED from::"+hostname;
        return mensajeRespuesta;
    }


}
