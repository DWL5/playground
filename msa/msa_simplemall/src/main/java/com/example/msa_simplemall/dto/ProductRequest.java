package com.example.msa_simplemall.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private String name;
    private int stock;

}
