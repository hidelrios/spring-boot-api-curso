package br.com.hidelbrandorios.apicursos.modules.curso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import java.util.List;
import java.util.Optional;


public interface CursoRepository extends JpaRepository<CursoEntity, UUID>{
    Optional<CursoEntity> findByName(String name);
}