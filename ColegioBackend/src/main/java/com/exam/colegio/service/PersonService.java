package com.exam.colegio.service;

import com.exam.colegio.dao.IPersonDAO;
import com.exam.colegio.dto.PersonLoginDTO;
import com.exam.colegio.repository.person.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonDAO {

        @Autowired
        private IPersonRepository personRepository;

        @Override
        public PersonLoginDTO findByUsername(String username, String password) {
                var personOptional = personRepository.findByAccessUsernameAndAccessPassword(username, password);

                var personLogingOptional = personOptional.map(person ->
                        PersonLoginDTO.builder()
                                .dni(person.getDni())
                                .name(person.getName())
                                .surnamePaternal(person.getSurnamePaternal())
                                .surnameMaternal(person.getSurnameMaternal())
                                .phoneNumber(person.getPhoneNumber())
                                .username(person.getAccess().getUsername())
                                .password(person.getAccess().getPassword())
                                .build()
                );

                return personLogingOptional.orElse(null);
        }

}
