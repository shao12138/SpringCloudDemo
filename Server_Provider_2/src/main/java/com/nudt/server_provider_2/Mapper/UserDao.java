package com.nudt.server_provider_2.Mapper;

import com.nudt.server_provider_2.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from users where id=#{id}")
    User findUser(int id);
}
