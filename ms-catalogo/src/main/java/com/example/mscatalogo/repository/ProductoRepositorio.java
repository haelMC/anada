package com.example.mscatalogo.repository;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
