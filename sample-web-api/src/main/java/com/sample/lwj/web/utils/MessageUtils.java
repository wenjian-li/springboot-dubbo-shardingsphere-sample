package com.sample.lwj.web.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 国际化提示
 * @date 2023-4-3 18:28:33
 */
@Component
public class MessageUtils {

    /**
     * @param msgCode 国际化
     * @return 国际化信息
     */
    public static String message(String msgCode) {
        MessageSource messageSource = SpringContextUtils.getBean(MessageSource.class);
        return messageSource.getMessage(msgCode, null, "", LocaleContextHolder.getLocale());
    }
}
