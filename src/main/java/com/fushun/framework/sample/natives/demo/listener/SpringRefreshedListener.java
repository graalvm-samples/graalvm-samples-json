package com.fushun.framework.sample.natives.demo.listener;

import cn.hutool.core.lang.TypeReference;
import com.fushun.framework.bean.properties.utils.spring.BeanUtils;
import com.fushun.framework.json.utils.hutool.JSONUtil;
import com.fushun.framework.sample.natives.demo.dto.ResultDataVO;
import com.fushun.framework.sample.natives.demo.dto.StudentDTO;
import com.fushun.framework.sample.natives.demo.dto.TeacherDTO;
import com.fushun.framework.sample.natives.demo.dto.UserDTO;
import com.fushun.framework.sample.natives.demo.po.StudentDO;
import com.fushun.framework.sample.natives.demo.po.TeacherDO;
import com.fushun.framework.sample.natives.demo.po.UserDO;
import com.fushun.framework.util.beans.ConverterUtil;
import com.fushun.framework.util.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Slf4j
public class SpringRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{

    private static Logger logger= LoggerFactory.getLogger(SpringRefreshedListener.class);

    /**
     * 测试  BeanUtils.copyProperties(userDO, userDTO);
     */
    public void getUser(){
        UserDO userDO=new UserDO();
        userDO.setAge(1);
        userDO.setName("王福顺");
        userDO.setEmail("122@qq.com");
        userDO.setId(2L);
        log.info("studentDO:{}",userDO);
        try {
            UserDTO userDTO=new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            log.info("userDTO:{}",userDTO);
        }catch (Exception err){
            log.info("d",err);
        }
        try {
            UserDTO userDTO2=new UserDTO();
            com.fushun.framework.bean.properties.utils.hutool.BeanUtil.copyProperties(userDO,userDTO2,false);
            log.info("userDTO2:{}",userDTO2);
        }catch (Exception err){
            log.info("d",err);
        }
        try {
            String userDOString = JsonUtil.toJson(userDO);
            log.info("userDOString:{}", userDOString);
            UserDTO userDTO3 = JsonUtil.jsonToClass(userDOString, UserDTO.class);
            log.info("userDTO3:{}", userDTO3);
        }catch (Exception err){
            log.info("d",err);
        }

    }

    /**
     * 测试 JsonUtil.toJson
     */
    public void getStudent(){
        StudentDO studentDO=new StudentDO();
        studentDO.setAge(1);
        studentDO.setName("王福顺");
        studentDO.setEmail("122@qq.com");
        studentDO.setId(2L);
        log.info("studentDO:{}",studentDO);
        try {
            StudentDTO studentDTO=new StudentDTO();
            BeanUtils.copyProperties(studentDO, studentDTO);
            log.info("studentDTO:{}",studentDTO);
        }catch (Exception err){
            log.info("d",err);
        }

        try {
            StudentDTO studentDTO1=new StudentDTO();
            com.fushun.framework.bean.properties.utils.hutool.BeanUtil.copyProperties(studentDO,studentDTO1,false);
            log.info("studentDTO1:{}",studentDTO1);
        }catch (Exception err){
            log.info("d",err);
        }

        try {
            String studentDOString=JsonUtil.toJson(studentDO);
            log.info("studentDOString:{}",studentDOString);
            StudentDTO studentDTO2=JsonUtil.jsonToClass(studentDOString,StudentDTO.class);
            log.info("studentDTO2:{}",studentDTO2);
        }catch (Exception err){
            log.info("d",err);
        }
    }

    /**
     * 测试 hutool.BeanUtil.copyProperties
     */
    public void getTeacher(){
        TeacherDO teacherDO=new TeacherDO();
        teacherDO.setAge(1);
        teacherDO.setName("王福顺");
        teacherDO.setEmail("122@qq.com");
        teacherDO.setId(2L);
        log.info("teacherDO:{}",teacherDO);
        try {
            TeacherDTO teacherDTO=new TeacherDTO();
            BeanUtils.copyProperties(teacherDO, teacherDTO);
            log.info("teacherDTO:{}",teacherDTO);
        }catch (Exception err){
            log.info("d",err);
        }

        try {
            TeacherDTO teacherDTO1=new TeacherDTO();
            com.fushun.framework.bean.properties.utils.hutool.BeanUtil.copyProperties(teacherDO,teacherDTO1,false);
            log.info("teacherDTO1:{}",teacherDTO1);
        }catch (Exception err){
            log.info("d",err);
        }

        try {
            String teacherDOString=JsonUtil.toJson(teacherDO);
            log.info("teacherDOString:{}",teacherDOString);
            TeacherDTO teacherDTO2=JsonUtil.jsonToClass(teacherDOString,TeacherDTO.class);
            log.info("teacherDTO2:{}",teacherDTO2);
        }catch (Exception err){
            log.info("d",err);
        }


        try {
            TeacherDTO teacherDTO1=new TeacherDTO();
            ConverterUtil.convert(teacherDO,teacherDTO1);
            log.info("teacherDTO12:{}",teacherDTO1);
        }catch (Exception err){
            log.info("d",err);
        }


    }

    /**
     * 测试反射的问题
     */
    public void jsonTypeReference(){
          UserDO userDO=new UserDO();
          userDO.setAge(1);
          userDO.setName("王福顺");
          userDO.setEmail("122@qq.com");
          userDO.setId(2L);
          log.info("studentDO:{}",userDO);
          String body="{\"code\":\"ok\",\"message\":\"message\",\"data\":[{\"id\":1,\"name\":\"name\",\"age\":1,\"email\":\"email\"}]}";
          TypeReference<ResultDataVO<ArrayList<UserDO>>> ref = new TypeReference<ResultDataVO<ArrayList<UserDO>>>() { };
          ResultDataVO<ArrayList<UserDO>> resultDataVO= JSONUtil.toBean(body,ref,true);
          log.info("resultDataVO:{}",resultDataVO.toString());
      }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.getUser();
        this.getStudent();
        this.getTeacher();
        this.jsonTypeReference();
        log.info("============SpringRefreshedListener 执行=========== ");

    }

}