package com.exam.colegio.dao;

import com.exam.colegio.model.person.Father;

import java.util.Optional;

public interface IFatherDAO {

        Optional<Father> findByDni(String dni);
}
