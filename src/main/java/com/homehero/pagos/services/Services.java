package com.homehero.pagos.services;

import com.homehero.pagos.models.Pago;
import com.homehero.pagos.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Services {

    @Autowired
    private PagoRepository repositoryPago;

    public Pago createPago(Pago pago){
        return repositoryPago.save(pago);
    }

    public Optional<Pago> updatePago(int id, Pago pago){
        if (!repositoryPago.existsById(id)){
            return Optional.empty();
        }
        pago.setId_pago(id);
        return Optional.of(repositoryPago.save(pago));
    }

    public boolean deletedPago(int id){
        if (!repositoryPago.existsById(id)){
            return false;
        }
        repositoryPago.deleteById(id);
        return true;
    }

    public List<Pago> getAllPagos(){
        return repositoryPago.findAll();
    }

    public Optional<Pago> getPagoById(int id){
        return repositoryPago.findById(id);
    }
}
