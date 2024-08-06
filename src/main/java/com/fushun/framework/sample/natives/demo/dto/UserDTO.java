package com.fushun.framework.sample.natives.demo.dto;

import com.fushun.framework.bean.properties.config.IBeanCopyPropertiesBean;
import com.fushun.framework.json.config.JsonGraalVMNativeBean;
import lombok.Data;

@Data
//@JsonGraalVMNativeBean
//@BeanPropertiesGraalVMNativeBean
public class UserDTO  implements IBeanCopyPropertiesBean, JsonGraalVMNativeBean {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

