package com.example.mscatalogo.service.impl;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.repository.CatergoriaRepositorio;
import com.example.mscatalogo.service.CatergoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CatergoriaService {
    @Autowired
    private CatergoriaRepositorio catergoriaRepositorio;

    @Override
    public List<Categoria> lista() {
        return catergoriaRepositorio.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return catergoriaRepositorio.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return catergoriaRepositorio.findById(id);
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        return catergoriaRepositorio.save(categoria);
    }

    @Override
    public void eleminar(Integer id) {
         catergoriaRepositorio.deleteById(id);

    }
}
