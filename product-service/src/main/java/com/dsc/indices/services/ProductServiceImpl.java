package com.dsc.indices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dsc.indices.persistence.ProductEntity;
import com.dsc.indices.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.ProductDto;
import se.magnus.api.core.product.ProductService;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.exceptions.NotFoundException;
import se.magnus.util.http.ServiceUtil;

@RestController
public class ProductServiceImpl implements ProductService {

    private ServiceUtil serviceUtil;
    private ProductRepository repository;
    private ProductMapper mapper;
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ServiceUtil serviceUtil, ProductRepository productRepository, ProductMapper productMapper) {
        this.serviceUtil = serviceUtil;
        this.repository = productRepository;
        this.mapper = productMapper;
    }

    @Override
    public ProductDto getProduct(int productId) {
        if (productId < 1) throw new InvalidInputException("Invalid productId:" + productId);
        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);

        //return new ProductDto(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());

        ProductEntity entity = repository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundException("No product found for productId: " + productId));

        ProductDto dto = mapper.entityToApi(entity);

        dto.setServiceAddress(serviceUtil.getServiceAddress());

        LOG.debug("getProduct: found productId: {}", dto.getProductId());

        return dto;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        ProductEntity productEntity = mapper.apiToEntity(dto);
        ProductEntity newEntity = repository.save(productEntity);

        LOG.debug("createProduct: entity created for productId: {}", newEntity.getProductId());

        return mapper.entityToApi(newEntity);
    }

    @Override
    public void deleteProduct(int productId) {
        LOG.debug("deleteProduct: tries to delete an entity with productId: {}", productId);
        repository.findByProductId(productId).ifPresent(e -> repository.delete(e));
    }
}
