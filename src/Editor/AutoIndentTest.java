package Editor;

import junit.framework.TestCase;


public class AutoIndentTest extends TestCase {

	AutoIndent auto;
	
	public void setUp() throws Exception {
		auto = new AutoIndent();
	}
	
	public void testNormaLine(){
		auto.indentSize = 4;
		String result = auto.indent("    Code", 0);
		assertEquals(result.length(), 4);
		assertEquals("    ", result);
	}
	
	public void testStartTag(){
		auto.indentSize = 4;
		String result = auto.indent("    <head>", 0);
		assertEquals(8, result.length());
		assertEquals("        ", result);
	}
	
	public void testEndTag(){
		auto.indentSize = 4;
		String result = auto.indent("        </head>", 0);
		assertEquals(4, result.length());
		assertEquals("    ", result);
	}
	
	public void testOddIndentEndTag(){
		auto.indentSize = 4;
		String result = auto.indent("       </head>", 0);
		assertEquals(3, result.length());
		assertEquals("   ", result);
	}
}
