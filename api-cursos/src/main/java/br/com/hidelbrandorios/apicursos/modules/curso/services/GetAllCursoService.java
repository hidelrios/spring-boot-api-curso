package br.com.hidelbrandorios.apicursos.modules.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.apicursos.exceptions.CursoNotFoundException;
import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;

@Service
public class GetAllCursoService {

    @Autowired
    CursoRepository cursoRepository;

    public List<CursoEntity> execute() {

        return this.cursoRepository.findAll();

    }
}
