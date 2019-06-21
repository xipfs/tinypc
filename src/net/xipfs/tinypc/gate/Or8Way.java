package net.xipfs.tinypc.gate;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>Demo</p>
 */
public class Or8Way {

    public static Signal input(Signal[] in){
        Signal temp0 = Or.input(in[0],in[1]);
        Signal temp1 = Or.input(in[2],in[3]);
        Signal temp2 = Or.input(in[4],in[5]);
        Signal temp3 = Or.input(in[6],in[7]);

        Signal temp4 = Or.input(temp0,temp1);
        Signal temp5 = Or.input(temp2,temp3);

        return Or.input(temp4,temp5);
    }
}
