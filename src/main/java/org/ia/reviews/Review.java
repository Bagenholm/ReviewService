package org.ia.reviews;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Review {

    private @Id @GeneratedValue Long id;
    private String model;
    private float rating;
}
