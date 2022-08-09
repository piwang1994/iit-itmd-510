package userEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import java.util.HashMap;

public class UserEnum {

    //按照如上写法，同样可以有 状态码：正常，禁用，删除
    //public enum Status
    // 角色：管理员，普通用户
    //public enum role

    @Getter
    @AllArgsConstructor
    public enum Sex {
        Man(1, "男"), WOMAN(2, "女");
        private static final HashMap<Integer, Sex> data = new HashMap<>();

        static {
            for (Sex d : Sex.values()) {
                data.put(d.code, d);
            }
        }

        public final Integer code;
        public final String msg;

        public static Sex parse(Integer code) {
            if (data.containsKey(code)) {
                return data.get(code);
            }
            return null;
        }
    }
}