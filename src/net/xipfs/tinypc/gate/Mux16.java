package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 16-bit multiplexor:
 * for i = 0..15 out[i] = a[i] if sel == 0
 *                        b[i] if sel == 1
 */
public class Mux16 {
    public static Signal[] input(Signal[] a, Signal[] b, Signal sel){
        Signal[] out = new Signal[16];
        out[0] = Mux.input(a[0],b[0],sel);
        out[1] = Mux.input(a[1],b[1],sel);
        out[2] = Mux.input(a[2],b[2],sel);
        out[3] = Mux.input(a[3],b[3],sel);
        out[4] = Mux.input(a[4],b[4],sel);
        out[5] = Mux.input(a[5],b[5],sel);
        out[6] = Mux.input(a[6],b[6],sel);
        out[7] = Mux.input(a[7],b[7],sel);
        out[8] = Mux.input(a[8],b[8],sel);
        out[9] = Mux.input(a[9],b[9],sel);
        out[10] = Mux.input(a[10],b[10],sel);
        out[11] = Mux.input(a[11],b[11],sel);
        out[12] = Mux.input(a[12],b[12],sel);
        out[13] = Mux.input(a[13],b[13],sel);
        out[14] = Mux.input(a[14],b[14],sel);
        out[15] = Mux.input(a[15],b[15],sel);
        return out;
    }
}
