package com.example.mvvm_lib.repository;

import com.example.mvvm_lib.common.MVVMModelException;
import com.example.mvvm_lib.model.Model;

import java.lang.reflect.Field;

/**
 * @ClassName BaseRepository
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/18 9:13
 * @Version 1.0
 */
public abstract class BaseRepository {
    public BaseRepository() {
        injectModel();
    }

    private void injectModel() {
        Class<? extends BaseRepository> aClass = this.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if (fields==null||fields.length==0){
            throw new MVVMModelException("no have any fields info...");
        }
        boolean flag=false;
        for (Field field:fields){
            Model annotation = field.getAnnotation(Model.class);
            if (null!=annotation){
                flag=true;
                field.setAccessible(true);
                String fieldClassName = field.getType().getName();
                try {
                    Class<?> fieldClazz = Class.forName(fieldClassName);
                    Object fieldInstance = fieldClazz.newInstance();
                    field.set(this,fieldInstance);
                } catch (ClassNotFoundException e) {
                    throw new MVVMModelException(e.getMessage());
                } catch (IllegalAccessException e) {
                    throw new MVVMModelException(e.getMessage());
                } catch (InstantiationException e) {
                    throw new MVVMModelException(e.getMessage());
                }

            }
        }
        if (!flag){
            throw new MVVMModelException("no set any model.....");
        }
    }
}
