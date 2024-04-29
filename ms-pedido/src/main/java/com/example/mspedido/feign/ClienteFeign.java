package com.example.mspedido.feign;

import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.entity.Pedido;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CircuitBreaker(name = "pedidoListarPorIdCB",fallbackMethod = "fallBackPedidoListarPorIdCB")
@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClienteFeign {
    @GetMapping("/{id}")
    ResponseEntity<ClienteDto> buscarPorId(@PathVariable(required = true) Integer id) ;
    private ResponseEntity<Pedido> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Pedido pedido = new Pedido();
        pedido.setId(90000);
        return ResponseEntity.ok().body(pedido);
    }
}
