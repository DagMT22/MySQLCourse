import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

class TestDemoTest {
	
	private TestDemo testDemo;	

	@BeforeEach
	void setUp() throws Exception {
	testDemo = new TestDemo();
	}

	/**
	 * Test for TestDemo.addPositive, where a 0 or negative value for a or b produces IllegalArgumentException
	 * @param a input int, must be positive (>0) or else throws exception
	 * @param b input int, must be positive (>0) or else throws exception
	 * @param expected result if inputs are legal, else 0
	 * @param expectException expect IllegalArgumentException("Both parameters must be positive!")
	 */
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	/**
	 * stream of input arguments for test for TestDemo.addPositive(a,b)
	 * @return
	 */
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(1, 2, 3, false),
				arguments(0, 4, 0, true),
				arguments(0, 0, 0, true),
				arguments(-2, 2, 0, true),
				arguments(-2, -2, 0, true)
				);
	}
	
	
	/**
	 * Testing TestDemo.randomNumberSquared(), with value 5*5 = 25 using mockito
	 */
	@Test
	void assertThatNumberSquaredIsCorrect() {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);	
	}
}
