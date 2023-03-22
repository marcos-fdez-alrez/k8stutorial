package es.nom.marcosfernandez.k8stutorial.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "TODOS_SEQ")
    @SequenceGenerator(name = "TODOS_SEQ",allocationSize = 1)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private Boolean completed;

}
