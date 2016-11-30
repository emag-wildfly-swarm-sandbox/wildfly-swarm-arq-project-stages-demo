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
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class TestableTrueTest {

  @Deployment
  public static Archive createDeployment() {
    return ShrinkWrap.create(JARArchive.class).add(EmptyAsset.INSTANCE, "nothing");
  }

  @Test
  public void test() throws Exception {
    assertThat(System.getProperty("foo"), is("bar"));
  }

}
