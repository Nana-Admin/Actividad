package com.orangehrm.suites;

import com.orangehrm.runners.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthenticationRunner.class,
        EmployeeRunner.class,
        UserRunner.class,
        LeaveRunner.class,
        CandidateRunner.class,
        PerformanceRunner.class,
        DirectoryRunner.class,
        DashboardRunner.class,
        ProfileRunner.class
})
public class RegressionTestSuite {
}
