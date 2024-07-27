package com.exam.colegio.repository.enrollment;

import com.exam.colegio.model.enrollment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
