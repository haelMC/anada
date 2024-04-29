package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductoService {
    List<Producto> lista();

    Producto guardar(Producto producto);

    Optional<Producto> buscarPorId(Integer id);

    Producto actualizar(Producto producto);

    void eleminar(Integer id);

}
