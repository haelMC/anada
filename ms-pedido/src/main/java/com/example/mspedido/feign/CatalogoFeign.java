package com.example.mspedido.feign;

import com.example.mspedido.dto.ProductoDto;
import com.example.mspedido.entity.Pedido;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/producto")
public interface CatalogoFeign {
    @CircuitBreaker(name = "productoListarPorIdCB",fallbackMethod = "fallBackPedidoListarPorIdCB")
    @GetMapping("/{id}")
    ResponseEntity<ProductoDto> productoBuscarPorId(@PathVariable(required = true) Integer id) ;

    private ResponseEntity<Pedido> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Pedido pedido = new Pedido();
        pedido.setId(90000);
        return ResponseEntity.ok().body(pedido);
    }

}
