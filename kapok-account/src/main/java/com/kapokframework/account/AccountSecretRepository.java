package com.kapokframework.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-18 17:39
 * @since
 */
public interface AccountSecretRepository extends JpaRepository<AccountSecret, Long> {

    AccountSecret findAccountSecretByUsername(String username);

}
