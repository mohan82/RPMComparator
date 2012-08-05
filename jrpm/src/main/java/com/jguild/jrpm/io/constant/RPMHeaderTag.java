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
 * Constants for tags.
 *
 * @version $Id: RPMHeaderTag.java,v 1.4 2004/05/06 20:59:24 mkuss Exp $
 */
public final class RPMHeaderTag implements EnumIf {
    public static final RPMHeaderTag UNKNOWN = new RPMHeaderTag(_UNKNOWN,
            "UNKNOWN");

    public static final int _HEADERIMAGE = 61;

    public static final RPMHeaderTag HEADERIMAGE = new RPMHeaderTag(
            _HEADERIMAGE, "HEADERIMAGE");

    public static final int _HEADERSIGNATURES = 62;

    public static final RPMHeaderTag HEADERSIGNATURES = new RPMHeaderTag(
            _HEADERSIGNATURES, "HEADERSIGNATURES");

    public static final int _HEADERIMMUTABLE = 63;

    public static final RPMHeaderTag HEADERIMMUTABLE = new RPMHeaderTag(
            _HEADERIMMUTABLE, "HEADERIMMUTABLE");

    public static final int _HEADERREGIONS = 64;

    public static final RPMHeaderTag HEADERREGIONS = new RPMHeaderTag(
            _HEADERREGIONS, "HEADERREGIONS");

    public static final int _HEADERI18NTABLE = 100;

    public static final RPMHeaderTag HEADERI18NTABLE = new RPMHeaderTag(
            _HEADERI18NTABLE, "HEADERI18NTABLE");

    public static final int _SIG_BASE = 256;

    public static final RPMHeaderTag SIG_BASE = new RPMHeaderTag(_SIG_BASE,
            "SIG_BASE");

    public static final int _SIGSIZE = _SIG_BASE + 1;

    public static final RPMHeaderTag SIGSIZE = new RPMHeaderTag(_SIGSIZE,
            "SIGSIZE");

    public static final int _SIGLEMD5_1 = _SIG_BASE + 2;

    public static final RPMHeaderTag SIGLEMD5_1 = new RPMHeaderTag(_SIGLEMD5_1,
            "SIGLEMD5_1");

    public static final int _SIGPGP = _SIG_BASE + 3;

    public static final RPMHeaderTag SIGPGP = new RPMHeaderTag(_SIGPGP,
            "SIGPGP");

    public static final int _SIGLEMD5_2 = _SIG_BASE + 4;

    public static final RPMHeaderTag SIGLEMD5_2 = new RPMHeaderTag(_SIGLEMD5_2,
            "SIGLEMD5_2");

    public static final int _SIGMD5 = _SIG_BASE + 5;

    public static final RPMHeaderTag SIGMD5 = new RPMHeaderTag(_SIGMD5,
            "SIGMD5");

    public static final RPMHeaderTag PKGID = new RPMHeaderTag(_SIGMD5, "PKGID");

    public static final int _SIGGPG = _SIG_BASE + 6;

    public static final RPMHeaderTag SIGGPG = new RPMHeaderTag(_SIGGPG,
            "SIGGPG");

    public static final int _SIGPGP5 = _SIG_BASE + 7;

    public static final RPMHeaderTag SIGPGP5 = new RPMHeaderTag(_SIGPGP5,
            "SIGPGP5");

    public static final int _BADSHA1_1 = _SIG_BASE + 8;

    public static final RPMHeaderTag BADSHA1_1 = new RPMHeaderTag(_BADSHA1_1,
            "BADSHA1_1");

    public static final int _BADSHA1_2 = _SIG_BASE + 9;

    public static final RPMHeaderTag BADSHA1_2 = new RPMHeaderTag(_BADSHA1_2,
            "BADSHA1_2");

    public static final int _PUBKEYS = _SIG_BASE + 10;

    public static final RPMHeaderTag PUBKEYS = new RPMHeaderTag(_PUBKEYS,
            "PUBKEYS");

    public static final int _DSAHEADER = _SIG_BASE + 11;

    public static final RPMHeaderTag DSAHEADER = new RPMHeaderTag(_DSAHEADER,
            "DSAHEADER");

    public static final int _RSAHEADER = _SIG_BASE + 12;

    public static final RPMHeaderTag RSAHEADER = new RPMHeaderTag(_RSAHEADER,
            "RSAHEADER");

    public static final int _SHA1HEADER = _SIG_BASE + 13;

    public static final RPMHeaderTag SHA1HEADER = new RPMHeaderTag(_SHA1HEADER,
            "SHA1HEADER");

    public static final RPMHeaderTag HDRID = new RPMHeaderTag(_SHA1HEADER,
            "HDRID");

    public static final int _NAME = 1000;

    public static final RPMHeaderTag NAME = new RPMHeaderTag(_NAME, "NAME");

    public static final RPMHeaderTag N = new RPMHeaderTag(_NAME, "N");

    public static final int _VERSION = 1001;

    public static final RPMHeaderTag VERSION = new RPMHeaderTag(_VERSION,
            "VERSION");

    public static final RPMHeaderTag V = new RPMHeaderTag(_VERSION, "V");

    public static final int _RELEASE = 1002;

    public static final RPMHeaderTag RELEASE = new RPMHeaderTag(_RELEASE,
            "RELEASE");

    public static final RPMHeaderTag R = new RPMHeaderTag(_RELEASE, "R");

    public static final int _EPOCH = 1003;

    public static final RPMHeaderTag EPOCH = new RPMHeaderTag(_EPOCH, "EPOCH");

    public static final RPMHeaderTag E = new RPMHeaderTag(_EPOCH, "E");

    /* backward comaptibility */
    public static final RPMHeaderTag SERIAL = new RPMHeaderTag(_EPOCH, "SERIAL");

    public static final int _SUMMARY = 1004;

    public static final RPMHeaderTag SUMMARY = new RPMHeaderTag(_SUMMARY,
            "SUMMARY");

    public static final int _DESCRIPTION = 1005;

    public static final RPMHeaderTag DESCRIPTION = new RPMHeaderTag(
            _DESCRIPTION, "DESCRIPTION");

    public static final int _BUILDTIME = 1006;

    public static final RPMHeaderTag BUILDTIME = new RPMHeaderTag(_BUILDTIME,
            "BUILDTIME");

    public static final int _BUILDHOST = 1007;

    public static final RPMHeaderTag BUILDHOST = new RPMHeaderTag(_BUILDHOST,
            "BUILDHOST");

    public static final int _INSTALLTIME = 1008;

    public static final RPMHeaderTag INSTALLTIME = new RPMHeaderTag(
            _INSTALLTIME, "INSTALLTIME");

    public static final int _SIZE = 1009;

    public static final RPMHeaderTag SIZE = new RPMHeaderTag(_SIZE, "SIZE");

    public static final int _DISTRIBUTION = 1010;

    public static final RPMHeaderTag DISTRIBUTION = new RPMHeaderTag(
            _DISTRIBUTION, "DISTRIBUTION");

    public static final int _VENDOR = 1011;

    public static final RPMHeaderTag VENDOR = new RPMHeaderTag(_VENDOR,
            "VENDOR");

    public static final int _GIF = 1012;

    public static final RPMHeaderTag GIF = new RPMHeaderTag(_GIF, "GIF");

    public static final int _XPM = 1013;

    public static final RPMHeaderTag XPM = new RPMHeaderTag(_XPM, "XPM");

    public static final int _LICENSE = 1014;

    public static final RPMHeaderTag LICENSE = new RPMHeaderTag(_LICENSE,
            "LICENSE");

    /* backward comaptibility */
    public static final RPMHeaderTag COPYRIGHT = new RPMHeaderTag(_LICENSE,
            "COPYRIGHT");

    public static final int _PACKAGER = 1015;

    public static final RPMHeaderTag PACKAGER = new RPMHeaderTag(_PACKAGER,
            "PACKAGER");

    public static final int _GROUP = 1016;

    public static final RPMHeaderTag GROUP = new RPMHeaderTag(_GROUP, "GROUP");

    public static final int _CHANGELOG = 1017;

    public static final RPMHeaderTag CHANGELOG = new RPMHeaderTag(_CHANGELOG,
            "CHANGELOG");

    public static final int _SOURCE = 1018;

    public static final RPMHeaderTag SOURCE = new RPMHeaderTag(_SOURCE,
            "SOURCE");

    public static final int _PATCH = 1019;

    public static final RPMHeaderTag PATCH = new RPMHeaderTag(_PATCH, "PATCH");

    public static final int _URL = 1020;

    public static final RPMHeaderTag URL = new RPMHeaderTag(_URL, "URL");

    public static final int _OS = 1021;

    public static final RPMHeaderTag OS = new RPMHeaderTag(_OS, "OS");

    public static final int _ARCH = 1022;

    public static final RPMHeaderTag ARCH = new RPMHeaderTag(_ARCH, "ARCH");

    public static final int _PREIN = 1023;

    public static final RPMHeaderTag PREIN = new RPMHeaderTag(_PREIN, "PREIN");

    public static final int _POSTIN = 1024;

    public static final RPMHeaderTag POSTIN = new RPMHeaderTag(_POSTIN,
            "POSTIN");

    public static final int _PREUN = 1025;

    public static final RPMHeaderTag PREUN = new RPMHeaderTag(_PREUN, "PREUN");

    public static final int _POSTUN = 1026;

    public static final RPMHeaderTag POSTUN = new RPMHeaderTag(_POSTUN,
            "POSTUN");

    public static final int _OLDFILENAMES = 1027;

    public static final RPMHeaderTag OLDFILENAMES = new RPMHeaderTag(
            _OLDFILENAMES, "OLDFILENAMES");

    public static final int _FILESIZES = 1028;

    public static final RPMHeaderTag FILESIZES = new RPMHeaderTag(_FILESIZES,
            "FILESIZES");

    public static final int _FILESTATES = 1029;

    public static final RPMHeaderTag FILESTATES = new RPMHeaderTag(_FILESTATES,
            "FILESTATES");

    public static final int _FILEMODES = 1030;

    public static final RPMHeaderTag FILEMODES = new RPMHeaderTag(_FILEMODES,
            "FILEMODES");

    public static final int _FILEUIDS = 1031;

    public static final RPMHeaderTag FILEUIDS = new RPMHeaderTag(_FILEUIDS,
            "FILEUIDS");

    public static final int _FILEGIDS = 1032;

    public static final RPMHeaderTag FILEGIDS = new RPMHeaderTag(_FILEGIDS,
            "FILEGIDS");

    public static final int _FILERDEVS = 1033;

    public static final RPMHeaderTag FILERDEVS = new RPMHeaderTag(_FILERDEVS,
            "FILERDEVS");

    public static final int _FILEMTIMES = 1034;

    public static final RPMHeaderTag FILEMTIMES = new RPMHeaderTag(_FILEMTIMES,
            "FILEMTIMES");

    public static final int _FILEMD5S = 1035;

    public static final RPMHeaderTag FILEMD5S = new RPMHeaderTag(_FILEMD5S,
            "FILEMD5S");

    public static final int _FILELINKTOS = 1036;

    public static final RPMHeaderTag FILELINKTOS = new RPMHeaderTag(
            _FILELINKTOS, "FILELINKTOS");

    public static final int _FILEFLAGS = 1037;

    public static final RPMHeaderTag FILEFLAGS = new RPMHeaderTag(_FILEFLAGS,
            "FILEFLAGS");

    public static final int _ROOT = 1038;

    public static final RPMHeaderTag ROOT = new RPMHeaderTag(_ROOT, "ROOT");

    public static final int _FILEUSERNAME = 1039;

    public static final RPMHeaderTag FILEUSERNAME = new RPMHeaderTag(
            _FILEUSERNAME, "FILEUSERNAME");

    public static final int _FILEGROUPNAME = 1040;

    public static final RPMHeaderTag FILEGROUPNAME = new RPMHeaderTag(
            _FILEGROUPNAME, "FILEGROUPNAME");

    public static final int _EXCLUDE = 1041;

    public static final RPMHeaderTag EXCLUDE = new RPMHeaderTag(_EXCLUDE,
            "EXCLUDE");

    public static final int _EXCLUSIVE = 1042;

    public static final RPMHeaderTag EXCLUSIVE = new RPMHeaderTag(_EXCLUSIVE,
            "EXCLUSIVE");

    public static final int _ICON = 1043;

    public static final RPMHeaderTag ICON = new RPMHeaderTag(_ICON, "ICON");

    public static final int _SOURCERPM = 1044;

    public static final RPMHeaderTag SOURCERPM = new RPMHeaderTag(_SOURCERPM,
            "SOURCERPM");

    public static final int _FILEVERIFYFLAGS = 1045;

    public static final RPMHeaderTag FILEVERIFYFLAGS = new RPMHeaderTag(
            _FILEVERIFYFLAGS, "FILEVERIFYFLAGS");

    public static final int _ARCHIVESIZE = 1046;

    public static final RPMHeaderTag ARCHIVESIZE = new RPMHeaderTag(
            _ARCHIVESIZE, "ARCHIVESIZE");

    public static final int _PROVIDENAME = 1047;

    public static final RPMHeaderTag PROVIDENAME = new RPMHeaderTag(
            _PROVIDENAME, "PROVIDENAME");

    /* backward comaptibility */
    public static final RPMHeaderTag PROVIDES = new RPMHeaderTag(_PROVIDENAME,
            "PROVIDES");

    public static final int _REQUIREFLAGS = 1048;

    public static final RPMHeaderTag REQUIREFLAGS = new RPMHeaderTag(
            _REQUIREFLAGS, "REQUIREFLAGS");

    public static final int _REQUIRENAME = 1049;

    public static final RPMHeaderTag REQUIRENAME = new RPMHeaderTag(
            _REQUIRENAME, "REQUIRENAME");

    public static final int _REQUIREVERSION = 1050;

    public static final RPMHeaderTag REQUIREVERSION = new RPMHeaderTag(
            _REQUIREVERSION, "REQUIREVERSION");

    public static final int _NOSOURCE = 1051;

    public static final RPMHeaderTag NOSOURCE = new RPMHeaderTag(_NOSOURCE,
            "NOSOURCE");

    public static final int _NOPATCH = 1052;

    public static final RPMHeaderTag NOPATCH = new RPMHeaderTag(_NOPATCH,
            "NOPATCH");

    public static final int _CONFLICTFLAGS = 1053;

    public static final RPMHeaderTag CONFLICTFLAGS = new RPMHeaderTag(
            _CONFLICTFLAGS, "CONFLICTFLAGS");

    public static final int _CONFLICTNAME = 1054;

    public static final RPMHeaderTag CONFLICTNAME = new RPMHeaderTag(
            _CONFLICTNAME, "CONFLICTNAME");

    public static final int _CONFLICTVERSION = 1055;

    public static final RPMHeaderTag CONFLICTVERSION = new RPMHeaderTag(
            _CONFLICTVERSION, "CONFLICTVERSION");

    public static final int _DEFAULTPREFIX = 1056;

    public static final RPMHeaderTag DEFAULTPREFIX = new RPMHeaderTag(
            _DEFAULTPREFIX, "DEFAULTPREFIX");

    public static final int _BUILDROOT = 1057;

    public static final RPMHeaderTag BUILDROOT = new RPMHeaderTag(_BUILDROOT,
            "BUILDROOT");

    public static final int _INSTALLPREFIX = 1058;

    public static final RPMHeaderTag INSTALLPREFIX = new RPMHeaderTag(
            _INSTALLPREFIX, "INSTALLPREFIX");

    public static final int _EXCLUDEARCH = 1059;

    public static final RPMHeaderTag EXCLUDEARCH = new RPMHeaderTag(
            _EXCLUDEARCH, "EXCLUDEARCH");

    public static final int _EXCLUDEOS = 1060;

    public static final RPMHeaderTag EXCLUDEOS = new RPMHeaderTag(_EXCLUDEOS,
            "EXCLUDEOS");

    public static final int _EXCLUSIVEARCH = 1061;

    public static final RPMHeaderTag EXCLUSIVEARCH = new RPMHeaderTag(
            _EXCLUSIVEARCH, "EXCLUSIVEARCH");

    public static final int _EXCLUSIVEOS = 1062;

    public static final RPMHeaderTag EXCLUSIVEOS = new RPMHeaderTag(
            _EXCLUSIVEOS, "EXCLUSIVEOS");

    public static final int _AUTOREQPROV = 1063;

    public static final RPMHeaderTag AUTOREQPROV = new RPMHeaderTag(
            _AUTOREQPROV, "AUTOREQPROV");

    public static final int _RPMVERSION = 1064;

    public static final RPMHeaderTag RPMVERSION = new RPMHeaderTag(_RPMVERSION,
            "RPMVERSION");

    public static final int _TRIGGERSCRIPTS = 1065;

    public static final RPMHeaderTag TRIGGERSCRIPT = new RPMHeaderTag(
            _TRIGGERSCRIPTS, "TRIGGERSCRIPTS");

    public static final int _TRIGGERNAME = 1066;

    public static final RPMHeaderTag TRIGGERNAME = new RPMHeaderTag(
            _TRIGGERNAME, "TRIGGERNAME");

    public static final int _TRIGGERVERSION = 1067;

    public static final RPMHeaderTag TRIGGERVERSION = new RPMHeaderTag(
            _TRIGGERVERSION, "TRIGGERVERSION");

    public static final int _TRIGGERFLAGS = 1068;

    public static final RPMHeaderTag TRIGGERFLAGS = new RPMHeaderTag(
            _TRIGGERFLAGS, "TRIGGERFLAGS");

    public static final int _TRIGGERINDEX = 1069;

    public static final RPMHeaderTag TRIGGERINDEX = new RPMHeaderTag(
            _TRIGGERINDEX, "TRIGGERINDEX");

    public static final int _VERIFYSCRIPT = 1079;

    public static final RPMHeaderTag VERIFYSCRIPT = new RPMHeaderTag(
            _VERIFYSCRIPT, "VERIFYSCRIPT");

    public static final int _CHANGELOGTIME = 1080;

    public static final RPMHeaderTag CHANGELOGTIME = new RPMHeaderTag(
            _CHANGELOGTIME, "CHANGELOGTIME");

    public static final int _CHANGELOGNAME = 1081;

    public static final RPMHeaderTag CHANGELOGNAME = new RPMHeaderTag(
            _CHANGELOGNAME, "CHANGELOGNAME");

    public static final int _CHANGELOGTEXT = 1082;

    public static final RPMHeaderTag CHANGELOGTEXT = new RPMHeaderTag(
            _CHANGELOGTEXT, "CHANGELOGTEXT");

    public static final int _BROKENMD5 = 1083;

    public static final RPMHeaderTag BROKENMD5 = new RPMHeaderTag(_BROKENMD5,
            "BROKENMD5");

    public static final int _PREREQ = 1084;

    public static final RPMHeaderTag PREREQ = new RPMHeaderTag(_PREREQ,
            "PREREQ");

    public static final int _PREINPROG = 1085;

    public static final RPMHeaderTag PREINPROG = new RPMHeaderTag(_PREINPROG,
            "PREINPROG");

    public static final int _POSTINPROG = 1086;

    public static final RPMHeaderTag POSTINPROG = new RPMHeaderTag(_POSTINPROG,
            "POSTINPROG");

    public static final int _PREUNPROG = 1087;

    public static final RPMHeaderTag PREUNPROG = new RPMHeaderTag(_PREUNPROG,
            "PREUNPROG");

    public static final int _POSTUNPROG = 1088;

    public static final RPMHeaderTag POSTUNPROG = new RPMHeaderTag(_POSTUNPROG,
            "POSTUNPROG");

    public static final int _BUILDARCHS = 1089;

    public static final RPMHeaderTag BUILDARCHS = new RPMHeaderTag(_BUILDARCHS,
            "BUILDARCHS");

    public static final int _OBSOLETENAME = 1090;

    public static final RPMHeaderTag OBSOLETENAME = new RPMHeaderTag(
            _OBSOLETENAME, "OBSOLETENAME");

    /* backward comaptibility */
    public static final RPMHeaderTag OBSOLETES = new RPMHeaderTag(
            _OBSOLETENAME, "OBSOLETES");

    public static final int _VERIFYSCRIPTPROG = 1091;

    public static final RPMHeaderTag VERIFYSCRIPTPROG = new RPMHeaderTag(
            _VERIFYSCRIPTPROG, "VERIFYSCRIPTPROG");

    public static final int _TRIGGERSCRIPTPROG = 1092;

    public static final RPMHeaderTag TRIGGERSCRIPTPROG = new RPMHeaderTag(
            _TRIGGERSCRIPTPROG, "TRIGGERSCRIPTPROG");

    public static final int _DOCDIR = 1093;

    public static final RPMHeaderTag DOCDIR = new RPMHeaderTag(_DOCDIR,
            "DOCDIR");

    public static final int _COOKIE = 1094;

    public static final RPMHeaderTag COOKIE = new RPMHeaderTag(_COOKIE,
            "COOKIE");

    public static final int _FILEDEVICES = 1095;

    public static final RPMHeaderTag FILEDEVICES = new RPMHeaderTag(
            _FILEDEVICES, "FILEDEVICES");

    public static final int _FILEINODES = 1096;

    public static final RPMHeaderTag FILEINODES = new RPMHeaderTag(_FILEINODES,
            "FILEINODES");

    public static final int _FILELANGS = 1097;

    public static final RPMHeaderTag FILELANGS = new RPMHeaderTag(_FILELANGS,
            "FILELANGS");

    public static final int _PREFIXES = 1098;

    public static final RPMHeaderTag PREFIXES = new RPMHeaderTag(_PREFIXES,
            "PREFIXES");

    public static final int _INSTPREFIXES = 1099;

    public static final RPMHeaderTag INSTPREFIXES = new RPMHeaderTag(
            _INSTPREFIXES, "INSTPREFIXES");

    public static final int _TRIGGERIN = 1100;

    public static final RPMHeaderTag TRIGGERIN = new RPMHeaderTag(_TRIGGERIN,
            "TRIGGERIN");

    public static final int _TRIGGERUN = 1101;

    public static final RPMHeaderTag TRIGGERUN = new RPMHeaderTag(_TRIGGERUN,
            "TRIGGERUN");

    public static final int _TRIGGERPOSTUN = 1102;

    public static final RPMHeaderTag TRIGGERPOSTUN = new RPMHeaderTag(
            _TRIGGERPOSTUN, "TRIGGERPOSTUN");

    public static final int _AUTOREQ = 1103;

    public static final RPMHeaderTag AUTOREQ = new RPMHeaderTag(_AUTOREQ,
            "AUTOREQ");

    public static final int _AUTOPROV = 1104;

    public static final RPMHeaderTag AUTOPROV = new RPMHeaderTag(_AUTOPROV,
            "AUTOPROV");

    public static final int _CAPABILITY = 1105;

    public static final RPMHeaderTag CAPABILITY = new RPMHeaderTag(_CAPABILITY,
            "CAPABILITY");

    public static final int _SOURCEPACKAGE = 1106;

    public static final RPMHeaderTag SOURCEPACKAGE = new RPMHeaderTag(
            _SOURCEPACKAGE, "SOURCEPACKAGE");

    public static final int _OLDORIGFILENAMES = 1107;

    public static final RPMHeaderTag OLDORIGFILENAMES = new RPMHeaderTag(
            _OLDORIGFILENAMES, "OLDORIGFILENAMES");

    public static final int _BUILDPREREQ = 1108;

    public static final RPMHeaderTag BUILDPREREQ = new RPMHeaderTag(
            _BUILDPREREQ, "BUILDPREREQ");

    public static final int _BUILDREQUIRES = 1109;

    public static final RPMHeaderTag BUILDREQUIRES = new RPMHeaderTag(
            _BUILDREQUIRES, "BUILDREQUIRES");

    public static final int _BUILDCONFLICTS = 1110;

    public static final RPMHeaderTag BUILDCONFLICTS = new RPMHeaderTag(
            _BUILDCONFLICTS, "BUILDCONFLICTS");

    public static final int _BUILDMACROS = 1111;

    public static final RPMHeaderTag BUILDMACROS = new RPMHeaderTag(
            _BUILDMACROS, "BUILDMACROS");

    public static final int _PROVIDEFLAGS = 1112;

    public static final RPMHeaderTag PROVIDEFLAGS = new RPMHeaderTag(
            _PROVIDEFLAGS, "PROVIDEFLAGS");

    public static final int _PROVIDEVERSION = 1113;

    public static final RPMHeaderTag PROVIDEVERSION = new RPMHeaderTag(
            _PROVIDEVERSION, "PROVIDEVERSION");

    public static final int _OBSOLETEFLAGS = 1114;

    public static final RPMHeaderTag OBSOLETEFLAGS = new RPMHeaderTag(
            _OBSOLETEFLAGS, "OBSOLETEFLAGS");

    public static final int _OBSOLETEVERSION = 1115;

    public static final RPMHeaderTag OBSOLETEVERSION = new RPMHeaderTag(
            _OBSOLETEVERSION, "OBSOLETEVERSION");

    public static final int _DIRINDEXES = 1116;

    public static final RPMHeaderTag DIRINDEXES = new RPMHeaderTag(_DIRINDEXES,
            "DIRINDEXES");

    public static final int _BASENAMES = 1117;

    public static final RPMHeaderTag BASENAMES = new RPMHeaderTag(_BASENAMES,
            "BASENAMES");

    public static final int _DIRNAMES = 1118;

    public static final RPMHeaderTag DIRNAMES = new RPMHeaderTag(_DIRNAMES,
            "DIRNAMES");

    public static final int _ORIGDIRINDEXES = 1119;

    public static final RPMHeaderTag ORIGDIRINDEXES = new RPMHeaderTag(
            _ORIGDIRINDEXES, "ORIGDIRINDEXES");

    public static final int _ORIGBASENAMES = 1120;

    public static final RPMHeaderTag ORIGBASENAMES = new RPMHeaderTag(
            _ORIGBASENAMES, "ORIGBASENAMES");

    public static final int _ORIGDIRNAMES = 1121;

    public static final RPMHeaderTag ORIGDIRNAMES = new RPMHeaderTag(
            _ORIGDIRNAMES, "ORIGDIRNAMES");

    public static final int _OPTFLAGS = 1122;

    public static final RPMHeaderTag OPTFLAGS = new RPMHeaderTag(_OPTFLAGS,
            "OPTFLAGS");

    public static final int _DISTURL = 1123;

    public static final RPMHeaderTag DISTURL = new RPMHeaderTag(_DISTURL,
            "DISTURL");

    public static final int _PAYLOADFORMAT = 1124;

    public static final RPMHeaderTag PAYLOADFORMAT = new RPMHeaderTag(
            _PAYLOADFORMAT, "PAYLOADFORMAT");

    public static final int _PAYLOADCOMPRESSOR = 1125;

    public static final RPMHeaderTag PAYLOADCOMPRESSOR = new RPMHeaderTag(
            _PAYLOADCOMPRESSOR, "PAYLOADCOMPRESSOR");

    public static final int _PAYLOADFLAGS = 1126;

    public static final RPMHeaderTag PAYLOADFLAGS = new RPMHeaderTag(
            _PAYLOADFLAGS, "PAYLOADFLAGS");

    public static final int _INSTALLCOLOR = 1127;

    public static final RPMHeaderTag INSTALLCOLOR = new RPMHeaderTag(
            _INSTALLCOLOR, "INSTALLCOLOR");

    public static final int _INSTALLTID = 1128;

    public static final RPMHeaderTag INSTALLTID = new RPMHeaderTag(_INSTALLTID,
            "INSTALLTID");

    public static final int _REMOVETID = 1129;

    public static final RPMHeaderTag REMOVETID = new RPMHeaderTag(_REMOVETID,
            "REMOVETID");

    public static final int _SHA1RHN = 1130;

    public static final RPMHeaderTag SHA1RHN = new RPMHeaderTag(_SHA1RHN,
            "SHA1RHN");

    public static final int _RHNPLATFORM = 1131;

    public static final RPMHeaderTag RHNPLATFORM = new RPMHeaderTag(
            _RHNPLATFORM, "RHNPLATFORM");

    public static final int _PLATFORM = 1132;

    public static final RPMHeaderTag PLATFORM = new RPMHeaderTag(_PLATFORM,
            "PLATFORM");

    public static final int _PATCHESNAME = 1133;

    public static final RPMHeaderTag PATCHESNAME = new RPMHeaderTag(
            _PATCHESNAME, "PATCHESNAME");

    public static final int _PATCHESFLAGS = 1134;

    public static final RPMHeaderTag PATCHESFLAGS = new RPMHeaderTag(
            _PATCHESFLAGS, "PATCHESFLAGS");

    public static final int _PATCHESVERSION = 1135;

    public static final RPMHeaderTag PATCHESVERSION = new RPMHeaderTag(
            _PATCHESVERSION, "PATCHESVERSION");

    public static final int _CACHECTIME = 1136;

    public static final RPMHeaderTag CACHECTIME = new RPMHeaderTag(_CACHECTIME,
            "CACHECTIME");

    public static final int _CACHEPKGPATH = 1137;

    public static final RPMHeaderTag CACHEPKGPATH = new RPMHeaderTag(
            _CACHEPKGPATH, "CACHEPKGPATH");

    public static final int _CACHEPKGSIZE = 1138;

    public static final RPMHeaderTag CACHEPKGSIZE = new RPMHeaderTag(
            _CACHEPKGSIZE, "CACHEPKGSIZE");

    public static final int _CACHEPKGMTIME = 1139;

    public static final RPMHeaderTag CACHEPKGMTIME = new RPMHeaderTag(
            _CACHEPKGMTIME, "CACHEPKGMTIME");

    public static final int _FILECOLORS = 1140;

    public static final RPMHeaderTag FILECOLORS = new RPMHeaderTag(_FILECOLORS,
            "FILECOLORS");

    public static final int _FILECLASS = 1141;

    public static final RPMHeaderTag FILECLASS = new RPMHeaderTag(_FILECLASS,
            "FILECLASS");

    public static final int _CLASSDICT = 1142;

    public static final RPMHeaderTag CLASSDICT = new RPMHeaderTag(_CLASSDICT,
            "CLASSDICT");

    public static final int _FILEDEPENDSX = 1143;

    public static final RPMHeaderTag FILEDEPENDSX = new RPMHeaderTag(
            _FILEDEPENDSX, "FILEDEPENDSX");

    public static final int _FILEDEPENDSN = 1144;

    public static final RPMHeaderTag FILEDEPENDSN = new RPMHeaderTag(
            _FILEDEPENDSN, "FILEDEPENDSN");

    public static final int _DEPENDSDICT = 1145;

    public static final RPMHeaderTag DEPENDSDICT = new RPMHeaderTag(
            _DEPENDSDICT, "DEPENDSDICT");

    public static final int _SOURCEPKGID = 1146;

    public static final RPMHeaderTag SOURCEPKGID = new RPMHeaderTag(
            _SOURCEPKGID, "SOURCEPKGID");

    public static final int _FILECONTEXTS = 1147;

    public static final RPMHeaderTag FILECONTEXTS = new RPMHeaderTag(
            _FILECONTEXTS, "FILECONTEXTS");

    public static final int _FSCONTEXTS = 1148;

    public static final RPMHeaderTag FSCONTEXTS = new RPMHeaderTag(_FSCONTEXTS,
            "FSCONTEXTS");

    public static final int _RECONTEXTS = 1149;

    public static final RPMHeaderTag RECONTEXTS = new RPMHeaderTag(_RECONTEXTS,
            "RECONTEXTS");

    public static final int _POLICIES = 1150;

    public static final RPMHeaderTag POLICIES = new RPMHeaderTag(_POLICIES,
            "POLICIES");

    public static final int _PRETRANS = 1151;

    public static final RPMHeaderTag PRETRANS = new RPMHeaderTag(_PRETRANS,
            "PRETRANS");

    public static final int _POSTTRANS = 1152;

    public static final RPMHeaderTag POSTTRANS = new RPMHeaderTag(_POSTTRANS,
            "POSTTRANS");

    public static final int _PRETRANSPROG = 1153;

    public static final RPMHeaderTag PRETRANSPROG = new RPMHeaderTag(
            _PRETRANSPROG, "PRETRANSPROG");

    public static final int _POSTTRANSPROG = 1154;

    public static final RPMHeaderTag POSTTRANSPROG = new RPMHeaderTag(
            _POSTTRANSPROG, "POSTTRANSPROG");

    public static final int _DISTTAG = 1155;

    public static final RPMHeaderTag DISTTAG = new RPMHeaderTag(_DISTTAG,
            "DISTTAG");

    public static final int _SUGGESTSNAME = 1156;

    public static final RPMHeaderTag SUGGESTSNAME = new RPMHeaderTag(
            _SUGGESTSNAME, "SUGGESTSNAME");

    public static final RPMHeaderTag SUGGESTS = new RPMHeaderTag(_SUGGESTSNAME,
            "SUGGESTS");

    public static final int _SUGGESTSVERSION = 1157;

    public static final RPMHeaderTag SUGGESTSVERSION = new RPMHeaderTag(
            _SUGGESTSVERSION, "SUGGESTSVERSION");

    public static final int _SUGGESTSFLAGS = 1158;

    public static final RPMHeaderTag SUGGESTSFLAGS = new RPMHeaderTag(
            _SUGGESTSFLAGS, "SUGGESTSFLAGS");

    public static final int _ENHANCESNAME = 1159;

    public static final RPMHeaderTag ENHANCESNAME = new RPMHeaderTag(
            _ENHANCESNAME, "ENHANCESNAME");

    public static final RPMHeaderTag ENHANCES = new RPMHeaderTag(_ENHANCESNAME,
            "ENHANCES");

    public static final int _ENHANCESVERSION = 1160;

    public static final RPMHeaderTag ENHANCESVERSION = new RPMHeaderTag(
            _ENHANCESVERSION, "ENHANCESVERSION");

    public static final int _ENHANCESFLAGS = 1161;

    public static final RPMHeaderTag ENHANCESFLAGS = new RPMHeaderTag(
            _ENHANCESFLAGS, "ENHANCESFLAGS");

    public static final int _PRIORITY = 1162;

    public static final RPMHeaderTag PRIORITY = new RPMHeaderTag(_PRIORITY,
            "PRIORITY");

    public static final int _CVSID = 1163;

    public static final RPMHeaderTag CVSID = new RPMHeaderTag(_CVSID, "CVSID");

    public static final RPMHeaderTag SVNID = new RPMHeaderTag(_CVSID, "SVNID");

    public static final int _BLINKPKGID = 1164;

    public static final RPMHeaderTag BLINKPKGID = new RPMHeaderTag(_BLINKPKGID,
            "BLINKPKGID");

    public static final int _BLINKHDRID = 1165;

    public static final RPMHeaderTag BLINKHDRID = new RPMHeaderTag(_BLINKHDRID,
            "BLINKHDRID");

    public static final int _BLINKNEVRA = 1166;

    public static final RPMHeaderTag BLINKNEVRA = new RPMHeaderTag(_BLINKNEVRA,
            "BLINKNEVRA");

    public static final int _FLINKPKGID = 1167;

    public static final RPMHeaderTag FLINKPKGID = new RPMHeaderTag(_FLINKPKGID,
            "FLINKPKGID");

    public static final int _FLINKHDRID = 1168;

    public static final RPMHeaderTag FLINKHDRID = new RPMHeaderTag(_FLINKHDRID,
            "FLINKHDRID");

    public static final int _FLINKNEVRA = 1169;

    public static final RPMHeaderTag FLINKNEVRA = new RPMHeaderTag(_FLINKNEVRA,
            "FLINKNEVRA");

    public static final int _PACKAGEORIGIN = 1170;

    public static final RPMHeaderTag PACKAGEORIGIN = new RPMHeaderTag(
            _PACKAGEORIGIN, "PACKAGEORIGIN");

    public static final int _TRIGGERPREIN = 1171;

    public static final RPMHeaderTag TRIGGERPREIN = new RPMHeaderTag(
            _TRIGGERPREIN, "TRIGGERPREIN");

    public static final int _BUILDSUGGESTS = 1172;

    public static final RPMHeaderTag BUILDSUGGESTS = new RPMHeaderTag(
            _BUILDSUGGESTS, "BUILDSUGGESTS");

    public static final int _BUILDENHANCES = 1173;

    public static final RPMHeaderTag BUILDENHANCES = new RPMHeaderTag(
            _BUILDENHANCES, "BUILDENHANCES");

    public static final int _SCRIPTSTATES = 1174;

    public static final RPMHeaderTag SCRIPTSTATES = new RPMHeaderTag(
            _SCRIPTSTATES, "SCRIPTSTATES");

    public static final int _SCRIPTMETRICS = 1175;

    public static final RPMHeaderTag SCRIPTMETRICS = new RPMHeaderTag(
            _SCRIPTMETRICS, "SCRIPTMETRICS");

    public static final int _BUILDCPUCLOCK = 1176;

    public static final RPMHeaderTag BUILDCPUCLOCK = new RPMHeaderTag(
            _BUILDCPUCLOCK, "BUILDCPUCLOCK");

    public static final int _FILEDIGESTALGOS = 1177;

    public static final RPMHeaderTag FILEDIGESTALGOS = new RPMHeaderTag(
            _FILEDIGESTALGOS, "FILEDIGESTALGOS");

    public static final int _VARIANTS = 1178;

    public static final RPMHeaderTag VARIANTS = new RPMHeaderTag(_VARIANTS,
            "VARIANTS");

    public static final int _XMAJOR = 1179;

    public static final RPMHeaderTag XMAJOR = new RPMHeaderTag(_XMAJOR,
            "XMAJOR");

    public static final int _XMINOR = 1180;

    public static final RPMHeaderTag XMINOR = new RPMHeaderTag(_XMINOR,
            "XMINOR");

    public static final int _REPOTAG = 1181;

    public static final RPMHeaderTag REPOTAG = new RPMHeaderTag(_REPOTAG,
            "REPOTAG");

    public static final int _KEYWORDS = 1182;

    public static final RPMHeaderTag KEYWORDS = new RPMHeaderTag(_KEYWORDS,
            "KEYWORDS");

    public static final int _BUILDPLATFORMS = 1183;

    public static final RPMHeaderTag BUILDPLATFORMS = new RPMHeaderTag(
            _BUILDPLATFORMS, "BUILDPLATFORMS");

    public static final int _PACKAGECOLOR = 1184;

    public static final RPMHeaderTag PACKAGECOLOR = new RPMHeaderTag(
            _PACKAGECOLOR, "PACKAGECOLOR");

    public static final int _PACKAGEPREFCOLOR = 1185;

    public static final RPMHeaderTag PACKAGEPREFCOLOR = new RPMHeaderTag(
            _PACKAGEPREFCOLOR, "PACKAGEPREFCOLOR");

    public static final int _XATTRSDICT = 1186;

    public static final RPMHeaderTag XATTRSDICT = new RPMHeaderTag(_XATTRSDICT,
            "XATTRSDICT");

    public static final int _FILEXATTRSX = 1187;

    public static final RPMHeaderTag FILEXATTRSX = new RPMHeaderTag(
            _FILEXATTRSX, "FILEXATTRSX");

    public static final int _DEPATTRSDICT = 1188;

    public static final RPMHeaderTag DEPATTRSDICT = new RPMHeaderTag(
            _DEPATTRSDICT, "DEPATTRSDICT");

    public static final int _CONFLICTATTRSX = 1189;

    public static final RPMHeaderTag CONFLICTATTRSX = new RPMHeaderTag(
            _CONFLICTATTRSX, "CONFLICTATTRSX");

    public static final int _OBSOLETEATTRSX = 1190;

    public static final RPMHeaderTag OBSOLETEATTRSX = new RPMHeaderTag(
            _OBSOLETEATTRSX, "OBSOLETEATTRSX");

    public static final int _PROVIDEATTRSX = 1191;

    public static final RPMHeaderTag PROVIDEATTRSX = new RPMHeaderTag(
            _PROVIDEATTRSX, "PROVIDEATTRSX");

    public static final int _REQUIREATTRSX = 1192;

    public static final RPMHeaderTag REQUIREATTRSX = new RPMHeaderTag(
            _REQUIREATTRSX, "REQUIREATTRSX");

    public static final int _BUILDPROVIDES = 1193;

    public static final RPMHeaderTag BUILDPROVIDES = new RPMHeaderTag(
            _BUILDPROVIDES, "BUILDPROVIDES");

    public static final int _BUILDOBSOLETES = 1194;

    public static final RPMHeaderTag BUILDOBSOLETES = new RPMHeaderTag(
            _BUILDOBSOLETES, "BUILDOBSOLETES");

    public static final int _DBINSTANCE = 1195;

    public static final RPMHeaderTag DBINSTANCE = new RPMHeaderTag(_DBINSTANCE,
            "DBINSTANCE");

    public static final int _NVRA = 1196;

    public static final RPMHeaderTag NVRA = new RPMHeaderTag(_NVRA, "NVRA");

    public static final int _FILEPATHS = 1197;

    public static final RPMHeaderTag FILEPATHS = new RPMHeaderTag(_FILEPATHS,
            "FILEPATHS");

    public static final int _ORIGPATHS = 1198;

    public static final RPMHeaderTag ORIGPATHS = new RPMHeaderTag(_ORIGPATHS,
            "ORIGPATHS");

    public static final int _RPMLIBVERSION = 1199;

    public static final RPMHeaderTag RPMLIBVERSION = new RPMHeaderTag(
            _RPMLIBVERSION, "RPMLIBVERSION");

    public static final int _RPMLIBTIMESTAMP = 1200;

    public static final RPMHeaderTag RPMLIBTIMESTAMP = new RPMHeaderTag(
            _RPMLIBTIMESTAMP, "RPMLIBTIMESTAMP");

    public static final int _RPMLIBVENDOR = 1201;

    public static final RPMHeaderTag RPMLIBVENDOR = new RPMHeaderTag(
            _RPMLIBVENDOR, "RPMLIBVENDOR");

    public static final int _CLASS = 1202;

    public static final RPMHeaderTag CLASS = new RPMHeaderTag(_CLASS, "CLASS");

    public static final int _TRACK = 1203;

    public static final RPMHeaderTag TRACK = new RPMHeaderTag(_TRACK, "TRACK");

    public static final int _TRACKPROG = 1204;

    public static final RPMHeaderTag TRACKPROG = new RPMHeaderTag(_TRACKPROG,
            "TRACKPROG");

    public static final int _SANITYCHECK = 1205;

    public static final RPMHeaderTag SANITYCHECK = new RPMHeaderTag(
            _SANITYCHECK, "SANITYCHECK");

    public static final int _SANITYCHECKPROG = 1206;

    public static final RPMHeaderTag SANITYCHECKPROG = new RPMHeaderTag(
            _SANITYCHECKPROG, "SANITYCHECKPROG");

    public static final int _FILESTAT = 1207;

    public static final RPMHeaderTag FILESTAT = new RPMHeaderTag(_FILESTAT,
            "FILESTAT");

    public static final int _STAT = 1208;

    public static final RPMHeaderTag STAT = new RPMHeaderTag(_STAT, "STAT");

    public static final int _ORIGINTID = 1209;

    public static final RPMHeaderTag ORIGINTID = new RPMHeaderTag(_ORIGINTID,
            "ORIGINTID");

    public static final int _ORIGINTIME = 1210;

    public static final RPMHeaderTag ORIGINTIME = new RPMHeaderTag(_ORIGINTIME,
            "ORIGINTIME");

    public static final int _HEADERSTARTOFF = 1211;

    public static final RPMHeaderTag HEADERSTARTOFF = new RPMHeaderTag(
            _HEADERSTARTOFF, "HEADERSTARTOFF");

    public static final int _HEADERENDOFF = 1212;

    public static final RPMHeaderTag HEADERENDOFF = new RPMHeaderTag(
            _HEADERENDOFF, "HEADERENDOFF");

    public static final int _PACKAGETIME = 1213;

    public static final RPMHeaderTag PACKAGETIME = new RPMHeaderTag(
            _PACKAGETIME, "PACKAGETIME");

    public static final int _PACKAGESIZE = 1214;

    public static final RPMHeaderTag PACKAGESIZE = new RPMHeaderTag(
            _PACKAGESIZE, "PACKAGESIZE");

    public static final int _PACKAGEDIGEST = 1215;

    public static final RPMHeaderTag PACKAGEDIGEST = new RPMHeaderTag(
            _PACKAGEDIGEST, "PACKAGEDIGEST");

    public static final int _PACKAGESTAT = 1216;

    public static final RPMHeaderTag PACKAGESTAT = new RPMHeaderTag(
            _PACKAGESTAT, "PACKAGESTAT");

    public static final int _PACKAGEBASEURL = 1217;

    public static final RPMHeaderTag PACKAGEBASEURL = new RPMHeaderTag(
            _PACKAGEBASEURL, "PACKAGEBASEURL");

    // special strings (TODO find out id if available)
    public static final RPMHeaderTag MULTILIBS = new RPMHeaderTag(10000,
            "MULTILIBS");

    public static final RPMHeaderTag FSSIZES = new RPMHeaderTag(10001,
            "FSSIZES");

    public static final RPMHeaderTag FSNAMES = new RPMHeaderTag(10002,
            "FSNAMES");

    public static final RPMHeaderTag FILENAMES = new RPMHeaderTag(10003,
            "FILENAMES");

    public static final RPMHeaderTag TRIGGERCONDS = new RPMHeaderTag(10004,
            "TRIGGERCONDS");

    public static final RPMHeaderTag TRIGGERTYPE = new RPMHeaderTag(10005,
            "TRIGGERTYPE");

    // jrpm flags
    public static final RPMHeaderTag J_FILESIZE = new RPMHeaderTag(90000,
            "J_FILESIZE");

    public static final RPMHeaderTag J_ARCHIVESIZE = new RPMHeaderTag(90001,
            "J_ARCHIVESIZE");

    private EnumIf delegate;

    private RPMHeaderTag(int tag, String name) {
        delegate = new EnumDelegate(RPMHeaderTag.class, tag, name, this);
    }

    /**
     * Get a enum by id
     *
     * @param id The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(long id) {
        return EnumDelegate.getEnumById(RPMHeaderTag.class, id);
    }

    /**
     * Get a enum by name
     *
     * @param name The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(String name) {
        return EnumDelegate.getEnumByName(RPMHeaderTag.class, name);
    }

    /**
     * Get all defined enums of this class
     *
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames() {
        return EnumDelegate.getEnumNames(RPMHeaderTag.class);
    }

    /**
     * Get a enum of this class by id
     *
     * @param tag The id
     * @return The enum object
     */
    public static RPMHeaderTag getRPMHeaderTag(int tag) {
        return (RPMHeaderTag) getEnumById(tag);
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param id The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Long id) {
        return EnumDelegate.containsEnumId(RPMHeaderTag.class, id);
    }

    /*
         * @see com.jguild.jrpm.io.constant.EnumIf#getId()
         */
    public long getId() {
        return delegate.getId();
    }

    /*
         * @see com.jguild.jrpm.io.constant.EnumIf#getName()
         */
    public String getName() {
        return delegate.getName();
    }

    /*
         * @see java.lang.Object#toString()
         */
    public String toString() {
        return delegate.toString();
    }
}
