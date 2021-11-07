package com.kapokframework.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-18 18:48
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    @NotBlank
    private Long id;
    private String userlogin;
    @Email(message = "${email_error_msg}")
    private String email;
    private Byte status;

}
