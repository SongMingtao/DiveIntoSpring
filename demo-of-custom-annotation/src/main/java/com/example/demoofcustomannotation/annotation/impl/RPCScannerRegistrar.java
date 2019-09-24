package com.example.demoofcustomannotation.annotation.impl;

import com.example.demoofcustomannotation.annotation.RPCScan;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.util.Set;

public class RPCScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private  ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //获得所有注解的属性和值
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(RPCScan.class.getName()));
        String[] basePackage = annotationAttributes.getStringArray("basePackage");

        if(basePackage.length == 0){
            basePackage = new String[]{((StandardAnnotationMetadata) importingClassMetadata).getIntrospectedClass().getPackage().getName()};
        }
        RPCServiceClassPathScanHandle scanHandle = new RPCServiceClassPathScanHandle(registry, false);
        if(resourceLoader != null){
            scanHandle.setResourceLoader(resourceLoader);
        }
        scanHandle.setBeanNameGenerator(new RPCBeanNameGenerator());


        final Set<BeanDefinitionHolder> beanDefinitionHolders = scanHandle.doScan(basePackage);
    }
}
