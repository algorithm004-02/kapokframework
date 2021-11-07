package com.kapokframework.dvcode;

import com.kapokframework.common.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-25 23:40
 * @since
 */
@Service
public class DynamicVerifiableCodeManager {

    // TODO 可以改用 MySQL 或 Redis 存储
    private final Map<String, DynamicVerifiableCode>
        registVerificationCodeConcurrentHashMap = new ConcurrentHashMap<>();


    public DynamicVerifiableCode generateVerificationCode(String phoneNumber, Long timestamp) {

        // TODO 1 分钟校验
        if (!oneMinuteCheck(phoneNumber)) {
            throw new ServiceException("还没够1分钟不能这么玩的");
        }

        // 随机生成6位数字短信验证码
        String dvCode = RandomStringUtils.randomNumeric(6);

        // 记录生成时间戳
        Long generateAt = System.currentTimeMillis();

        // 生成 MD5 哈希码
        String hash = generateHash(phoneNumber, generateAt, dvCode, timestamp);

        // 构造动态验证码对象
        DynamicVerifiableCode dynamicVerifiableCode = DynamicVerifiableCode.builder()
            .phoneNumber(phoneNumber) // 手机号码
            .dvCode(dvCode) // 动态验证码
            .generateAt(generateAt) // 生成时间戳
            .hash(hash) // 校验 hash
            .build();

        this.registVerificationCodeConcurrentHashMap.put(phoneNumber, dynamicVerifiableCode);

        return dynamicVerifiableCode;

    }


    public boolean checkVerificationCode(String phoneNumber, String dvCode, Long timestamp) {

        DynamicVerifiableCode dynamicVerifiableCode
            = this.registVerificationCodeConcurrentHashMap.get(phoneNumber);

        if (null == dynamicVerifiableCode) {
            throw new ServiceException("无效的验证码");
        }

        Long generateAt = dynamicVerifiableCode.getGenerateAt();

        if (System.currentTimeMillis() >= (generateAt + 5 * 60 * 1000)) {// 5 分钟后过期
            this.registVerificationCodeConcurrentHashMap.remove(phoneNumber);
            throw new ServiceException("验证码过期");
        }

        String hash = generateHash(phoneNumber, generateAt, dvCode, timestamp);

        if (!hash.equals(dynamicVerifiableCode.getHash())) {
            throw new ServiceException("验证码错误");
        } else {
            this.registVerificationCodeConcurrentHashMap.remove(phoneNumber);// 验证码正确
            return true;
        }

    }


    public boolean checkVerificationCodeIsExist(String phoneNumber) {

        return null != this.registVerificationCodeConcurrentHashMap.get(phoneNumber);

    }


    private boolean oneMinuteCheck(String phoneNumber) {

        DynamicVerifiableCode dynamicVerifiableCode =
            this.registVerificationCodeConcurrentHashMap.get(phoneNumber);

        if (dynamicVerifiableCode == null) {
            return true;
        } else {
            Long generateAt = dynamicVerifiableCode.getGenerateAt();
            return System.currentTimeMillis() >= (generateAt + 60 * 1000);
        }

    }


    private String generateHash(String phoneNumber, Long generateAt, String verificationCode, Long timestamp) {

        // 拼接 hash 字符串（原文）
        String rawHash = StringUtils.joinWith(".", phoneNumber, verificationCode, generateAt, timestamp);

        // 对 hash 原文进行 MD5 哈希编码
        return DigestUtils.md5Hex(rawHash.getBytes(StandardCharsets.UTF_8));

    }


}
