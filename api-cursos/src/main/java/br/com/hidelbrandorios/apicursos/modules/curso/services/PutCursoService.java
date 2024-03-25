package br.com.hidelbrandorios.apicursos.modules.curso.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.apicursos.exceptions.CursoNotFoundException;
import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;

@Service
public class PutCursoService {
    
    @Autowired
    CursoRepository cursoRepository;

    public CursoEntity execute(UUID idCurso, CursoEntity cursoDetails) {

        var curso = this.cursoRepository.findById(idCurso).orElseThrow(() -> {
            throw new CursoNotFoundException();
        });

        if (cursoDetails.getName() != null) {
            curso.setName(cursoDetails.getName());
        }

        if (cursoDetails.getCategory() != null) {
            curso.setCategory(cursoDetails.getCategory());
        }

        final CursoEntity updatedCurso = cursoRepository.save(curso);
        return updatedCurso;

    }
}

