package com.wine.to.up.winestyle.parser.service.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**Класс  ошибка, который кидается
 * когда мы запускаем парсинг при уже запущеном парсинге.
 */
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Service is busy.")
public class ServiceIsBusyException extends Exception {
    private final String cause;

    private ServiceIsBusyException(String cause) {
        this.cause = cause;
    }

    public static ServiceIsBusyException createWith(String cause) {
        return new ServiceIsBusyException(cause);
    }

    public String getMessage() {
        return "The server reported: " + cause;
    }
}