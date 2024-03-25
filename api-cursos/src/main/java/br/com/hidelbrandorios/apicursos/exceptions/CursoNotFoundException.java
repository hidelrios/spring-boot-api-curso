package br.com.hidelbrandorios.apicursos.exceptions;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(){
        super("Curso não encontrado");
     }
}
