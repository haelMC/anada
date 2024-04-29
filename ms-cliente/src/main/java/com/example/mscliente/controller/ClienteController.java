package com.example.mscliente.controller;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    ResponseEntity<List<Cliente>> lista(){
        return ResponseEntity.ok(clienteService.lista());
    }
    @PostMapping
    ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.guardar((cliente)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Cliente> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(clienteService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.actualizar((cliente)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Cliente>> eleminar(@PathVariable(required = true) Integer id){
        clienteService.eleminar(id);
        return ResponseEntity.ok(clienteService.lista());

    }
}
