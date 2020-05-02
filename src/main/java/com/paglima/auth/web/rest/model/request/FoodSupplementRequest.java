package com.paglima.auth.web.rest.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodSupplementRequest {

    private String sku;
    private String name;
    private String description;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private List<VitaminRequest> vitamins;

}