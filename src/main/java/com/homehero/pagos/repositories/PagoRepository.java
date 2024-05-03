package com.homehero.pagos.repositories;

import com.homehero.pagos.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
