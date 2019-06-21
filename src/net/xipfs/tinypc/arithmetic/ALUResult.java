package net.xipfs.tinypc.arithmetic;

import net.xipfs.tinypc.common.Signal;

/**
 * @author xiehui
 * @version 1.0
 * <pre><b>email: </b>flexie@foxmail.com</pre>
 * <pre><b>blog: </b>https://xiehui.me</pre>
 *
 * out[16], // 16-bit output
 * zr, // 1 if (out == 0), 0 otherwise
 * ng; // 1 if (out < 0),  0 otherwise
 */
public class ALUResult {
    private Signal[] out;
    private Signal zr;
    private Signal ng;

    public Signal[] getOut() {
        return out;
    }

    public void setOut(Signal[] out) {
        this.out = out;
    }

    public Signal getZr() {
        return zr;
    }

    public void setZr(Signal zr) {
        this.zr = zr;
    }

    public Signal getNg() {
        return ng;
    }

    public void setNg(Signal ng) {
        this.ng = ng;
    }
}
