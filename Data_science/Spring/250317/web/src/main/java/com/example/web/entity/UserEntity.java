package com.example.web.entity;

import com.example.web.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // primary key
    private String userID;

    @Column(length = 100)
    private String pwd;

    @Column(length = 100)
    private String userName;

    @Column(length = 100)
    private String userEmail;

    @Builder
    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserID(userDTO.getUserID());
        userEntity.setPwd(userDTO.getPwd());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserEmail(userDTO.getUserEmail());
        return userEntity;
    }
}
