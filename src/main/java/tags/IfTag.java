package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public final class IfTag extends SimpleTagSupport {
    private Boolean exp;
    private String isTrue;
    private String isFalse;

    public void setExp(Boolean exp) {
        this.exp = exp;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
    }

    public void setIsFalse(String isFalse) {
        this.isFalse = isFalse;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (this.exp == null) {
            out.println("");
        } else if (this.exp) {
            out.println(this.isTrue);
        } else {
            out.println(this.isFalse);
        }
    }
}
