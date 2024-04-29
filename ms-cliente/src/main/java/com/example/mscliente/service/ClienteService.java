package com.example.mscliente.service;

import com.example.mscliente.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ClienteService {
    List<Cliente> lista();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(Integer id);
    Cliente actualizar(Cliente cliente);
    void eleminar(Integer id);
}
