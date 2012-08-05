package org.rpmcompartor.data;

import com.jguild.jrpm.io.Header;
import com.jguild.jrpm.io.RPMLead;
import com.jguild.jrpm.io.Store;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 2:44 PM
 * An abstraction class which encapsulates all jrpm required
 * header classes
 */
public class RPMFileHeaderData implements Serializable {
    private static final long serialVersionUID = -3788013453757317115L;
    private Header header;
    private RPMLead lead;
    private Header signature;
    private Store store;

    public RPMFileHeaderData(Header header, RPMLead rpmLead, Header signature, Store store) {
        this.header = header;
        this.lead = rpmLead;
        this.signature = signature;
        this.store = store;
    }

    public Header getHeader() {
        return header;
    }

    public RPMLead getLead() {
        return lead;
    }

    public Store getStore() {
        return store;
    }

    public Header getSignature() {
        return signature;
    }
}
