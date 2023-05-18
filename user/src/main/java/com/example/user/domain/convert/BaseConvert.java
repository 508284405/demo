package com.example.user.domain.convert;

import java.util.Collection;
import java.util.List;

public interface BaseConvert<M, E> {
    M toDomain(E e);


    E toEntity(M m);

    List<M> toDomains(List<E> e);

//    <T extends Collection<E>, R extends Collection<M>> R toDomains(T e);
//
//    <T extends Collection<E>, R extends Collection<M>> T toEntitys(R m);
}
