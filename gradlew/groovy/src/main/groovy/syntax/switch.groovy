package syntax

/**
 * @author zack <br/>
 * @create 2020-09-21 19:55 <br/>
 * @project groovy <br/>
 */

def x = 500
def result
switch (x) {
    case 'foo':
        result = 'string'
        break
    case [4, 5, 6, 'in-list']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    default: result = 'default'
}

println result