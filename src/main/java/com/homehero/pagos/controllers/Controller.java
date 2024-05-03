package com.homehero.pagos.controllers;

import com.homehero.pagos.models.Pago;
import com.homehero.pagos.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/homeHero-Pagos")
public class Controller {

    @Autowired
    private Services service;

    @GetMapping(value = "/pagos")
    public List<Pago> getAllPagos(){
        return service.getAllPagos();
    }

    @GetMapping("/pagos/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable("id") int id) {
        Optional<Pago> pagoById = service.getPagoById(id);
        return pagoById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/pagos")
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago){
        Pago createPago = service.createPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPago);
    }

    @PutMapping("/pago/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable("id") int id, @RequestBody Pago pago) {
        Optional<Pago> updatePago = service.updatePago(id, pago);
        return updatePago.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/pago/{id}")
    public ResponseEntity<Void> deletedPagoById(@PathVariable("id") int id){
        boolean deleted = service.deletedPago(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
