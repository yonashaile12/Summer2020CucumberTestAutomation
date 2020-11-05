package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = " @add_car_scenario_outline",
        publish = true
)
public class CucumberRunner {
    //"@s_o and @with_two_columns",
    // scenario must have both tags
    // java logics if( @s_o && @with_two_columns)

    //"@s_o and @with_two_columns",
    // scenario must have EITHER or tags
    // java logics if( @s_o || @with_two_columns)
}
