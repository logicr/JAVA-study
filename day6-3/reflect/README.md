* HelloB 这个题都错了好多次了
* 记住啊，主方法的静态代码块优先于主方法执行
* 而有要优先执行父类

```
static A 父类静态代码块
static B 静态代码块
---start---
i'm A class.父类非静态代码块
Hello A!父类构造方法
i'm B class.非静态代码块
Hello B! 构造方法
i'm A class.父类非静态代码块
Hello A!父类构造方法
i'm B class.非静态代码块
Hello B! 构造方法
---end---
```
