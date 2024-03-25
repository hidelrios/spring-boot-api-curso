package br.com.hidelbrandorios.apicursos.modules.curso.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.apicursos.exceptions.CursoNotFoundException;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;

@Service
public class DeleteCursoService {
    
    @Autowired
    CursoRepository cursoRepository;

    public void execute(UUID idCurso) {

        var curso = this.cursoRepository.findById(idCurso).orElseThrow(() -> {
            throw new CursoNotFoundException();
        });

        this.cursoRepository.delete(curso);

    }
}
