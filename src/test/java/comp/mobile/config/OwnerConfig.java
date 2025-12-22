package comp.mobile.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:secret.properties"
})
public interface OwnerConfig extends Config {

    @Key("url")
    String url();

    // ===== ANDROID =====
    @Key("android.deviceName")
    String androidDeviceName();

    @Key("android.osVersion")
    String androidOsVersion();

    @Key("android.app")
    String androidApp();

    // ===== IOS =====
    @Key("ios.deviceName")
    String iosDeviceName();

    @Key("ios.osVersion")
    String iosOsVersion();

    @Key("ios.app")
    String iosApp();

    // ===== COMMON =====
    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("sessionName")
    String sessionName();


}
