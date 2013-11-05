package grails.issues

import grails.test.mixin.TestMixin
import grails.test.mixin.integration.IntegrationTestMixin
import org.junit.Before
import org.junit.Test

/**
 * @author Klaus Lehner, Catalysts GmbH
 */
@TestMixin(IntegrationTestMixin)
class BlogCleanupTests {

    @Before
    void before() {
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
