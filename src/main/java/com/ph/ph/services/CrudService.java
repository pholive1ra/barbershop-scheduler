package com.ph.ph.services;

import java.util.List;

public interface CrudService<T> {

    void cadastrar(T entidade);
    List<T> listar();
    void remover (T entidade);
    T buscar (String nome);

}
