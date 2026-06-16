package com.orangehrm.suites;

import com.orangehrm.runners.AuthenticationRunner;
import com.orangehrm.runners.DashboardRunner;
import com.orangehrm.runners.DirectoryRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthenticationRunner.class,
        DashboardRunner.class,
        DirectoryRunner.class
})
public class SmokeTestSuite {
}
