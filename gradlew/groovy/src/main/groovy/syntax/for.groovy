package syntax

/**
 * @author zack <br/>
 * @create 2020-09-21 20:00 <br/>
 * @project groovy <br/>
 */

def sum = 0;
for (i in 0..9) {
    sum = sum + i
}
println sum

// list
sum = 0
for (i in [1, 2, 5, 5]) {
    sum = sum + i
}
println sum


// map
sum = 0
for (i in ['a': 1, 'b': 2, 'c': 3]) {
    sum = sum + i.value
}
println sum