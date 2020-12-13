序列化问题：放入缓冲中的类对象都需要实现序列化？
缓存讲解：
    CacheUserService的findAll方法中设置@Cacheable(value = {"user"})
    意思是将该方法的返回值交给名为user的缓存组件进行缓存。以键值对的形式
    进行缓存，其中键默认是传入的值，值是返回的结果，而规定的缓存组件能够
    将不同的类隔离开，因此缓存时应保证每个方法的参数是不同的。
    
   cacheUSerService的findById方法，设置@Cacheable(value = {"user"},key = "#root.methodName+'['+#参数+']'")
   通过指定方法名和参数作为键，更安全，不会引起歧义，因为考虑到了重载才加上参数。
   
   
查：Cacheable
改和增：CachePut
删：CacheEvict 
以上注解中两个属性：value表明归类，key表示键，关键就在于键，需要对应，才能实现不同方法间的结果缓存。
                   还有一个隐藏的属性是key对应的值。
使用caching可以指定不同的key
在类上使用CacheConfig(cachename="name")可以省略方法上的value值    
   