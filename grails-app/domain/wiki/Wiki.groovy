package wiki

class Wiki {

    String name
    String content

    static constraints = {
        content maxSize: 5000
    }
}
