package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.service.CatergoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CatergoriaService catergoriaService;

    @GetMapping
    ResponseEntity<List<Categoria>> lista(){
        return ResponseEntity.ok(catergoriaService.lista());
    }
    @PostMapping
    ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return ResponseEntity.ok(catergoriaService.guardar((categoria)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Categoria> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(catergoriaService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria){
        return ResponseEntity.ok(catergoriaService.actualizar((categoria)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Categoria>> eleminar(@PathVariable(required = true) Integer id){
        catergoriaService.eleminar(id);
        return ResponseEntity.ok(catergoriaService.lista());

    }
}
