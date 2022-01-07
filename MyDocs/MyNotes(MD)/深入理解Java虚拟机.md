    说明：
    本笔记主要记录分析了Java技术体系中那些最基础、最重要特性的实现原理。
    使用的是周志华教授编著的《深入理解Java虚拟机》。    
    ©qingjiu

[TOC]

## 第一部分 走进Java

### 1. 走进Java

#### 1.1 概述

Java是一个由一系列计算机软件和规范组成的技术体系。    

Java的优点：    
+ 结构严谨、面向对象
+ 摆脱了硬件平台的束缚，实现“一次编写，到处运行”
+ 提供了一种相对安全的内存管理和访问机制，避免了绝大多数的内存泄漏和指针越界的问题
+ 实现了热点代码检测和运行时编译及优化
+ 有一套完善的应用程序接口，及无数第三方类库帮助用户实现各种功能
  
> **【灵感】    
> 作为一名Java程序员，在编写程序时除了尽情发挥Java各种优势外，还会情不自禁地想去了解和思考Java技术体系中这些优秀的技术特性是如何出现及怎样实现的，认识这些技术运行的本质。**

#### 1.2 Java技术体系

按各个组成部分的功能来划分，包含以下几部分：    
+ Java程序设计语言
+ 各种硬件平台上的Java虚拟机实现
+ 【❓】Class文件格式
+ 【❓】Java类库API
+ 来自商业机构和开源社区的第三方Java类库    

按照技术关注的重点业务划分：
+ Java Card    
+ Java ME（Micro Edition）
+ Java SE
+ Java EE
#### 1.3 Java发展史

#### 1.4 Java虚拟机家族
##### 1.4.1 虚拟机始祖：Sun Classic/Exact VM

##### 1.4.2 武林盟主：HotSpot VM

##### 1.4.3 小家碧玉：Mobile/Embedded VM

##### 1.4.4 天下第二：BEA JRockit/IBM J9 VM

##### 1.4.5 软硬合璧：BEA Liquid VM/Azul VM

##### 1.4.6 挑战者：Apache Harmony/Google Android Dalvik VM

##### 1.4.7 没有成功，但并非失败：Microsoft JM及其他

##### 1.4.8 百家争鸣

#### 1.5 展望Java技术的未来
##### 1.5.1 无语言倾向

##### 1.5.2 新一代即时编译器

##### 1.5.3 向Native迈进

##### 1.5.4 灵活的胖子

##### 1.5.5 语言语法持续增强

#### 1.6 实战：自己编译JDK
##### 1.6.1 获取源码

##### 1.6.2 系统需求

##### 1.6.3 构建编译环境

##### 1.6.4 进行编译

##### 1.6.5 在IDE工具中进行源码调试


    1th Chapter is over.
    ©qingjiu

## 第二部分 自动内存管理

### 2. Java内存区域与内存溢出异常

    2th Chapter is over.
    ©qingjiu

### 3. 垃圾收集器与内存分配策略


    3th Chapter is over.
    ©qingjiu
### 4. 虚拟机性能监控、故障处理工具


    4th Chapter is over.
    ©qingjiu
### 5. 调优案例分析与实战


    5th Chapter is over.
    ©qingjiu

## 第三部分 虚拟机执行子系统
### 6. 类文件结构

    6th Chapter is over.
    ©qingjiu
### 7. 虚拟机类加载机制

    7th Chapter is over.
    ©qingjiu
### 8. 虚拟机字节码执行引擎

    8th Chapter is over.
    ©qingjiu
### 9. 类加载及执行子系统的案例与实战

    9th Chapter is over.
    ©qingjiu
## 第四部分 程序编译与代码优化

### 10. 前端编译与优化

    10th Chapter is over.
    ©qingjiu
### 11. 后端编译与优化

    11th Chapter is over.
    ©qingjiu
## 第五部分 高效并发
### 12. Java内存模型与线程

    12th Chapter is over.
    ©qingjiu
### 13. 线程安全与锁优化

    13th Chapter is over.
    ©qingjiu

