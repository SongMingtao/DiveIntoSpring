package com.example.demoofcustomannotation.annotation.impl;

import com.example.demoofcustomannotation.annotation.MyRPC;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class RPCBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String name = getNameByServiceFinedAnntation(definition, registry);
        if(name != null && !"".equals(name)){
            return name;
        }
        return null;
    }

    private String getNameByServiceFinedAnntation(BeanDefinition definition, BeanDefinitionRegistry registry) {

        String beanClassName = definition.getBeanClassName();
        try {
            Class<?> aClass = Class.forName(beanClassName);
            MyRPC annotation = aClass.getAnnotation(MyRPC.class);
            if(annotation == null){
                return null;
            }
            return annotation.name();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
