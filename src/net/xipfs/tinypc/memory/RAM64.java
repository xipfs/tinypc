package net.xipfs.tinypc.memory;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.DMux8Way;
import net.xipfs.tinypc.gate.Mux8Way16;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>RAM64</p>
 */
public class RAM64 {
    private RAM8[] ram8s = new RAM8[]{
            new RAM8(),new RAM8(),new RAM8(),new RAM8(),
            new RAM8(),new RAM8(),new RAM8(),new RAM8(),
            new RAM8(),new RAM8(),new RAM8(),new RAM8(),
            new RAM8(),new RAM8(),new RAM8(),new RAM8()
    };

    public Signal[] input(Signal[] in, Signal load,Signal[] address){
        Signal[] addr0_2 = new Signal[3];
        Signal[] addr3_5 = new Signal[3];
        System.arraycopy(address,0,addr0_2,0,3);
        System.arraycopy(address,3,addr3_5,0,3);
        Signal[] loads = DMux8Way.input(load,addr3_5);
        Signal loadA = loads[0];
        Signal loadB = loads[1];
        Signal loadC = loads[2];
        Signal loadD = loads[3];
        Signal loadE = loads[4];
        Signal loadF = loads[5];
        Signal loadG = loads[6];
        Signal loadH = loads[7];
        Signal[] o1 = ram8s[0].input(in,loadA,addr0_2);
        Signal[] o2 = ram8s[1].input(in,loadA,addr0_2);
        Signal[] o3 = ram8s[2].input(in,loadA,addr0_2);
        Signal[] o4 = ram8s[3].input(in,loadA,addr0_2);
        Signal[] o5 = ram8s[4].input(in,loadA,addr0_2);
        Signal[] o6 = ram8s[5].input(in,loadA,addr0_2);
        Signal[] o7 = ram8s[6].input(in,loadA,addr0_2);
        Signal[] o8 = ram8s[7].input(in,loadA,addr0_2);
        Signal[] out = Mux8Way16.input(o1,o2,o3,o4,o5,o6,o7,o8,addr3_5);
        return out;
    }

}
