package com.shoutplatform.restresources;

import com.shoutplatform.domain.Group;
import static org.junit.Assert.assertEquals;
 
import org.junit.Test;
 
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import junit.framework.Assert;



public class GroupsTest extends JerseyTest {
    
    /*
     * super call in constructor - it passes list of package names to scan. 
     * Another useful method is resource() which returns WebResource instance 
     * with URI set to base URI of your application. 
     * You can get preconfigured Jersey Client instance similarly by calling client() method.*/
    public GroupsTest()throws Exception {
        super("com.shoutplatform.restresources");
    }

    @Test
    public void testing() {
        WebResource webResource = resource();
        String responseMsg = webResource.path("/groups/test").get(String.class);
        assertEquals("OK", responseMsg);
    }
   // @Test
    public void testing2() {
        WebResource webResource = resource();
        Response responseMsg = webResource.path("/groups/test2").get(Response.class);
        System.out.println("***********************************"+responseMsg);
        
        //assertEquals("KO", responseMsg);
    }
    
   // @Test
    public void getGroupForID() {
        WebResource webResource = resource();
        Response responseMsg = webResource.path("/groups").get(Response.class);
        Assert.assertNotNull(responseMsg);
        System.out.println("got this"+responseMsg);
        
    }

}