# tdd-locker
## task

given：柜子还有储物格  
when：存物品  
then：返回有效票据，存入成功  

given：柜子没有储物格  
when：存物品  
then：提示已存满，存入失败  

given：票据有效  
when：取物品  
then：取到正确的物品  

given：票据无效  
when：取物品  
then：提示无效票据  

given：使用使用过的票据  
when：取物品  
then：提示无效票据  

## robot-locker
given robot管理2个Locker，储物柜有空柜 1号Locker未满, when 存包, then 存入1号Locker并返回票据

given robot管理2个Locker，1号Locker 已满 2号Locker未满, when 存包,then 存入2号Locker并返回票据

given robot管理2个Locker，1号和2号Locker都已满 , when 存包, then 提示储物柜已满

given robot管理2个Locker，收到有效的票据，when 取包，then 成功取包

given robot管理2个Locker，收到无效的票据，when 取包，then 提示票据无效


