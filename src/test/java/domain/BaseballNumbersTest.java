package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

	@Test
	@DisplayName("nullüũ")
	void testBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers(null))
        .isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@DisplayName("���� üũ")
	void testvalidNumberBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123ff"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("���� üũ")
	void testvalidIntegerBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123.111"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("�ڸ��� üũ")
	void testvalidLengthBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("1234"))
        .isInstanceOf(IllegalArgumentException.class);
	}

}
