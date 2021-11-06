package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoStatisticsTest {

	@ParameterizedTest
	@CsvSource(value = {"1,13,26,38,41,8:0001", "1,13,25,38,41,8:0010", "1,13,26,31,33,8:0100",
						"3,15,26,31,41,8:1000", "1,13,27,31,42,3:0000"}, delimiter = ':')
	@DisplayName("당첨통계 등수 별 당첨자 수 확인")
	public void LottoStatisticsWinnerCountTest(String inputData, String expected) {
		//given
		int[] winningNumbers = Arrays.stream(inputData.split(",")).mapToInt(Integer::parseInt).toArray();
		int[] lottoNumbers = {1, 13, 26, 38, 41, 8};
		Lotto lotto = new Lotto(lottoNumbers);
		LottoStatistics lottoStatistics = new LottoStatistics();
		String winnerCount = "";

		//when
		lottoStatistics.record(lotto.countMatchNumber(winningNumbers));
		for (WinningInformation information : lottoStatistics.getWinningRecord()) {
			winnerCount += information.getWinnerCount();
		}

		//then
		assertThat(winnerCount).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,13,26,38,41,8:2000000", "1,13,25,38,41,8:1500", "1,13,26,31,33,8:50",
						"3,15,26,31,41,8:5", "1,13,27,31,42,3:0"}, delimiter = ':')
	@DisplayName("당첨통계 수익률 확인")
	public void LottoStatisticsProfitRateTest(String inputData, double expected) {
		//given
		int[] winningNumbers = Arrays.stream(inputData.split(",")).mapToInt(Integer::parseInt).toArray();
		int[] lottoNumbers = {1, 13, 26, 38, 41, 8};
		Lotto lotto = new Lotto(lottoNumbers);
		LottoStatistics lottoStatistics = new LottoStatistics();

		//when
		lottoStatistics.record(lotto.countMatchNumber(winningNumbers));

		//then
		assertThat(lottoStatistics.getProfitRate()).isEqualTo(expected);
	}
}
