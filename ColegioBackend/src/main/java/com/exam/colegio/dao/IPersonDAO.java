package com.exam.colegio.dao;

import com.exam.colegio.dto.PersonLoginDTO;
public interface IPersonDAO {

        PersonLoginDTO findByUsername(String username, String password);

}
