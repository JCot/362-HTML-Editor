package Editor;

import junit.framework.TestCase;


public class AutoIndentTest extends TestCase {

	AutoIndent auto;
	
	public void setUp() throws Exception {
		auto = new AutoIndent();
	}
	
	public void testNormalLine(){
		auto.indentSize = 4;
		String result = auto.indent("    Code", 1);
		assertEquals(4, result.length());
		assertEquals("    ", result);
	}
	
	public void testStartTag(){
		auto.indentSize = 4;
		String result = auto.indent("    <head>", 1);
		assertEquals(8, result.length());
		assertEquals("        ", result);
	}
	
}
