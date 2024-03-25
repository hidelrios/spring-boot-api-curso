package br.com.hidelbrandorios.apicursos.modules.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.apicursos.exceptions.CursoNotFoundException;
import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;

@Service
public class GetCursoService {

    @Autowired
    CursoRepository cursoRepository;

    public CursoEntity execute(String nameCurso) {

        var curso = this.cursoRepository.findByName(nameCurso).orElseThrow(() -> {
            throw new CursoNotFoundException();
        });

        return curso;

    }
}
