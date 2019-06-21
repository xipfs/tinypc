package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * 8-way demultiplexor:
 * {a, b, c, d, e, f, g, h} = {in, 0, 0, 0, 0, 0, 0, 0} if sel == 000
 *                            {0, in, 0, 0, 0, 0, 0, 0} if sel == 001
 *                            etc.
 *                            {0, 0, 0, 0, 0, 0, 0, in} if sel == 111
 */
public class DMux8Way {
    public static Signal[] input(Signal in , Signal[] sel){
        Signal[] out = new Signal[8];

        Signal[] temp1 = DMux.input(in,sel[2]);
        Signal[] temp2_1 = DMux.input(temp1[0],sel[1]);
        Signal[] temp2_2 = DMux.input(temp1[1],sel[1]);

        Signal[] a_b = DMux.input(temp2_1[0],sel[0]);
        Signal[] c_d = DMux.input(temp2_1[1],sel[0]);
        Signal[] e_f = DMux.input(temp2_2[0],sel[0]);
        Signal[] g_h = DMux.input(temp2_2[1],sel[0]);

        out[0] = a_b[0];
        out[1] = a_b[1];
        out[2] = c_d[0];
        out[3] = c_d[1];
        out[4] = e_f[0];
        out[5] = e_f[1];
        out[6] = g_h[0];
        out[7] = g_h[1];
        return out;

    }
}
