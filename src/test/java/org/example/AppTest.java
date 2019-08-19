package org.example;

import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws Exception {
        new MockUp<AdvancedCollaborator>() {
            @Mock
            private String privateMethod() {
                return "mocked: ";
            }
        };

        AdvancedCollaborator advancedCollaborator = new AdvancedCollaborator("abc");
        String actual = advancedCollaborator.methodThatCallsPrivateMethod(1);
        assertEquals("mocked: 1", actual);
    }
}

class AdvancedCollaborator {
    int i;
    private int privateField = 5;

    // default constructor omitted

    public AdvancedCollaborator(String string) throws Exception {
        i = string.length();
    }

    public String methodThatCallsPrivateMethod(int i) {
        return privateMethod() + i;
    }

    public int methodThatReturnsThePrivateField() {
        return privateField;
    }

    private String privateMethod() {
        return "default:";
    }

    class InnerAdvancedCollaborator {
    }
}