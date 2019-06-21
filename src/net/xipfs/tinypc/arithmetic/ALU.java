package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;
import me.xiehui.tinycomputer.gate.*;
import net.xipfs.tinypc.gate.And16;
import net.xipfs.tinypc.gate.Mux16;
import net.xipfs.tinypc.gate.Not;
import net.xipfs.tinypc.gate.Not16;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 * <p>Demo</p>

 * The ALU (Arithmetic Logic Unit).
 * Computes one of the following functions:
 * x+y, x-y, y-x, 0, 1, -1, x, y, -x, -y, !x, !y,
 * x+1, y+1, x-1, y-1, x&y, x|y on two 16-bit inputs,
 * according to 6 input bits denoted zx,nx,zy,ny,f,no.
 * In addition, the ALU computes two 1-bit outputs:
 * if the ALU output == 0, zr is set to 1; otherwise zr is set to 0;
 * if the ALU output < 0, ng is set to 1; otherwise ng is set to 0.
 *
 * Implementation: the ALU logic manipulates the x and y inputs
 * and operates on the resulting values, as follows:
 * if (zx == 1) set x = 0        // 16-bit constant
 * if (nx == 1) set x = !x       // bitwise not
 * if (zy == 1) set y = 0        // 16-bit constant
 * if (ny == 1) set y = !y       // bitwise not
 * if (f == 1)  set out = x + y  // integer 2's complement addition
 * if (f == 0)  set out = x & y  // bitwise and
 * if (no == 1) set out = !out   // bitwise not
 * if (out == 0) set zr = 1
 * if (out < 0) set ng = 1
 */

public class ALU {
    public static ALUResult input(
                    Signal[] x, Signal[] y, Signal zx, Signal nx,
                    Signal zy, Signal ny, Signal f, Signal no){
        ALUResult result = new ALUResult();

        // zero the x input?
        Signal[] allZero = new Signal[]{
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO
        };
        Signal[] allOne = new Signal[]{
                Signal.ONE, Signal.ONE, Signal.ONE, Signal.ONE,
                Signal.ONE, Signal.ONE, Signal.ONE, Signal.ONE,
                Signal.ONE, Signal.ONE, Signal.ONE, Signal.ONE,
                Signal.ONE, Signal.ONE, Signal.ONE, Signal.ONE
        };

        Signal[] one = new Signal[]{
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ZERO,
                Signal.ZERO, Signal.ZERO, Signal.ZERO, Signal.ONE
        };
        Signal[] xByzx = Mux16.input(x,allZero,zx);

        // negate the x input?
        Signal[] notxBYzx = Not16.input(xByzx);
        Signal[] xBYnx = Mux16.input(xByzx,notxBYzx,nx);

        // zero the y input?
        Signal[] yBYzy = Mux16.input(y,allZero,zy);

        // negate the y input?
        Signal[] notyBYzy = Not16.input(yBYzy);
        Signal[] yBYny = Mux16.input(yBYzy, notyBYzy, ny);

        // compute out = x + y (if 1) or x & y (if 0)
        Signal[] xANDy = And16.input(xBYnx,yBYny);
        Signal[] xADDy = Add16.input(xBYnx,yBYny);
        Signal[] xyBYf = Mux16.input(xANDy,xADDy,f);

        // negate the out output?
        Signal[] notxyBYf = Not16.input(xyBYf);
        Signal[] out = Mux16.input(xyBYf, notxyBYf, no);
        result.setOut(out);
        Signal[] outTOzr = new Signal[out.length];

        System.arraycopy(out,0,outTOzr,0,out.length);

        // is the output equal to zero?
        Signal zr1 = Or16Way.input(outTOzr);
        Signal zr = Not.input(zr1);

        Signal ng = IsNeg.input(outTOzr);

        result.setZr(zr);
        result.setNg(ng);

        return result;
    }

}
