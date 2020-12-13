本例讲解了两种将yml中的文件注入到实体类中的方法。
其中各有优劣.
注意：
1.如果实例变量被private所修饰，则必须使用get，set
方法对其注入，否则无法注入。
2.@ConfigurationProperties需要maven依赖devtool工具包