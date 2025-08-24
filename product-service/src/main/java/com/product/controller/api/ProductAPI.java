package com.product.controller.api;

import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product")
public interface ProductAPI {

    @Operation(summary = "Create Product", description = "Create Product")
    @ApiResponse(responseCode = "201", description = "Product Created Successfully")
    @ApiResponse(responseCode = "403", description = "Not a authorized user")
    @PostMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> createProduct(
            @Parameter(in = ParameterIn.DEFAULT, description = "Body of the product") @Valid @RequestBody ProductRequest product
    );


    @Operation(summary = "Update Product", description = "Update product returns the updated product")
    @ApiResponse(responseCode = "200", description = "Product Updated Successfully")
    @ApiResponse(responseCode = "403", description = "Not a authorized user")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @PutMapping(path = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> updateProduct(
            @Parameter(in = ParameterIn.DEFAULT, description = "Product Body") @Valid @RequestBody ProductRequest productRequest,
            @Parameter(in = ParameterIn.PATH, description = "Id of the product", required = true) @NotEmpty @PathVariable(value = "productId") Long productId
    );

    @Operation(summary = "Get Product", description = "Get Product returns the product details")
    @ApiResponse(responseCode = "200", description = "Successfully fetched the product")
    @ApiResponse(responseCode = "403", description = "Not a authorized user")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping(path = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductResponse> getProduct(
            @Parameter(in = ParameterIn.PATH, description = "Id of the product", required = true) @NotEmpty @PathVariable(value = "productId") Long productId
    );

    @Operation(summary = "Delete Product",description = "Delete Product")
    @ApiResponse(responseCode = "200", description = "Successfully Deleted the product")
    @ApiResponse(responseCode = "403", description = "Not a authorized user")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @DeleteMapping(path = "/products/{productId}")
    ResponseEntity<String> deleteProduct(
            @Parameter(in = ParameterIn.PATH, description = "Id of the product", required = true) @NotEmpty @PathVariable(value = "productId") Long productId
    );

    @Operation(summary = "Get All Products", description = "Get All Products returns all the products")
    @ApiResponse(responseCode = "200", description = "Successfully fetched all the product")
    @ApiResponse(responseCode = "403", description = "Not a authorized user")
    @GetMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductResponse>> getAllProducts(
            @Parameter(in = ParameterIn.QUERY, description = "Search text of the product",required = true) @NotEmpty @RequestParam(value = "searchText") String searchText
    );

}