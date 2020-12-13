package com.example.demo.cache.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer id;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;
    private List<Account> accounts;

}
