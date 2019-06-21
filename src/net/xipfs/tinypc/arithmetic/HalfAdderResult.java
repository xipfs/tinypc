package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>半加器计算结果</p>
 */
public class HalfAdderResult {
    private Signal sum;
    private Signal carry;

    public HalfAdderResult(){}

    public HalfAdderResult(Signal sum, Signal carry) {
        this.sum = sum;
        this.carry = carry;
    }


    public Signal getSum() {
        return sum;
    }

    public void setSum(Signal sum) {
        this.sum = sum;
    }

    public Signal getCarry() {
        return carry;
    }

    public void setCarry(Signal carry) {
        this.carry = carry;
    }
}
