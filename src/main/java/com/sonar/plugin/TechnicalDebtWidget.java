package com.sonar.plugin;

import com.sonar.plugin.batch.ExampleSensor;
import com.sonar.plugin.batch.RandomDecorator;
import com.sonar.plugin.ui.ExampleFooter;
import com.sonar.plugin.ui.ExampleRubyWidget;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * This class is the entry point for all extensions
 */
@Properties({
  @Property(
    key = ExamplePlugin.MY_PROPERTY,
    name = "Plugin Property",
    description = "A property for the plugin",
    defaultValue = "Hello World!")})
public final class ExamplePlugin extends SonarPlugin {

  public static final String MY_PROPERTY = "sonar.example.myproperty";

  // This is where you're going to declare all your Sonar extensions
  public List getExtensions() {
    return Arrays.asList(
        // Definitions
        ExampleMetrics.class,

        // Batch
        ExampleSensor.class, RandomDecorator.class,

        // UI
        ExampleFooter.class, ExampleRubyWidget.class);
  }
}
