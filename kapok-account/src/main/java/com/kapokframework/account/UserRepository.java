package com.kapokframework.account;

import com.kapokframework.account.User;
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
 * @since
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User user set user.status = 'DELETE' where user.id = :id")
    void recycle(@Param("id") Long id);

}
