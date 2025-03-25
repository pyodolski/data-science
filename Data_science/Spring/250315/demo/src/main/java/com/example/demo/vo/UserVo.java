package com.example.demo.vo;

import lombok.Data;

@Data // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
public class UserVo {
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userAuth;
    private String appendDate;
    private String updateDate;
}
