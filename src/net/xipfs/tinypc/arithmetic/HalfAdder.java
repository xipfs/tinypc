package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.And;
import net.xipfs.tinypc.gate.Xor;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>半加器 Computes the sum of two bits.</p>
 */
public class HalfAdder {
    public static HalfAdderResult input(Signal a, Signal b){
        HalfAdderResult result = new HalfAdderResult();
        result.setSum(Xor.input(a,b));
        result.setCarry(And.input(a,b));
        return result;
    }
}
