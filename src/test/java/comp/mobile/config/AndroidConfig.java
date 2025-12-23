package comp.mobile.config;

import org.aeonbits.owner.Config;

public interface AndroidConfig extends OwnerConfig {

    // ===== ANDROID =====
    @Config.Key("android.deviceName")
    String androidDeviceName();

    @Config.Key("android.osVersion")
    String androidOsVersion();

    @Config.Key("android.app")
    String androidApp();
}
