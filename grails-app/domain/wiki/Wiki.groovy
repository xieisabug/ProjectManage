package wiki

/**
 * Wiki
 */
class Wiki {

    String name //wiki������
    String content //wiki�����ݣ�markdown��ʽ

    static constraints = {
        content maxSize: 5000 //���5000����
    }
}
