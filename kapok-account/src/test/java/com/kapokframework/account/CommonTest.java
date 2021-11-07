package com.kapokframework.account;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-12-26 16:28
 * @since 1.0.0
 */
@Slf4j
public class CommonTest {

    @Test
    public void test() {
        log.info("MD5 Phone Number: {}", Md5Crypt.apr1Crypt("13824543893".getBytes(StandardCharsets.US_ASCII)));
    }

}
