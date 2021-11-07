package com.kapokframework.account;

import com.kapokframework.common.exception.ServiceException;
import com.kapokframework.dvcode.DynamicVerifiableCode;
import com.kapokframework.dvcode.DynamicVerifiableCodeManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-12-26 15:46
 * @since
 */
@Service
@RequiredArgsConstructor
public class RegistAccountByPhoneNumberServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final DynamicVerifiableCodeManager dynamicVerifiableCodeManager;


    public void sendRegistVerificationCode(String phoneNumber) {

        // TODO 1. 检查手机号码是否已经被注册
        if (null != this.accountRepository.findAccountByPhoneNumber(phoneNumber)) {
            throw new ServiceException("手机号已经被注册过了");
        }

        DynamicVerifiableCode dynamicVerifiableCode
            = this.dynamicVerifiableCodeManager.generateVerificationCode(phoneNumber, 123123123l);

        // TODO 3. 发送验证码

    }


    public AccountDTO registAccount(String phoneNumber) {

        this.dynamicVerifiableCodeManager.checkVerificationCode(phoneNumber, "dvCode", 123123123l);

        Account account = Account.builder()
            .username(phoneNumber)
            .phoneNumber(phoneNumber)
            .status((byte) 1).build();

        this.accountRepository.save(account);

        return null;

    }

}
