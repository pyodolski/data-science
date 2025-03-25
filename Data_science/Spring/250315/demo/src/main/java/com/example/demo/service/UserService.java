package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Transactional
    public void joinUser(UserVo userVo) {
        try {
            // 비밀번호 암호화
            userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
            userVo.setUserAuth("USER");
            userVo.setAppendDate(format.format(new Date()));
            userVo.setUpdateDate(format.format(new Date()));

            // DB에 저장
            userMapper.saveUser(userVo);
            System.out.println("회원가입 성공: " + userVo.getUserId());

        } catch (Exception e) {
            System.err.println("회원가입 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
