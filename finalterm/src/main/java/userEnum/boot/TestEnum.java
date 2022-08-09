package userEnum.boot;

import org.junit.Test;
import userEnum.UserEnum;

public class TestEnum {
    @Test
    public  void test1() {
        //此处假如客户端传入状态码 1
        Integer man = 1;
        UserEnum.Sex parse = UserEnum.Sex.parse(man);
        System.out.println(parse);
    }
    @Test
    public  void test2() {
        //此处假如客户端传入状态码 1
        Integer man =1;
        UserEnum.Sex parse = UserEnum.Sex.parse (man);
        switch (parse){
            case  Man:
                //todo
                System.out.println("Man");
                break;
            case WOMAN:
                System.out.println("WOMAN");
                //todo
                break;
        }
    }
}
