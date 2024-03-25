package br.com.hidelbrandorios.apicursos.exceptions;

public class CursoFoundException extends RuntimeException{
     public CursoFoundException(){
        super("Curso ja existe");
     }
}
