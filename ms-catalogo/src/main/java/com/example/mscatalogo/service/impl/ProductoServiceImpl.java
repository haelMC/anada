package com.example.mscatalogo.service.impl;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import com.example.mscatalogo.repository.CatergoriaRepositorio;
import com.example.mscatalogo.repository.ProductoRepositorio;
import com.example.mscatalogo.service.CatergoriaService;
import com.example.mscatalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> lista() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eleminar(Integer id) {
        productoRepositorio.deleteById(id);

    }
}
