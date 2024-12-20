package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.ProductImageDTO;
import com.dev.BookPlace.models.dto.ProductMinDTO;
import com.dev.BookPlace.models.entities.Product;
import com.dev.BookPlace.models.entities.ProductImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class ProductDTOMinMapperImpl implements ProductDTOMinMapper {

    @Autowired
    private ProductImagesDTOMapper productImagesDTOMapper;

    @Override
    public ProductMinDTO toProductMinDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductMinDTO productMinDTO = new ProductMinDTO();

        productMinDTO.setId( product.getId() );
        productMinDTO.setName( product.getName() );
        productMinDTO.setPrice( product.getPrice() );
        productMinDTO.setCashPrice( product.getCashPrice() );
        productMinDTO.setInstallmentPrice( product.getInstallmentPrice() );
        productMinDTO.setDescription( product.getDescription() );
        productMinDTO.setDetails( product.getDetails() );
        productMinDTO.setProductImages( productImageListToProductImageDTOList( product.getProductImages() ) );

        return productMinDTO;
    }

    protected List<ProductImageDTO> productImageListToProductImageDTOList(List<ProductImage> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductImageDTO> list1 = new ArrayList<ProductImageDTO>( list.size() );
        for ( ProductImage productImage : list ) {
            list1.add( productImagesDTOMapper.toProductImagesDTO( productImage ) );
        }

        return list1;
    }
}
