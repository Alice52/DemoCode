package syntax

/**
 * @author zack <br/>
 * @create 2020-09-21 00:11 <br/>
 * @project groovy <br/>
 */

// 1. groovy 中都是包装类型
int x = 20;
println x.class;            // java.lang.Integer

def y = 15.6
println y.class;            // java.math.BigDecimal

y = "str"
println y.class;            // java.lang.String

z = 'also string'
println z.class;            // java.lang.String

a = '''\
line one.
This is statement.
'''
println a;                  // java.lang.String


def name = "zack"
println name                // java.lang.String
def helloTo = "hello ${name}"
println helloTo
println helloTo.class       // org.codehaus.groovy.runtime.GStringImpl


def sum = "the sum of 2 and 3 equals ${2 + 3}"
println sum

def function = echo(sum);
println function
println function.class      // java.lang.String

String echo(String message) {
    return message;
}



/*============================== string method ===================================*/
name.center()
// ...







