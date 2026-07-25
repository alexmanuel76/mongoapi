package com.mova.mongoapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Balancer document in the MongoDB database.
 * This class is used to store information about server requests for load balancing purposes.
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balancer {

    /**
     * The unique identifier for the balancer entry.
     */
    @Id
    private String id;
    /**
     * The name of the server that handled the request.
     */
    private String servidor;
    /**
     * The timestamp when the request was handled.
     */
    private String hora;
    /**
     * A comment, which can include details like the server's IP address and a version.
     */
    private String comentario;
}
