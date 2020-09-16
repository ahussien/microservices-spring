package se.magnus.api.core.product;

import org.springframework.web.bind.annotation.*;

public interface ProductService {

    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return the product, if found, else null
     */
    @GetMapping(
        value    = "/product/{productId}",
        produces = "application/json")
    ProductDto getProduct(@PathVariable int productId);

    @PostMapping(
            value    = "/product",
            consumes = "application/json",
            produces = "application/json")
    ProductDto createProduct(@RequestBody ProductDto body);

    @DeleteMapping(value = "/product/{productId}")
    void deleteProduct(@PathVariable int productId);
}
