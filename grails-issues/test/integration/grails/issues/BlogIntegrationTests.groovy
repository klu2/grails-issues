package grails.issues

import grails.test.mixin.TestMixin
import grails.test.mixin.integration.IntegrationTestMixin
import org.junit.Test

/**
 * @author Klaus Lehner, Catalysts GmbH
 */
@TestMixin(IntegrationTestMixin)
class BlogIntegrationTests {

    /**
     * This test fails in Grails 2.3.1 due to http://jira.grails.org/browse/GRAILS-10727 (entries is null)
     */
    @Test
    void testCreateBlog() {
        def blog = new Blog(title: "My Blog").save()
        assert blog.entries != null
        assert blog.entries.empty
    }
}
