package com.education.ztu;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CarTest.class,
        OperationTest.class,
        TeacherParameterizedTest.class,
})
public class AllTest {

}
