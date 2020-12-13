package ch18.sec4.forth;

/**
 * 代码清单18-18 策略枚举
 *
 * @author 王涵威
 * @date 20.12.13 19:04
 */
public enum Calculator {
    /**
     * add
     */
    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },

    /**
     * sub
      */
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value = "";

    private Calculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);
}
