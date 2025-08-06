## Java 平台的三大版本

* Java SE（Java Platform, Standard Edition, Java 平台标准版）
  * 是 Java ME、Java EE 的基础，可以用来开发一些小型桌面应用、游戏
  * Java 语言基础就属于 Java SE 的范畴，包含 Java 语言的基本功能和标准库，如集合框架、输入输出、网络编程等
* Java ME（Java Platform, Micro Edition, Java 平台微型版）
  * 主要应用在移动设备和嵌入式设备上，比如功能机时代的飞信等软件就是用 Java ME 开发的
* Java EE（Java Platform, Enterprise Edition, Java 平台企业版）
  * 主要用于企业级后台开发，比如电商网站、后台管理系统等的后台
  * 企业级后台开发就属于 Java EE 的范畴，包含 Servlet、JSP、EJB、JPA、分布式计算、事务管理、安全性、Web 服务等

我们现在学习主要就是学 Java SE 和 Java EE。

## JDK 和 Java 语言的各大版本
| JDK 版本  |     Java 语言版本     |   发布日期   |
|:-------:|:-----------------:|:--------:|
| JDK 1.0 |     Java 1.0      | 1996年5月  |
| JDK 1.1 |     Java 1.1      | 1997年2月  |
| JDK 1.2 | Java 2 (Java 1.2) | 1998年12月 |
| JDK 1.3 | Java 2 (Java 1.3) | 2000年5月  |
| JDK 1.4 | Java 2 (Java 1.4) | 2002年2月  |
|  JDK 5  | Java 5 (Java 1.5) | 2004年9月  |
|  JDK 6  | Java 6 (Java 1.6) | 2006年12月 |
|  JDK 7  | Java 7 (Java 1.7) | 2011年7月  |
|  JDK 8  | Java 8 (Java 1.8) | 2014年3月  |
|  JDK 9  |      Java 9       | 2017年9月  |
| JDK 10  |      Java 10      | 2018年3月  |
| JDK 11  |      Java 11      | 2018年9月  |
| JDK 12  |      Java 12      | 2019年3月  |
| JDK 13  |      Java 13      | 2019年9月  |
| JDK 14  |      Java 14      | 2020年3月  |
| JDK 15  |      Java 15      | 2020年9月  |
| JDK 16  |      Java 16      | 2021年3月  |
| JDK 17  |      Java 17      | 2021年9月  |
| JDK 18  |      Java 18      | 2022年3月  |
| JDK 19  |      Java 19      | 2022年9月  |
| JDK 20  |      Java 20      | 2023年3月  |
| JDK 21  |      Java 21      | 2023年9月  |

JDK 是 Java Development Kit 的缩写，意为 Java 开发工具包，它是用于开发 Java 应用程序的工具集，主要包含以下部分：

* Java 编译器（javac、Java Compiler）：用于将 Java 源代码编译成字节码
* Java 运行时环境（JRE、Java Runtime Environment）：提供运行 Java 应用程序所需的环境，包括 Java 虚拟机 (JVM)
* 工具：包括调试工具、文档生成工具等，帮助开发者进行开发和测试

JDK 就像 FlutterSDK 一样，是各自生态系统中的开发工具包，而 Java 语言就像 Dart 语言一样，是各自生态系统中的开发语言。
我们在安装 JDK 的时候会自动安装相应版本的 Java 语言 SDK，所以不需要再单独安装 Java 语言 SDK。

而且我们注意到从 JDK 5 和 Java 5 起，JDK 的版本和 Java 语言的版本命名就统一了，所以我们一般又将 JDK 的版本和 Java 语言的版本统称为 Java 版本。目前企业中应用最多的版本是 Java 8、Java 11、Java 17、Java 21，因为它们都是长期支持（LTS）版本。