### Java 基础

#### 元数据

<u>关于Unicode字符，</u>

Unicode escape sequences may be used elsewhere in a program (such as in field names, for example), not just in `char` or `String` literals.

<u>关于转义字符，</u>

The Java programming language supports a few special escape sequences for `char` and `String` literals: `\b` (backspace), `\t` (tab), `\n` (line feed), `\f` (form feed), `\r` (carriage return), `\"` (double quote), `\'` (single quote), and `\\` (backslash).

#### 数组

<u>Java中的数组拷贝，</u>

The [`System`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/System.html) class has an [`arraycopy()`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/System.html#arraycopy(java.lang.Object,int,java.lang.Object,int,i)) method that you can use to efficiently copy data from one array into another:

```java
public static void arraycopy(Object src, int srcPos,
                             Object dest, int destPos, int length)
```

The two `Object` arguments specify the array to copy from and the array to copy to. The three `int` arguments specify the starting position in the source array, the starting position in the destination array, and the number of array elements to copy.

数组操作，



### Java注解

详情参见官方文档《[Annotations](https://dev.java/learn/annotations/)》。文档包括以下内容：

简介，注解的使用格式，注解的使用位置（classes, fields, methods, and other program elements），如何声明一个注解类型，预定义的注解类型（the Java Language，Other Annotations），注解的重复使用，Type Annotations and Pluggable Type Systems。

