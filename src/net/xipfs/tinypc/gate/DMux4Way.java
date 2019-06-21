package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * 4-way demultiplexor:
 * {a, b, c, d} = {in, 0, 0, 0} if sel == 00
 *                {0, in, 0, 0} if sel == 01
 *                {0, 0, in, 0} if sel == 10
 *                {0, 0, 0, in} if sel == 11
 */
public class DMux4Way {
    public static Signal[] input(Signal in, Signal[] sel){
        Signal[] out = new Signal[4];

        Signal[] temp = DMux.input(in,sel[1]);
        Signal[] a_b = DMux.input(temp[0],sel[0]);
        Signal[] c_d = DMux.input(temp[1],sel[0]);
        out[0] = a_b[0];
        out[1] = a_b[1];
        out[2] = c_d[0];
        out[3] = c_d[1];
        return out;
    }
}
