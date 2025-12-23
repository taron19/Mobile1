package comp.mobile.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:secret.properties"
})
public interface OwnerConfig extends Config {

    @Key("url")
    String url();

    // ===== COMMON =====
    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("sessionName")
    String sessionName();



}
