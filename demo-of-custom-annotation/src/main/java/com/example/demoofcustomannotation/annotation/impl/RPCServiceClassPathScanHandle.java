package com.example.demoofcustomannotation.annotation.impl;

import com.example.demoofcustomannotation.annotation.MyRPC;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class RPCServiceClassPathScanHandle  extends ClassPathBeanDefinitionScanner {
    public RPCServiceClassPathScanHandle(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        //添加过滤条件
         addIncludeFilter(new AnnotationTypeFilter(MyRPC.class));
         Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        return beanDefinitionHolders;
    }
}
