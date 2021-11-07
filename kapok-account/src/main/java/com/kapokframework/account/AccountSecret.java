package com.kapokframework.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-18 16:00
 * @since
 */
@Data
@Builder
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class AccountSecret {

    @Id
    private Long id;

    private String username;
    private String userpass;
    private Byte status;
}
