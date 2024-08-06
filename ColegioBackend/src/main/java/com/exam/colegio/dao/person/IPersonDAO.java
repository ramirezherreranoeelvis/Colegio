package com.exam.colegio.dao;

import com.exam.colegio.dto.PersonLoginDTO;

import java.util.Optional;

public interface IPersonDAO {

        Optional<PersonLoginDTO> findByUsername(String username, String password);

        Optional<String> getTypeParent(String dni);

}
