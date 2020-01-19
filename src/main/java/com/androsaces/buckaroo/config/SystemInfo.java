/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides basic information about the system on which the
 * application JVM is running.
 *
 * @author Andrew Kearney
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class SystemInfo {
    private static final Logger logger = LoggerFactory.getLogger(SystemInfo.class);

    /** The {@code awt.toolkit} System Property. */
    public static final String AWT_TOOLKIT = sysprop("awt.toolkit");

    /** The {@code file.encoding} System Property. */
    public static final String FILE_ENCODING = sysprop("file.encoding");
    /** The {@code file.separator} System Property. */
    public static final String FILE_SEPARATOR = sysprop("file.separator");

    /** The {@code java.awt.fonts} System Property. */
    public static final String JAVA_AWT_FONTS = sysprop("java.awt.fonts");
    /** The {@code java.awt.graphicsenv} System Property. */
    public static final String JAVA_AWT_GRAPHICSENV = sysprop("java.awt.graphicsenv");
    /** The {@code java.awt.headless} System Property. */
    public static final String JAVA_AWT_HEADLESS = sysprop("java.awt.headless");
    /** The {@code java.awt.printerjob} System Property. */
    public static final String JAVA_AWT_PRINTERJOB = sysprop("java.awt.printerjob");
    /** The {@code java.class.path} System Property. */
    public static final String JAVA_CLASS_PATH = sysprop("java.class.path");
    /** The {@code java.class.version} System Property. */
    public static final String JAVA_CLASS_VERSION = sysprop("java.class.version");
    /** The {@code java.compiler} System Property. */
    public static final String JAVA_COMPILER = sysprop("java.compiler");
    /** The {@code java.endorsed.dirs} System Property. */
    public static final String JAVA_ENDORSED_DIRS = sysprop("java.endorsed.dirs");
    /** The {@code java.ext.dirs} System Property. */
    public static final String JAVA_EXT_DIRS = sysprop("java.ext.dirs");
    /** The {@code java.home} System Property. */
    public static final String JAVA_HOME = sysprop("java.home");
    /** The {@code java.io.tmpdir} System Property. */
    public static final String JAVA_IO_TMPDIR = sysprop("java.io.tmpdir");
    /** The {@code java.library.path} System Property. */
    public static final String JAVA_LIBRARY_PATH = sysprop("java.library.path");
    /** The {@code java.runtime.name} System Property. */
    public static final String JAVA_RUNTIME_NAME = sysprop("java.runtime.name");
    /** The {@code java.runtime.version} System Property. */
    public static final String JAVA_RUNTIME_VERSION = sysprop("java.runtime.version");
    /** The {@code java.specification.name} System Property. */
    public static final String JAVA_SPECIFICATION_NAME = sysprop("java.specification.name");
    /** The {@code java.specification.vendor} System Property. */
    public static final String JAVA_SPECIFICATION_VENDOR = sysprop("java.specification.vendor");
    /** The {@code java.specification.version} System Property. */
    public static final String JAVA_SPECIFICATION_VERSION = sysprop("java.specification.version");
    /** The {@code java.util.prefs.PreferencesFactory} System Property. */
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = sysprop("java.util.prefs.PreferencesFactory");
    /** The {@code java.vendor} System Property. */
    public static final String JAVA_VENDOR = sysprop("java.vendor");
    /** The {@code java.vendor.url} System Property. */
    public static final String JAVA_VENDOR_URL = sysprop("java.vendor.url");
    /** The {@code java.version} System Property. */
    public static final String JAVA_VERSION = sysprop("java.version");
    /** The {@code java.vm.info} System Property. */
    public static final String JAVA_VM_INFO = sysprop("java.vm.info");
    /** The {@code java.vm.name} System Property. */
    public static final String JAVA_VM_NAME = sysprop("java.vm.name");
    /** The {@code java.vm.specification.name} System Property. */
    public static final String JAVA_VM_SPECIFICATION_NAME = sysprop("java.vm.specification.name");
    /** The {@code java.vm.specification.vendor} System Property. */
    public static final String JAVA_VM_SPECIFICATION_VENDOR = sysprop("java.vm.specification.vendor");
    /** The {@code java.vm.specification.version} System Property. */
    public static final String JAVA_VM_SPECIFICATION_VERSION = sysprop("java.vm.specification.version");
    /** The {@code java.vm.vendor} System Property. */
    public static final String JAVA_VM_VENDOR = sysprop("java.vm.vendor");
    /** The {@code java.vm.version} System Property. */
    public static final String JAVA_VM_VERSION = sysprop("java.vm.vendor");

    /** The {@code line.separator} System Property. */
    public static final String LINE_SEPARATOR = sysprop("line.separator");

    /** The {@code os.arch} System Property. */
    public static final String OS_ARCH = sysprop("os.arch");
    /** The {@code os.name} System Property. */
    public static final String OS_NAME = sysprop("os.name");
    /** The {@code os.version} System Property. */
    public static final String OS_VERSION = sysprop("os.version");

    /** The {@code path.separator} System Property. */
    public static final String PATH_SEPARATOR = sysprop("path.separator");

    /** The {@code user.country} System Property. */
    public static final String USER_COUNTRY = sysprop("user.country") == null ? sysprop("user.region") : sysprop("user.country");
    /** The {@code user.dir} System Property. */
    public static final String USER_DIR = sysprop("user.dir");
    /** The {@code user.home} System Property. */
    public static final String USER_HOME = sysprop("user.home");
    /** The {@code user.language} System Property. */
    public static final String USER_LANGUAGE = sysprop("user.language");
    /** The {@code user.name} System Property. */
    public static final String USER_NAME = sysprop("user.name");
    /** The {@code user.timezone} System Property. */
    public static final String USER_TIMEZONE = sysprop("user.timezone");

    private static final JavaVersion JAVA_VERSION_AS_ENUM = JavaVersion.get(JAVA_SPECIFICATION_VERSION);

    /** Is {@code true} if this is Java version 1.1 or any 1.1.x version. */
    public static final boolean IS_JAVA_1_1 = getJavaVersionMatches("1.1");
    /** Is {@code true} if this is Java version 1.2 or any 1.2.x version. */
    public static final boolean IS_JAVA_1_2 = getJavaVersionMatches("1.2");
    /** Is {@code true} if this is Java version 1.3 or any 1.3.x version. */
    public static final boolean IS_JAVA_1_3 = getJavaVersionMatches("1.3");
    /** Is {@code true} if this is Java version 1.4 or any 1.4.x version. */
    public static final boolean IS_JAVA_1_4 = getJavaVersionMatches("1.4");
    /** Is {@code true} if this is Java version 1.5 or any 1.5.x version. */
    public static final boolean IS_JAVA_1_5 = getJavaVersionMatches("1.5");
    /** Is {@code true} if this is Java version 1.6 or any 1.6.x version. */
    public static final boolean IS_JAVA_1_6 = getJavaVersionMatches("1.6");
    /** Is {@code true} if this is Java version 1.7 or any 1.7.x version. */
    public static final boolean IS_JAVA_1_7 = getJavaVersionMatches("1.7");
    /** Is {@code true} if this is Java version 1.8 or any 1.8.x version. */
    public static final boolean IS_JAVA_1_8 = getJavaVersionMatches("1.8");
    /** Is {@code true} if this is Java version 1.9 or any 1.9.x version. */
    @Deprecated public static final boolean IS_JAVA_1_9 = getJavaVersionMatches("9");
    /** Is {@code true} if this is Java version 9 or any 9.x.y version. */
    public static final boolean IS_JAVA_9 = getJavaVersionMatches("9");
    /** Is {@code true} if this is Java version 10 or any 10.x.y version. */
    public static final boolean IS_JAVA_10 = getJavaVersionMatches("10");
    /** Is {@code true} if this is Java version 10 or any 11.x.y version. */
    public static final boolean IS_JAVA_11 = getJavaVersionMatches("11");
    /** Is {@code true} if this is Java version 10 or any 12.x.y version. */
    public static final boolean IS_JAVA_12 = getJavaVersionMatches("12");
    /** Is {@code true} if this is Java version 10 or any 13.x.y version. */
    public static final boolean IS_JAVA_13 = getJavaVersionMatches("13");

    /** Is {@code true} if this is an AIX Operating System. */
    public static final boolean IS_OS_AIX = getOsMatches("AIX");
    /** Is {@code true} if this is an HP-UX Operating System. */
    public static final boolean IS_OS_HP_UX = getOsMatches("HP-UX");
    /** Is {@code true} if this is an OS/400 Operating System. */
    public static final boolean IS_OS_400 = getOsMatches("OS/400");
    /** Is {@code true} if this is an Irix Operating System. */
    public static final boolean IS_OS_IRIX = getOsMatches("Irix");
    /** Is {@code true} if this is a Linux Operating System. */
    public static final boolean IS_OS_LINUX = getOsMatches("Linux") || getOsMatches("LINUX");
    /** Is {@code true} if this is a Mac Operating System. */
    public static final boolean IS_OS_MAC = getOsMatches("Mac");
    /** Is {@code true} if this is a Mac OS X Operating System. */
    public static final boolean IS_OS_MAC_OSX = getOsMatches("Mac OS X");
    /** Is {@code true} if this is a Mac OS X Cheetah Operating System. */
    public static final boolean IS_OS_MAC_OSX_CHEETAH = getOsMatches("Mac OS X", "10.0");
    /** Is {@code true} if this is a Mac OS X Puma Operating System. */
    public static final boolean IS_OS_MAC_OSX_PUMA = getOsMatches("Mac OS X", "10.1");
    /** Is {@code true} if this is a Mac OS X Jaguar Operating System. */
    public static final boolean IS_OS_MAC_OSX_JAGUAR = getOsMatches("Mac OS X", "10.2");
    /** Is {@code true} if this is a Mac OS X Panther Operating System. */
    public static final boolean IS_OS_MAC_OSX_PANTHER = getOsMatches("Mac OS X", "10.3");
    /** Is {@code true} if this is a Mac OS X Tiger Operating System. */
    public static final boolean IS_OS_MAC_OSX_TIGER = getOsMatches("Mac OS X", "10.4");
    /** Is {@code true} if this is a Mac OS X Leopard Operating System. */
    public static final boolean IS_OS_MAC_OSX_LEOPARD = getOsMatches("Mac OS X", "10.5");
    /** Is {@code true} if this is a Mac OS X Snow Leopard Operating System. */
    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD = getOsMatches("Mac OS X", "10.6");
    /** Is {@code true} if this is a Mac OS X Lion Operating System. */
    public static final boolean IS_OS_MAC_OSX_LION = getOsMatches("Mac OS X", "10.7");
    /** Is {@code true} if this is a OS X Mountain Lion Operating System. */
    public static final boolean IS_OS_OSX_MOUNTAIN_LION = getOsMatches("Mac OS X", "10.8");
    /** Is {@code true} if this is a OS X Mavericks Operating System. */
    public static final boolean IS_OS_OSX_MAVERICKS = getOsMatches("Mac OS X", "10.9");
    /** Is {@code true} if this is a OS X Yosemite Operating System. */
    public static final boolean IS_OS_OSX_YOSEMITE = getOsMatches("Mac OS X", "10.10");
    /** Is {@code true} if this is a OS X El Capitan Operating System. */
    public static final boolean IS_OS_OSX_EL_CAPITAN = getOsMatches("Mac OS X", "10.11");
    /** Is {@code true} if this is a macOS Sierra Operating System. */
    public static final boolean IS_OS_MACOS_SIERRA = getOsMatches("Mac OS X", "10.12");
    /** Is {@code true} if this is a macOS High Sierra Operating System. */
    public static final boolean IS_OS_MACOS_HIGH_SIERRA = getOsMatches("Mac OS X", "10.13");
    /** Is {@code true} if this is a macOS Catalina Operating System. */
    public static final boolean IS_OS_MASOS_MOJAVE = getOsMatches("Mac OS X", "10.14");
    /** Is {@code true} if this is a macOS Catalina Operating System. */
    public static final boolean IS_OS_MASOS_CATALINA = getOsMatches("Mac OS X", "10.15");
    /** Is {@code true} if this is a FreeBSD Operating System. */
    public static final boolean IS_OS_FREE_BSD = getOsMatches("FreeBSD");
    /** Is {@code true} if this is an OpenBSD Operating System. */
    public static final boolean IS_OS_OPEN_BSD = getOsMatches("OpenBSD");
    /** Is {@code true} if this is a NetBSD Operating System. */
    public static final boolean IS_OS_NET_BSD = getOsMatches("NetBSD");
    /** Is {@code true} if this is a OS/2 Operating System. */
    public static final boolean IS_OS_OS2 = getOsMatches("OS/2");
    /** Is {@code true} if this is a Solaris Operating System. */
    public static final boolean IS_OS_SOLARIS = getOsMatches("Solaris");
    /** Is {@code true} if this is a SunOS Operating System. */
    public static final boolean IS_OS_SUN_OS = getOsMatches("SunOS");
    /** Is {@code true} if this is a UNIX like system like AIX, Linux, Mac OS X, etc. */
    public static final boolean IS_OS_UNIX = IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX
            || IS_OS_SOLARIS || IS_OS_SUN_OS || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD;
    /** Is {@code true} if this is a Windows Operating System. */
    public static final boolean IS_OS_WINDOWS = getOsMatches("Windows");
    /** Is {@code true} if this is a Windows 2000 Operating System. */
    public static final boolean IS_OS_WINDOWS_2000 = getOsMatches("Windows", "5.0");
    /** Is {@code true} if this is a Windows 95 Operating System. */
    public static final boolean IS_OS_WINDOWS_95 = getOsMatches("Windows" + " 9", "4.0");
    /** Is {@code true} if this is a Windows 98 Operating System. */
    public static final boolean IS_OS_WINDOWS_98 = getOsMatches("Windows" + " 9", "4.1");
    /** Is {@code true} if this is a Windows ME Operating System. */
    public static final boolean IS_OS_WINDOWS_ME = getOsMatches("Windows", "4.9");
    /** Is {@code true} if this is a Windows NT Operating System. */
    public static final boolean IS_OS_WINDOWS_NT = getOsMatches("Windows" + " NT", "");
    /** Is {@code true} if this is a Windows XP Operating System. */
    public static final boolean IS_OS_WINDOWS_XP = getOsMatches("Windows", "5.1");
    /** Is {@code true} if this is a Windows Vista Operating System. */
    public static final boolean IS_OS_WINDOWS_VISTA = getOsMatches("Windows", "6.0");
    /** Is {@code true} if this is a Windows 7 Operating System. */
    public static final boolean IS_OS_WINDOWS_7 = getOsMatches("Windows", "6.1");
    /** Is {@code true} if this is a Windows 8 Operating System. */
    public static final boolean IS_OS_WINDOWS_8 = getOsMatches("Windows", "6.2");
    /** Is {@code true} if this is a Windows 8.1 Operating System. */
    public static final boolean IS_OS_WINDOWS_8_1 = getOsMatches("Windows", "6.3");
    /** Is {@code true} if this is a Windows 10 Operating System. */
    public static final boolean IS_OS_WINDOWS_10 = getOsMatches("Windows", "10.0");
    /** Is {@code true} if this is a z/OS Operating System. */
    public static final boolean IS_OS_ZOS = getOsMatches("z/OS");

    private SystemInfo() {}

    private static boolean getJavaVersionMatches(String versionPrefix) {
        return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix);
    }

    private static boolean isJavaVersionMatch(String version, String versionPrefix) {
        if (version == null) {
            return false;
        }
        return version.startsWith(versionPrefix);
    }

    private static boolean getOsMatches(String osNamePrefix) {
        return OS_NAME != null && OS_NAME.startsWith(osNamePrefix);
    }

    private static boolean getOsMatches(String osNamePrefix, String osVersionPrefix) {
        return !(OS_NAME == null || OS_VERSION == null)
                && OS_NAME.startsWith(osNamePrefix)
                && OS_VERSION.startsWith(osVersionPrefix);
    }

    private static String sysprop(String property) {
        try {
            return System.getProperty(property);
        } catch (SecurityException e) {
            logger.warn("SecurityException reading the system property '{}'; the SystemInfo property will default to null", property);
            return null;
        }
    }

    /**
     * Is the Java version at least the requested version.
     *
     * @param requiredVersion the required version, for example {@code 1.6f};
     * @return {@code true} if the actual version is equal or greater that the required version
     */
    public static boolean isJavaVersionAtLeast(JavaVersion requiredVersion) {
        return JAVA_VERSION_AS_ENUM.atLeast(requiredVersion);
    }
}
