package com.kapokframework.account.dvcode;

import com.kapokframework.dvcode.DynamicVerifiableCodeManager;
import com.kapokframework.dvcode.DynamicVerifiableCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-27 17:23
 * @since
 */
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 设置测试实例对整个测试 Class 有效
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DynamicVerifiableCodeManagerTest {

    @Autowired
    DynamicVerifiableCodeManager dynamicVerifiableCodeManager;

    private static String phoneNumber;
    private static Long timestamp;

    private String dvCode;

    @BeforeAll
    void setUp() {
        phoneNumber = "13824543893";
        timestamp = System.currentTimeMillis();
    }


    @Test
    @Order(1)
    void testGenerateVerificationCode() {

        DynamicVerifiableCode dynamicVerifiableCode =
            dynamicVerifiableCodeManager.generateVerificationCode(phoneNumber, timestamp);

        dvCode = dynamicVerifiableCode.getDvCode();

        Assertions.assertNotNull(dynamicVerifiableCode);
        Assertions.assertNotNull(dynamicVerifiableCode.getPhoneNumber());
        Assertions.assertNotNull(dynamicVerifiableCode.getDvCode());
        Assertions.assertNotNull(dynamicVerifiableCode.getGenerateAt());
        Assertions.assertNotNull(dynamicVerifiableCode.getHash());

        log.info("{}", dynamicVerifiableCode);

    }


    @Test
    @Order(2)
    void testCheckVerificationCode() {

        boolean checkVerificationCode
            = dynamicVerifiableCodeManager.checkVerificationCode(phoneNumber, dvCode, timestamp);
        boolean checkVerificationCodeIsExist
            = dynamicVerifiableCodeManager.checkVerificationCodeIsExist(phoneNumber);

        Assertions.assertTrue(checkVerificationCode);
        Assertions.assertFalse(checkVerificationCodeIsExist);

    }


}
