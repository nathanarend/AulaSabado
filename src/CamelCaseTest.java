import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CamelCaseTest {

	private List<String> listaCamelCase;
	
	@BeforeEach
	void inicialize() {
		listaCamelCase = new ArrayList<>();
	}
	@Test
	void converterCamelCaseTestNaoNulo() {
		listaCamelCase.add("nome");
		assertNotNull(CamelCase.converterCamelCase("nome"));
		
	}
	@Test
	void converterCamelCaseTestStringNome() {
		listaCamelCase.removeAll(listaCamelCase);
		listaCamelCase.add("nome");
		assertLinesMatch(listaCamelCase, CamelCase.converterCamelCase("nome"));
	}

	@Test
	void converCamelCaseTestNomeFIrstLetterUpperCase() {
		listaCamelCase.removeAll(listaCamelCase);
		listaCamelCase.add("nome");
		assertLinesMatch(listaCamelCase, CamelCase.converterCamelCase("Nome"));
	}
	
	@Test
	void convertCamelCaseTestStringnomeComposto() {
		listaCamelCase.removeAll(listaCamelCase);
		listaCamelCase.add("nome");
		assertLinesMatch(listaCamelCase, CamelCase.converterCamelCase("nomeComposto"));
	}
	
	private static boolean isCapital (char c) {
		if(c >= 65 && c <= 90) {
			return true;
		}
		return false;
	}
	
	private static int getCapitalPosition(char[] letras) {
		int pos = 0;
		for (char c : letras) {
			if(isCapital(c)) {
				return pos;
			}
			pos++;
		}
		return 0;
	}
	
	private static List<String> toLowerCaseSplitterString(List<String> splittedList) {
		List<String> lowerCaseSplitterList = new ArrayList<>();
		for (String string : splittedList) {
			lowerCaseSplitterList.add(string.toLowerCase());
		}
		return lowerCaseSplitterList;
	}
	
	private static List<String> sliptString(String original) {
		List<String> splittedString = new ArrayList<String>();
		int posicao;
		char letras[] = original.toCharArray();
		posicao = getCapitalPosition(letras);
		if(posicao != 0) {
			splittedString.add(original.substring(posicao));
			return toLowerCaseSplitterString(splittedString);
		}
	}
	
	
	
	
	
	
}
