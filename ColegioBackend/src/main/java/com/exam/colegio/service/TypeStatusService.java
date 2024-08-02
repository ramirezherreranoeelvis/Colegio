package com.exam.colegio.service;

import com.exam.colegio.model.enrollment.TypeStatus;
import com.exam.colegio.repository.enrollment.ITypeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeStatusService {

        @Autowired
        private ITypeStatusRepository typeStatusRepository;

        public List<TypeStatus> findAll() {
                return this.typeStatusRepository.findAll();
        }

}
