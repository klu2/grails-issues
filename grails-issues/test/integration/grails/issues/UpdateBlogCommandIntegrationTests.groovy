package grails.issues

import grails.test.mixin.TestMixin
import grails.test.mixin.integration.IntegrationTestMixin
import org.codehaus.groovy.grails.web.binding.DataBindingUtils
import org.junit.Test


@TestMixin(IntegrationTestMixin)
class UpdateBlogCommandIntegrationTests {

    @Test
    void bindData() {
        def params = [:]
        params.title = '8'
        params.version = '6'
        params.id = '4'

        UpdateBlogCommand cmd = new UpdateBlogCommand()
        DataBindingUtils.bindObjectToInstance(cmd, params)

        assert cmd.id == 4
        assert cmd.version == 6
        assert cmd.title == '8'
    }
}
