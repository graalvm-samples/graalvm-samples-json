package com.fushun.framework.sample.natives.demo.dto;


import com.fushun.framework.bean.properties.config.IBeanCopyPropertiesBean;
import com.fushun.framework.json.config.JsonGraalVMNativeBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDataVO<T> implements JsonGraalVMNativeBean, IBeanCopyPropertiesBean {

    /**
     * string[1,32]	是
     * 是	错误码，枚举值见错误码列表
     * 	示例值：INVALID_REQUEST
     */
    private String code;

    /**
     * string[1,256]	否
     * 返回信息，如非空，为错误原因
     * 	示例值：参数格式校验错误
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

}