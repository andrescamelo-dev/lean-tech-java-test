package com.lean.tech.java.Employees.common;

import lombok.Getter;
import lombok.Setter;

/**
 * <br>ErrorsCodeEnum.<br/>
 *
 * @author DREAMCODE
 * @since 04/06/2021
 * Historia de Modificaciones
 * ---------------------------
 * Autor              Fecha          Modificacion
 * DREAMCODE         04/06/2021      Creaci\u00f3n
 * -----------------  -------------- ----------------------------
 */
@Getter
public enum ErrorsCodeEnum
{
    BAD_REQUEST("01","400","Bad Request"),
    UNAUTHORIZED("02","401","Unauthorized  Request"),
    FORBIDDEN("03","403","Forbidden Request"),
    NOT_FOUND("04","404","Not found"),
    INTERNAL_SERVER_ERROR("06","500","Internal server error");

    private String code;
    private String description;
    private String codeErrorHttp;

    ErrorsCodeEnum(String code, String codeErrorHttp ,String description)
    {
        this.code          = code;
        this.codeErrorHttp = codeErrorHttp;
        this.description   = description;
    }
}
