package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * Adds two 16-bit values.
 * The most significant carry bit is ignored.
 */
public class Add16 {
    public static Signal[] input(Signal[] a, Signal[] b){
        Signal[] out = new Signal[16];

        HalfAdderResult har = HalfAdder.input(a[0],b[0]);
        out[0] = har.getSum();
        FullAdderResult far = FullAdder.input(a[1],b[1],har.getCarry());
        out[1] = far.getSum();
        far = FullAdder.input(a[2],b[2],far.getCarry());
        out[2] = far.getSum();
        far = FullAdder.input(a[3],b[3],far.getCarry());
        out[3] = far.getSum();
        far = FullAdder.input(a[4],b[4],far.getCarry());
        out[4] = far.getSum();
        far = FullAdder.input(a[5],b[5],far.getCarry());
        out[5] = far.getSum();
        far = FullAdder.input(a[6],b[6],far.getCarry());
        out[6] = far.getSum();
        far = FullAdder.input(a[7],b[7],far.getCarry());
        out[7] = far.getSum();
        far = FullAdder.input(a[8],b[8],far.getCarry());
        out[8] = far.getSum();
        far = FullAdder.input(a[9],b[9],far.getCarry());
        out[9] = far.getSum();
        far = FullAdder.input(a[10],b[10],far.getCarry());
        out[10] = far.getSum();
        far = FullAdder.input(a[11],b[11],far.getCarry());
        out[11] = far.getSum();
        far = FullAdder.input(a[12],b[12],far.getCarry());
        out[12] = far.getSum();
        far = FullAdder.input(a[13],b[13],far.getCarry());
        out[13] = far.getSum();
        far = FullAdder.input(a[14],b[14],far.getCarry());
        out[14] = far.getSum();
        far = FullAdder.input(a[15],b[15],far.getCarry());
        out[15] = far.getSum();

        return out;
    }
}
