package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 8-way 16-bit multiplexor:
 * out = a if sel == 000
 *       b if sel == 001
 *       etc.
 *       h if sel == 111
 */
public class Mux8Way16 {

    public static Signal[] input(Signal[] a, Signal[] b, Signal[] c, Signal[] d,
                                 Signal[] e, Signal[] f, Signal[] g, Signal[] h, Signal[] sel){

        Signal[] temp0 = Mux16.input(a,b,sel[0]);
        Signal[] temp1 = Mux16.input(c,d,sel[0]);
        Signal[] temp2 = Mux16.input(e,f,sel[0]);
        Signal[] temp3 = Mux16.input(g,h,sel[0]);

        Signal[] temp4 = Mux16.input(temp0,temp1,sel[1]);
        Signal[] temp5 = Mux16.input(temp2,temp3,sel[1]);

        Signal[] out = Mux16.input(temp4,temp5,sel[2]);

        return out;
    }
}
