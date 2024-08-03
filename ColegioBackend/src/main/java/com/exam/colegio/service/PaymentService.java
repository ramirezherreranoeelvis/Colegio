package com.exam.colegio.service;

import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.repository.enrollment.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

        public List<Payment> findPaymentByTypeStatusId(Integer typeStatusId) {
                return paymentRepository.findByTypeStatusIdTypeStatus(typeStatusId);
        }

        public List<Payment> findPaymentByTypeStatusName(String typeStatusName) {
                return paymentRepository.findByTypeStatusName(typeStatusName);
        }

        private final IPaymentRepository paymentRepository;

        @Autowired
        public PaymentService(IPaymentRepository paymentRepository) {
                this.paymentRepository = paymentRepository;
        }

}
