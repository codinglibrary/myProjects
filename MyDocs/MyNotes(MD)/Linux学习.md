[TOC]



## 安装nginx的bug记录及修复全过程

### bug
安装好nginx和php后，需要在nginx.conf中配置server语句块，但是该congf中不存在此句块。然后使用指令：grep -rn "server" * ,查到在avaliable/default下。

service

systemctl 

数据库名：welcome   
数据库用户名：qingjiu   
数据库密码：L\*\*\*\*\*\*\*.   
数据库主机：localhost(47.97.\*\*\*.\*\*)    
数据库表前缀：wl\* 

### bug1
期间发生生了一个难以解决的问题，耽误了我进三个小时：
能够进入网站，但是必须手动在后面添加index.php才能进去。

原因是sites-enabled/default中的配置问题，具体哪一个不清楚，但反复修改四五遍。

然后修改次数太多，多次service nginx reload ，导致必须重启服务才能OK。

期间修改default的时候无意间把主机地址改掉了，许久没有发现，也是一个重要原因。
其次，进入网站后有许多问题，我重新安装了wordpress，换了个全英的，不要汉化的。

### bug2
背景：
> 先前安装php和mysql的时候没有考虑版本问题，所以安装的是php7.1，后来想安装某个插件，提示需要php7.4以上，于是安装了php8.0。

问题：
> 安装php8.0之后发现，php连接不上数据库了，报错显示找不到mysql扩展。最初的想法是安装php8.0后ini中的内容没有修改（觉得php7.1和mysql先后安装的时候，mysql会将php.ini自动修改。自己重新安装php8.0后ini没办法自动修改，所以觉得是ini配置的问题，我真傻）。

解决路线：
> 原先是各种该ini，再reload nginx ，service ** restart。丝毫没有逻辑，想一出是一出。后来冷静下来，查看一下php7.1的ini配置，发现和php8.1的ini是一摸一样的（就是extension=mysqli这一行都被注释掉了）。所以，认为连接mysqli不是通过ini来实现的。后来，发现了一个指令
“apt install php-mysql”。重新安装了php-install，安装的时候注意到有8.0等字样，成功。

## ftp服务器相关
### 匿名服务anonymous   

[ftp常见报错之Use PORT or PASV first解决思路和方法](
http://www.east263.com/news/server/FTPServer/2019-10-23/1964.html)

[vsftpd 常用功能参数配置及参数详解](https://www.cnblogs.com/halberd-lee/p/11734363.html)

## 常用命令
### 新机器、新环境
#### 安装和卸载软件

[Linux系统基础-在Linux上安装软件的3种方式](https://dlonng.com/posts/linux-install-soft)      
    
    通过apt-get安装，常用命令：
    sudo apt-get update:从网上的源更新安装包信息  
    sudo apt-get upgrade:升级软件包到最新版本     
    sudo apt-get -f install：修复软件依赖包的关系     
    sudo apt-get install software_name     
    sudo apt-get remove software_name：卸载软件，卸载不完全     
    sudo apt-get remove --purge software：常用卸载方式，卸载完全   

#### 更改主机名      

    vi /etc/hostname
    reboot

#### 如果是第一次安装系统需要更新apt   

    apt update

#### 安装PPA

    apt-get install software-properties-common

#### 安装neovim

    sudo apt neovim

#### 更改admin用户密码为123456

    sudo passwd admin
    123456
    123456

#### 从windows编辑的sysinit.vim文件要注意使用下面这个语句更改一下

    :w ++ff=unix

#### 文件夹内容批量移动

    cp -r config/config/. config/

#### 更改命令行样式

    nvim ~/.bashrc

### 压缩包命令

#### .tar

    解包：tar xvf FileName.tar    
    打包：tar cvf FileName.tar DirName    
（注：tar是打包，不是压缩！）

#### .gz

    解压1：gunzip FileName.gz     
    解压2：gzip -d FileName.gz    
    压缩：gzip FileName   

#### .tar.gz 和 .tgz

    解压：tar zxvf FileName.tar.gz        
    压缩：tar zcvf FileName.tar.gz DirName    

### 查看端口占用情况
#### lsof(list open files)
是一个列出当前系统打开文件的工具。

lsof 查看端口占用语法格式：

	lsof -i:端口号
更多 lsof 的命令如下：

	lsof -i:8080：查看8080端口占用
	lsof abc.txt：显示开启文件abc.txt的进程 
	lsof -c abc：显示abc进程现在打开的文件
	lsof -c -p 1234：列出进程号为1234的进程所打开的文件 
	lsof -g gid：显示归属gid的进程情况 
	lsof +d /usr/local/：显示目录下被进程开启的文件 
	lsof +D /usr/local/：同上，但是会搜索目录下的目录，时间较长 
	lsof -d 4：显示使用fd为4的进程 
	lsof -i -U：显示所有打开的端口和UNIX domain文件

#### netstat
netstat -tunlp  用于显示 tcp，udp 的端口和进程等相关情况。

netstat 查看端口占用语法格式：

	netstat -tunlp | grep 端口号

-   -t (tcp) 仅显示tcp相关选项
-   -u (udp)仅显示udp相关选项
-   -n 拒绝显示别名，能显示数字的全部转化为数字
-   -l 仅列出在Listen(监听)的服务状态
-   -p 显示建立相关链接的程序名
	更多命令：

		netstat -ntlp //查看当前所有tcp端口 
		netstat -ntulp | grep 80  //查看所有80端口使用情况 
		netstat -ntulp | grep 3306  //查看所有3306端口使用情况

#### kill 
在查到端口占用的进程后，如果你要杀掉对应的进程可以使用 kill 命令：

	kill -9 PID

