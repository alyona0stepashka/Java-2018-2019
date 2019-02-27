package example;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class kevLabledTextFieldTag extends TagSupport {
    private String name;
    private int value;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int doStartTag() throws JspException {
        try {
            if (this.getName().equalsIgnoreCase("tagday"))
                if (!((this.getValue()>0) && (this.getValue()<31))) setValue(1);
            if (this.getName().equalsIgnoreCase("tagmonth"))
                if (!((this.getValue()>0) && (this.getValue()<13))) setValue(1);
            if (this.getName().equalsIgnoreCase("tagyear"))
                if (!((this.getValue()>=1970))) setValue(1970);
            pageContext.getOut().print("<input type='text' name='"+this.getName()+"' value='"+this.getValue()+"'/>");
        } catch (Exception ex){
            throw new JspException("kevLabledTextField: "+ex.getMessage());
        }
        return SKIP_BODY;
    }
    public int doEndTag(){
        return EVAL_PAGE;
    }
}
