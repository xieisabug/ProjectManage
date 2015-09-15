package wiki

/**
 * Wiki
 */
class Wiki {

    String name //wiki的名称
    String content //wiki的内容，markdown格式

    static constraints = {
        content maxSize: 5000 //最大5000个字
    }
}
