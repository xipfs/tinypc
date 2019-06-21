package net.xipfs.tinypc.memory;

import net.xipfs.tinypc.common.Signal;
import net.xipfs.tinypc.gate.DMux8Way;
import net.xipfs.tinypc.gate.Mux8Way16;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * Memory of 8 registers, each 16 bit-wide. Out holds the value
 * stored at the memory location specified by address. If load==1, then
 * the in value is loaded into the memory location specified by address
 * (the loaded value will be emitted to out from the next time step onward).
 */
public class RAM8 {
    private Register[] regs = new Register[]{
            new Register(),new Register(),new Register(),new Register(),
            new Register(),new Register(),new Register(),new Register()
    };
    public Signal[] input(Signal[] in, Signal load, Signal[] address){
        Signal[] loads = DMux8Way.input(load,address);
        Signal loadA = loads[0];
        Signal loadB = loads[1];
        Signal loadC = loads[2];
        Signal loadD = loads[3];
        Signal loadE = loads[4];
        Signal loadF = loads[5];
        Signal loadG = loads[6];
        Signal loadH = loads[7];

        Signal[] o1 = regs[0].input(in,loadA);
        Signal[] o2 = regs[1].input(in,loadB);
        Signal[] o3 = regs[2].input(in,loadC);
        Signal[] o4 = regs[3].input(in,loadD);
        Signal[] o5 = regs[4].input(in,loadE);
        Signal[] o6 = regs[5].input(in,loadF);
        Signal[] o7 = regs[6].input(in,loadG);
        Signal[] o8 = regs[7].input(in,loadH);
        Signal[] out = Mux8Way16.input(o1,o2,o3,o4,o5,o6,o7,o8,address);

        return out;
    }
}
