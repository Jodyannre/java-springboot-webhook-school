package com.allstudent.data.service;


import com.allstudent.data.dto.ApiResponse;

@org.springframework.stereotype.Service
public interface Service<E,D> {
    ApiResponse<D> save(D dto);
    D convertToDto(E entity);
    E convertToEntity(D dto);
}


