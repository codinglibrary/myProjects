[toc]

常用命令

  > + 使用f{char}移动到char字符上，t移动到前一个字符。如果第一次没搜到可用分号（；）或逗号（，）继续搜索；F反过来搜索前面的char
  > + u 撤销undo,<C-r> redo
  > + zc 折叠，zC折叠所有嵌套；zo展开折叠，zO展开所有折叠
  > + !shell 执行外部命令
  > + \# 可以快速搜索本字符/单词
### 普通模式：
  + 快速移动
    + 跳到第n行在命令模式下执行
    + 数字+h/j/k/l 实现向左/下/上/右移动"数字"次
    + gi 快速回到最后一次编辑的位置，并切换到插入模式移动
    + w/e移到下一个word/WORD开头。e/E移到下一个word/WORD结尾
    + b/B上一个word/WORD开头，background
    + word指以非空白符分割的字符，WORD指以空白符分割的字符
    + 使用f{char}移动到char字符上，t移动到前一个字符。如果第一次没搜到可用分号（；）或逗号（，）继续搜索；F反过来搜索前面的char
    + 0和^移动到行首，$移动到行尾，g_移动到行尾非空白字符
    + （），{}在句子间、段落间移到
  + 页面移动
    + gg/G移动到文件开头和结尾，ctrl+快速返回
    + H/M/L跳转到屏幕的开头、中间、结尾
    + ctrl+u下翻页，zz将当前行显示在中间
  + 增删改查
    + 增：
      + 切换到插入模式i(insert),a(append),o(open in new line)，A（在行尾插入）I（在行首插入）O（在上一行插入）
      + gi 快速回到最后一次编辑的位置，并切换到插入模式
    + 删：
      + x/d，都**可以搭配数字**来执行多少次 
      + dw（删除单词：从光标到下个单词开始的范围内），diw（删除整个单词不包含空白字符），daw（delete around word，删除单词并包含它周围的空格）
      + dd 删除当前行
      + D删除当前行所有内容，只留下一个空行
      + dt+)   ：delete to )删除字符直到)
      + d0 删到下行行首
      + d$ 删到行尾
    + 改：
     + r（replace，更改一个char），c（change，配合文本对象进行快速修改），s（substitute，删除该字符并进入编辑模式，可以数字+s）
      + R（不断替换下一个字符），S（删除该行字符并进入编辑模式）
      + cw（删除该单词并插入），caw，ciw，ct+char
    + 查：
      + 使用/或？进行前向/反向搜索
      + 使用n/N跳转到下一个/上一个匹配
      + 使用*/#进行当前单词的前向/后向匹配zo
  + 文本对象 [number]<command>[text object]
    - number:次数    
    - command: d(delete),c(change),y(yank),v(view,可以以这种规则去选择单词、句子或段落)    
    - text object:w(word),s(sentence),p(paragraph)    
    - iw表示inner word,aw表示a word,它不但会选中当前单词，还会包含当前单词之后的空格。同理，is,as,ip,ap。
  + 复制粘贴
    - y(yank)、p(put)
    - yy 复制一行，yiw,yis,yip.
    

### 编辑模式

  + ctr l+h删除上一个字符
  + ctrl+w删除上一个单词
  + ctrl+u删除当前行
  + ctrl+t正行对齐（tab）


### 选择模式

+ 普通模式下按  v 、V、ctrl+v
+ 选中后按u/U 切换大小写

### 命令模式
+ e(edit) filename 打开文件
+ vs(vertical split)，:sp(split)  分屏 
+ set nu 显示行号 
+ :n 跳到第n行
+ reg 打开寄存器栏
+ :set autoindent 设置自动缩进(在编写代码时可以使用，但是粘贴python代码会有缩进错乱的问题)
+ :set paste,:set nopaste 解决上述问题
+ res 应该是reset,重置界面
+ % s/foo/bar/g （%：全部文件，s:替换，foo->bar，g:全局）全局替换
+ q 退出当前文件 
+ syntax on（语法标亮，应该需要插件）
+ set hls（highlight search） 将搜索内容高亮
+ set incsearch 增量搜索
+ 搜索替换 [range]s[ubstitute]/{pattern}/{string}/[flags]

    > range 表示范围，比如：10，20表示10-20行，%表示全部；    
    > pattern是要替换的模式    
    > string是替换后的文本    
    >
    > flags:     
    > + g(global)表示全局范围内执行    
    > + c(confirm)表示确认，可以确认或者拒绝修改    
    > + n(number)报告匹配到的次数而不替换，可以用来查询匹配次数    
+ set expandtab  此配置使得在Vim插入模式下按下 Tab 键时，输入到Vim中的都是空格    
+ 多文件操作    

    > - Buffer
    >   + :ls 列举当前缓冲区
    >   + :b n 跳转到第n个缓冲区
    >   + :bpre， :bnext， :bfirst， :blast
    >   + :b buffer_name 可以使用tab补全
    >
    >- Window：
    >   + 窗口切换
    >     + <Ctrl+w>w/W 在窗口间循环切换
    >     + <Ctrl+w>k/K 切换到上边的窗口
    >     + <Ctrl+w>j/J 切换到下边的窗口
    >     + <Ctrl+w>h/H 切换到左边的窗口
    >     + <Ctrl+w>l/L 切换到右边的窗口
    >
    >   - 重排窗口
    >     + <Ctrl+w>= 适应化所有窗口
    >     + <Ctrl+w>_ 最大化当前窗口的高度
    >     + <Ctrl+w>| 最大化当前窗口的宽度
    >     + [n]<Ctrl+w>_ 当前活动窗口的高度调整为n行
    >     + [n]<Ctrl+w>| 当前活动窗口的宽度调整为n列
    >
    > - Table
    >
    >   + tabnew tab_name 打开一个名为tab_name的新的标签页
    >   + gt 在标签页间切换
    >
    
+ VIM更换配色
  + :colorschme 显示当前主题配色
  + :colorscheme <Ctrl+d> 显示所有配色
  + :colorscheme 配色名  修改配色
  + 注意neovim的配置文件在init.vim下（vim的配置文件名字是vimrc）
+ 批量操作
  + VIM宏使用流程
    1. {command}:qa  //开始录制,并将动作记录到寄存器a中，a可以更改为a-z中的任意一个
    2. {normal}选择某一行进行操作
    3. {command}:q   //取消录制
    4. {view}选中需要执行该宏的行
    5. {command}:normal @a //执行宏
  + Normal命令批量操作
    1. 选中需要操作的行
    2. {command}:normal 命令集
       比如，normal A" ，这句话的意思就是在所选行的每行末尾添加双引号。

+ 补全方式
  + 自带补全命令
    | Command     | Description      |
    | ----------- | ---------------- |
    |\<C-n>       | 普通关键字       |
    |\<C-x>\<C-n> | 当前缓冲区关键字 |
    |\<C-x>\<C-i> | 包含文件关键字   |
    |\<C-x>\<C-]> | 标签文件关键字   |
    |\<C-x>\<C-k> | 字典查找         |
    |\<C-x>\<C-l> | 整行补全         |
    |\<C-x>\<C-f> | 文件名补全       |
    |\<C-x>\<C-o> | 全能补全         |

  + 常见类型
    + 补全单词：ctrl+n，ctrl+p
    + 补全文件名：ctrl+x ctrl+f
    + 代码补全：ctrl+x ctrl+o ，开启代码补全需要开启类型检查，安装插件




### vim进阶


重要命令
+ let $变量名="path"  给变量赋值，便于打开文件
+ echo $变量名 查看变量映射的地址（一些默认变量：$VIM,$HOME）
+ stdpath('config')配置文件的路径；stdpath('data')数据文件的路径；stdpat('cache')
+ scriptnames 查看加载时加载了那些vim脚本
+ source fileName 将该文件作为配置文件;source % ,Flush by current file

Important Knowledge

#### vim profile
If use Neovim,    
the profile should be set neovim/share/nvim/sysinit.vim .    

If use vim,
the profile should be set $HOME/.vim/vimrc .
#### vim map
Mode-specific maps    
+ Normal    
+ Visual    
+ Insert    
+ Command-line    
+ Operator pending        

Some arguments:     
> "nore":no recursive    

Some commands:    
> map    
> imap,nmap,vmap,xmap,omap    
#### vimscript
>  h options-list 查看可用命令    
>  推荐一本书《笨方法学VimScript》    
#### vim plugin
> 常见的插件管理器：**vim-plug**,Vundle,Pathogen,Deiv.Vim,volt    
> **vim-plug Commands:** Pluginstall,PlugStatus,PlugClean,PlugUpdate    

Good Plugins:    
> plug  "plugin manager"    
> airline    
> airline-theme    
> starify    
> molokai "a theme on vim"    
> nerdtree   
> markdown-preview
