package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entity.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> create(@RequestBody Employe employe) {
        return new ResponseEntity<>(employeService.create(employe), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> findAll() {
        return ResponseEntity.ok(employeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> findById(@PathVariable Long id) {
        return employeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return ResponseEntity.ok(employeService.update(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}