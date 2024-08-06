package com.exam.colegio.service;

import com.exam.colegio.model.enrollment.TypeStatus;
import com.exam.colegio.repository.enrollment.ITypeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TypeStatusService {

        @Autowired
        private ITypeStatusRepository typeStatusRepository;

        public Optional<TypeStatus> getPendiente() {
                return this.typeStatusRepository.findAll().stream().filter(typeStatus -> typeStatus.getName().equals("pendiente")).findFirst();
        }

        public Optional<TypeStatus> getCancelado() {
                return this.typeStatusRepository.findAll().stream().filter(typeStatus -> typeStatus.getName().equals("cancelado")).findFirst();
        }

        public Optional<TypeStatus> getAnulado() {
                return this.typeStatusRepository.findAll().stream().filter(typeStatus -> typeStatus.getName().equals("anulado")).findFirst();
        }

        public Optional<TypeStatus> findById(int id) {
                return this.typeStatusRepository.findById(id);
        }

}
