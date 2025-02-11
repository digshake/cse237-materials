
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpellCheckerCompleteTest {

//@Test
	//void test() {
	//	fail("Not yet implemented");
//	}
	private SpellChecker speller;

	@BeforeEach 
	void objectCreation() {
		 speller = new SpellChecker(); 
	}
	@Test 
	void zeroCountTest() {
		int count = speller.getWordCount(); 
		assertTrue(count == 0); 
	}
	
	
	@Test 
	void addOneTest() {
		speller.add("cat");
		int count = speller.getWordCount(); 
		assertTrue(count == 1); 
	}
	
	@Test 
	void duplicateTest() {
		speller.add("cat");
		speller.add("cat");
		boolean duplicate = speller.findDuplicates(); 
		assertTrue(duplicate == true);
	}
	
	@Test 
	void improperSpellingTest() {
		speller.add("tupperware");
		boolean spellCheck = speller.spellCheck("tuperware"); 
		assertTrue(!spellCheck); 
	}
	
	@Test 
	void properSpellingTest() {
		speller.add("tupperware");
		boolean spellCheck = speller.spellCheck("tupperware"); 
		assertTrue(spellCheck); 
	}
	
	@Test 
	void ignoreUpperCaseTest() {
		speller.add("cAt");
		speller.add("dog");
		boolean uppercase = speller.spellCheck("cat");
		boolean lowercase = speller.spellCheck("dOg");
		assertTrue(uppercase && lowercase); 
	}
	
	@Test 
	void autoCorrectTest() {
		speller.add("stupid");
		speller.add("stoopid");
		String autoCorrect = speller.getClosest("stoopid");
		assertTrue(autoCorrect.equals("stupid")); 
	}
	
	@Test 
	void autoCorrectCorrectTest() {
		speller.add("stupid");
		String autoCorrect = speller.getClosest("stupid");
		assertTrue(autoCorrect.equals("stupid")); 
	}

}