import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for temperature conversion methods.
 * Tests the accuracy of conversion formulas with various test cases.
 */
public class TempConvProgramTest {

    private static final double DELTA = 0.01; // Acceptable precision error

    /**
     * Test converting freezing point of water from Celsius to Fahrenheit.
     * 0°C should equal 32°F
     */
    @Test
    public void testConvertCelsiusToFahrenheit_FreezingPoint() {
        double celsius = 0.0;
        double expected = 32.0;
        double actual = TempConvProgramRefactored.convertCelsiusToFahrenheit(celsius);
        assertEquals(expected, actual, DELTA, "0°C should convert to 32°F");
    }

    /**
     * Test converting boiling point of water from Celsius to Fahrenheit.
     * 100°C should equal 212°F
     */
    @Test
    public void testConvertCelsiusToFahrenheit_BoilingPoint() {
        double celsius = 100.0;
        double expected = 212.0;
        double actual = TempConvProgramRefactored.convertCelsiusToFahrenheit(celsius);
        assertEquals(expected, actual, DELTA, "100°C should convert to 212°F");
    }

    /**
     * Test converting negative temperature from Celsius to Fahrenheit.
     * -40°C should equal -40°F (special case where both scales meet)
     */
    @Test
    public void testConvertCelsiusToFahrenheit_NegativeTemperature() {
        double celsius = -40.0;
        double expected = -40.0;
        double actual = TempConvProgramRefactored.convertCelsiusToFahrenheit(celsius);
        assertEquals(expected, actual, DELTA, "-40°C should convert to -40°F");
    }

    /**
     * Test converting freezing point from Fahrenheit to Celsius.
     * 32°F should equal 0°C
     */
    @Test
    public void testConvertFahrenheitToCelsius_FreezingPoint() {
        double fahrenheit = 32.0;
        double expected = 0.0;
        double actual = TempConvProgramRefactored.convertFahrenheitToCelsius(fahrenheit);
        assertEquals(expected, actual, DELTA, "32°F should convert to 0°C");
    }

    /**
     * Test converting boiling point from Fahrenheit to Celsius.
     * 212°F should equal 100°C
     */
    @Test
    public void testConvertFahrenheitToCelsius_BoilingPoint() {
        double fahrenheit = 212.0;
        double expected = 100.0;
        double actual = TempConvProgramRefactored.convertFahrenheitToCelsius(fahrenheit);
        assertEquals(expected, actual, DELTA, "212°F should convert to 100°C");
    }

    /**
     * Test converting room temperature from Fahrenheit to Celsius.
     * 68°F should equal 20°C
     */
    @Test
    public void testConvertFahrenheitToCelsius_RoomTemperature() {
        double fahrenheit = 68.0;
        double expected = 20.0;
        double actual = TempConvProgramRefactored.convertFahrenheitToCelsius(fahrenheit);
        assertEquals(expected, actual, DELTA, "68°F should convert to 20°C");
    }

    /**
     * Test converting absolute zero from Celsius to Kelvin.
     * -273.15°C should equal 0 K
     */
    @Test
    public void testConvertCelsiusToKelvin_AbsoluteZero() {
        double celsius = -273.15;
        double expected = 0.0;
        double actual = TempConvProgramRefactored.convertCelsiusToKelvin(celsius);
        assertEquals(expected, actual, DELTA, "-273.15°C should convert to 0 K");
    }

    /**
     * Test converting freezing point from Celsius to Kelvin.
     * 0°C should equal 273.15 K
     */
    @Test
    public void testConvertCelsiusToKelvin_FreezingPoint() {
        double celsius = 0.0;
        double expected = 273.15;
        double actual = TempConvProgramRefactored.convertCelsiusToKelvin(celsius);
        assertEquals(expected, actual, DELTA, "0°C should convert to 273.15 K");
    }

    /**
     * Test converting boiling point from Celsius to Kelvin.
     * 100°C should equal 373.15 K
     */
    @Test
    public void testConvertCelsiusToKelvin_BoilingPoint() {
        double celsius = 100.0;
        double expected = 373.15;
        double actual = TempConvProgramRefactored.convertCelsiusToKelvin(celsius);
        assertEquals(expected, actual, DELTA, "100°C should convert to 373.15 K");
    }
}
