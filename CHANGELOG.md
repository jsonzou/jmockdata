## V3.1.0
1. mockConfig添加了个开关enabledCircle解决mock重复对象。
2. 新增注解mockIgnore忽略字段。
## V3.0.1
1. 代码优化，性能提升，减少内部new对象开销。
2. 为后期扩展性移除MockManager，注册自定义Mocker由mockConfig注册。
3. 提供枚举类型的支持。