package com.eece416.jbehave.JbehaveWeb;

import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;


//import com.eece416.jbehave.JbehaveWeb.pages.Colors;
//import com.eece416.jbehave.JbehaveWeb.steps.ColorSteps;
import com.eece416.jbehave.JbehaveWeb.steps.LoginSteps;

import org.jbehave.web.selenium.FlashWebDriverProvider;
import org.jbehave.web.selenium.PerStoryWebDriverSteps;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class LoginStories extends JUnitStories {

    
	private Selenium selenium = SeleniumConfiguration.defaultSelenium();
	private ConditionRunner conditionRunner = SeleniumConfiguration.defaultConditionRunner(selenium);
	private SeleniumContext seleniumContext = new SeleniumContext();

    //private WebDriverProvider driverProvider = new FlashWebDriverProvider("coloredSquare", new FirefoxDriver());
    //private Colors colorsPage = new Colors(driverProvider);

    @Override
    public Configuration configuration() {
    	
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
            .useSelenium(selenium)
            .useSeleniumContext(seleniumContext)
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryReporterBuilder(
                  new StoryReporterBuilder().withCodeLocation(codeLocationFromClass(embeddableClass))
                  .withDefaultFormats().withFormats(CONSOLE, TXT, HTML, XML)); 
//        {
//             
//                @Override
//                public StoryReporter reporterFor(String storyPath, Format format) {
//                    if (format == CONSOLE) {
//                        return new ConsoleOutput() {
//                            @Override
//                            public void beforeScenario(String title) {
//                                seleniumContext.setCurrentScenario(title);
//                                super.beforeScenario(title);
//                            }
//                        };
//                    } else {
//                        return super.reporterFor(storyPath, format);
//                    }
//                }
//            }
//            .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
//            .withDefaultFormats()
//            .withFormats(CONSOLE, TXT, HTML, XML));
//        Class<? extends Embeddable> embeddableClass = this.getClass();
//        return new SeleniumConfiguration()
//        	//    .useWebDriverProvider(driverProvider)
//                .useStoryLoader(new LoadFromClasspath(embeddableClass))
//                .useStoryReporterBuilder(
//                        new StoryReporterBuilder().withCodeLocation(codeLocationFromClass(embeddableClass))
//                                .withDefaultFormats().withFormats(CONSOLE, TXT, HTML, XML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new LoginSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story"), null);
    }

}
