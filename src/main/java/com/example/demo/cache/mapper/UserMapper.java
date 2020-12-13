package com.example.demo.cache.mapper;

import com.example.demo.cache.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "accounts",
                    many = @Many(select = "com.example.demo.cache.mapper.IAccountMapper.findAccountByUid",
                            fetchType = FetchType.EAGER))
    })
     List<User> findAll();

    @Select("select * from user  where id=#{id} ")
    User findById(Integer userId);
    @Update("UPDATE user SET username=#{userName},sex=#{sex},birthday=#{birthday},address=#{address} WHERE id=#{id}")
    void updateById(User user);
}
