package CHNTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CHNSubmit extends TagSupport
{
	public int doStartTag() throws JspException
	{
		String in = "<input type=\"submit\" value=\"OK\"><input type=\"reset\" value=\"Cancel\"><br/>";
		try
		{
			JspWriter out = pageContext.getOut();
			out.print(in);
		} catch(IOException e)
		{
			System.out.println("CHNTags exception with : " + e);
		}
		return EVAL_BODY_INCLUDE;
	}
}