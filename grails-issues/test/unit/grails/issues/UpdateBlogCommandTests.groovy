package grails.issues

import org.codehaus.groovy.grails.web.binding.DataBindingUtils
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: klehner
 * Date: 16.01.14
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
class UpdateBlogCommandTests {

    @Test
    void bindData() {
        def params = [:]
        params.version = '6'
        params.title = '8'
        params.id = '4'

        UpdateBlogCommand cmd = new UpdateBlogCommand()
        DataBindingUtils.bindObjectToInstance(cmd, params)

        assert cmd.id == 4
        assert cmd.version == 6
        assert cmd.title == '8'
    }
}
