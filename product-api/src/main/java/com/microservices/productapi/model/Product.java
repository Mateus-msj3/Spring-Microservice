package com.microservices.productapi.model;

import com.microservices.productapi.model.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(product.getNome());
        product.setPreco(product.getPreco());
        product.setDescricao(product.getDescricao());
        product.setProductIdentifier(product.getProductIdentifier());

        if (productDTO.getCategoryDTO() != null) {
            product.setCategory(Category.convert(productDTO.getCategoryDTO()));
        }
        return product;
    }
}
