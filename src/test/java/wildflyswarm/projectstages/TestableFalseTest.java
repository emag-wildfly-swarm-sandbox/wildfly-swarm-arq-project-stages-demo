package wildflyswarm.projectstages;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.spi.api.JARArchive;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class TestableFalseTest {

  @Deployment(testable = false)
  public static Archive createDeployment() {
    return ShrinkWrap.create(JARArchive.class).add(EmptyAsset.INSTANCE, "nothing");
  }

  @Test
  public void test() throws Exception {
    // null is natural because it's not in container, however,  I want to get the value from project-stages.yml
    assertThat(System.getProperty("foo"), is(nullValue()));
  }

}
