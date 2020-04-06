# Spring Boot Source

## 总流程

1. 实例化SpringBootApplication
   1. 注册ApplicationContextInitializer
   2. 注册ApplicationListener
2. 通过EventPublishingRunListener发布ApplicationStartingEvent事件
3. 初始化环境信息
4. 通过EventPublishingRunListener发布ApplicationEnvironmentPreparedEvent事件
5. 实例化ApplicationContext
6. 执行ApplicationContextInitializer
7. 通过EventPublishingRunListener发布ApplicationContextInitializedEvent事件
8. 通过EventPublishingRunListener发布ApplicationPreparedEvent事件
9. 上下文刷新
10. 通过EventPublishingRunListener委派上下文发布ApplicationStartedEvent事件
11. 通过EventPublishingRunListener委派上下文发布ApplicationReadyEvent事件

## 组件

LoggingApplicationListener

日志初始化

DelegatingApplicationListener

执行context.listener.classes配置的ApplicationEnvironmentPreparedEvent监听

ConfigFileApplicationListener

执行EnvironmentPostProcessor和添加PropertySourceOrderingPostProcessor

ConfigurationWarningsApplicationContextInitializer

添加ConfigurationWarningsPostProcessor

DelegatingApplicationContextInitializer

执行环境context.initializer.classes配置的Initializer

AutoConfigurationImportSelector

添加EnableAutoConfiguration

```
ConditionalOnWebApplication
```

@Qualifier

AnnotationConfigUtils

解析Annotation，processCommonDefinitionAnnotations解析Lazy，Primary，DependsOn，Role，Description

AnnotationScopeMetadataResolver

解析@Scope

ConfigurationClassBeanDefinition

@Bean映射



ConfigurationPropertiesBindingPostProcessor

ConfigurationPropertiesBeanDefinitionValidator

ConfigurationBeanFactoryMetadata

ImportAwareBeanPostProcessor

## 事件顺序

1. SpringApplicationEvent
   1. ApplicationStartingEvent
   2. ApplicationEnvironmentPreparedEvent
      1. 执行EnvironmentPostProcessor#postProcessEnvironment
   3. ApplicationContextInitializedEvent
   4. ApplicationPreparedEvent
      1. 执行ApplicationContextAware#setApplicationContext
      2. 上下文添加监听
   5. ApplicationStartedEvent
   6. ApplicationReadyEvent

## 解析ConfigClass

1. ConfigurationClassPostProcessor找到所有@Configuration并进行排序
2. ConfigurationClassParser解析@Configuration
   1. 解析@Conditional判断会否需要注入
   2. 递归解析@Configuration
      1. @Component注解-》递归解析内部@Configuration类
      2. 解析@PropertySources
      3. 解析@ComponentScan，委派ComponentScanAnnotationParser注册BeanDefinition
      4. 解析@Import
         1. ImportSelector 递归解析Import
         2. DeferredImportSelector  设置deferredImportSelectorHandler
         3. ImportBeanDefinitionRegistrar  设置当前ConfigClass
         4. @Configuration 递归解析
      5. 解析@ImportResources
      6. 解析@Bean
      7. 解析接口
      8. 查找父类，直到没有父类为止
   3. 执行DeferredImportSelector#process
   4. ConfigurationClassBeanDefinitionReader注册BeanDefinition
      1. 注册Import
      2. 注册Bean
      3. 注册ImportResources
      4. 注册Regsitar

## 注册BeanDefinition

1. 注册被导入的ConfigClass
2. 注册ConfigClass中的@Bean
3. 注册@ImportResource的BeanDefinition，即XML
4. 注册@Import导入的ImportBeanDefinitionRegistrar