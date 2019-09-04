package com.kapokframework.account.service;

import com.kapokframework.account.model.QUser;
import com.kapokframework.account.model.User;
import com.kapokframework.account.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Will WM. Zhang
 * @since 2019-08-13 14:12
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    public UserService(UserRepository userRepository, JPAQueryFactory jpaQueryFactory) {
        this.userRepository = userRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /**
     * 创建
     *
     * @param user user
     * @return
     */
    @Transactional
    public User create(User user) {
        return this.userRepository.save(user);
    }

    /**
     * 获取
     *
     * @param id id
     * @return
     */
    public User retrieve(Long id) {
        return this.userRepository.findById(id).orElse(null);// TODO 找不到时，这里应该抛出异常
    }

    /**
     * 更新
     *
     * @param id id
     * @param values values
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Transactional
    public User update(Long id, Map<String, Object> values) throws InvocationTargetException, IllegalAccessException {
        Optional<User> userOptional =  this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            User oldUser = userOptional.get();
            for (String key: values.keySet()) {
                BeanUtils.setProperty(oldUser, key, values.get(key));
            }
            return oldUser;
        }
        return null;// TODO 找不到时，这里应该抛出异常
    }

    /**
     * 删除
     *
     * @param id id
     * @return message
     */
    @Transactional
    public String delete(Long id) {
        this.userRepository.deleteById(id);
        return "{\"Status\":\"OK\"}";
    }

    /**
     * 回收
     *
     * @param id id
     * @return message
     */
    @Transactional
    public String recycle(Long id) {
        this.userRepository.recycle(id);
        return "{\"Status\":\"OK\"}";
    }

    /**
     * 搜索
     *
     * @param predicate
     * @return
     */
    public List<User> search(Predicate predicate) {
        QUser user = QUser.user;
        JPAQuery<User> query = this.jpaQueryFactory.selectFrom(user);

        if (predicate != null)
            query.where(predicate);

        return query.fetch();
    }

}
