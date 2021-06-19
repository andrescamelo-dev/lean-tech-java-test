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
public enum ErrorTypeEnum
{
    LOGICAL("LogicalError"),
    GENERAL("GeneralError");
    
    private String name;
    

    ErrorTypeEnum(String name)
    {
        this.name = name;
       
    }
}
