package base.plugin

import org.apache.commons.io.IOUtils
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.springframework.core.io.UrlResource

class File implements Serializable {

    byte[] content
    int size
    String fileName
    String mimeType
    boolean image
    String url

    static constraints = {
        content nullable: true, validator: { val, obj ->
            obj.external ? true : (val ? true : false)
        }, maxSize: 10000000 // max 10MB file
        fileName nullable: false, blank: false, matches: /^[^\\\?\/\|"<>\*\%]*$/
        mimeType nullable: true
        url nullable: true, validator: { val, obj ->
            !obj.external && obj.content == null ? false : true
        }
    }

    void beforeInsert() {
        if (external) {
            try {
                HttpClient client = new DefaultHttpClient()
                def response = client.execute(new HttpGet(url))
                if (response.statusLine.statusCode == 200) {
                    mimeType = response.entity.contentType.value
                    image = mimeType?.contains('image')
                    size = response.entity.contentLength
                }
            } catch (Exception ex) {
            }
        }
    }

    static mapping = {
        table 'core_file'
        columns { content sqlType: 'longblob' }
    }

    boolean isExternal() {
        return url
    }

    InputStream createInputStream() {
        if (external) {
            def out = new ByteArrayOutputStream()
            IOUtils.copy(new UrlResource(url).inputStream, out)
            return new ByteArrayInputStream(out.toByteArray())
        } else {
            return new ByteArrayInputStream(content)
        }
    }
}



