package _20接口;

/*
 * 一、什么是接口？
 * 在代码层面，接口体现为一系列抽象方法的集合，也就是说接口只负责定义方法，不负责实现方法，而是交由任何想实现这些方法的类自己去实现。
 * 说到这里，我们插一句，Java里接口的概念其实是照抄OC里协议的概念，OC里的协议不就是一堆方法的集合嘛，然后那些类想要实现这些方法就去遵守协议并实现。
 * 只不过OC协议里的方法可以被声明为optional可选实现和required必须实现，而Java接口里的方法则都是必须实现的，当然Java8之后提供了default关键字，
 * 我们可以在接口里为某个方法提供一个默认的实现，那别的类就可以不必须实现这个方法了。
 *
 * 在面向对象层面，接口体现为一系列行为或者说一系列能力的集合（这些行为或者说能力对应到代码的世界里不就是方法嘛），这也是为什么Java规范里要求接口的
 * 名字都定义为Xxxable，这个名字代表的就是实现类能做接口里的行为或者说具备接口里的能力。
 * 
 * 可以看下example包里的例子理解理解。
 * 
 * 
 * 二、除了抽象方法，接口里还可以定义什么（这个也可以帮助我们决定什么时候使用接口，什么时候使用抽象类）：
 * 1、常量，即static final XXX这种常量
 * 2、嵌套类（内部类和静态嵌套类）
 * 3、类方法
 * 再不能定义其它东西了。
 * 
 * 注意：
 * 1、接口里所有定义的东西其实都是隐式public的，也就是说就算你不写public它也是public的，而且你还不能写成其它的修饰符，因为接口设计的初衷就是为了
 * 让别人实现的，你换了修饰符那别人还怎么实现
 * 2、抽象方法可以省略abstract，默认就是
 * 
 * 
 * 三、使用接口需注意：
 * 1、接口不能实例化，因为它里面的方法都是抽象方法，都没有实现，你实例化了去掉用没有实现的方法不就崩了嘛
 * 2、任何能使用类的地方都可以使用接口，接口也像个父类一样可以指向任何实现了这个接口的“子类”
 * 3、一个类可以implements一个或多个接口
 * 4、接口可以继承自其它接口（就像OC里的协议可以继承自其它协议一样)，并且继承在接口这里的体现是可以多继承的
 * 5、一个类可以同时继承自类A并实现接口B，但是extends A必须写在implements B前面，这是语法规定
 */
public class Interface {

}
