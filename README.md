# Dismtools

## Description
A simple GUI tool based-on Dism command
(For testing)

一个简单的基于DISM命令的GUI实现
(仅供测试)

## Demo
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/7b46e740-a5e7-40c5-aa3b-c63475a65e03)
get-imageinfo

## Properties

### 实现方式总结
在GUI上，每个窗体类大同小异，即利用以上提到的类为各自的命令指定参数与选项；但在执行上都是基于DISM程序自身的不同功能，由GUI方式来操作以上类提供不同的参数与选项。

### 功能展示
该程序拥有.wim等映像文件的挂载、卸载、查看相关信息、释放以及为适用于相关需求而拓展的对操作系统的简单扫描、修复等操作。

#### 查看映像
在主窗体内点击“查看映像信息”按钮打开相关窗体后再点击“查看映像”，通过JFileChooer类实现以对话框方式要求用户指定映像文件，仅限路径+文件整体，而后将文件路径显示到不可编辑的文本框内以便查看。然后输入下方文本框以指定映像序号，点击一次“设置映像序号”即可赋值于映像序号变量Index并锁定文本框为不可用以表示设置完成，再点击一次即解锁。复选框为设置是否查看该映像的所有序号（即索引），若选中即表示输出所有序号的简略信息，并禁用左侧文本框和按钮，否则表示输出指定序号的详细信息，并重新启用被禁用的文本框和按钮。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/b7267b1d-9577-4147-a710-06fc08b7f6c6)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/f1b369b3-d0d5-4738-a531-2b9ae258ebdb)

 
#### 挂载映像
##### 挂载映像操作
在主窗体内点击“查看映像信息”按钮打开相关窗体，同样以对话框方式要求用户指定映像文件，仅限路径+文件整体，而后同样的将文件路径显示到不可编辑的文本框内以便查看。设置挂载路径同理，但仅限路径部分。然后输入下方文本框以指定映像序号，点击一次“设置映像序号”即可赋值并锁定文本框。“只读”复选框为设置只读挂载，一旦选中则挂载后任何对挂载路径的操作都不可写入/更改映像文件。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/3b1aa056-c97d-48d0-bea9-528041f9f444)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/525d5bd7-09ef-422b-a0a8-24517b501096)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/dba69a5a-b60c-47eb-9692-8486c68a1d4d)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/a8489813-e13f-4100-b318-316e1b4d2c98)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/08c601df-d2ef-414c-a71b-c4d094fe1058)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/bee1ba21-9b36-413c-9bd7-01161daf88fe)



##### 查看已挂载的映像
挂载后，即可在主窗体的“查看映像信息”选项内点击“查看已挂载的映像”按钮即可查看当前已挂载映像的相关信息
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/6623617f-c735-4d1d-8b1b-f208e7b8a0aa)




#### 卸载映像
（因此前挂载的映像为只读，因此无法先进行保存操作，只能先卸载后保存）
在主窗体点击“卸载映像”打开相关窗体，卸载映像不同于挂载映像，仅需指定挂载路径即可。同时也有保存功能，可通过复选框指定，但是，只读挂载映像同样无法通过此方法保存。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/fa990cb3-31c1-4e78-ab43-b16f6fe43989)
 
 

#### 保存映像
在主窗体点击“保存映像”打开相关窗体，跟“卸载映像”同样，仅需指定挂载路径即可。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/44686132-5e62-4cff-b651-bc2fe4792115)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/e9c8e2b1-d2c5-4ddc-8918-6ed1094deb89)


 

#### 使用映像简单修复
利用DISM自带的修复功能，即可修复当前操作系统的部分异常。
在主窗体点击“简单修复”打开相关窗体，而后以勾选复选框形式指定联机映像或手动指定脱机映像路径的形式修复当前系统的部分异常，若要进行扫描则勾选“检查映像健康”复选框，DISM会在修复之前扫描当前系统是否有异常而后进行修复，若要进一步修复，在DISM扫描并修复阶段结束后可点击“修复当前系统”直接运行“sfc /scannow”命令。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/6e655ffc-e316-4865-b19b-307d5a00d53d)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/99335d26-211f-4b83-ac07-5a720903902f)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/e1c70b5c-5cc6-412d-bbdb-86677e39d9d7)
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/f002460c-2ffe-4b42-97d6-09b094508f99)

 
 

#### 释放映像——指定映像以安装系统

在主窗体点击“释放映像”打开相关窗体，首先点击“启动diskpart”以打开diskpart磁盘分区程序对指定磁盘进行分区（要求为系统分区和EFI分区指定盘符，且磁盘为物理磁盘，如U盘、移动硬盘等）。

![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/4448c897-41da-4bc4-9724-26b2179f34cd)

然后指定映像文件、释放路径和映像序号以安装系统于释放路径，点击“确定”开始安装。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/bda3759c-ddbc-4874-9576-55d3bc4a5285)


待映像释放完成，即系统安装后，点击“添加引导记录”进入相关窗体，设置系统路径（释放盘符:\Windows）和EFI路径，点击“确定”即可添加引导记录于安装盘的EFI分区。
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/4448c897-41da-4bc4-9724-26b2179f34cd)

最后放入虚拟机测试（指定物理磁盘，要求管理员权限）
![image](https://github.com/Briar-CatHei/Dismtools/assets/82100581/da202438-67fd-4bd7-a75b-58a8d92ed017)


 

