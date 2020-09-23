package syntax

/**
 * @author zack <br/>
 * @create 2020-09-21 20:15 <br/>
 * @project groovy <br/>
 */

def clouser = { println("Hello Clouser!") }
result = clouser.call();
println result; // null

def clouser2 = { String name, Integer age -> println("Hello ${name}, ${age}") }
clouser2.call("zack", 4)

def clouser3 = { println("Hello ${it}") }
clouser3("zack")


def clouser4 = { return "Hello ${it}" }
def result4 = clouser4("zack")
println result4


/*==================== basic type =======================================*/
println(fat(5))

int fat(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result;
}

println(fatDown(5))

int fatDown(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result;
}

println(cal(101))

int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result;
}

/*==================== string type =======================================*/
String str = 'the sum of 2 and 3 equals 5'

str.each {
    t -> print t * 2
}
println ""

def res = str.find {
    t -> t.isNumber()
};
println res


def list = str.findAll {
    t -> t.isNumber()
};
println list.toListString()

def any = str.any {
    t -> t.isNumber()
};
println any

def every = str.every {
    t -> t.isNumber()
};
println every

def collection = str.collect {
    t -> t.toUpperCase()
};
println collection // list type


/*==================== this/owner/delegate =======================================*/

def scriptClouser = {
    println "scriptClouser this: " + this                           // 闭包定义处的类
    println "scriptClouser owner: " + owner                         // 闭包定义处的类或者对象[闭包内定义的闭包的owner是闭包]
    println "scriptClouser delegate: " + delegate                   // 任意对象, 默认值是 owner 一致
}
scriptClouser.call()

// inner class
class Person {
    def static innerClassClouser = {
        println "innerClassClouser this: " + this
        println "innerClassClouser owner: " + owner
        println "innerClassClouser delegate: " + delegate
    }

    def static sav() {
        def innerClassClouser = {
            println "innerClassMethodClouser this: " + this
            println "innerClassMethodClouser owner: " + owner
            println "innerClassMethodClouser delegate: " + delegate
        }
        innerClassClouser.call()
    }
}

Person.innerClassClouser.call()
Person.sav()

class Person2 {
    def innerClassClouser = {
        println "innerClassClouser this: " + this
        println "innerClassClouser owner: " + owner
        println "innerClassClouser delegate: " + delegate
    }

    def sav() {
        def innerClassClouser = {
            println "innerClassMethodClouser this: " + this
            println "innerClassMethodClouser owner: " + owner
            println "innerClassMethodClouser delegate: " + delegate
        }
        innerClassClouser.call()
    }
}

Person2 p = new Person2()
p.innerClassClouser.call()
p.sav()

def nestClouser = {
    println "outerClouser this: " + this
    println "outerClouser owner: " + owner
    println "outerClouser delegate: " + delegate

    def innerClouser = {
        println "innerClouser this: " + this
        println "innerClouser owner: " + owner
        println "innerClouser delegate: " + delegate
    }

    innerClouser.delegate = p // delegate = p
    innerClouser.call()
}

nestClouser.call()

/*==================== 闭包的委托策略 =======================================*/

class Student {
    String name;
    Integer age;
    def pretty = {
        println "Student name is ${name}"
    }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name;
}

def student = new Student(name: "zack")
def teacher = new Teacher(name: "tim")
student.toString()                                              // Student name is zack
student.pretty.delegate = teacher
student.pretty.resolveStrategy = Closure.DELEGATE_FIRST
student.toString()                                              // Student name is tim
