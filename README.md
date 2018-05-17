# springboot-jmockit-junit

### 一句话：JMockit 很强大，但是，入门门槛相比PowerMock会高一点。
* JMockit必须在JDK1.7或以上跑。
* JMockit必须使用JUnit/TestNG
* 细节：Maven `pom.xml`中写依赖时，要先写JMockit，后写JUnit，否则，需要每一个测试类都加上注解`@RunWith(JMockit.class)`

### 注解分析
* `@Tested`
  * 自动创建被测对象。（调用该类的无参构造器）
  * `@Tested(fullyInitialized = true)`表示对当前被测对象进行递归初始化，他内部的所有依赖都会被正常初始化，不存在mock。
* `@Injectable`
  * **仅对当前实例**的所有方法进行mock
* `@Mocked`
  * 对**今后的所有实例**进行mock
* `@Capturing`
  * 对本类方法全部mock
  * 对本接口的所有子类/实现类mock
> 注意：无论是`@Injectabe`,`@Mocked`,`@Capturing`哪种Mock对象，都是对类的方法全部mock了

### 用法示例：
1. Mock `Service` 中依赖的 `DAO`
2. Mock 一个对象中的部分方法
3. Mock 静态属性
4. Mock 静态方法
5. Mock private属性
6. Mock private方法
   > 注意：由于最高版本 1.39 不支持 private 方法的mock，所以，本项目采用的是 1.19版本（最多人用的版本）。
7. Mock final 属性
8. Mock final 方法

### 参考文章
- [JMockit中文网](http://jmockit.cn/showArticle.htm?id=7)
- [JMockit官方文档](http://jmockit.github.io/)