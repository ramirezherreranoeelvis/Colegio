package com.exam.colegio.dao;

import com.exam.colegio.model.person.Mother;

import java.util.Optional;

public interface IMotherDAO {

        Optional<Mother> findByDni(String dni);

}
