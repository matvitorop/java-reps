package com.education.ztu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TeacherParameterizedTest {
    private Teacher teacher;
    private String expected;

    public TeacherParameterizedTest(Teacher teacher, String expected) {
        this.teacher = teacher;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Teacher("John", "Doe", "Teacher", 30, Gender.MALE, Location.KIEV, "Math", "ZP", new Car("BMW")), "Teacher"},
                {new Teacher("Jane", "Smith", "Teacher", 35, Gender.FEMALE, Location.ZHYTOMYR, "Chemistry", "Harvard", new Car("Marcedec Benz")), "Teacher"}
        });
    }

    @Test
    public void testExpectations() {
        assertEquals(expected, teacher.getOccupation());
    }
}
