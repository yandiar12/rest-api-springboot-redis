package com.yandiar.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author YAR
 */

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;
}
