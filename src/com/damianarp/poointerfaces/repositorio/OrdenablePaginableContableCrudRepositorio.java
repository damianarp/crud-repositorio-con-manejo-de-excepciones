package com.damianarp.poointerfaces.repositorio;

// Interface OrdenablePaginableContableCrudRepositorio con parámetro genérico T.
public interface OrdenablePaginableContableCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
