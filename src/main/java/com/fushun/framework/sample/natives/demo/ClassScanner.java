package com.fushun.framework.sample.natives.demo;

import com.google.common.reflect.ClassPath;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassScanner {
    private static final String BASE_PACKAGE = "org.bouncycastle";

    public static Set<Class<?>> scanPackage() throws IOException {
        Set<Class<?>> classes = new HashSet<>();
        ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());

        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClassesRecursive(BASE_PACKAGE)) {
            Class<?> clazz = classInfo.load();
            classes.add(clazz);
            addNestedClasses(classes, clazz);
        }
        return classes;
    }

    private static void addNestedClasses(Set<Class<?>> classes, Class<?> clazz) {
        for (Class<?> nestedClass : clazz.getDeclaredClasses()) {
            classes.add(nestedClass);
            addNestedClasses(classes, nestedClass); // 递归检查嵌套类
        }
    }

    public static void main(String[] args) throws IOException {
        Set<Class<?>> classes = scanPackage();
        StringBuffer sb = new StringBuffer();
        classes.forEach(clazz -> sb.append(clazz.getName()+","));
//        System.out.println(sb.toString());
        log.info(sb.toString());
//        System.out.println("Total classes scanned: " + classes.size());
    }
}


