package ut.com.jpmc.gti.adp;

import org.junit.Test;
import com.jpmc.gti.adp.api.MyPluginComponent;
import com.jpmc.gti.adp.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}