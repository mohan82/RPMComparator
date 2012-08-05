/*
 *  Copyright 2003 jRPM Team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jguild.jrpm.io.constant;


/**
 * File attributes. (e.g. RPMHeaderTag.FILEFLAGS)
 *
 * @author kuss
 */
public class RPMFileAttr implements FlagIf {
    public static final int _NONE = 0;
    public static final RPMFileAttr NONE = new RPMFileAttr(_NONE);

    /**
     * from %%config
     */
    public static final int _CONFIG = (1 << 0);
    public static final RPMFileAttr CONFIG = new RPMFileAttr(_CONFIG);

    /**
     * from %%doc
     */
    public static final int _DOC = (1 << 1);
    public static final RPMFileAttr DOC = new RPMFileAttr(_DOC);

    /**
     * from %%donotuse.
     */
    public static final int _ICON = (1 << 2);
    public static final RPMFileAttr ICON = new RPMFileAttr(_ICON);

    /**
     * from %%config(missingok)
     */
    public static final int _MISSINGOK = (1 << 3);
    public static final RPMFileAttr MISSINGOK = new RPMFileAttr(_MISSINGOK);

    /**
     * from %%config(noreplace)
     */
    public static final int _NOREPLACE = (1 << 4);
    public static final RPMFileAttr NOREPLACE = new RPMFileAttr(_NOREPLACE);

    /**
     * @todo (unnecessary) marks 1st file in srpm.
     */
    public static final int _SPECFILE = (1 << 5);
    public static final RPMFileAttr SPECFILE = new RPMFileAttr(_SPECFILE);

    /**
     * from %%ghost
     */
    public static final int _GHOST = (1 << 6);
    public static final RPMFileAttr GHOST = new RPMFileAttr(_GHOST);

    /**
     * from %%license
     */
    public static final int _LICENSE = (1 << 7);
    public static final RPMFileAttr LICENSE = new RPMFileAttr(_LICENSE);

    /**
     * from %%readme
     */
    public static final int _README = (1 << 8);
    public static final RPMFileAttr README = new RPMFileAttr(_README);

    /**
     * from %%exclude
     */
    public static final int _EXCLUDE = (1 << 9);
    public static final RPMFileAttr EXCLUDE = new RPMFileAttr(_EXCLUDE);

    /**
     * placeholder (SuSE)
     */
    public static final int _UNPATCHED = (1 << 10);
    public static final RPMFileAttr UNPATCHED = new RPMFileAttr(_UNPATCHED);

    /**
     * from %%pubkey
     */
    public static final int _PUBKEY = (1 << 11);
    public static final RPMFileAttr PUBKEY = new RPMFileAttr(_PUBKEY);
    public static final int _ALL = ~(_NONE);
    public static final RPMFileAttr ALL = new RPMFileAttr(_ALL);
    private final int flag;

    private RPMFileAttr(int flag) {
        this.flag = flag;
    }

    /*
     * @see com.jguild.jrpm.io.constant.FlagIf#value()
     */
    public int value() {
        return flag;
    }
}
