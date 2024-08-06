package com.exam.colegio.service;

import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.repository.enrollment.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

        public List<Payment> findPaymentByTypeStatusId(Integer typeStatusId) {
                return paymentRepository.findByTypeStatusIdTypeStatus(typeStatusId);
        }

        public List<Payment> findPaymentByTypeStatusName(String typeStatusName) {
                return paymentRepository.findByTypeStatusName(typeStatusName);
        }

        public Optional<Payment> findById(Integer id) {
                return this.paymentRepository.findById(id);
        }

        public Payment save(Payment payment) {
                return this.paymentRepository.save(payment);
        }

        private final IPaymentRepository paymentRepository;

        @Autowired
        public PaymentService(IPaymentRepository paymentRepository) {
                this.paymentRepository = paymentRepository;
        }

}
