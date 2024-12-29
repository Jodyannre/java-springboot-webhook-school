package com.allstudent.data.service;


import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public interface Service<E,D> {
    D save(D dto);
    D convertToDto(E entity);
    E convertToEntity(D dto);
}


