package com.liangzai.bugs.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author liangzaixiaoxia
 * @Date 2023/4/17
 * @Description 一些反射工具
 */
public class ClassUtil {

    /**
     * getDeclaredFields 只能获取当前类的所有属性，不包含父类
     * 该方法用于获取当前类及父类、爷类、太爷类...的所有属性
     *
     * @param o 想要追根溯源获取所有属性的对象
     * @return 自己和父类、爷类、太爷类...的所有属性
     */
    public static Field[] getAllFields(Object o) {
        Class<?> clazz = o.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

}
