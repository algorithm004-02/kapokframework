package com.kapokframework.account.repository;

import com.kapokframework.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Will WM. Zhang
 * @since 2019-08-13 14:04
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User user set user.status = 'DELETE' where user.id = :id")
    void recycle(@Param("id") Long id);

}
