package syntax

/**
 * @author zack <br/>
 * @create 2020-09-21 21:40 <br/>
 * @project groovy <br/>
 */

def file = new File('../../groovy.iml')
file.eachLine { line ->
    println line
}
println file.getText()
println file.readLines()  // list

//读取文件部分内容
def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader

def result2 = copy('../../groovy.iml', '../../groovy2.iml')
println result2

def copy(String sourcePath, String destPath) {
    try {
        //首先创建目标文件
        def desFile = new File(destPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }

        //开始copy
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            desFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\r\n")
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def student = new Student(name: 'Qndroid', age: 26)
saveObject(student, '../../student.bin')

def result3 = (Student) readObject('../../student.bin')
println "the name is ${result3.name} and the age is ${result.age}"

def saveObject(Object object, String path) {
    try {
        //首先创建目标文件
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
    }
    return false
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) return null
        //从文件中读取对象
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
    } catch (Exception e) {

    }
    return obj
}