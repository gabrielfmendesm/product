package store.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product", url = "http://product:8080")
public interface ProductController {

    @PostMapping("/product")
    ResponseEntity<ProductOut> create(
        @RequestBody ProductIn productIn
    );

    @GetMapping("/product")
    ResponseEntity<List<ProductOut>> findAll();

    @GetMapping("/product/{id}")
    ResponseEntity<ProductOut> findById(
        @PathVariable String id
    );

    @DeleteMapping("/product/{id}")
    ResponseEntity<Void> deleteById(
        @PathVariable String id
    );
}
