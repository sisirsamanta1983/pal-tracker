package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;
import java.util.HashMap;

@RestController
public class EnvController {
    String PORT;
    String MEMORY_LIMIT;
    String CF_INSTANCE_INDEX;
    String CF_INSTANCE_ADDR;

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", PORT);
        env.put("MEMORY_LIMIT", MEMORY_LIMIT);
        env.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        env.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);

        return env;
    }
    public EnvController(
            /*@Value("8080") String port,
            @Value("2048") String mlimit,
            @Value("20") String cm_index,
            @Value("12.12.13.20") String cf_addr*/

            @Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress
    )
    {
        this.PORT = port;
        this.MEMORY_LIMIT = memoryLimit;
        this.CF_INSTANCE_INDEX = cfInstanceIndex;
        this.CF_INSTANCE_ADDR = cfInstanceAddress;
    }


}
