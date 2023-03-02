# 设计模式分类

设计模式使用的主要因素：**封装 继承 多态**

## 根据作用范围·

① 类模式

② 对象模式

## 根据目的

① 创建型模式  ==5种==  ：**如何创建对象**

* 单例模式（懒汉式、饿汉式、双检锁、线程唯一单例）
* 工厂方法模式 （类）
* 抽象工厂模式
* 建造者模式
* 原型模式

② 结构型模式 ==7种==：**如何将类或对象结合在一起形成一个更强大稳定的结构** 

* 适配器模式（类/对象）
* 组合模式
* 装饰器模式
* 代理模式
* 享元模式
* 外观模式
* 桥接模式

③ 行为型模式 ==11种== ：**类或对象间如何交互、如何划分职责，从而更好地完成任务**

* 迭代器模式
* 模板方法模式（类）
* 策略模式
* 命令模式
* 状态模式
* 责任链模式
* 备忘录模式
* 观察者模式
* 访问者模式
* 中介者模式
* 解释器模式（类）

💯 <span style="color:pink">合并总结设计模式</span>


**⭕作用**：

1. 规范代码写法，避免山峰代码，**可读性高**
2. 开拓思维，设计独特的代码，**复用性强**，**可靠**
3. 高级技术运用了设计模式
4. 代码便于拓展，**模块 高内聚**（依赖，聚合），**但耦合性低**，**可扩展度高**
5. 一款软件（从简单到复杂构建）： 面向对象（OOP）  ->  功能模块 （设计模式+算法/数据结构） ->  框架 （多种设计模式）-> 架构 （服务器集群） 

# 23种设计模式

​	💥从0到1慢慢学习，**先了解，再编码**



## 💯单例模式

☕作用：提供唯一的实例

☕解决问题：资源节省，提高性能

☕场景： 重量级的对象实例（耗时多，耗资源多）；经常使用对象，工具类对象；一些需要频繁创建销毁对象的场景

☕特点：对于某个类**只存在一个对象实例**，并且该类只对外提供取得这一个对象的方法（静态方法）

☕类和对象的关系 配合UML类图：



### 饿汉式

#### 饿汉式之静态成员

1. 构造器私有化
2. 内部创建一个本类的私有静态成员实例：`private static final Singleton instance=new Singleton()` <!--final对这个变量做优化-->
3. 创建一个公有的静态方法 ，返回实例对象 

🍎优点：操作简单，保证实例唯一。避免了线程同步问题

🍓缺点：

1. 不符合 **懒加载** 规则， 如果后续没有使用这个实例就会造成资源浪费
2. 除了调用 获取实例对象的方法可以触发instance实例化以外，可能也会因为其他的操作导致instance实例化，造成资源浪费

#### 饿汉式之静态代码块

🪒修改：只是将实例化静态成员实例的操作，放到静态代码块中进行操作。优缺点和上面一样

### 懒汉式

#### 懒汉式之线程不安全

1. 构造器私有化
2. 内部创建一个本类的私有静态成员变量：`private static final Singleton instance;`
3. 创建一个公有的静态方法。先判断 instance是否为空，为空就先实例化在返回，否则直接返回实例

🍎优点：达到了懒加载，只有调用 getInstance方法时，才会实例化对象

🍓缺点：

1. 只能适用于单线程的情况下
2. 多线程下可能会创建多个实例，**无法满足单例**

#### 懒汉式之线程安全

🪒修改：对获取实例的方法，加上 synchronized 关键字

🍎优点：解决线程安全问题

🍓缺点：以后每个线程想要调用方法获取单例实例，都需要排队等待，十分影响效率。应该只实例化一次就够了，其余情况直接返回



### 双重检查

*good*

1. 构造器私有化
2. 内部创建一个本类的私有静态成员变量：`private volatile static final Singleton instance;`
3. 创建一个公有的静态方法，用于获取实例。
   这次不在方法上加锁，而是使用代码块锁将判断instance是否为空的且实例化的操作锁起来，对唯一静态资源Singleton.class锁住。同时为了避免效率过低，在锁的外面再加一层判断instance的条件

> ❗注意：instance的volatile关键字必须加。

* 因为对于 `instance=new Singleton()`并不是一个原子性的操作。
* 即但这条代码并编入及机器中后，它会变成三条指令
* 但是new操作 一共分成了**三条指令**：①分配对象内存空间 ② 初始化对象 ③将对象指向内存空间
* 第一条指令是必先执行的，但是2 3条对于机器来说就无所谓了，有可能会进行指令重排。
* 如果3比2先执行，这时，instance就不为空，但是它并没有初始化。
* **后续的线程在锁代码块外部**，判断不为空，就会直接返回instance，但是它是有问题的。
* 所以加上volatile，主要是为了**禁止指令重排**。

🍎优点：

1. 实现了懒加载
2. 保证了线程安全，而且效率也提高了

🍓缺点：不容易想到，容易忘记细节



### 静态内部类

*good*

1. 构造器私有化
2. 定义一个静态内部类（保证唯一），内部定义私有静态常量实例：`private static final Singleton INSTANCE=new Singleton()` 
3. 创建一个公有的静态方法，用于获取静态内部类的常量实例

🍎优点：

1. 实现了懒加载
2. 保证了线程安全，因为类加载是线程安全的，
3. 静态内部类在Singleton类加载时不会被加载，只有触发公有的静态方法才会加载
4. 类的**静态属性只会在第一次加载**时初始化，jvm帮我们保证了线程安全，保证了单例



### 枚举方式

*good*

1. 定义一个枚举类
2. 定义一个枚举实例

🍎优点：

1. 通过枚举类拿到实例也是单例，而且没有线程安全问题
2. 同时也避免了反序列化造成的问题

### 源码使用

#### JDK中使用到的单例模式

💨 java.lang.Runtime类，这个类是使用的单例模式其中的饿汉式写法

## 🔐简单工厂模式（静态工厂模式）

合并复用

属于 *工厂模式家族*中最简单实用的模式

☕作用： 将实例化对象的代码提取出来，放到一个类中统一管理和维护。类解构，项目扩展性和维护性变高

☕解决问题：得到类实例方式简单

☕场景：需要相似有区别的类实例，

☕特点：工厂类不够灵活，新增子类需要修改功能（使用ifelse判断），不用关心具体实现细节

☕类和对象的关系 配合UML类图：


🍎优点：

1. 获取不同的子类实例对象很方便，不用关心实现细节
2. 减少了多次修改代码的情况

🍓缺点：

1. 仍然不够灵活，创建新的子类时，需要修改工厂方法代码
2. 违反了OCP原则

### 源码使用

#### DateFormat 

① java.text.DateFormat 中


#### Calendar

② Calendar类


## 工厂方法模式

单一职责

☕作用： 将实例化对象的代码提取出来，放到一个类中统一管理和维护。

☕解决问题：得到类实例方式简单

☕场景：有着多个不同点的同一类型类的使用； **生产不同品牌的鼠标，每个品牌有不同的型号**

☕特点：将子类对象的**实例化功能抽象**成抽象方法，推迟到子类实现 

☕类和对象的关系 配合UML类图：

​					BJOrderPizza LDOrderPizza 是工厂子类（new）  OrderPizza 是工厂父类

例如：披萨案例

1. 创建一个父工厂，可以是抽象类也可以是接口。在其中定义创建实例的抽象方法
2. 创建各种子工厂，实现父工厂并且实现创建实例的方法

🍎优点：

1. 可以通过扩展子工厂来对新型号的产品创建
2. 符合OCP原则
3. 类解耦，项目扩展性好，维护性好

🍓缺点：

1. 一个子工厂只能创建一种大类产品
2. 可用性比较单一

### 源码使用

#### JDK中Collection

常见的Collection接口 ，其中有一个方法是生成迭代器 Iterator 这是一个抽象方法。然后子类ArrayList实现了这个方法，并且创建ArrayList的迭代器 `Itr` `Itr`又继承了`Iterator` 接口

UML类图：


## 抽象工厂模式

*用的多*

依赖倒置

☕作用：将实例化对象的代码提取出来，放到一个类中统一管理和维护。类解构，项目扩展性和维护性变高

☕解决问题：得到类实例方式简单

☕场景：**生产不同品牌的鼠标，键盘，显示器等，型号也不同**

☕特点： 将单个工厂类变成工厂簇，利于维护。打破了工厂和产品一对一的关系，一个具体的子工厂可以处理多种产品的创建

☕类和对象的关系 配合UML类图：



​	☕内容：

1. 定义了一个interface用于创建相关或有依赖关系的对象簇，而无需指明具体的类
2. 可以将简单工厂模式和工厂方法模式进行**整合**
3. 将工厂抽象为两层，**抽象工厂**和 **具体实现的子工厂** 。根据创建对象的类型使用对应的工厂子类。<!--替代了if else 的操作-->
4. 父工厂可以处理多种大类产品，对应的子工厂同样可以处理多种大类产品的不同型号。但是如果只处理一种大类，它就退化成了工厂方法模式



🍎优点：

1. 可用性高，一个子工厂可以创建多个大类产品
2. 如果是扩展已有大类的新子类，可扩展

🍓缺点：

1. 违背了OCP。如果扩展的是新大类，不光父工厂要修改，原有的一众子工厂都要修改

==工厂模式原则==

1. 创建对象实例时，不要直接new。又称变量不要直接持有具体类的引用
2. 不要让类继承具体类，而是抽象类和接口
3. 不要覆盖基类已经实现的方法
4. 三种不同的工厂模式不是能解决所有问题，我们需要在 **扩展性和可用性上权衡** 
5. 理论上来说，工厂模式可以有更多层体系（目前是两层），用来细化不同产品的区别

## 迭代器模式



☕内容： 属于行为型模式，**可以在不暴露集合底层表现形式** （列表、栈、树等）的情况下遍历访问集合中的所有元素 （目前java的许多集合都有获取对应迭代器的方法）

—- 提供一种遍历集合元素的接口，用一致的方式遍历集合元素，使用时不需要集合底层的实现

☕作用：简单不暴露集合形式遍历元素

☕场景： 如果我们**集合元素是用不同的方式实现的，有数组，有java集合类等**，需要对多种不同方式集合遍历时

☕特点： 不暴露集合底层表现形式

☕类和对象的关系 配合UML类图：

​	

🍐案例UML （学院中系的相关信息遍历输出）


​		$		Department是集合元素，具体集合形式由实际代码决定；ComputerColleage计算机学院 中有系Department的集合$

😊模式巧妙之处：

1. 在获取迭代器时，将集合元素传给迭代器（构造方法）


2.  **右边的迭代器区域根据集合结构遍历元素**，**左边聚合管理得到真正的集合元素并且聚合迭代器** 左右互不干扰，但又互相关联

🍎优点：

1. 符合依赖倒置原则，依赖于抽象
2. 一个类只会引起一种变化，遍历的遍历元素，管理的管理元素，**符合单一职责原则**
3. 提供一个统一的遍历集合方式，隐藏集合内部结构，用户不需要关心它

🍓缺点：

1. 迭代器一一对应，容易造成类增加问题



### 源码使用

#### JDK

① 许多集合类，举例：ArrayList

​	ArrayList的迭代器是存在于这个类中的，是一个**内部类** 。Itr这个迭代器就**不需要聚合元素**获得元素列表

Itr

ListIterator

**核心UML类图**：


## 策略模式（政策模式）

☕内容： 定义一组算法，将**每个算法都封装**起来，并且使他们之间可以互换。策略模式**让算法==独立于==使用他们的客户而变化** （由客户端指定使用那些策略）

☕解决问题：利用聚合和组合的方式替换继承，解决继承带来的麻烦

☕场景：分析出需求中的变化和不变部分，抽象出使用和生成关系

☕特点：方便扩展维护

☕类和对象的关系 配合UML类图：


​		💨老方案是将operation1等方法设计在Context中，由子类继承决定重写方法

🍐案例UML类图 （不同的鸭子有不同的行为策略）

​	Duck中有fly方法 quack方法等行为，根据传入策略，调用对应的策略方法；  **左边：算法使用者；右边：算法生产者**

🍎优点：

1. 合并复用原则
2. 面向接口编程
3. 易于维护，扩展方便，修改方便

🍓缺点：

1. 每增加一种策略就需要一个类，类爆炸

### 和状态模式的区别

状态模式**强调一个状态对做事的影响**，指对象在不同的状态下做相同的事会有不同的结果。比如在不同状态下读书和玩游戏；而策略模式是**强调做事的过程**。比如怎么打游戏？和朋友一起还是自己一个人？怎么读书？大声读还是无声看？

但这两个模式还是很像的，类图几乎相同。<u>策略模式中选定一个策略开始工作，一般不会像状态模式一样随时会变化</u>

### 源码使用

#### JDK

① **ThreadPoolExecutor**


这个拒绝执行接口，底下就有不同的算法实现逻辑来实现拒绝需求

② **Arrays**

​		在sort方法中会接收一个**`Compartor`**接口的对象，一般是采用匿名内部类的方式，直接实现compare方法；实际上这用的也是策略模式，重写出每一种不同的compare方法都是一种策略。 <!--这里重写compare也可以使用lambda表达式，因为这个接口是一个函数式接口-->



## 建造者模式(生成器)

$传统创建对象：$

* 一步到位，直接在构造器中将所有的成员变量初始化
* 产品和产品的创建过程封装到一起了，在产品完全创建之前，你无法看见它的成果
* 操作简单，但是扩展性不好，也不好维护

☕内容：不推荐我们将对象的初始化工作放在构造函数中，应该使用一个类来作为建造者，在里面定义初始化工作的代码。将对象的初始化工作分为一系列的步骤（**方法**），我们要什么才初始化什么。用户只需要用它来组建产品	


<span style="color:red">建造者模式的重要角色</span>

1. `Product` ==产品角色== ：一个具体的产品对象
2. `Builder` ==抽象建造者==：创建一个Product对象的各个部件指定的接口/抽象类 （**在Product产品需要多种型号时**）
3. `ConcreteBuilder` ==具体建造者==：实现接口，构建和装配各个部件
4. `Director` ==指挥者== :构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象。它主要有两个作用，一是:隔离了客户与对象的生产过程，二是:负责控制产品对象的生产过程，组装属性。<!--想要生成不同属性的相同类对象，在这里可以增加-->

🖐**快速使用**：

① 由于是对类的成员变量进行初始化，一般来说都是模板化的操作。**所以可以借助插件来生成：`Builder Generator`** 🥖使用：`alt+insert` 在类中创建一个**静态内部类作为建造者**

② 使用 `lombok` 在类上加注解 `@Builder`,同样达到和①相同效果



☕作用：**分步创建**复杂对象，将复杂对象分解成简单对象创建 再组合；抽离共同的特征建造

☕解决问题：解决不同时候要求不同对象的复杂创建（*比如之前要的房子没有堤坝，现在想要堤坝*）

☕场景：分离复杂的构造业务代码；**对象定制化**；想要一个不同风格，不同价位的装修菜单选择

☕特点： **对象和对象的创建过程进行解耦** 建造者类一般是final

☕类和对象的关系 配合UML类图：

​		==其实在具体的使用中Director，不复杂的指挥流程也可以交给客户端==，所以可以不用它

🍎优点：

1. 客户端不必知道产品内部细节，产品和产品创建进行解耦
2. 用户使用不同的建造者可以创建不同的产品
3. 更加**精细的控制产品的创建过程**，可定制对象（由Director定义）
4. 增加新的具体建造者不需要修改原有的代码，扩展方便

🍓缺点：

1. 创建产品一般要具有较多共同点，**如果差异性较大，不适合建造者模式**
2. 如果产品内部变化复杂，建造者的逻辑也会十分复杂

### 抽象工厂模式VS建造者模式

1. 抽象工厂实现对产品家族的创建。一个产品家族是这样的一系列产品:具有不同分类维度的产品组合，采用抽象工厂模式不需要关心构建过程，只关心什幺产品由什么工厂生产即可。
2. 而建造者模式叫是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品
3. **抽象工厂重于产品结果，建造者重于产品过程** 
4. **不同对象使用工厂，相同对象拥有不同属性使用建造者**

### 源码使用

#### JDK中StringBuilder

​	抽象建造者

​	具体建造者

​	而StringBuilder也算是具体建造者或者指挥者，只是它没有改变append方法，只是复用了AbstractStringBuilder的append方法。

## 模板方法模式

☕内容：模板的特性。**定义一个操作中的算法框架，而将一些步骤延迟到子类中**，使得子类可以不改变一个算法的结构即可**重新定义**该算法的某些特定步骤 <!--属于行为型-->

☕作用：规定某件事的大体做法

☕解决问题：规范化

☕场景：炒菜（烧锅，放油，炒料，下菜，放调味料，关火…. [这些步骤中具体的操作交给子类]）；砌墙筑房；

​	<span style="color:yellow">当要完成在某个过程，过程有一系列步骤，一些**步骤所要求的基本相同**，只有**个别步骤**不同，可以考虑这种设计模式</span>

☕特点：行为由父类控制，操作由子类实现

☕类和对象的关系 配合UML类图：

​				**注意❗：** 父类中的方法模板方法设置为**final**，保证行为由自己控制。有的方法可以是抽象的（不同子类不同要求）有的可以是实现的（共同特性）。

🍓缺点：

1. 不同的处理要新建不同类，会导致类的增加

🍎优点：

1. 符合开闭原则，能够在原有的基础上修改
2. 实现代码复用，提高灵活性

### 模板模式中的钩子方法

① 什么是钩子方法？ **在模板方法模式的父类中，可以定义一个方法，返回一个true或者空，子类可以视情况而定要不要覆盖它。**

设计钩子方法的**主要**目的是**干预执行流程**，使得控制行为流程更加**灵活**，更符合实际业务的需求。**钩子方法的返回值一般为适合条件分支语句的返回值**（如boolean、int等） ；当然也有空返回，方法里面是空实现，全部交由子类实现，子类在这种方法中实现它的逻辑来控制业务流程实现

② 怎么写？

实现一：

[案例演示](https://blog.csdn.net/weixin_41979002/article/details/118786378)

实现二：

🕳在上图的两个钩子方法中，父类虽然将其调用进入流程，但是它是空实现。子类可以选择重写它，然后增加业务代码或者逻辑



### 源码使用

#### Spring

① IOC源码

​		主要类：`AbstractApplicationContext`  中的 `refresh`方法，这个方法就是模板方法，调用了各种步骤方法



## 代理模式

☕内容：**为其他对象提供一种代理以控制对这个对象的访问** （间接访问）。被代理的对象可以是：远程对象，创建开销大的对象，需要安全控制的对象

​	代理模式：静态代理和动态代理（JDK代理和cglib代理）

☕作用：为其他对象提供一种代理以控制对这个对象的访问

☕解决问题：不暴露核心对象

☕场景：本地实现了一个代理类远程调用另一个服务器的实现方法；通过代理网站访问海外网站；拦截器

☕特点：扩展方便

☕类和对象的关系 配合UML类图：

…

### 静态代理

​	静态代理在使用时,需要**定义接口或者父类,**被代理对象(即目标对象)与代理对象一起实现相同的接口或者是继承相同父类	

### 动态代理（jdk代理/接口代理）

​	<!--代理笔记在Spring5中AOP章节也有记录-->

代理对象不需要实现接口，目标对象还需要实现接口

代理对象的生成是利用JDK的API，动态地生成在内存中


$TeacherDao需要传给ProxyFactory的构造器$

☕主要使用到了`java.lang.reflect.Proxy` 中的`newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)`

* `ClassLoader loader` :指定当前目标对象使用的类加载器，获取加载器的方法固定
* `Class<?>[] interfaces`: 目标对象实现的接口类型，使用泛型方法确认类型
* `InvocationHandler` h :事情处理，执行目标对象的方法时，会触发事情处理器方法


🍃如果接口中存在多个方法怎么办？

* 在拿到代理对象后，调用对应的方法就行了。至于对不同方法的增强，可以通过method获取它的方法名指定对某个方法进行增强

### Cglib代理（子类代理）

​	之前的jdk代理和静态代理都只能代理接口，但是**cglib代理可以代理接口也可以代理类**。在内存生成目标类的子类对其进行代理操作

​	cglib包的底层是通过使用**字节码处理框架**ASM来转换字节码并生成新的类

**🥖实现步骤**

​	<span style="color:pink">注意版本依赖容易冲突</span>

🍸UML类图和解释

☕主要代码：

```java
//返回一个代理对象:
public Object getProxyInstance() {
    //创建一个工具类
    Enhancer enhancer = new Enhancer();
    //2.设置父类
    enhancer.setSuperclass (target.getClass());
    //3.设置回调函数
    enhancer.setCallback(this); //目前这个类是实现了MethodIntercept接口的
    //4.创建子类对象，即代理对象
    return enhancer.create();
}

//重写拦截方法intercept,  // 它会拦截并且调用目标对象方法
@Override
public Object intercept(Object arg0, Method method, Object[ ] args , MethodProxy arg3) throws Throwable {
    System.out.print1n("Cglib代理模式~~开始");
    Object returnVal = method. invoke(target, args );
	System.out.println("Cglib代理模式~~提交");|
    return returnVal;
}	
```

### 代理变体

也算是代理的具体应用场景

<!--常见的，了解即可-->


🍓缺点：

1. 静态代理中目标对象和代理对象需要继承/实现相同的抽象类/接口，如果接口修改了，它的子类都要修改

🍎优点：

1. 可以在原有对象上扩展功能，增强对象

### 和装饰器的区别

装饰器实在原有的功能上，扩展出新的功能；而代理模式是通过其他对象对原对象进行**控制访问** <!--在很多其他设计模式上也有用到代理模式的思想--> 



## 责任链模式

​	🍐案例：学校申请公用费用

☕内容： 一种处理请求的模式，它让多个处理器都有机会处理该请求，直到其中某个处理成功为止。责任链模式将多个处理器串成一条链子，然后让请求在链上游走处理。通常<u>每一个接受者都包含对另一个接受者的引用</u>

☕作用：

☕解决问题： 解决复杂代码避免ifelse增加，避免类的强耦合

☕场景：过滤器链；公司请假流程；**需要多个对象处理同一个其请求的情况** 

☕类和对象的关系 配合UML类图： 

​	💫类图角色说明：

* Handler：抽象处理者，定义了一个处理请求的接口，同时包含另一个处理者
* ConcreteHandlerA：具体的处理者，处理自己负责的请求、如果自己无法处理，可以访问自己的后继处理器，交给它处理
* Request: 表示一个请求



🍎优点：

1. 将请求和处理分开，提高系统灵活性
2. 提高代码灵活性避免冗余代码
3. 简化对象操作

🍓缺点：

1. 每个请求都需要从链头走到链尾，效率不高，所以要控制链的长度
2. 调试不方便

### 源码使用

#### SpringMVC

① **DispatchServlet** 

​	含有一个HandlerExecutionChain，其中包含了一个处理请求的 **拦截器链**

* springmvc请求的流程图中，执行了拦截器相关方法`interceptor.preHandler`等等在处理SpringMvc请求时，使用到**职责链模式**还使用到**适配器模式**
* `HandlerExecutionChain`主要**负责的是请求拦截器的执行和请求处理**,但是他**本身不处理请求**，只是**将请求分配给链上注册处理器处理**，这是职责链实现方式,减少职责链本身与处理逻辑之间的耦合,规范了处理流程
* `HandlerExecutionChain`维护了`HandlerInterceptor`的集合，可以向其中注册相应的拦截器.**增删拦截比较方便，这是相对于类图多出来的管理职责器链的部分**


## 适配器模式

<span style="color:pink">结构型模式</span>

☕内容：模式由来-充电器让220V交流电变成20V直流电给手机充电。**将一个类的接口变换成客户端所期待的另一种接口**，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

​	$和被适配类的关系$：可以是**聚合**，也可以是**继承**

☕作用：将一个类的接口变换成客户端所期待的另一种接口

☕解决问题：解决兼容问题

☕场景：插座口不一样，使用转换接口；TypeC接口转换为耳机接口；充电器电压转换

☕特点：不改变原有接口功能，客户端不关心提供功能的原始接口

☕类和对象的关系 配合UML类图：

### 类适配器

UML类图：

​		原始接口是有子类提供功能的：比如提供220V电压

🍓缺点：

1. 由于类的单继承机制，有一定局限性
2. src类(原始接口)的方法在Adapter中暴露出来，**增加使用成本**

🍎优点：

1. 继承了src，可以重写src的方法对其进行一定的修改



### 对象适配器

​	同样是按照类适配器的原理工作，只是取消了原有继承方式。选择了关联方式处理原始接口。遵守了“**合并复用原则**” （也是子烁讲的方式）

UML类图

🍎优点：

1. 解决了继承的缺点，使用**聚合**替换**继承**
2. 降低成本，更加灵活

### 接口适配器（缺省适配器）

​	场景：当类不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现(空方法)，那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求

​	UML类


<span style="color:red">在实际的框架源码中，适配器模式的具体实现可能是多式多样的，不一定完完全全按照这三种设计。所以**我们要灵活看源码，抓住每个设计模式的核心思想**</span>

### 源码使用

#### SpringMVC

① DisPatcherServlet


流程：

1. 首先请求来到`DispatcherServlet`，调用`doDispatcher`()方法。根据request需要这次请求需要的handler（controller），即调用`getHandler`()；根据handler判断应该用什么适配器来处理这个请求调用对应handler的什么方法，即调用`getHandlerAdapter`() ；随后根据拿到的适配器，传入handler，request，response参数，执行对应适配器的handle方法，触发对应handler 的方法来处理本次请求，返回ModelAndView！！
2. 其中获取适配器，是遍历所有的子类实现适配器，通过`supports`方法判断，此适配器是否能处理这个handler
3. getHandlerAdapter中是通过遍历适配器，调用`supports`（）确定返回那个适配器

​		<span style="color:orange">原始输出：你Controller方法写的返回值  —适配—>   目标输出：ModelAndView; </span> 而不同的适配器是因为有不同类型的Controller，就像牛奶有伊利的有蒙牛的，你需要在伊利工厂创建伊利牛奶，反之则乱套了。

🍐例子：

① HandlerAdapter中的某一个处理Controller子类 ：`SimpleControllerHandlerAdapter`


刚好这种处理器处理的是controller，controller接口自己调用自己子类的handleRequestxxx（）方法返回的就是ModelAndView。然后在这些具体的Controller子类中，又利用反射代理等高级方法去触发你写的controller 方法，然后封装ModelAndView返回



②  HandlerAdapter中的另一种子类：

这种目前只有一个类实现了：`RequestMappingHandlerAdapter`，这样设计估计是为了方便以后扩展


==动手模拟核心适配器模式的使用流程源码==

1. UML类图：
2. 在DispatchServlet中拥有HandlerAdapter 的所有实现类的对象，用于后续遍历判断为controller寻找对应的handler



### 适配器VS装饰者

区别：

1. 适配器模式是将原来的无法使用的接口（类）通过adapter的方法处理变成可以得到原来类的信息（可以使用），但不会修改原来的接口
2. 装饰者模式相反，它就是为原来的接口进行继承扩展操作的，要修改原来的接口



## 观察者模式

​	$项目需求$

☕内容：类的依赖关系，类似**发布订阅模式** 。定义对象间的一种 **一对多**的依赖关系，使得每当 “一”对应的对象状态改变时，就可以通知其依赖的对象集群 获取变化的状态

☕作用：使用数据结构管理主题使用者（依赖者），实现一对多的依赖方式

☕解决问题： 解决类的耦合性强问题，将主题和使用主题者进行解耦

☕场景：天气预报和各大APP应用互通；

☕类和对象的关系 配合UML类图： 

​		$在观察者的子类中还有一些显示信息的方法，类图中没有写出$

🍎优点：

1. 类解耦，提供系统稳定性
2. 遵守OCP原则 

🍓缺点：

### 源码使用

#### JDK

① Observable类（直接实现了对Observer的管理） 和 Observer接口，原理和上面的一样



## 外观模式 （过程模式）

​	$似乎建造者模式的一个例子使用了这个模式Facade$

☕内容：要求一个子系统的外部和其内部的通信必须通过一个**统一的对象**进行，**外观模式提供一个高层次的接口**，对外屏蔽子系统的操作细节，使得子系统更容易使用

☕作用： 让客户端做一件简单的事代替做一系列复杂的操作

☕解决问题： 解决多个复杂接口带来的使用困难，起到简化用户操作的作用

☕场景： 看电影（电影屏幕，投影仪，零食，灯光）；政府办理签证；在**维护一个遗留的大型系统**时，可能这个系统已经变得非常难以维护和扩展，此时可以考虑为新系统开发一个Facade类，来提供遗留系统的比较清晰简单的接口，让新系统与Facade类交互，提高复用性

☕特点：使用简单，修改麻烦

☕类和对象的关系 配合UML类图： 


最初是Client直接依赖三个子系统，并进行使用，现在只是外观类进行中转了一下（整理使用）；如果更难一点的就是各个<u>子系统之间叶可能相互依赖</u>，导致系统调用复杂度急剧上升 （*这个例子还不太难*）

🍎优点：

1. 和子系统解耦，易扩展和维护
2. 划分访问的层次

🍓缺点：

1. 不符合开闭原则，如果子系统内部进行改变，外观模式的接口具体实现可能也要修改

### 源码使用

#### Mybatis

​	① Configuration中**`MetaObject`**对象使用到外观模式

```java
 protected ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
  protected ObjectFactory objectFactory = new DefaultObjectFactory();
  protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
-------
public MetaObject newMetaObject(Object object) {
  return MetaObject.forObject(object, objectFactory, objectWrapperFactory, reflectorFactory);
}
--------
public static MetaObject forObject(Object object, ObjectFactory objectFactory, ObjectWrapperFactory objectWrapperFactory, ReflectorFactory reflectorFactory) {
    if (object == null) {
      return SystemMetaObject.NULL_META_OBJECT;
    } else {
      return new MetaObject(object, objectFactory, objectWrapperFactory, reflectorFactory);
    }
  }
-------
    MetaObject的构造方法又拿着这几个参数经过复杂的条件判断最后返回了对象（此处实现了创建MetaObject的细节）
    
```



## 🔏桥接模式

​	如何引出桥接模式？

因为不同的样式的手机有不同品牌，所以如果按照上图来设计类，非常容易造成类爆炸问题，而且违反了**SRP原则**， 而且维护代码困难 

☕内容： 将 **抽象**和**实现**解耦，使得两者可以独立地变化。基于 **类的最小设计原则** ，使用继承，聚合，实现让不同的类实现不同的责任。  **该设计模式需要正确地识别出系统中==两个独立变化的维度==，该模式替代继承方案，可以减少子类的个数** 

☕作用： 使用继承，聚合，实现让**不同的类实现不同的责任**

☕解决问题： 解决设计类过多的问题；对于不想使用继承或者因为继承造成类爆炸的情况

☕场景：  不同手机的不同型号；银行转账：不同转账方式，不同类型用户，要分别进行搭配进行不同处理；

☕特点：**继承关系 转为 关联关系** ，<!--装饰器使用到继承+关联-->

☕类和对象的关系 配合UML类图： 

🍐案例手机UML类图

​				==Phone充当桥的作用，子类使用品牌的方法，拿到Phone中聚合的Brand进行调用==，将原先直接依赖样式的品牌拆分出来中间加上Phone这个缓冲层，处理两者之间的关系

该设计模式的抽象类图

​	👨‍🎓 $感觉和装饰器模式以及适配器都有点相似$

🍎优点：

1. 减少类的耦合，变化灵活
2. 提高系统的灵活性，有助于系统进行分层设计

🍓缺点：

1. 需要抽象能力，增加系统的理解和设计难度

### 源码使用

#### JDK

① **JDBC** 

​		jdbc中Driver接口，如果从桥接模式来看，Driver就是一个接口，下面可以有MYSQL的Driver,Oracle的Driver，就是实现接口类



## 组合模式

☕内容: 属于组合型设计模式（**如何将对象和类组装成一个较大的结构** ）。组合模式你可以**使用它将对象组合层一个==树状结构==**，并且能像使用**独立对象**一样使用他们（**组合后的对象**）；站在**组织的大小区分层次 （将各个层次都放同一位面，只是理念上管理有大小之分）**

​	两个主要的对象：<span style="color:red">容器和叶子</span> 两个都要实现相同的接口或抽象类，并且容器中要聚合一个接口对象 。容器中可能有叶子也可能是容器。**容器计算下级层次的结果，当然也可以增加删除对应的容器或叶子，叶子没有管理功能，只负责最基本的功能** 

1. **Component** :这是组合中对象声明接口，在适当情况下，实现**所有类共有的接口默认行为**,用于访问和管理Component子部件, Component可以是抽象类或者接口
2. **Leaf** :在组合中表示叶子节点，叶子节点没有子节点
3. **Composite** :非叶子节点，用于存储子部件，在Component接口中实现子部件的相关操作，比如增加(add),删除。I

☕作用： 设计类构建一个大结构

☕解决问题： 

☕场景：全国人口计数；学校院系展示

☕特点：逻辑清晰，管理得当

☕类和对象的关系 配合UML类图：



🍎优点：

1. 利用 **多态**和 **递归机制** 更加方便地使用复杂树结构
2. 符合OCP原则，不需要修改原有代码
3. 简化客户端的操作，客户端只需要一致地像使用一般对象

🍓缺点：

1. **要求较高的抽象性**，如果叶子和容器有很多差异性的话，比如方法和属性等不同，不适合组合模式



### 源码使用

#### JDK

① **HashMap**


源码设计：Node是HashMap的一个静态内部类，只负责存储数据（只有getset方法）


分析：

1. Map就是一个抽象的构建(类似我们的**Component**)
2. HashMap是一个中间的构建(**Composite**)，实现/继承了相关方法put， putall
3. Node 是 HashMap的静态内部类,类似**Leaf叶子节点**，这里就没有put，putall
   static class Node<K,V> implements Map.Entry<K,V>

## **装饰器**模式


☕内容：通过关联关系，对原有的类对象功能进行扩展。**动态的地给一个对象添加一些额外的功能** 就增加功能的用点来说：装饰器模式比继承更加灵活。**装饰器类实现了原始对象的接口，同时也聚合了一个原始对象进来，对其进行装饰（增加功能）**

🍒理解：装饰器模式是在原有类的基础上动态添加新的功能，这种添加功能的方式不同于继承，它是在**对象层面**实现功能扩展，而不是继承的类层面，因此说装饰器模式比继承更加**灵活**。另外，装饰器模式属于结构型设计模式。创建型可以理解为生成新的对象，而结构型可以理解为构建更大的类或类对象。

​		🍐$抽象例子$：想要升级机器人，让其能够走路：在机器人外面套上一层特质盒子，让其可以添加上双腿，这样就扩展了走路功能

☕作用： 扩展类的功能，可以通过对象进行扩展

☕解决问题：**不用破坏原类的结构**增加功能

☕场景：扩展新功能，不用修改原类

☕特点：**新功能附加到对象上**，OO思想 ，==继承+组合== 

☕类和对象的关系 配合UML类图：

​			🍕例子类图


🍐按照这个类图，举一个具体的例子




🍎优点：

1. 遵循了OCP原则
2. 比继承更加灵活

🍓缺点：

1. 一个装饰器只能对一个接口进行装饰

### 源码使用

#### JDK

① IO流的使用。比如一个`BufferInputStream` 创建时需要传入一个对象，是`InputStream`的对象。这就是在`InputStream`对象上增加功能（**缓存**），这种方式通过关联关系扩展了`InputStream`对象的功能 




## 状态模式

阿里巴巴开发手册提及到


—-🍕  同一个对象在不同环境下做同一件事的时候，可能会有不同的结果。这种一般就会用到`ifelse`，但为了避免屎山代码，使用状态模式来达到相同作用—–**将环境（条件）和表现抽象出来结合对应在一起，传输给对象时，对象可以根据环境选择对应的表现完成工作** <!--将ifelse使用多个子类重写方法的做法来代替-->



​	🍐案例 抽奖活动 （箭头是操作方法，黄方块是状态）


☕内容： 允许一个对象在其内部状态改变时改变他的行为，对象看起来似乎修改了他的类 。对于对象来说，状态和行为是一一对应的

☕解决问题： 避免不规范的代码 

☕场景：抽奖活动，不同阶段不同行为；借贷平台流程； **当一个事件有很多状态，状态之间会相互切换，对应不同状态不同行为时**

☕类和对象的关系 配合UML类图： 

​		<u>原理类图</u>


​	 	-–🍕  Context中拥有ConcreteStateA等多种状态，直接包含多种状态情况的发生，；ConcreteStateA中也有Context，用来改变状态或者获取对象的某些变量值，**两者是一种关联关系** <!--当然这种关系也不是一定存在，不同人实现不一样-->

🍐案例UML类图


🍎优点：

1. 符合OCP原则，增删状态容易
2. 方便维护

🍓缺点：

1. 类增多，容易搞错类关系



## 访问者模式


​	工作解析：

* 机器人  ： 执行功能  接收升级包  拥有初始化硬件
* 硬件： 执行指令  接收升级包 
* 升级包： 访问硬件 升级指令

☕内容：  用于**封装一些作用于某种数据结构中的各元素（机器人硬件）的操作**，它可以**在不改变数据结构的前提**下**定义作用于这些各元素的新的操作（升级包-访问器）** 新的操作通过之前元素留有的暴露接口，让新操作可以访问到之前的元素，就可以完成更新操作

**原理**：在被访问的类里加一个对外提供接待访问者的接口 `accpet(Visitor v)` 

硬件原本是有操作的，升级包只是增加和更新原有操作

☕作用：不动原来的结构，就可以新增操作

☕解决问题： 将数据结构和数据操作分离，解耦两者

☕场景：升级机器人;  💘**需要对一个数据结构中的对象进行很多不同操作(这些操作彼此没有关联)**，同时需要避免让这些操作"污染"这些对象的类，而且数据结构比较稳定，可以选用访问者模式解决

☕类和对象的关系 配合UML类图： <!--代码写法 使用到了反向调用；又即双分派写法-->


​		目的和装饰者相似，做法不同，装饰者使用了*继承加聚合*。 

🍎优点：

1. 符合**单一职责**
2. 符合**OCP原则**
3. 适用于数据结构稳定 

🍓缺点：

1. 新增元素（硬件）需要新增访问器的方法
2. 元素必须是暴露的，不能是私有不可访问的
3. 访问器违背了**依赖倒置原则**，它依赖的是具体元素，而不是抽象元素

### 双分派

什么是双分派？  

​		不管类怎么变化，我们都能找到期望的方法运行。双分派意味着 **得到执行的操作取决于请求的种类和两个接收者的类型**

[博文解释](https://blog.csdn.net/wangkaizheng123/article/details/122742696) $自己平时用到了，只是没有意识到$

①分派 

②动态分派

③静态分派

④双分派 （两次动态分派）





## 中介者模式

（**网状结构转为星型结构**）


​	中间的服务接待员就是**中介者**的角色

☕内容： 中介者模式是一种行为设计模式，能让你减少对象之间**混乱无序的依赖关系**。该模式会限制对象之间的直接交互,迫使它们通过一个**中介者对象进行合作**。

☕作用：

☕解决问题：解决类之间的复杂引用

☕场景：飞机降落机场；婚姻中介所；智能家具的相互协调工作

☕类和对象的关系 配合UML类图： 


​				在参与者中调用中介者的方法，将自己加入到中介者的集合中管理。中介者负责管理参与者和协调各个参与者的动作；<u>参与者可能上层也有一个接口或者抽象类</u>

🍐案例智能家具工作UML类图 <!--有些许改动-->


🍎优点：

1. 简化对象交互，解耦类，符合迪米特原则（最小知道原则）
2. 系统设计合理 
3. 新增加参与者，客户端不需要处理任何逻辑

🍓缺点：

1. 中介者本身管理大量参与者，可能本类会难以维护
2. 中介者本身随着参与者增加，自身修改代码违背OCP 



## 命令模式

🍐案例引入：


​	<!--和外观模式有些相似-->

☕内容： 

* 它可将请求转换成一个包含与请求相关的所有信息的**独立对象**，该转换让你能根据不同的请求将 -方法参数化、-延迟请求执行或-将其放入**队列**中，且能实现可撤销操作
* 这种模式会**将请求发送者与请求接收者消除彼此之间的耦合**，让对象之间的调用关系更加灵活，实现解耦
* 在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知被请求的操作是什么。需要在程序运行时指定具体的请求接收者即可

☕作用：将请求发送者与请求接收者消除彼此之间的耦合 ，命令对象成为两者之间的桥梁

☕解决问题：解耦发送者和接收者；可借用队列数据结构，适用多线程；请求的撤销和重做可以实现

☕场景：遥控器控制一系列智能电器

☕特点：统一管理

☕类和对象的关系 配合UML类图：


**类图解析**：

* Invoker： 命令调用角色
* Command：命令角色，需要执行的所有命令都在这儿，这个角色可以是接口也可以是抽象类
* Receiver：接受者角色，知道如何实施和执行一个请求相关的操作
* ConcreteCommand :将一个接收者对象receiver与一个动作execute绑定，调用接收者相应的动作实现 execute方法




🍎优点：

1. 符合单一职责
2. 符合OCP原则 

🍓缺点：

1. 命令很多的话，类爆炸，使代码更加复杂



### 源码使用

#### Spring

**①JdbcTemplate**


`JdbcTemplate`： 命令调用者

​	🍐执行了execute方法


在execute方法中（是重载方法），调用命令接口实现类的方法 `doInstatement` 

☕总结：

* 设计模式的使用上有微小的变化是正常的，**重要的是思想** <!--此处就是用的内部类-->
* `StatementCallback`接口： 类似命令接口
* 局部内部类 `class QueryStatementCallback implements StatementCallback<T>` 实现了`StatementCallback`接口，又在重写的方法中写出了具体的命令执行操作。 **所以它既是命令接口实现子类，也是命令接收者**
* 命令调用者是 `JdbcTemplate` 其中 `execute(StatementCallback<T> action)`方法中，调用 `action.doInStatement` 方法。不同的子类有不同的实现逻辑



## 备忘录模式

☕内容： 允许在不暴露对象实现细节的情况下**保存和恢复**对象之前的**状态**。将**创建快照的工作交给本类自己**，这点和原型模式很像，但是创建出来的快照中不包含什么实质性的操作，只有保存和获取信息的方法；会涉及到一种数据结构：**数据栈** 

​	🥖所以为了节约内存，可以将备忘录模式和原型模式结合使用，利用原型创建副本的高效来解决资源浪费

☕场景：打游戏存档；编辑器编辑文字

☕类和对象的关系 配合UML类图： 


角色：

* 原始角色 （修改和撤销操作都只能是这个角色） `Original`
* 备忘录角色 `MementoActor`
* 备忘录栈角色（管理备忘录角色） `MementoActorManager`

​	

🍎优点：

1. 用户不需要关心内部逻辑，简化操作

🍓缺点：

1. 如果类的成员变量较多，会占用大量资源

## 🔓原型模式

👳‍♂️传统克隆实现：

1. 拿到对象的属性值等，根据new方法创建新的对象
2. 比较好理解，简单易操作
3. 创建新的对象时，需要**获取原始对象的属性，效率低**
4. 需要重新初始化对象，而**不能获取对象的运行时状态直接创建，不够灵活**
5. ==传统无法克隆的情况==：如果原始对象的属性是私有的且没有提供获取方法。而且有可能传给我们看的时候，引用类型是接口或者父类的类型，我们无法知道具体的对象类型





以上的实现方式就是 **浅拷贝**：

1. 对于数据类型是基本数据类型的成员变量，浅拷贝会直接值传递

2. 如果是引用数据类型的，浅拷贝会进行引用传递，也就是将成员变量的引用值赋值给新对象。即两个对象都指向同一个实例，**缺点： 在一个对象中修改该成员变量会影响到另一个对象的该成员变量**

   

### 深拷贝

☕内容：

1. 复制对象的所有基本数据类型的成员变量值、
2. 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。也就是说，对象进行深拷贝要对整个对象进行拷贝
3. 实现方式1:重写clone方法来实现深拷贝
4. 实现方式2:通过对象序列化实现深拷贝

#### ①重写clone

```java
    //方式1 重写clone
    @Override
    protected Object clone()  {
        // 先调用默认的克隆方法，将该对象的非引用类型对象拷贝下来
       Computer clone = null;
try {
           clone = (Computer) super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }
        //再单独处理引用类型的变量，再次进行一个拷贝
       clone.keyBoard= (KeyBoard) keyBoard.clone();
        return clone;
   }
```

#### ②对象序列化🍙（推荐）

 *利用序列化(对象-> 字节序列)和反序列化(字节序列-> 对象)的操作，将对象克隆出来*  [序列化和反序列化的介绍](https://www.bilibili.com/video/BV1JU4y1d72P/?spm_id_from=333.337.search-card.all.click&vd_source=eb83af48877ec21cc6becae65c4758a9)

**需要使用的流对象**：`ObjectOutputStream` ,`ObjectInputStream`,`ByteArrayOutputStream`,`ByteArrayInputStream` 

```java
// ❗❗❤推荐写法：序列化和反序列化（更方便，以后Computer发生改变，这个写法不用改变）
@Override
protected Object clone(){
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    ByteArrayInputStream bis=null; //对象最后要通过Byte形式传输，而不是Object
    ByteArrayOutputStream bos=null;
    try {
        //序列化 （不写入文件中，只是放在数据流管道里）
        bos=new ByteArrayOutputStream();
        oos= new ObjectOutputStream(bos); // 这个类的无参构造对象是protect修饰，于是只能调用有参数的
        oos.writeObject(this); //writeObject

       //反序列化
        bis=new ByteArrayInputStream(bos.toByteArray()); // public ByteArrayInputStream(byte buf[])
        ois=new ObjectInputStream(bis);
        Computer readObject = (Computer) ois.readObject();

        return readObject;

    } catch (Exception e) {
        e.printStackTrace();
        // 关闭流
    } finally {
        try {
            oos.close();
            ois.close();
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return null;
}
```





🍎优点：

1. 提高创建对象的效率
2. 动态获得对象运行时的状态，不用重新初始化对象
3. 如果原始对象发生变化（属性变化），不用修改克隆对象的代码（**对象序列化法**）

🍓缺点：

1. 如果对已经有的类提供可克隆功能，需要修改代码，违背了OCP原则

### 在框架中的使用

#### Spring中的原型Bean的创建

*现在一般写注解，以前是写Bean.xml 中使用bean标签*

如何测试？


##  享元模式（蝇量模式）

☕内容：**运用共享技术有效地支持大量细类度的对象** 。享元对象**只保存**自己的公有状态(内部状态)，不同客户端造成的环境状态（外部状态）不保存，使用时由客户端传入。拥有享元工厂管理享元对象，例如线程池

☕作用：充分利用对象

☕解决问题：避免重复对象的创建，充分利用对象，解决系统性能问题

☕场景：**池技术**（线程池，常量池等）；*共享单车* 

☕特点： 复杂，节约资源

☕类和对象的关系 配合UML类图：


​		**对象解析**：

* `FlyWeight` 是抽象的享元角色，他是产品的抽象类，同时定义出对象的**外部状态**和**内部状态**的接口或实现
* `ConcreteFlylWeight` 是具体的享元角色，是具体的产品类，**实现**抽象角色定义的相关**业务**
* `UnSharedConcreteFlyWeight` 是不可共享的角色，**一般不会出现在享元工厂**。
* `FlyWeightFactory` 享元工厂类，用于构建一个池容器(集合)，同时提供从池中获取对象方法

​		**内部状态和外部状态**：

* 享元模式提出了两个要求:**细粒度和共享对象**。这里就涉及到内部状态和外部状态了，即将**对象的信息分为两个部分:内部状态和外部状态**
* 内部状态指**对象共享出来的信息**，存储在享元对象内部且不会随环境的改变而改变
* 外部状态指**对象得以依赖的一个标记**，是随环境改变而改变的、不可共享的状态。

​		🍐例子UML类图




🍎优点：

1. 充分利用对象，**节约资源**
2. 内外状态相互分离，可以在**不同状态中使用**

🍓缺点：

1. 外部状态的分离造成每次需要结合外部状态工作，浪费了时间，操作逻辑也会变得复杂
2. **提高系统的复杂度**，区分内部状态和外部状态（$所以要选择容易区分出两种状态的情况$）

### 源码分析

#### JDK

① Integer 源码

​	使用到`ValueOf(int i)`方法, 这个方法判断如果i在-128~127之间，就直接从常量池中获取，否则是重新new一个

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)]; //cache是一个Integer数组，事先创建好的整型数组
    return new Integer(i);
}
```

​	cache数组的来源

```java
static {
    // high value may be configured by property
    int h = 127;
    String integerCacheHighPropValue =
        VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
    if (integerCacheHighPropValue != null) {
        try {
            h = Math.max(parseInt(integerCacheHighPropValue), 127);
            // Maximum array size is Integer.MAX_VALUE
            h = Math.min(h, Integer.MAX_VALUE - (-low) -1);
        } catch( NumberFormatException nfe) {
            // If the property cannot be parsed into an int, ignore it.
        }
    }
    high = h;

    // Load IntegerCache.archivedCache from archive, if possible
    CDS.initializeFromArchive(IntegerCache.class);
    int size = (high - low) + 1;

    // Use the archived cache if it exists and is large enough
    if (archivedCache == null || size > archivedCache.length) {
        Integer[] c = new Integer[size];
        int j = low;
        for(int i = 0; i < c.length; i++) {
            c[i] = new Integer(j++);
        }
        archivedCache = c;
    }
    cache = archivedCache;
    // range [-128, 127] must be interned (JLS7 5.1.7)
    assert IntegerCache.high >= 127;
}
```



## 解释器模式 |难|

<!--非精通人士慎用-->

🍐案例引入：


$不包含乘除，不包含括号$

☕内容：  在编译原理中，一个算术表达式通过**词法分析器**形成词法单元，而后这些词法单元再通过**语法分析器**构建语法分析树，最终形成一颗抽象的语法分析树。<u>这里的词法分析器和语法分析器都可以看做是解释器</u>

解释器模式( **Interpreter** Pattern):是指给定一个语言(表达式)，定义它的文法的一种表示，并定义一个解释器，使用该**解释器来解释语言中的句子(表达式)**

☕场景：将一个需要解释执行的语言中的句子表示为一个抽象语法树；一个简单语法需要解释，如正则表达式，运算表达式等

☕类和对象的关系 配合UML类图： 


角色说明：

* Context:是环境角色,**含有解释器之外**的全局信息.
* AbstractExpression:抽象表达式，声明一个抽象的解释操作,这个方法为抽象语法树中所有的节点所共享
* TerminalExpression:为**终结符表达式**，实现与文法中的终结符相关的解释操作
* NonTerminalExpression:为**非终结符表达式**，为文法中的非终结符实现解释操作. （**里面聚合有表达式，可能是终结符也可能是非终结符**，聚合进来一起进行逻辑处理）
* **说明**:输入Context 和 TerminalExpression 信息通过Client输入即可

🍐案例UML类图


​			将值存入hashmap，然后分析表达式expstr，遇到值就去hashmap中取，遇到符号就利用对应解释器解释

🍎优点：

1. 良好的扩展性

🍓缺点：

1. 类复杂，类多。使用递归调用，将导致调试效率低下

### 源码使用

#### Spring

① SpelExp



# 复习23种设计模式和实际运用

b 站：[极客时间Gof23设计模式回顾](https://www.bilibili.com/video/BV1tK4y1s7Uo/?vd_source=eb83af48877ec21cc6becae65c4758a9)