package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_문자하나() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("우테캠"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표구분자_문자2개_() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("우테캠,자바"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_쉼표외의_구분자_숫자2개_() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1;2"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_외의_구분자() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1.2-3"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자_숫자가아닌_문자() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("자바,우테캠:코드리뷰"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자외_다른구분자_사용() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1-2-3"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_custom_구분자_문자입력() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n자바;우테캠;코드리뷰"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("[ERROR] 구분자 혹은 입력 값을 다시 한번 확인해주세요.");
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
