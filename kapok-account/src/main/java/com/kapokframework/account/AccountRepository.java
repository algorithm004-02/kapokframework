package com.kapokframework.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2019-08-13 14:04
 * @since 1.0
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByPhoneNumber(String phoneNumber);

    @Modifying
    @Query("update Account a set a.status = -1 where a.id = :id")
    void recycle(@Param("id") Long id);

}
