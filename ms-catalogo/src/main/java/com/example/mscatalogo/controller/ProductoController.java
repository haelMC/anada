package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import com.example.mscatalogo.service.CatergoriaService;
import com.example.mscatalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
    @RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    ResponseEntity<List<Producto>> lista(){
        return ResponseEntity.ok(productoService.lista());
    }
    @PostMapping
    ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar((producto)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Producto> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(productoService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Producto> actualizar(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizar((producto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Producto>> eleminar(@PathVariable(required = true) Integer id){
        productoService.eleminar(id);
        return ResponseEntity.ok(productoService.lista());

    }
}
