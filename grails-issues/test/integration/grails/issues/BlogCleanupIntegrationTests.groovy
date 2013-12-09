package grails.issues

import org.junit.Test

/**
 * @author Klaus Lehner, Catalysts GmbH
 */
class BlogCleanupIntegrationTests extends GroovyTestCase {

//    this method was called with Grails 2.2, but is not called any more with Grails 2.3
//    @see http://jira.grails.org/browse/GRAILS-10726
//
//    @Before
//    void before() {
//        new Blog(title: "My Blog").save()
//    }

    /**
     * Therefore we override the setUp-Method
     */
    public void setUp() {
        super.setUp()
        // but the entity that we create in here is not rollbacked after the test, therefore testCleanup2() will fail
        new Blog(title: "My Blog").save()

    }

    @Test
    void testCleanup1() {
        assert Blog.count() == 1
    }

    @Test
    void testCleanup2() {
        assert Blog.count() == 1
    }

}
