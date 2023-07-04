import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 패턴_연습 {

    // o를 포함한 단어만 출력하는 간단한 예제
    private static void findAllEqualRegEx() {
        String regEx = "[a-zA-Z]*o[a-zA-Z]*";
        String tset = "You did a good job!";
        Pattern pat = Pattern.compile(regEx);
        Matcher match = pat.matcher(tset);

        while (match.find()) {
            System.out.println(match.group());
        }
    }

    private static void test1() {
        String name = "홍길동";
        String tel = "010-1234-5678";
        String email = "test@naver.com";

        //유효성 검사
        boolean name_check = Pattern.matches("^[가-힣]*$", name);
        boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);

        //출력
        System.out.println("이름 : " + name_check);
        System.out.println("전화번호 : " + tel_check);
        System.out.println("이메일 : " + email_check);
    }

    public static void main(String[] args)  {
        test1();
        findAllEqualRegEx();
    }
}
