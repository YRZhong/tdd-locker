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
