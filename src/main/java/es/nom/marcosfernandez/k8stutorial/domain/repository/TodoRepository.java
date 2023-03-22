package es.nom.marcosfernandez.k8stutorial.domain.repository;

import es.nom.marcosfernandez.k8stutorial.domain.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
	Page<TodoEntity> findByCompleted(Boolean completed, Pageable pageable);
}
