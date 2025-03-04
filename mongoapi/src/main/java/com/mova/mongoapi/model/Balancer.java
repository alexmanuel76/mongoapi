package com.mova.mongoapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balancer {

    @Id
    private Integer id;
    private String servidor;
    private String hora;
    private String comentario;
}
