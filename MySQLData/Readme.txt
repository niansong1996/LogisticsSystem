说明：为了大家方便同步数据库里面的数据，并且我方便改数据库的表，将数据库的同步方式介绍如下
1.打开MYSQL workbench
2.连接数据库，输入密码
3.左中下方有一个management，点一下
4.点击Data Import/Restore
5.目录选择该readme文件所在目录
6.确认左下方的lms被勾选上了，双击lms
7.点击start import
8.同步数据库成功

要将数据库同步至git，导出的方法如下：
完成上面操作1-3
4.点击Data Export
5.双击lms，确认右边的table都被选上了
6.目录设置为该readme文件所在目录
7.点击Start import
7.成功导出数据库