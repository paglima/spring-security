package com.paglima.auth.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonPropertyOrder({"token", "user", "expiresAt"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    @JsonProperty("token")
    private String token;

    @JsonProperty("expiresAt")
    @JsonFormat(timezone="America/Sao_Paulo", pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expiresAt;
}