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

## robot-locker
given robot管理2个Locker，储物柜有空柜 1号Locker未满, when 存包, then 存入1号Locker并返回ticket

given robot管理2个Locker，1号Locker 已满 2号Locker未满, when 存包,then 存入2号Locker并返回ticket

given robot管理2个Locker，1号和2号Locker都已满 , when 存包, then 提示储物柜已满

given robot管理2个Locker，收到有效的ticket，when 取包，then 成功取包

given robot管理2个Locker，收到无效的ticket，when 取包，then 提示ticket无效

## smart-locker-robot
Given  smart-locker-robot管理的两个locker，一号locker空余数量大于二号locker，when 存包，then 成功存入一号locker，返回ticket。

Given  smart-locker-robot管理的两个locker，一号locker空余数量小于二号locker，when 存包，then 成功存入二号locker，得到ticket。

Given  smart-locker-robot管理的两个locker，一号locker空余数量等于二号locker，when 存包，then 成功存入一号locker，得到ticket。

Given  smart-locker-robot管理的两个locker，两个locker已经存满，when 存包，then 存包失败，提示locker已经满了。

Given  smart-locker-robot管理的两个locker，收到无效ticket，when 取包，then 取包失败,提示ticket无效。

Given  smart-locker-robot和locker-robot同时管理的两个locker，locker有位置，when 通过smart-locker-robot存包返回ticket，locker-robot收到ticket取包，then 取包成功。

Given  smart-locker-robot和locker-robot同时管理的两个locker，locker有位置，when 通过locker-robot存包返回ticket，smart-locker-robot收到ticket取包，then 取包成功。


