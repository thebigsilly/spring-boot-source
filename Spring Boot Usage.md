# Spring Boot Usage

## 配置修改

### 定制配置

```java
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }
}
```

### 扩展配置

```java
@Configuration
public class ModifyDefaultBeanConfig extends WebMvcConfigurationSupport {

    @Override
    public CompositeUriComponentsContributor mvcUriComponentsContributor(FormattingConversionService conversionService, RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        return super.mvcUriComponentsContributor(conversionService, requestMappingHandlerAdapter);
    }
```

## 注解

1. @Import

   导入配置类

   可使用4类：@Configuration注解，ImportSelector，DeferredImportSelector，ImportBeanDefinitionRegistrar

2. @ConfigurationProperties

   注释配置文件

3. @EnableConfigurationProperties

   在xxxAutoConfiguration使用，用来注入@ConfigurationProperties

4. @AutoConfigureBefore

   标记在xxxAutoConfiguration配置之后实例化

5. @ConditionalOnClass

   标记在存在某个Java类时生效，使用的Condition为OnClassCondition

6. @ConditionalOnProperty

   标记当存在某个属性时生效，使用的Condition为OnPropertyCondition

7. @ConditionalOnMissingBean

   如果存在Bean则不生成，使用Condition为OnBeanCondition

8. @ConditionalOnMissingClass

9. @ConditionalOnBean

10. @ConditionalOnExpression

11. @ConditionalOnNotWebApplication

12. @ConditionalOnWebApplication