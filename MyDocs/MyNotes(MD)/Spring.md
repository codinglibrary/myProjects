## 一、理论知识——《Spring技术内幕》
### 1. 什么是Spring？

    Spring核心特性：
        IoC（Inversion of Control）
        DI（Dependency Injection）
        AOP（Aspect Oritented Programming）    
    
    Spring核心部件：MVC容器（Spring的Web框架）,DAO提供一些对数据持久化的支持    
    
    Spring Boot：提供自动配置等特性    

#### 1.1. Spring架构   

+ Data Access/Integration    
+ Web    
+ Aspects    
+ Instrumentation    
+ Core Container    
    > Beans   
    > Aspects    
    > Context    
    > SpEL    
+ Test    

#### 1.2. 两类IOC容器

+ BeanFactory

      主要负责初始化各种Bean，并调用它们的生命周期方法
    > 最常用的实现类
    > + XmlBeanFactory

+ ApplicationContext    
  
      继承了BeanFactory接口，增加了很多企业级功能    

    > 两个常用的实现类    
    > 
    > + ClassPathXmlApplicationContext
    > + FileSystemXmlApplicationContext

#### 1.3. SpringBean
    Bean定义可以包含很多配置信息，包括构造函数参数、属性值和容器一些具体信息(初始化函数)
##### 1.3.1.Spring配置文件的两种格式    

> Properties:key-value形式存在    
> XML:树形结构    

##### 1.3.2. \<bean>元素的常用属性    
|属性名称	|描述    |
|---|---|
id	|Bean 的唯一标识符，Spring 容器对 Bean 的配置和管理都通过该属性完成。id 的值必须以字母开始，可以使用字母、数字、下划线等符号。
name	|name 属性中可以为 Bean 指定多个名称，每个名称之间用逗号或分号隔开。Spring 容器可以通过 name 属性配置和管理容器中的 Bean。
class	|该属性指定了 Bean 的具体实现类，它必须是一个完整的类名，即类的全限定名。
**scope** 	|**用于设定 Bean 实例的作用域，属性值可以为 singleton（单例）、prototype（原型）、request、session 和 global Session。其默认值是 singleton**
constructor-arg	|\<bean>元素的子元素，可以使用此元素传入构造参数进行实例化。该元素的 index 属性指定构造参数的序号（从 0 开始），type 属性指定构造参数的类型
property  |\<bean>元素的子元素，用于调用 Bean 实例中的 setter 方法来属性赋值，从而完成依赖注入。该元素的 name 属性用于指定 Bean 实例中相应的属性名
ref	|\<property> 和 \<constructor-arg> 等元素的子元素，该元素中的 bean 属性用于指定对某个 Bean 实例的引用
value	|\<property> 和 \<constractor-arg> 等元素的子元素，用于直接指定一个常量值
list	|用于封装 List 或数组类型的依赖注入
set	|用于封装 Set 类型的依赖注入
map	|用于封装 Map 类型的依赖注入
entry	|\<map> 元素的子元素，用于设置一个键值对。其 key 属性指定字符串类型的键值，ref 或 value 子元素指定其值
init-method	|容器加载 Bean 时调用该方法，类似于 Servlet 中的 init() 方法
destroy-method	|容器删除 Bean 时调用该方法，类似于 Servlet 中的 destroy() 方法。该方法只在 scope=singleton 时有效
lazy-init	|懒加载，值为 true，容器在首次请求时才会创建 Bean 实例；值为 false，容器在启动时创建 Bean 实例。该方法只在 scope=singleton 时有效

##### 1.3.3. Bean的生命周期    

    Spring 中 Bean 的生命周期较复杂，可以表示为：
        Bean 的定义 -> Bean 的初始化 -> Bean 的使用 -> Bean 的销毁

![](https://gitee.com/green-wine/myProjects/raw/master/MyDocs/drawio/SpringBean%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.svg)

了解 Spring 生命周期的意义就在于，可以利用 Bean 在其存活期间的指定时刻完成一些相关操作。一般情况下，会在 Bean 被初始化后和被销毁前执行一些相关操作。    

Spring 官方提供了 3 种方法实现初始化回调和销毁回调：    
> 实现 InitializingBean 和 DisposableBean 接口    
> 在 XML 中配置 init-method 和 destory-method    
> 使用 @PostConstruct 和 @PreDestory 注解    

在一个 Bean 中有多种生命周期回调方法时，优先级为：注解 > 接口 > XML。    
    
    不建议使用接口和注解，这会让 pojo 类和 Spring 框架紧耦合。    


##### 1.3.4. BeanPostProcessor(Spring后置处理器)      
> postProcessBeforeInitialization 在 Bean 实例化、依赖注入后，初始化前调用。    
>
> postProcessAfterInitialization 在 Bean 实例化、依赖注入、初始化都完成后调用。

###### 1.3.5. Bean继承
需要注意的是，Spring Bean 定义的继承与 Java 中的继承无关。您可以将父 Bean 的定义作为一个模板，其它子 Bean 从父 Bean 中继承所需的配置。       

在配置文件中通过 parent 属性来指定继承的父 Bean。

+ Bean模板    
可以创建一个 Bean 定义模板，该模板只能被继承，不能被实例化。创建 Bean 定义模板时，不用指定 class 属性，而是指定 abstarct="true" 将该 Bean 定义为抽象 Bean,如：

```xml
<bean id="beanTeamplate" abstract="true">
        <property name="message" value="Hello World!" />
</bean>
```

##### 1.4. 依赖注入和控制反转
Spring 依赖注入（Dependency Injection，DI）和控制反转含义相同，它们是从两个角度描述的同一个概念。使用依赖注入可以更轻松的管理和测试应用程序。

当某个 Java 实例需要另一个 Java 实例时，传统的方法是由调用者创建被调用者的实例（例如，使用 new 关键字获得被调用者实例），而使用 Spring 框架后，被调用者的实例不再由调用者创建，而是由 Spring 容器创建，这称为控制反转。

Spring 容器在创建被调用者的实例时，会自动将调用者需要的对象实例注入给调用者，调用者通过 Spring 容器获得被调用者实例，这称为依赖注入。    

###### 1.4.1. 依赖注入的实现方式
+ 构造函数注入   
+ setter注入    

> 在 Spring 实例化 Bean 的过程中，首先会调用默认的构造方法实例化 Bean 对象，然后通过 Java 的反射机制调用 setXxx() 方法进行属性的注入。因此，setter 注入要求 Bean 的对应类必须满足以下两点要求。
> + 必须提供一个默认的无参构造方法。
> + 必须为需要注入的属性提供对应的 setter 方法。
> 
> 使用 setter 注入时，在 Spring 配置文件中，需要使用 <bean> 元素的子元素 <property> 为每个属性注入值。而使用构造注入时，在配置文件中，主要使用 <constructor-arg> 标签定义构造方法的参数，使用其 value 属性（或子元素）设置该参数的值。

---
## 二、简易项目实操——TacoCloud  

使用Spring Tool Suite创建一个简单的Spring程序TacoCloud。    

##### 2.1. 开发环境    

Spring Web程序的项目根目录下pom.xml文件时Maven构建工具的配置文件，声明了依赖项和不同工程之间的继承关系。文件目录中，src/main存储代码文件及其所需的资源文件，src/test存储的是测试文件。    

##### 2.2. 流程    
> (1) 新建项目后通过Spring Initializr生成Spring项目结构的骨架，构建工具使用Maven，编程语言选择Java(Groovy也可以)。并添加项目依赖项：DevTools(开发工具)、Thymeleaf(Web模板引擎)、Web。    
> 
> (2) TacoCloudApplication.java用来引导项目，含有main函数入口。需要编写两个文件：一个是业务处理文件HomeController.java，位置在main/java下，；另一个是Web页面排版文件home.html，放置在resources/templates下，该文件用到的静态资源(比如图片、GIF)放在resources/static下。    
> 
> (3) 【未解决】除此之外还需要编写测试文件，放置在src/test/java目录下    
> 
> (4) 编辑好后(STS会自动编译)，可通过BootDash启动项目。        

#### 参考链接

[Spring框架入门教程](http://c.biancheng.net/spring/)

## 三、Spring入门项目实践笔记——Spring-guides

```java
使用Maven构建工程
```

### 1. 前言

Maven目录结构，如图：

![](https://gitee.com/green-wine/myProjects/raw/master/MyDocs/drawio/Maven项目目录结构.svg)

### 2. org.springframework.stereotype

#### @Component

`@Component` is an annotation that allows Spring to automatically detect our custom beans.

In other words, without having to write any explicit code, Spring will:

- Scan our application for classes annotated with`@Component`
- Instantiate them and inject any specified dependencies into them
- Inject them wherever needed

`@Component` doesn't do anything unless it can be found by `@ComponentScan`.

`@Component`vs `@Bean`: 

`@Bean` is also an annotation that Spring uses to gather beans at runtime, but it's not used at the class level. Instead, we annotate methods with `@Bean` so that Spring can store the method's result as a Spring bean.

#### @Controller

The  class is annotated with `@Controller` so that Spring MVC can pick it up and look for routes. 

#### @Service

#### @Repository

#### @Indexed

### 3. 关键注解

#### @SpringBootApplication

`@SpringBootApplication` is a convenience annotation that adds all of the following:

- `@Configuration`: Tags the class as a source of bean definitions for the application context.
- `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if `spring-webmvc` is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`.
- `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `com/example` package, letting it find the controllers.

The `main()` method uses Spring Boot’s `SpringApplication.run()` method to launch an application.

The `@SpringBootApplication` annotation provides a load of defaults (like the embedded servlet container), depending on the contents of your classpath and other things. It also turns on Spring MVC’s `@EnableWebMvc` annotation, which activates web endpoints.

#### @RestController

The class is marked up with `@RestController` so that Spring MVC can autodetect the controller (by using its built-in scanning features) and automatically configure the necessary web routes.

`@RestController` also tells Spring MVC to write the text directly into the HTTP response body, because there are no views. Instead, when you visit the page, you get a simple message in the browser

#### @Bean

`@Bean` is a method-level annotation and a direct analog of the XML `<bean/>` element. The annotation supports most of the attributes offered by `<bean/>`, such as: `init-method`, `destroy-method`, `autowiring`, `lazy-init`, `dependency-check`, `depends-on` and `scope`.

#### @Autowired

It allows Spring to resolve and inject collaborating beans into our bean.

The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring.

After enabling annotation injection, **we can use autowiring on properties, setters, and constructors**.

Otherwise, if there are two concrete implementations of *Formatter* available for the Spring container,Spring will throw a \*NoUniqueBeanDefinitionException\* exception. we can use the `@Qualifier` annotation to indicate the required bean.

**Spring uses the bean's name as a default qualifier value.** It will inspect the container and look for a bean with the exact name as the property to autowire it.

#### @RequestMapping

The `@RequestMapping` annotation ensures that HTTP requests to `path` are mapped to the `method()` method.

##### @GetMapping

The method is tagged with `@GetMapping` or `@PostMapping` to tie the path and the HTTP action to a particular controller action.

##### @PostMapping

The method is tagged with `@GetMapping` or `@PostMapping` to tie the path and the HTTP action to a particular controller action.

##### @RequestBody

##### @RequestParam

`@RequestParam` binds the value of the query string parameter `name` into the `name` parameter of the `greeting()` method. This query string parameter is implicitly not `required` because of the use of the `defaultValue` attribute. If it is absent in the request, the `defaultValue` of `World` is used.

##### @RequestAttribute

#### @ReponseBody

`@ResponseBody`Annotation that indicates a method return value should be bound to the web response body. Supported for annotated handler methods.As of version 4.0 this annotation can also be added on the type level in which case it is inherited and does not need to be added on the method level.

The `@ResponseBody`annotation tells Spring MVC not to render a model into a view but, rather, to write the returned object into the response body. It does so by using one of Spring’s message converters. Because Jackson 2 is in the classpath, [`MappingJackson2HttpMessageConverter`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/json/MappingJackson2HttpMessageConverter.html) will handle the conversion of a `Greeting` object to JSON if the request’s `Accept` header specifies that JSON should be returned.

#### @ConfigurationProperties

#### @EnableConfigurationProperties

#### @Entity

The `className` class is annotated with `@Entity`, indicating that it is a JPA entity. (Because no `@Table` annotation exists, it is assumed that this entity is mapped to a table named `className`.)

### 4. 关键接口

#### > ApplicationContext

The `org.springframework.context.ApplicationContext` interface represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans. 

[`ApplicationContext`](https://docs.spring.io/spring-framework/docs/5.3.15/javadoc-api/org/springframework/context/ApplicationContext.html) is a sub-interface of `BeanFactory`. It adds:

- Easier integration with Spring’s AOP features
- Message resource handling (for use in internationalization)
- Event publication
- Application-layer specific contexts such as the `WebApplicationContext` for use in web applications.

#### > CommandLineRunner、ApplicationRunner

If you need to run some specific code once the `SpringApplication` has started, you can implement the `ApplicationRunner` or `CommandLineRunner` interfaces. Both interfaces work in the same way and offer a single `run` method, which is called just before `SpringApplication.run(…)` completes.

### 四、Spring 框架——Reference Document 学习笔记

#### [Spring Framework Documentation5.3.15](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/index.html)

##### 1. [Spring Framework Overview](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/overview.html#overview)

history, design philosophy, feedback, getting started.

##### 2. [Core Technologies](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#spring-core)

IoC Container, Events, Resources, i18n, Validation, Data Binding, Type Conversion, SpEL, AOP.

###### 2.1. [IOC Container](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#beans)

![ContainerOverview](https://gitee.com/green-wine/myProjects/raw/master/MyDocs/drawio/ContainerOverview.svg)

Bean的定义：

| Property                 | Explained in…                                                |
| :----------------------- | :----------------------------------------------------------- |
| Class                    | [Instantiating Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-class) |
| Name                     | [Naming Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-beanname) |
| Scope                    | [Bean Scopes](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes) |
| Constructor arguments    | [Dependency Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-collaborators) |
| Properties               | [Dependency Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-collaborators) |
| Autowiring mode          | [Autowiring Collaborators](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-autowire) |
| Lazy initialization mode | [Lazy-initialized Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lazy-init) |
| Initialization method    | [Initialization Callbacks](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle-initializingbean) |
| Destruction method       | [Destruction Callbacks](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle-disposablebean) |

###### 2.2. [Resources](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#resources)

###### 2.3. [Validation, Data Binding, and Type Conversion](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#validation)

###### 2.4. [Spring Expression Language (SpEL)](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#expressions)

###### 2.5. [Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#aop)

###### 2.6. [Spring AOP APIs](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#aop-api)

###### 2.7. [Null-safety](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#null-safety)

###### 2.8. [Data Buffers and Codecs](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#databuffers)

###### 2.9. [Logging](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#spring-jcl)

###### 2.10. [Appendix](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/core.html#appendix)

##### 3. [Testing](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/testing.html)

Mock Objects, TestContext Framework, Spring MVC Test, WebTestClient.

##### 4. [Data Access](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/data-access.html#spring-data-tier)

Transactions, DAO Support, JDBC, R2DBC, O/R Mapping, XML Marshalling.

##### 5. [Web on Servlet Stack](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/web.html#spring-web)

Spring MVC, WebSocket, SockJS, STOMP Messaging.

##### 6. [Web on Reactive Stack](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/web-reactive.html#spring-webflux)

Spring WebFlux, WebClient, WebSocket, RSocket.

##### 7. [Integration](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/integration.html#spring-integration)

Remoting, JMS, JCA, JMX, Email, Tasks, Scheduling, Caching.

##### 8. [Language Support](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/languages.html#languages)

Kotlin, Groovy, Dynamic Languages.

##### 9. [Appendix](https://docs.spring.io/spring-framework/docs/5.3.15/reference/html/appendix.html#appendix)

Spring properties.
