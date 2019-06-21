package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 16-bit incrementer:
 * out = in + 1 (arithmetic addition)
 */
public class Inc16 {
    public static Signal[] input(Signal[] in){
        Signal[] out = new Signal[16];
        HalfAdderResult har = HalfAdder.input(in[0],Signal.ONE);
        out[0] = har.getSum();
        har = HalfAdder.input(in[1],har.getCarry());
        out[1] = har.getSum();
        har = HalfAdder.input(in[2],har.getCarry());
        out[2] = har.getSum();
        har = HalfAdder.input(in[3],har.getCarry());
        out[3] = har.getSum();
        har = HalfAdder.input(in[4],har.getCarry());
        out[4] = har.getSum();
        har = HalfAdder.input(in[5],har.getCarry());
        out[5] = har.getSum();
        har = HalfAdder.input(in[6],har.getCarry());
        out[6] = har.getSum();
        har = HalfAdder.input(in[7],har.getCarry());
        out[7] = har.getSum();
        har = HalfAdder.input(in[8],har.getCarry());
        out[8] = har.getSum();
        har = HalfAdder.input(in[9],har.getCarry());
        out[9] = har.getSum();
        har = HalfAdder.input(in[10],har.getCarry());
        out[10] = har.getSum();
        har = HalfAdder.input(in[11],har.getCarry());
        out[11] = har.getSum();
        har = HalfAdder.input(in[12],har.getCarry());
        out[12] = har.getSum();
        har = HalfAdder.input(in[13],har.getCarry());
        out[13] = har.getSum();
        har = HalfAdder.input(in[14],har.getCarry());
        out[14] = har.getSum();
        har = HalfAdder.input(in[15],har.getCarry());
        out[15] = har.getSum();
        return out;
    }
}
