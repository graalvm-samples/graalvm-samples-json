package com.fushun.framework.sample.natives.demo.dto;

import com.fushun.framework.bean.properties.config.IBeanCopyPropertiesBean;
import com.fushun.framework.json.config.JsonGraalVMNativeBean;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherDTO implements IBeanCopyPropertiesBean, JsonGraalVMNativeBean {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

