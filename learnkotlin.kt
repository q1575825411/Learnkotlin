package cn.hui.learnkotlin

import kotlin.math.max

fun main() {

    /*
    学习任意一门语言，我们要了解的最基本的就是变量和函数，这两个是所有编程语言的共同点
    学习Kotlin我们就可以从变量和函数开始入手
     */
    val number = 10
    val numberIn: Int = 10 // 1
    println("number is $number")
    var mubNumber = 10
    mubNumber = 100
    println("number is $mubNumber")

    /*
    如果有一定的编程基础，那么起码可以明白这一段就是声明变量并输出的作用
    从这一段我们可以看出Kotlin和Java的最主要改变就是行尾的分号是去掉了，习惯了这一点以后其实会感觉非常舒服
    第二点是变量声明的时候并没有注明变量类型，但是也能正常运行

    Kotlin 新增了一个叫做类型推导的机制，根据赋值推导类型。当然我们也可以声明具体类型，要注意的是Kotlin的基本数据类型其实都是对象数据类型，和Java不同，
    数据类型的首字母都是大写。带类型的声明见注释 1 。

    这一段有两个关键字
    val 声明一个不可变变量，
    var 声明一个可变变量。

    字面意思，val等同于 final 。这里Kotlin 主动限制了变量是否能被修改，在进行Kotlin编程的时候，变量都应该是 val 等到需要改变的时候，再去修改类型为 var

     */

    fun show() {
        println("This is a menu, nothing happen")
    }

    fun whereIsPods(x: Int, y: Int): Int {
        return (x + y) / (x - y)
    }
    /*
    上述就是Kotlin函数的声明方式，fun 定义函数的关键字，紧随其后的是函数名。括号内的是传递进函数的参数，参数名在前，参数类型在后，: 区分。
     括号后面 冒号 + 数据类型 是函数的返回类型，如果没有返回不写即可。
     Kotlin函数有一个语法糖，比较重要，演示在下面
     当函数只有一行代码时，可以不用写函数体，而是通过 = 将代码连接在声明尾部。（max是Kotlin内嵌的比较函数）
     */

    fun largeNumber(num1: Int, num2: Int): Int = max(num1, num2)

    //第二部分，逻辑控制

    //常规写法我就不写了，同java，但是Kotlin的if语句是可以有返回值的。
    /*
     很好理解，Kotlin 的if 语句会把每个条件的最后一行当作返回值进行返回。
      */
    fun largeNumber2(num1: Int, num2: Int): Int = if (num1 > num2) {
        num1
    } else {
        num2
    }

    /*
    Kotlin 有一个新增的逻辑控制，when 理解起来可以类比Java的 switch，但是远比 switch 好用，范例如下
    when 的格式大致如下
    ”匹配值“ -> {执行逻辑}
    同时 when 也可以进行类型匹配，见范例
    基本用法就这俩，其他的用的少
     */

    fun getGrade(name: String) = when (name) {
        "Tom" -> 99
        "Jack" -> 99
        "Mar" -> 99
        "Lily" -> 99
        else -> 0
    }

    fun checkNum(num: Number) {
        when (num) {
            is Int -> print("$num is Int")
            is Double -> print("$num is Double")
            else -> print("$num is not number")
        }
    }

    /*
    循环 两种 while 和 for while 同Java 。for 废弃了 for-i 结构 采用 for-in
    0 .. 10 表示[0,10]的闭区间
    0 until 10  表示 [0,10)
    10 downTo 1 降序闭区间
    不做详解
     */
    for (i in 0..10) {
        println(i) // 意为输出 1-10 的整数
    }
    /*---------------------------------------------------------------------------------------------*/
    /*
    面向对象部分 见文尾
    这里需要解释的是关于构造函数的问题

    Kotlin 构造函数有主构造函数和次构造函数，每个类都会默认有一个不含参的主构造函数
    次构造函数基本用不到，通过 constructo 关键字引出，见范例即可了解。
     */

    val stu = Student()
    val stu1 = Student("jack", 15);
    val stu2 = Student("0121710880315", 15, "jack", 15)
    doStudy(stu2)

    /*---------------------------------------------------------------------------------------------*/

    /*
    这里想说的是数据类和单例类，因为不涉及到具体使用就仅作描述
    数据类其实就是一个 data 关键字，将Java繁琐的数据操作封装起来
    声明 data 表示你希望这个类是一个数据类，kotlin会根据主构造函数中的参数完成数据类的 equals() hashCode() toString() 等操作
     */
    data class Phone(val brand: String, val price: Double)

    /*
    单例类其实相当于单例模式  将 class 替换成 object 即可
     */

    /*---------------------------------------------------------------------------------------------*/

    /*
    Lambda 编程
    = 一小段可以作为参数传递的代码
    完整语法结构，后续都是简化过的，这个可以自己学习。
    {参数名1： 参数类型，参数名2：参数类型 -> 函数体}

    下述是集合 Kotlin 集合 也是三种 List Set Map ，使用方法大致如下
    同时 集合也分不变集合和可变集合，不同的是可变集合的方法会多个 mutoble 的前缀。
    常规的用法和Java一致

    这里要说明的是Kotlin 关于集合的特殊用法 集合的函数式API
    如下面例子里面的 filter map any all maxBy 等

     */

    var list = mutableListOf("apple", "banana", "orange", "pear", "watermelon")
    list.add("5")
    val newList = list.filter { it.length <= 6 }.map { it.toUpperCase() }
    val anyResult = list.any { it.length <= 5 }
    val allResult = list.all { it.length <= 5 }
    println("anyResult is $anyResult, allResult is $allResult")
    for (num in newList) {
        println(num)
    }
    var set = mutableSetOf("apple", "banana", "orange", "pear", "watermelon")
    set.add("6")

    for (num in set) {
        println(num)
    }
    var map = mutableMapOf("apple" to 1, "demo" to 2)
    map["banana"] = 1

    for ((fruit, number) in map) {
        println("fruit is $fruit, number is $number")
    }

    val maxLength = list.maxBy { it.length }
    println(" the maxLength is $maxLength")


    /*
    函数式API最常用的还是用于调用 Java 方法，因为很多第三方库其实还是Java，例子如下
     */

    //Java版本的写法

    /*
    new  Thread(new Runnable() {
        public void run(){
            System.out.println("run");
        }
    }).start();

     */

    //Kotlin 实现版本，更多的使用要去实践当中学习
    Thread(object : Runnable {
        override fun run() {
            TODO("Not yet implemented")
            println("run")
        }
    }).start()


    /*---------------------------------------------------------------------------------------------*/

    /*
    Kotlin在处理空指针异常的时候的确很到位，默认所有的数据类型都不为空，如果需要使用为空的类型
    有以下的方式
     */
    var a: String? = ""
    var b: String? = "111"

    /*
     通过  String? 的方式，告诉编译器数据类型存在为空的可能，
     但是空类型不能直接调用函数，因为编译器会警告空类型错误
     这里  可以看doStudy函数 通过  ?. 调用，类似于 非空调用的if语句，
     这样的被叫做判空辅助工具
     类似的是 ?: 以及非空断言 !! 当然我们应当尽量避免使用非空断言。
     */
    val c = a ?: b
    fun getTextLength(text: String?) = text?.length ?: 0
    fun doStudytest(study: Study?) {
        study?.read()
        study?.write()
    }

    /*
    let 一个函数，提供了函数式API的编程接口，并将原始调用对象作为参数传递到Lambda表达式当中

    obj.let {
        obj2 ->
        //具体业务
    }
     obj的let函数被调用，Lambda代码块执行，同时obj作为参数被传递进去，是Kotlin的标准函数

     在判空辅助工具当中的作用可以参考下例

     通过 let 可以处理全局变量的一个判空问题，if 是无法解决的，if 无法保证全局变量是否被其他线程修改为空。let 可以解决。
     */

    fun doStudytest1(study: Study?) {
//        study?.let { study ->
//            study.read()
//            study.write()
//        }
        study?.let {
            it.read()
            it.write()
        }
    }
    /*---------------------------------------------------------------------------------------------*/

    /*
    上述的所有内容应该涵盖了Kotlin初学者应当了解的相关语法习惯，剩下的就应当去实际练习中去加深掌握

    这里还有一些关于Kotlin的小知识
     */

    //字符串内嵌表达式，就是前面程序当中出现过的
    println("number is $mubNumber")
    //通过 $变量名 可以直接在字符串当中嵌入变量或者表达式 正式格式应该是 ${变量，变量} 等，只有一个变量可以省略。

    //函数的参数默认值 主要就是一个键值对的模型

    fun printPass(num:Int = 100,str:String = "hello"){
        println("num is $num, and str is $str")
    }
    printPass(123) //输出应该会有str的默认值

    /*
    这里其实很容理解，当然，如果当你输入参数只包含后面的字符串，会报错，编译器会以为你要把 String传递给 Int

     */
    printPass(str = "123") //这样能解决类型不匹配的问题
}

fun doStudy(study: Study?){
    study?.read()
    study?.write()
}


    /*------------------------------------------------------------------------------------------------*/

    /*
    面向对象部分，类的声明其实和Java 一样，但是要注意的是可见性修饰符 Kotlin 的可见修饰符类型有 public private protected internal
    默认的是 public
    internal 是 对模块可见

    Kotlin当中类的继承不太一样，Kotlin默认类是不可继承的，某个类要想能够被继承，需要 open 关键字，继承的使用见以下范例即可
    同时Kotlin 也移除了 extends 关键字，被继承的类放置于冒号以后，接口也是，实现一个接口同继承，逗号隔开
    class Student():Person(),Study{}

    接口的声明很简单，如下，接口内的函数不编写函数体。
    interface Study {
        fun read()
    }

    在使用过程中，Kotlin 移除了 new 关键字，
    val p = Person1() 即可

     */

open class Person1(var name :String,var age: Int) {

    fun eat() {
        println("$name is eating ,He is $age years old")
    }
}

class Student1(var sno : String, var garde : Int,name: String,age: Int) : Person1(name,age),Study {

    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    constructor() : this("", 0) {

    }

    init {
        println("$name sno is $sno")
        println("$name grade is $garde")
    }

    override fun read() {
        println("$name is reading")
    }

    override fun write() {
        // TODO("Not yet implemented")
        println("$name is writing")
    }
}
interface Study1 {
    fun read()
    fun write()
}

