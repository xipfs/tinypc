package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.And;
import net.xipfs.tinypc.gate.Or;
import net.xipfs.tinypc.gate.Xor;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>全加器 Computes the sum of three bits.</p>
 */
public class FullAdder {
    public static FullAdderResult input(Signal a, Signal b, Signal c){
        FullAdderResult result = new FullAdderResult();
        Signal temp0 = Xor.input(a,b);
        Signal sum = Xor.input(temp0,c);

        Signal temp1 = And.input(a,b);
        Signal temp2 = And.input(b,c);
        Signal temp3 = And.input(a,c);


        Signal temp4 = Or.input(temp1,temp2);
        Signal carry = Or.input(temp4,temp3);

        result.setSum(sum);
        result.setCarry(carry);

        return result;
    }
}
