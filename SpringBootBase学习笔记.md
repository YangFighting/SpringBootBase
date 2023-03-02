# 自动配置原理

@SpringBootApplication

```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
```

@Target



## @ComponentScan

参考来源：https://blog.csdn.net/winterking3/article/details/114699603

@ComponentScan用于类或者接口上，主要是指定扫描路径把带有指定注解的类注册到Spring容器中

@ComponentScan可以设置includeFilters和excludeFilters来自定义过滤器，excludeFilters表示包含过滤器

#### 不同type的含义

参考来源：https://blog.csdn.net/yerenyuan_pku/article/details/110239421

FilterType.ANNOTATION：按照注解来包含或者排除，classes用于指定包含或者排除注解

FilterType.ASSIGNABLE_TYPE：按照给定的类型进行包含或者排除,，classes用于指定类型，包含类(接口)或者其子类（实现类或子接口）

FilterType.ASPECTJ：按照ASPECTJ表达式进行包含或者排除

FilterType.REGEX：按照正则表达式进行包含或者排除

FilterType.CUSTOM，是自定义过滤，classes 指定的类要实现**TypeFilter**接口，实现TypeFilter接口时，需要实现该接口中的match()方法，match()方法的返回值为boolean类型。当返回true时，表示符合规则，会包含在Spring容器中；当返回false时，表示不符合规则。

```java
@ComponentScan(excludeFilters = {
  @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}), 
  @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})
})
```

上述注解的意思是，只扫描实现TypeExcludeFilter.class 和 AutoConfigurationExcludeFilter.class的类