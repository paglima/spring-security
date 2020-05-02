package com.paglima.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private List<String> roles;

}
