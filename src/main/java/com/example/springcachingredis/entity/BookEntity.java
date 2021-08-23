package com.example.springcachingredis.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {


        private static final long serialVersionUID = 1307525040224585678L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private String category;
        private String author;
        private String publisher;
        private String edition;

}

