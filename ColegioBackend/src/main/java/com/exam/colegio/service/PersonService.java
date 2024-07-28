package com.exam.colegio.service;

import com.exam.colegio.dao.IPersonDAO;
import com.exam.colegio.dto.PersonLoginDTO;
import com.exam.colegio.repository.person.IPersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonDAO {

        @Autowired
        private IPersonRepository personRepository;

        @Override
        public Optional<PersonLoginDTO> findByUsername(String username, String password) {

                var personOptional = personRepository.findByAccessUsernameAndAccessPassword(username, password);

                return personOptional.map(person -> PersonLoginDTO.builder()
                        .dni(person.getDni())
                        .name(person.getName())
                        .surnamePaternal(person.getSurnamePaternal())
                        .surnameMaternal(person.getSurnameMaternal())
                        .phoneNumber(person.getPhoneNumber())
                        .typePerson(person.getTypePerson())
                        .accessEnabled(person.getAccess().isAccessEnabled())
                        .username(person.getAccess().getUsername())
                        .password(person.getAccess().getPassword())
                        .description(person.getAccess().getDescription())
                        .build()
                );
        }

}
