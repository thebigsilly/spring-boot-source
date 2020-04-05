# Spring Boot Source

## 解析

1. ConfigurationClassPostProcessor

   查找@Configuration

2. ConfigurationClassParser

   解析@Configuration

3. ConditionalEvaluator

   解析@Conditional

4. 

### 文本流程

1. ConfigurationClassPostProcessor找到所有Configuration并进行排序
2. ConfigurationClassParser解析@Configuration
   1. 解析@Conditional判断会否需要注入
   2. 递归解析@Configuration
      1. 递归解析内部@Configuration
      2. 解析@PropertySources
      3. 解析@ComponentScan
      4. 解析@Import
      5. 解析@ImportResources
      6. 解析@Bean
      7. 解析接口
      8. 解析父类，直到没有父类为止
   3. ConfigurationClassBeanDefinitionReader注册BeanDefinition
      1. 注册Import
      2. 注册Bean
      3. 注册ImportResources
      4. 注册Regsitar