package comp.mobile.config;

import org.aeonbits.owner.Config;

public interface IoSConfig extends OwnerConfig{

    // ===== IOS =====
    @Config.Key("ios.deviceName")
    String iosDeviceName();

    @Config.Key("ios.osVersion")
    String iosOsVersion();

    @Config.Key("ios.app")
    String iosApp();

}
