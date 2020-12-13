package com.example.demo.cache.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Data
@JsonIgnoreProperties(value = { "handler" })
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
    //从表实体应该包含一个主表实体的对象引用
    private User user;


}
