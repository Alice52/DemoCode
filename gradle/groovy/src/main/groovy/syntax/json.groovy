package syntax

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * @author zack <br/>
 * @create 2020-09-21 21:20 <br/>
 * @project groovy <br/>
 */

def list = [
        new Student(name: "zack", age: 15),
        new Student(name: "kayla", age: 16),
        new Student(name: "able", age: 18),
]

def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)
//def jsonInput = new JsonSlurper()

def reponse =
        getNetworkData(
                'http://101.37.174.197:8011/goods/list?currentPage=1&pageSize=20')
println reponse

def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    //将json转化为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)
}


