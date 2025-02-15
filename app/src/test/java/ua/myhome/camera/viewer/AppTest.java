/*
 * This source file was generated by the Gradle 'init' task
 */
package ua.myhome.camera.viewer;

import java.io.IOException;
import java.util.Set;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {
    @Test public void appInstantiated() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest, "app instantiated.");
    }

    @Test public void testPropertiesNames() throws IOException {
        PlayList playList = new PlayList();
        Set<String> expected = Set.of("cam1", "cam2", "cam3");
        assertEquals(playList.getProperties(), expected);
    }

    @Test public void testPropertyValue() throws IOException {
        PlayList playList = new PlayList();
        String value = "rtsp://<user1>:<pass>@<ipv4address>:554/cam/realmonitor?channel=1&subtype=0";
        assertNotNull(playList.getPropertyValue("cam1"), value);
    }
}
