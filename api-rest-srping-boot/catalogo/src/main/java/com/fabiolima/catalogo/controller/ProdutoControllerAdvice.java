package com.fabiolima.catalogo.controller;

import com.fabiolima.catalogo.exception.ProdutoNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoNullException.class)
    public ResponseEntity<Object> capturaErroNull(){

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("mensagem", "Verifique os campos do produto");

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
