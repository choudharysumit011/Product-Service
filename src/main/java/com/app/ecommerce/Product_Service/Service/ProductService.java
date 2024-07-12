package com.app.ecommerce.Product_Service.Service;

import com.app.ecommerce.Product_Service.Model.Product;
import com.app.ecommerce.Product_Service.dto.ProductRequest;
import com.app.ecommerce.Product_Service.dto.ProductResponse;
import com.app.ecommerce.Product_Service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

   private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName()).price(productRequest.getPrice())
                .description(productRequest.getDescription()).build();
                productRepository.save(product);
                log.info("Product {} created",product.getId());

    }

    public List<ProductResponse> getProduct() {
        List<Product> products = productRepository.findAll();
       return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
