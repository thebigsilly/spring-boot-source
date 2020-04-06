package com.fyh.springbootsource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class ModifyDefaultBeanConfig extends WebMvcConfigurationSupport {

    @Override
    public CompositeUriComponentsContributor mvcUriComponentsContributor(FormattingConversionService conversionService, RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        return super.mvcUriComponentsContributor(conversionService, requestMappingHandlerAdapter);
    }
}
