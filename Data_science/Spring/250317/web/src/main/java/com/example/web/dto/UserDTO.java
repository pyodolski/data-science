package com.example.web.dto;

import com.example.web.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String userID;
    private String pwd;
    private String userName;
    private String userEmail;

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(userEntity.getUserID());
        userDTO.setPwd(userEntity.getPwd());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserEmail(userEntity.getUserEmail());
        return userDTO;
    }
}
