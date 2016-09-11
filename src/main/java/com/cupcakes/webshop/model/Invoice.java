package com.cupcakes.webshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by scheldejonas on 10/09/16.
 */
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOrdered = LocalDateTime.now();;

    public Invoice() {
    }

    public Invoice(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
}
