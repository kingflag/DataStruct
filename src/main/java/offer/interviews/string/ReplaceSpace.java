package offer.interviews.string;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author kingflag
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        String res = str.toString().replace(" ", "%20");
        return res;
    }

    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("We Are Happy");
        String res = replaceSpace(test);
        System.out.println(res);
    }
}
