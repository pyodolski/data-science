package com.example.web.service;

import com.example.web.dto.UserDTO;
import com.example.web.entity.UserEntity;
import com.example.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserDTO userDTO) {
        // request -> DTO -> Entity -> Repository에서 save
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
        // Repository의 save 호출
    }
}
