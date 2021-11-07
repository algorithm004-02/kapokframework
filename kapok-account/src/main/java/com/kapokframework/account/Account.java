package com.kapokframework.account;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2019-08-13 18:47
 * @since
 */
@Data
@Builder
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String userpass;
    private String nickname;
    private String realname;
    private String phoneNumber;
    private String email;
    private String type;
    private String avatar;
    private Byte status;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private Date createdAt;

}
