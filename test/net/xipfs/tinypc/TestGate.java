package net.xipfs.tinypc;

import net.xipfs.tinypc.common.EndianModel;
import net.xipfs.tinypc.common.Signal;
import me.xiehui.tinycomputer.gate.*;
import net.xipfs.tinypc.util.CommonUtils;
import net.xipfs.tinypc.gate.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @authOr xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 */
public class TestGate {
    @Test
    public void testNand(){
        Signal out = Nand.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Nand.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
        out = Nand.input(Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Nand.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
    }

    @Test
    public void testNot(){
        Signal out = Not.input(Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Not.input(Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
    }

    @Test
    public void testNot16(){
        Signal[] in = CommonUtils.string2Signals("0000000000000000", EndianModel.Little);
        Signal[] out = Not16.input(in);
        Assertions.assertEquals("1111111111111111",CommonUtils.signals2String(out, EndianModel.Little));
    }
    @Test
    public void testAnd(){
        Signal out = And.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = And.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
        out = And.input(Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = And.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
    }

    @Test
    public void testOr(){
        Signal out = Or.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Or.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
        out = Or.input(Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Or.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
    }

    @Test
    public void testXor(){
        Signal out = Xor.input(Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Xor.input(Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
        out = Xor.input(Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Xor.input(Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
    }

    @Test
    public void testMux(){
        Signal out = Mux.input(Signal.ZERO,Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Mux.input(Signal.ZERO,Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Mux.input(Signal.ONE,Signal.ZERO,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Mux.input(Signal.ONE,Signal.ONE,Signal.ZERO);
        Assertions.assertEquals(Signal.ONE,out);
        out = Mux.input(Signal.ZERO,Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Mux.input(Signal.ZERO,Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);
        out = Mux.input(Signal.ONE,Signal.ZERO,Signal.ONE);
        Assertions.assertEquals(Signal.ZERO,out);
        out = Mux.input(Signal.ONE,Signal.ONE,Signal.ONE);
        Assertions.assertEquals(Signal.ONE,out);

    }

    @Test
    public void testMux16(){
        Signal[] a = CommonUtils.string2Signals("0000000000000000",EndianModel.Little);
        Signal[] b = CommonUtils.string2Signals("1111111111111111",EndianModel.Little);

        Signal sel= Signal.ZERO;
        Signal[] out = Mux16.input(a,b,sel);
        Assertions.assertEquals("0000000000000000", CommonUtils.signals2String(out,EndianModel.Little));

        sel= Signal.ONE;
        out = Mux16.input(a,b,sel);
        Assertions.assertEquals("1111111111111111",CommonUtils.signals2String(out,EndianModel.Little));
    }

    @Test
    public void testMux4Way16(){
        Signal[] a = CommonUtils.string2Signals("0000000000000000",EndianModel.Little);
        Signal[] b = CommonUtils.string2Signals("0000000000000001",EndianModel.Little);
        Signal[] c = CommonUtils.string2Signals("1111111111111110",EndianModel.Little);
        Signal[] d = CommonUtils.string2Signals("1111111111111111",EndianModel.Little);

        Signal[] sel= CommonUtils.string2Signals("00",EndianModel.Little);
        Signal[] out = Mux4Way16.input(a,b,c,d,sel);
        Assertions.assertEquals("0000000000000000", CommonUtils.signals2String(out,EndianModel.Little));

        sel= CommonUtils.string2Signals("01",EndianModel.Little);
        out = Mux4Way16.input(a,b,c,d,sel);
        Assertions.assertEquals("0000000000000001", CommonUtils.signals2String(out,EndianModel.Little));

        sel= CommonUtils.string2Signals("10",EndianModel.Little);
        out = Mux4Way16.input(a,b,c,d,sel);
        Assertions.assertEquals("1111111111111110", CommonUtils.signals2String(out,EndianModel.Little));

        sel= CommonUtils.string2Signals("11",EndianModel.Little);
        out = Mux4Way16.input(a,b,c,d,sel);
        Assertions.assertEquals("1111111111111111", CommonUtils.signals2String(out,EndianModel.Little));

    }


    @Test
    public void testMux8Way16(){
        Signal[] a = CommonUtils.string2Signals("0000000000000000",EndianModel.Little);
        Signal[] b = CommonUtils.string2Signals("0000000000000010",EndianModel.Little);
        Signal[] c = CommonUtils.string2Signals("0000000000000100",EndianModel.Little);
        Signal[] d = CommonUtils.string2Signals("0000000000001000",EndianModel.Little);
        Signal[] e = CommonUtils.string2Signals("0000000000010000",EndianModel.Little);
        Signal[] f = CommonUtils.string2Signals("0000000000100000",EndianModel.Little);
        Signal[] g = CommonUtils.string2Signals("0000000001000000",EndianModel.Little);
        Signal[] h = CommonUtils.string2Signals("0000000010000000",EndianModel.Little);
        Signal[] sel= CommonUtils.string2Signals("000",EndianModel.Little);

        Signal[] out = Mux8Way16.input(a,b,c,d,e,f,g,h,sel);
        Assertions.assertEquals("0000000000000000", CommonUtils.signals2String(out,EndianModel.Little));
    }


    @Test
    public void testDMux(){
        Signal in = Signal.ONE;
        Signal sel = Signal.ZERO;
        Signal[] out = DMux.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ONE);
        Assertions.assertEquals(out[1],Signal.ZERO);
        in = Signal.ZERO;
        sel = Signal.ZERO;
        out = DMux.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        in = Signal.ONE;
        sel = Signal.ONE;
        out = DMux.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ONE);
        in = Signal.ZERO;
        sel = Signal.ONE;
        out = DMux.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
    }

    @Test
    public void testDMux4Way(){
        Signal in = Signal.ONE;
        Signal[] sel = CommonUtils.string2Signals("00",EndianModel.Little);
        Signal[] out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ONE);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("01",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ONE);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("10",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ONE);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("11",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ONE);

        in = Signal.ZERO;
        sel = CommonUtils.string2Signals("00",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("01",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("10",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);

        sel = CommonUtils.string2Signals("11",EndianModel.Little);
        out = DMux4Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
    }

    @Test
    public void testDMux8Way(){
        Signal in = Signal.ONE;
        Signal[] sel = CommonUtils.string2Signals("000",EndianModel.Little); // 000
        Signal[] out = DMux8Way.input(in,sel);
        System.out.println(out);
        Assertions.assertEquals(out[0],Signal.ONE);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("001",EndianModel.Little); // 001
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ONE);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);


        sel = CommonUtils.string2Signals("010",EndianModel.Little);// 010
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ONE);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("011",EndianModel.Little); //011
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ONE);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("100",EndianModel.Little); //100
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ONE);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("101",EndianModel.Little); //101
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ONE);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("110",EndianModel.Little);//110
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ONE);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("111",EndianModel.Little); //111
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ONE);


        in = Signal.ZERO;
        sel = CommonUtils.string2Signals("000",EndianModel.Little);; // 000
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);


        sel = CommonUtils.string2Signals("001",EndianModel.Little);// 001
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("010",EndianModel.Little); // 010
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("011",EndianModel.Little); // 011
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("100",EndianModel.Little); // 100
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("101",EndianModel.Little); // 101
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("110",EndianModel.Little); // 110
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);

        sel = CommonUtils.string2Signals("111",EndianModel.Little); // 111
        out = DMux8Way.input(in,sel);
        Assertions.assertEquals(out[0],Signal.ZERO);
        Assertions.assertEquals(out[1],Signal.ZERO);
        Assertions.assertEquals(out[2],Signal.ZERO);
        Assertions.assertEquals(out[3],Signal.ZERO);
        Assertions.assertEquals(out[4],Signal.ZERO);
        Assertions.assertEquals(out[5],Signal.ZERO);
        Assertions.assertEquals(out[6],Signal.ZERO);
        Assertions.assertEquals(out[7],Signal.ZERO);
    }
}
