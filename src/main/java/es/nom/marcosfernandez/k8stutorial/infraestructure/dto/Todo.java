package es.nom.marcosfernandez.k8stutorial.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {

    private Integer id;

    private String title;

    private String description;

    private Boolean completed;

}
