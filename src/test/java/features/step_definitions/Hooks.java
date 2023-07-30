package features.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.DriversUtils.*;

public class Hooks {

    @Before
    public void BeforeSteps(){

    }

    @After
    public void AfterSteps(){
        System.out.println("After the scenario");
       // tearDown();
    }
}
