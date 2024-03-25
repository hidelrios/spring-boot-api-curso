package br.com.hidelbrandorios.apicursos.modules.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.apicursos.exceptions.CursoFoundException;
import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;

@Service
public class CreateCursoService {

    @Autowired
    CursoRepository cursoRepository;

    public CursoEntity execute(CursoEntity cursoEntity){

        this.cursoRepository.findByName(cursoEntity.getName()).ifPresent((curso)-> {
            throw new CursoFoundException();
        });

        return this.cursoRepository.save(cursoEntity);
    }    
}
