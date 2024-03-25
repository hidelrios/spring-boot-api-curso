package br.com.hidelbrandorios.apicursos.modules.curso.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.hidelbrandorios.apicursos.modules.curso.entities.CursoEntity;
import br.com.hidelbrandorios.apicursos.modules.curso.repositories.CursoRepository;
import br.com.hidelbrandorios.apicursos.modules.curso.services.CreateCursoService;
import br.com.hidelbrandorios.apicursos.modules.curso.services.DeleteCursoService;
import br.com.hidelbrandorios.apicursos.modules.curso.services.GetAllCursoService;
import br.com.hidelbrandorios.apicursos.modules.curso.services.GetCursoService;
import br.com.hidelbrandorios.apicursos.modules.curso.services.PatchCursoService;
import br.com.hidelbrandorios.apicursos.modules.curso.services.PutCursoService;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CreateCursoService createCursoService;

    @Autowired
    private GetCursoService getCursoService;

    @Autowired
    private GetAllCursoService getAllCursoService;

    @Autowired
    private PutCursoService putCursoService;

    @Autowired
    private PatchCursoService patchCursoService;

    @Autowired
    private DeleteCursoService deleteCursoService;

    @PostMapping
    public ResponseEntity<Object> post(@Valid @RequestBody CursoEntity cursoEntity){

        try {
            var result = this.createCursoService.execute(cursoEntity);  
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<Object> get(@Valid @RequestBody  Map<String, String> requestBody){

        try {
            String cursoName = requestBody.get("cursoName");
            if (cursoName == null || cursoName.isEmpty()) {
                throw new IllegalArgumentException("O nome do curso é obrigatório");
            }
            var result = this.getCursoService.execute(cursoName);  
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(){

        try {
            var result = this.getAllCursoService.execute();  
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCurso(@PathVariable(value = "id") String cursoId, @RequestBody CursoEntity cursoDetails){
        try {
            var result = this.putCursoService.execute(UUID.fromString(cursoId.toString()), cursoDetails);  
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> updateStatusCurso(@PathVariable(value = "id") String cursoId, @RequestBody CursoEntity cursoDetails){
        try {
            var result = this.patchCursoService.execute(UUID.fromString(cursoId.toString()), cursoDetails);  
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable(value = "id") String cursoId){
        try {
            this.deleteCursoService.execute(UUID.fromString(cursoId.toString()));  
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
