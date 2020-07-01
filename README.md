# tdd-locker
## task

given：locker还有储物格  
when：存物品  
then：返回有效ticket，存入成功  

given：locker没有储物格  
when：存物品  
then：提示已存满，存入失败  

given：ticket有效  
when：取物品  
then：取到正确的物品  

given：ticket无效  
when：取物品  
then：提示无效ticket  

given：使用使用过的ticket  
when：取物品  
then：提示无效ticket  

## primary primaryLockerRobot-locker
given robot管理2个Locker，储物柜有空柜 1号Locker未满, when 存包, then 存入1号Locker并返回ticket

given robot管理2个Locker，1号Locker 已满 2号Locker未满, when 存包,then 存入2号Locker并返回ticket

given robot管理2个Locker，1号和2号Locker都已满 , when 存包, then 提示储物柜已满

given robot管理2个Locker，收到有效的ticket，when 取包，then 成功取包

given robot管理2个Locker，收到无效的ticket，when 取包，then 提示ticket无效

## smart-locker-primaryLockerRobot
Given  smart-locker-robot管理的两个locker，一号locker空余数量大于二号locker，when 存包，then 成功存入一号locker，返回ticket。

Given  smart-locker-robot管理的两个locker，一号locker空余数量小于二号locker，when 存包，then 成功存入二号locker，得到ticket。

Given  smart-locker-robot管理的两个locker，一号locker空余数量等于二号locker，when 存包，then 成功存入一号locker，得到ticket。

Given  smart-locker-robot管理的两个locker，两个locker已经存满，when 存包，then 存包失败，提示locker已经满了。

Given  smart-locker-robot管理的两个locker，收到无效ticket，when 取包，then 取包失败,提示ticket无效。

Given  smart-locker-robot和locker-robot同时管理的两个locker，收到smart-locker-robot返回的ticket，when locker-robot取包，then 取包成功。

Given  smart-locker-robot和locker-robot同时管理的两个locker，收到locker-robot返回的ticket，when smart-locker-robot取包，then 取包成功。

## lockerRobotManager

given LockerRobotManager 管理的2 locker 都有位置，无管理的 robot，包，when LockerRobotManager 存包，then 存包第一个locker成功，得到 ticket。

given LockerRobotManager 管理的第一个locker 没有位置，第二个有位置，无管理的 robot，包，when LockerRobotManager 存包，存包第2个locker成功，得到 ticket。

given LockerRobotManager 管理的两个 locker 有位置，管理的两个 robot 的 locker 位置，包，when 存包，then 存入第一个robot的locker，返回 ticket。

given LockerRobotManager 管理的两个 locker 有位置，管理的第一个 robot 没有有位置，第二个 robot 有位置，包，when 存包，then 存入第二个robot的locker，返回 ticket。

given LockerRobotManager 和 管理的的 robot 的 locker 都没有位置，包， when 存包，then 存包失败，提示柜子已经满了。

given LockerRobotManager ，有效的 ticket ， when 取包，then 取包成功。

given LockerRobotManager ，无效的 ticket ， when 取包，then 取包失败，提示票据无效。



## Locker-robot-director
Given locker-robot-director管理1个robot-manager，robot-manger管理2个locker，第一个locker的可用容量和总容量分别为4,5，
第二个locker的可用容量和总容量分别为3,4，when locker-robot-director统计报表，then 打印
M 7 9
 L 4 5
 L 3 4
 
Given locker-robot-director管理1个robot-manager，robot-manger管理2个robot，每个robot管理一个locker，第一个robot管理的locker的可用容量和总容量分别为3,5，
第二个robot管理的locker的可用容量和总容量分别为6,7，when locker-robot-director统计报表，then 打印
M 9 12
 R 3 5
  L 3 5
 R 6 7
  L 6 7
  
Given locker-robot-director管理1个robot-manager，robot-manger管理1个locker和1个robot，robot-manger管理的locker的可用容量和总容量分别为9,10，
robot管理的locker的可用容量和总容量分别为7,8，when locker-robot-director统计报表，then 打印
M 16 18
 L 9 10
 R 7 8
  L 7 8
  
Given locker-robot-director管理2个robot-manager，第一个manager管理1个locker，可用容量和总容量分别为0,1，
第二个manager管理1个locker，可用容量和总容量分别为3,4，when locker-robot-director统计报表，then 打印
M 0 1
 L 0 1
M 3 4
 L 3 4


