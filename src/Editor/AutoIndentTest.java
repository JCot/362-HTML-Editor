package Editor;

import junit.framework.TestCase;


public class AutoIndentTest extends TestCase {

	AutoIndent auto;
	
	public void setUp() throws Exception {
		auto = new AutoIndent();
	}
	
	public void testNormaLine(){
		String result = auto.indent("    Code", 0, 4);
		assertEquals(result.length(), 4);
		assertEquals("    ", result);
	}
	
	public void testStartTag(){
		String result = auto.indent("    <head>", 0, 4);
		assertEquals(8, result.length());
		assertEquals("        ", result);
	}
	
	public void testEndTag(){
		String result = auto.indent("        </head>", 0, 4);
		assertEquals(4, result.length());
		assertEquals("    ", result);
	}
	
	public void testOddIndentEndTag(){
		String result = auto.indent("       </head>", 0, 4);
		assertEquals(3, result.length());
		assertEquals("   ", result);
	}
}
