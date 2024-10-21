package mk.ukim.finki.booksapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

   public String author;

   public String description;

}
