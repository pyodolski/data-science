package com.example.demo.mapper;
import com.example.demo.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 유저 정보를 DB에 저장하기 위한 Mapper 인터페이스
public interface UserMapper {
    @Insert("insert into USER(USER_ID, USER_PW, USER_NAME, USER_AUTH, APPEND_DATE, UPDATE_DATE) " +
            "values(#{userId}, #{userPw}, #{userName}, #{userAuth}, #{appendDate}, #{updateDate})")
    void saveUser(UserVo user);
}
