import junit.framework.TestCase;

public class WellFormedTest extends TestCase{

	WellFormed checker = new WellFormed();
	
	public void testGoodTags(){
		boolean result = checker.wellFormedCheck("<head>\n\n</head>");
		assertTrue(result);
	}
	
	public void testUnclosedTag(){
		assertFalse(checker.wellFormedCheck("<head>"));
	}
	
	public void testUnopendTag(){
		assertFalse(checker.wellFormedCheck("</head>"));
	}
	
	public void testMultipleGoodTags(){
		assertTrue(checker.wellFormedCheck("<head>\n\n<body>\n\n</body>\n\n</head>"));
	}
	
	public void testMultipleUnclosedTags(){
		assertFalse(checker.wellFormedCheck("<head> <body> </head>"));
	}
	
	public void testMultipleUnopenedTags(){
		assertFalse(checker.wellFormedCheck("<body> </body> </head>"));
	}

}
