package com.paglima.auth.web.rest.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodSupplementRequest {

    private String sku;
    private String name;
    private String description;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private List<VitaminRequest> vitamins;

}